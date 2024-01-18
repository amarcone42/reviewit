package it.amarcone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TimeZone;

public class DatabaseManager {
    private Connection connection;
    private String name;
    private String user;
    private String password;
    
    public DatabaseManager() {
        connection = null;
        loadCredentials();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public void createConnection() {
        try {
            String url = "jdbc:mysql://" + getName() + "?serverTimezone=" + TimeZone.getDefault().getID();

            connection = DriverManager.getConnection(url, getUser(), getPassword());
        } catch (Exception e) {
            System.out.println("Connessione al database fallita");
        }
    }
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Errore chiusura connessione");
        }
    }
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    public void saveCredentials() {
        // TODO save credential in a savefile
    }
    public void loadCredentials() {
        String savedname = null;
        String saveduser  = null;
        String savedpassword  = null;
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/dbcredentials.txt"))) {
            // read first line with database path
            savedname = br.readLine();
            // read second line with username
            if (savedname != null) {
                count++;
                saveduser = br.readLine();
            }
            // read second line with username
            if (saveduser != null) {
                count++;
                savedpassword = br.readLine();
            }
            if (savedpassword != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File delle credenziali non trovato");
        } catch (IOException i) {
            throw new RuntimeException(i);
        }

        if (count == 3) {
            updateCredentials(savedname, saveduser, savedpassword);
        } else {
            System.out.println("Errore nella lettura delle credenziali");
        }
    }

    public void updateCredentials(String dbname, String user, String password) {
        setName(dbname);
        setUser(user);
        setPassword(password);
    }



    public void viewOpereInDateRange(String username, String dataMin, String dataMax) {
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT o.* FROM opera o JOIN recensione ON o.id = operaId WHERE profiloId = ? AND data > ? AND data < ?");
            stmt.setString(1,username);
            stmt.setString(2,dataMin);
            stmt.setString(3,dataMax);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                System.out.println("id: " + result.getInt("id"));
                System.out.println("tipo: " + result.getInt("tipo"));
                System.out.println("durata: " + result.getTime("durata"));
                System.out.println("titolo: " + result.getString("titolo"));
                System.out.println("descrizione: " + result.getString("descrizione"));
                System.out.println("locandina: " + result.getString("locandina"));
                System.out.println("data di uscita: " + result.getDate("dataDiUscita"));
                System.out.println("classificazione: " + result.getString("classificazione"));
                System.out.println("voto medio: " + result.getFloat("votoMedio") + "\n");
            }
        }catch (SQLException e) {
            System.out.println("Esecuzione query fallita");
        }
    }

    public int countOpereInDateRange(String username, String dataMin, String dataMax) {
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(operaId) as visualizzazioni FROM recensione WHERE profiloId = ? AND data >= ? AND data <= ?");
            stmt.setString(1,username);
            stmt.setString(2,dataMin);
            stmt.setString(3,dataMax);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getInt("visualizzazioni");
            }
        } catch (SQLException e) {
            System.out.println("Esecuzione query fallita");
            return -1;
        }
        return -1;
    }

    public int countFollowers(String username) {
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(profiloSeguito) AS followers FROM seguire WHERE profiloSeguito = ?");
            stmt.setString(1,username);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getInt("followers");
            }
        } catch (SQLException e) {
            System.out.println("Esecuzione query fallita");
            return -1;
        }
        return -1;
    }

}
