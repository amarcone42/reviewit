package it.amarcone;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        try ( PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/dbcredentials.txt")) ){
            writer.println(getName());
            writer.println(getUser());
            writer.println(getPassword());
        } catch (IOException e) {
            System.out.println("Errore nel salvataggio delle credenziali");
        }
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

    private String checkResult(String result) {
        if (result.equals("")) {
            result = "Nessun risultato trovato";
        }
        return result;
    }

    public String viewOpereViewdByUtente(String username) {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT o.* " +
                    "FROM opera o INNER JOIN recensione r ON o.id = r.operaId " +
                    "WHERE r.profiloId = ?");
            stmt.setString(1,username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("id: " + result.getString("id") + "\n");
                resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);  
    }

    public String viewOperefromListaViewed(String username, int listaId, boolean viewed) {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM opera WHERE " +
                    "(id IN ( SELECT operaId FROM collezione WHERE listaId = ?) " +
                    "or id IN ( SELECT operaId FROM classificazione WHERE listaId = ?) ) " +
                    "AND id "+ (viewed?"":"NOT") + " IN (SELECT operaId FROM recensione WHERE profiloId = ?)");
            stmt.setInt(1,listaId);
            stmt.setInt(2,listaId);
            stmt.setString(3,username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("id: " + result.getString("id") + "\n");
                resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);  
    }
    

    public String viewOperaByLavoratore(String nome, String cognome) {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT o.* FROM opera o WHERE " +
            "o.id IN (SELECT operaId FROM partecipazione p INNER JOIN lavoratore l ON p.membroCrewId = l.id WHERE l.nome = ? AND l.cognome = ?) or " + 
            "o.id IN (SELECT operaId FROM recitazione r INNER JOIN lavoratore l ON r.attoreId = l.id WHERE l.nome = ? AND l.cognome = ?)");
            stmt.setString(1,nome);
            stmt.setString(2,cognome);
            stmt.setString(3,nome);
            stmt.setString(4,cognome);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("id: " + result.getString("id") + "\n");
                resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);   
    }

    
    public String viewNotizieByUtente(String username) {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM notizia WHERE profiloId = ?");
            stmt.setString(1,username);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("profiloId: " + result.getString("profiloId") + "\n");
                resultString = resultString.concat("data: " + result.getDate("data") + "\n");
                resultString = resultString.concat("ora: " + result.getTime("ora") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("anteprima: " + result.getString("anteprima") + "\n");
                resultString = resultString.concat("contenuto: " + result.getString("contenuto") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);   
    }

    public String viewOpereInDateRange(String username, String dataMin, String dataMax) {
        String resultString = "";
        try{
            PreparedStatement stmt = connection.prepareStatement("SELECT o.* FROM opera o JOIN recensione ON o.id = operaId WHERE profiloId = ? AND data > ? AND data < ?");
            stmt.setString(1,username);
            stmt.setString(2,dataMin);
            stmt.setString(3,dataMax);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                resultString = resultString.concat("id: " + result.getInt("id") + "\n");
                resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        }catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);
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

    public String viewLavoratoriOrderByNumeroOpere() {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("((SELECT l.id, l.nome, l.cognome, COUNT(DISTINCT(operaId)) as numeroOpere\n" + //
                    "FROM recitazione r INNER JOIN lavoratore l ON r.attoreId = l.id\n" + //
                    "GROUP BY l.id, l.nome, l.cognome\n" + //
                    ")\n" + //
                    "union all\n" + //
                    "(SELECT l.id, l.nome, l.cognome, COUNT(DISTINCT(operaId)) as numeroOpere\n" + //
                    "FROM partecipazione p INNER JOIN lavoratore l ON p.membroCrewId = l.id\n" + //
                    "GROUP BY l.id, l.nome, l.cognome\n" + //
                    "))\n" + //
                    "ORDER BY numeroOpere DESC;");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("id: " + result.getString("id") + "\n");
                resultString = resultString.concat("Nome: " + result.getString("nome") + "\n");
                resultString = resultString.concat("Cognome: " + result.getString("cognome") + "\n");
                resultString = resultString.concat("Numero opere: " + result.getInt("numeroOpere") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);   
    }

    public String viewOpereWithRegistaMultipleRoles() {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT o.*\r\n" + //
                    "FROM opera o INNER JOIN partecipazione p ON o.id=p.operaId\r\n" + //
                    "GROUP BY o.id, p.ruolo , p.membroCrewId\r\n" + //
                    "HAVING p.ruolo != \"Regista\" AND p.membroCrewId IN (\r\n" + //
                    "SELECT membroCrewId\r\n" + //
                    "FROM partecipazione\r\n" + //
                    "WHERE ruolo = \"Regista\" AND operaId=o.id )");
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("id: " + result.getInt("id") + "\n");
                resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);   
    }

    public String reportUtente(String username) {
        String resultString = "";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT username, grado, nome, cognome, biografia, COUNT(s.profiloSeguente) AS numFollower\r\n" + //
                    "FROM profilo p INNER JOIN seguire s ON p.username = s.profiloSeguito\r\n" + //
                    "WHERE p.username = ?\n" + //
                    "GROUP BY p.username");
            stmt.setString(1,username);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                resultString = resultString.concat("username: " + result.getString("username") + "\n");
                resultString = resultString.concat("grado: " + result.getInt("grado") + "\n");
                resultString = resultString.concat("nome: " + result.getString("nome") + "\n");
                resultString = resultString.concat("cognome: " + result.getString("cognome") + "\n");
                resultString = resultString.concat("biografia: " + result.getString("biografia") + "\n");
                resultString = resultString.concat("follower: " + result.getInt("numFollower") + "\n\n");
            }

            resultString = resultString.concat("Opere viste e recensite:\n");
            stmt = connection.prepareStatement("SELECT o.titolo, o.descrizione, r.data, r.voto, r.descrizione AS recensione\r\n" + //
                    "FROM recensione r INNER JOIN opera o ON r.operaId = o.id\r\n" + //
                    "WHERE r.profiloId = ?");
            stmt.setString(1,username);
            result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n");
                resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                resultString = resultString.concat("data: " + result.getDate("data") + "\n");
                resultString = resultString.concat("voto: " + result.getFloat("voto") + "\n");
                resultString = resultString.concat("recensione: " + result.getString("recensione") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        return checkResult(resultString);   
    }
}
