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
    public String showUsers() {
        String resultString = "";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT username FROM reviewit.profilo");
    
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                resultString = resultString.concat("username: " + result.getString("username") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }

        return checkResult(resultString);
    }

    public String showOpere() {
        String resultString = "";
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT titolo FROM reviewit.opera");
    
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                //resultString = resultString.concat("id: " + result.getString("id") + "\n");
                //resultString = resultString.concat("tipo: " + result.getInt("tipo") + "\n");
                //resultString = resultString.concat("durata: " + result.getTime("durata") + "\n");
                resultString = resultString.concat("titolo: " + result.getString("titolo") + "\n\n");
                //resultString = resultString.concat("descrizione: " + result.getString("descrizione") + "\n");
                //resultString = resultString.concat("locandina: " + result.getString("locandina") + "\n");
                //resultString = resultString.concat("data di uscita: " + result.getDate("dataDiUscita") + "\n");
                //resultString = resultString.concat("classificazione: " + result.getString("classificazione") + "\n");
                //resultString = resultString.concat("voto medio: " + result.getFloat("votoMedio") + "\n\n");
            }
        } catch (SQLException e) {
            resultString = "Esecuzione query fallita";
        }
        
        return checkResult(resultString);
    }
        
    public String insertAttore(String nome, String cognome, String immagine, String dataDiNascita, String dataDiMorte, String titolo, String personaggio) {
        int idLavoratore = -1;
        String resultString = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO reviewit.lavoratore\n" + //
                    "\t(nome, cognome, immagine, dataDiNascita, dataDiMorte)\n" + //
                    "\tVALUES (?, ?, ?, ?, ?)");
            stmt.setString(1,nome);
            stmt.setString(2,cognome);
            stmt.setString(3,immagine);
            stmt.setString(4,dataDiNascita);

            if(!dataDiMorte.equals("")){
                stmt.setString(5,dataDiMorte);
            }else{
                stmt.setString(5,null);
            }
    
            stmt.executeUpdate();

        }catch (SQLException e) {
                resultString = "Esecuzione query 1.1 fallita";
                return resultString;
        }

        try{
            stmt = connection.prepareStatement("SELECT id\n" + //
                    "FROM lavoratore\n" + //
                    "WHERE nome = ? AND cognome = ? AND immagine = ? AND dataDiNascita = ?");
            stmt.setString(1,nome);
            stmt.setString(2,cognome);
            stmt.setString(3,immagine);
            stmt.setString(4,dataDiNascita);
            result = stmt.executeQuery();
            while (result.next()) {
                idLavoratore = result.getInt("id");
            }
        }catch (SQLException e) {
                resultString = "Esecuzione query 1.2 fallita";
                return resultString;
        }

        try{

            stmt = connection.prepareStatement("INSERT INTO reviewit.attore\n" + //
                    "\t(lavoratoreId)\n" + //
                    "\tVALUES(?)");
            stmt.setInt(1,idLavoratore);
            stmt.executeUpdate();

        }catch (SQLException e) {
            resultString = "Esecuzione query 1.3 fallita";
            return resultString;
        }

        try{

            System.out.println("idLavoratore: " + idLavoratore + " personaggio: " + personaggio + " titolo: " + titolo);

            stmt = connection.prepareStatement("INSERT INTO reviewit.recitazione\n" + //
                    "\t(operaId, attoreId, nomePersonaggio)\n" + //
                    "SELECT o.id, (?), (?)\n" + //
                    "FROM opera o\n" + //
                    "WHERE titolo LIKE ?");
            stmt.setInt(1,idLavoratore);
            stmt.setString(2,personaggio);
            stmt.setString(3,titolo + "%");
            stmt.executeUpdate();

            resultString = "Inserimento lavoratore avvenuto con successo";
        } catch (SQLException e) {
            resultString = "Esecuzione query 1 fallita";
            return resultString;
        }
        return checkResult(resultString);
    }

    public String insertRecensione(String username,String titolo, String data, float voto, String descrizione, Boolean preferito, Boolean spoiler) {
        int idOpera = -1;
        String resultString = "";
        PreparedStatement stmt = null;
        ResultSet result = null;
        try {
            stmt = connection.prepareStatement("SELECT o.id " +
                                "FROM opera o " +
                                "WHERE o.titolo LIKE ?");
            stmt.setString(1, titolo + "%");
            result = stmt.executeQuery();
            if (result.next()) {
                idOpera = result.getInt("id");
            }
        } catch (SQLException e) {
            resultString = "Errore query 1";
            return resultString;
        }

        try {
            stmt = connection.prepareStatement("INSERT INTO reviewit.recensione " + //
                                "\t(profiloId, operaId, data, voto, descrizione, preferito, spoiler) " + //
                                "\tVALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, username);
            stmt.setInt(2, idOpera);
            stmt.setString(3, data);
            stmt.setFloat(4, voto);
            stmt.setString(5, descrizione);
            stmt.setBoolean(6, preferito);
            stmt.setBoolean(7, spoiler);
            stmt.executeUpdate();
        } catch (SQLException e) {
            resultString = "Errore query 2";
            return resultString;
        }

        try {
            stmt = connection.prepareStatement("UPDATE opera \n" + //
                                "SET opera.votoMedio = ROUND(((opera.votoMedio * opera.numRecensioni) + ?) / (opera.numRecensioni + 1),1) \n" + //
                                "WHERE opera.id = ?");
            stmt.setFloat(1, voto);
            stmt.setInt(2, idOpera);
            stmt.executeUpdate();
        } catch (SQLException e) {
            resultString = "Errore query 3";
            return resultString;
        }

        try {
            stmt = connection.prepareStatement("UPDATE opera \n" + //
                                "SET opera.numRecensioni = opera.numRecensioni + 1 \n" + //
                                "WHERE opera.id = ?");
            stmt.setInt(1, idOpera);
            stmt.executeUpdate();
        } catch (SQLException e) {
            resultString = "Errore query 4";
            return resultString;
        }
        resultString = "Inserimento recensione avvenuto con successo";
        return resultString;
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
