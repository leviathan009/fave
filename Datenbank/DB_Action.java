package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB_Action implements DataModel {
	
	HashMap<Integer, Customer> userMap = new HashMap<Integer, Customer>();
	 
	public  DB_Action () {
		loadData();
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
	public boolean createCustomer(int id, String firstName, String lastName, String eMail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer getCustomerByID(int id) {
		return userMap.get(id);
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
	public HashMap<Integer, Customer> getAllCustomers() {
		return userMap;
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
		userMap = new HashMap<Integer, Customer>();
		// TODO Mock Data
		Customer c;
		for(int i=0;i<50;i++) {
			c = new Customer(i, "firstName"+i, "lastName", "foo@bar.abc");
			userMap.put(i, c);
		}
		
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


