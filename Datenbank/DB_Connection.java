package Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class DB_Connection {	    
    private String host;
    private String database;
    private String user;
    private String password;
    private Connection dbConnection; 
    private Statement sqlStatement;  
    private ResultSet resultSet;     
    
    
    public DB_Connection(String pHost, String pDatabase, String pUser, String pPassword) {
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //JDBC-Treiberklasse, die die Kommunikation mit MySQL-DBMS ermöglicht.
        
        host = pHost;
        database = pDatabase;
        user = pUser;
        password = pPassword;
        
        try{
            Class.forName(JDBC_DRIVER); //Beim Laden der JDBC-Treiberklasse, registriert diese sich beim JDBC-Treibermanager.
            System.out.println("JDBC-Treiber beim JDBC-Treibermanager registriert...");
        }
        catch(ClassNotFoundException e){
            System.out.println("JDBC-Treiber nicht gefunden: " + e.toString());
        }
    }
    	
   
    
    
    //Datenbank-Verbindung öffnen
    public boolean openConnection() {
        String url = "jdbc:mysql://" + host + "/" + database; //JDBC-URL ("Wo finde ich die Datenbank?")
        boolean connected = false;
        
        try{
            dbConnection = DriverManager.getConnection(url, user, password); //Beim DriverManager ein Connection-Objekt (DB-Verbindung) anfordern
            connected = true;
            System.out.println("Verbindung hergestellt...");
        }
        catch(SQLException e){
            System.out.println("Datenbankverbindung fehlgeschlagen: " + e.toString());
        }
        
        return connected;
    }    
 
    
    
    
    //SQL-Anweisung (Abfrage) ausführen und Rückgabe des entsprechenden Abfrageergebnisses
    public ResultSet executeQuery(String pSql) {
        ResultSet resultSet = null;
        
        try {
            sqlStatement = dbConnection.createStatement();   
            resultSet = sqlStatement.executeQuery(pSql);     
            this.resultSet = resultSet;                      
            System.out.println("Datenbank-Abfrage durchgeführt...");
        }
        catch(SQLException e){
            System.out.println("Datenbank-Abfrage fehlgeschlagen: " + e.toString());
            System.out.println("SQL-Anweisung: " + pSql);
        }
        
        return resultSet;
    }
    
    
    
    //SQL-Anweisung (Datenmanipulation) ausführen (z. B. INSERT INTO, UPDATE der DELETE)
    public boolean executeUpdate(String pSql) {
        boolean executed = false;
        
        try{
            sqlStatement = dbConnection.createStatement();   
            sqlStatement.executeUpdate(pSql);               
            executed = true;
            System.out.println("Datenbank-Aktualisierung durchgeführt...");
        }
        catch(SQLException e){
            System.out.println("Datenbank-Aktualisierung fehlgeschlagen: " + e.toString());
            System.out.println("SQL-Anweisung: " + pSql);
        }
        
        return executed;
    }
    
}





