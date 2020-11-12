package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB_Action implements DataModel {
	
	Map<String, String> userMap = new HashMap<String, String>();
	 
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

	@Override
	public boolean createCustomer(String firstName, String lastName, String eMail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomer(int id, String firstName, String lastName, String eMail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAnyCustomers() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createBicycle(String serialNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bicycle getBicycleByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBicyle(int id, String serialNumber, String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteBicycle(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean connectBicycleWithCustomer(int idBicycle, int idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnectBicycle(int idBicycle) {
		// TODO Auto-generated method stub
		return false;
	}
	
}


