package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DB_Action implements DataModel {
	
	HashMap<UUID, Customer> userMap = new HashMap<UUID, Customer>();
	HashMap<UUID, Bicycle> bicycleMap = new HashMap<UUID, Bicycle>();
	HashMap<Integer, Customer> userBicycleMap = new HashMap<Integer, Customer>();

	DB_Connection db_connection = new DB_Connection("localhost", "oszimt", "oszimt", "oszimt");

	
	public  DB_Action () {
		loadData();
	}
	

	@Override
	public boolean createCustomer(String firstName, String lastName, String eMail) {
		// TODO Auto-generated method stub
		UUID userGuid = NewGUID();
		userMap.put(userGuid, new Costumer(userGuid, fistName, ));
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
		String sql = "DELETE FROM user WHERE userid='"+id+"';";
		
		return db_connection.executeUpdate(sql);

	}

	@Override
	public HashMap<UUID, Customer> getAllCustomers() {
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
		String sql = "INSERT INTO user('firstname', 'lastname', 'email_address', 'lastupdate') VALUES ();";
		
		return db_connection.executeUpdate(sql);
		
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
		String sql = "DELETE FROM bicycle WHERE bicycleid='"+id+"';";
		return db_connection.executeUpdate(sql);
		
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		userMap = new HashMap<UUID, Customer>();
		
		
		// TODO Mock Data
		Customer user_arr;

		
		
		ResultSet userResult;
		ResultSet bicycleResult;
		ResultSet userBicycleResult;

    	
		
    	if( db_connection.openConnection() ) {
    		userResult = db_connection.executeQuery("SELECT * FROM user WHERE deleted=0;");
    		bicycleResult = db_connection.executeQuery("SELECT * FROM bicycle;");
    		//userBicycleResult = db_connection.executeQuery("SELECT * FROM user;");
    		
            try{
                if(userResult!=null) {
                    while(userResult.next()) {
                    	userMap.put(UUID.fromString(userResult.getString("user_guid")), new Customer(UUID.fromString(userResult.getString("user_guid")), Integer.parseInt(userResult.getString("userid")), userResult.getString("firstname"), userResult.getString("lastname"), userResult.getString("email_address"),Integer.parseInt(userResult.getString("deleted"))));
                    }
                }
                
                if(bicycleResult!=null) {
                    while(bicycleResult.next()) {
                    	bicycleMap.put(Integer.parseInt(bicycleResult.getString("bicycleid")), new Bicycle(Integer.parseInt(bicycleResult.getString("bicycleid")), Integer.parseInt(bicycleResult.getString("userid")), bicycleResult.getString("serial_nr")));
                    }
                }
                
                //if(userBicycleResult!=null) {
                    //while(userBicycleResult.next()) {
                    	//userMap.put(Integer.parseInt(userBicycleResult.getString("userid")), new Customer(Integer.parseInt(userBicycleResult.getString("userid")), userBicycleResult.getString("firstname"), userBicycleResult.getString("lastname"), userBicycleResult.getString("email_address")));
                    //}
                //}
            }
            catch (SQLException e) {
    			e.printStackTrace();
    		}
        }
    	
    	// TODO db connenction beenden
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		ResultSet userResult;
		
		for (UUID key: getAllCustomers().keySet()) {
			userResult = db_connection.executeQuery("SELECT * FROM user WHERE user_guid='"+key+"';");
			if (userResult!=null) {
				String sql = "UPDATE FROM user SET fistname=.... ;";
				db_connection.executeUpdate(sql);
			} else {
				String sql = "INSERT INTO user fistname=.... ;";
				db_connection.executeUpdate(sql);
			}
			
		}
		
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


