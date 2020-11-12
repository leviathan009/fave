package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DB_Action implements DataModel {
	
	 
	public  DB_Action () {
		//
	}
	
	public Map<String, String> getUser (Integer userid) {
		
		Map<String, String> capitalCities = new HashMap<String, String>();
        	
		
    	DB_Connection db_connection = new DB_Connection("localhost", "oszimt", "oszimt", "oszimt");
		ResultSet resultSet;
		//userid = Integer.parseInt(userid);
		if (userid > 0) {
	        if(db_connection.openConnection()) {
	            resultSet = db_connection.executeQuery("SELECT * FROM user WHERE userid='"+userid+"';");
	            try {
	                if(resultSet!=null && resultSet.next()) {
	                  //  System.out.println( resultSet.getString("menu"));
	                	capitalCities.put("firstname", resultSet.getString("firstname"));
	                	capitalCities.put("lastname", resultSet.getString("lastname"));
	                	capitalCities.put("email_adrese", resultSet.getString("email_adrese"));
	            	}
	            }
	            catch (SQLException e) {
	                System.out.println("Fehler beim DB-Zugriff!" + e.toString());
	            }
	            finally { 
	            	System.out.println("finsch");
	            }
	        }
		}
		return capitalCities;
	}
	
}


