package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB_Action implements DataModel {
	
	HashMap<Integer, Customer> userMap = new HashMap<Integer, Customer>();
	HashMap<Integer, Bicycle> bicycleMap = new HashMap<Integer, Bicycle>();
	HashMap<Integer, Customer> userBicycleMap = new HashMap<Integer, Customer>();

	DB_Connection db_connection = new DB_Connection("localhost", "oszimt", "oszimt", "oszimt");

	
	public  DB_Action () {
		loadData();
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
		String sql = "DELETE FROM user WHERE userid='"+id+"';";
		
		return db_connection.executeUpdate(sql);

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
		String sql = "INSERT INTO user('firstname', 'lastname', 'email_address') VALUES ();";
		
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
		userMap = new HashMap<Integer, Customer>();
		
		
		// TODO Mock Data
		Customer user_arr;

		
		
		ResultSet userResult;
		ResultSet bicycleResult;
		ResultSet userBicycleResult;

    	
		
    	if( db_connection.openConnection() ) {
    		userResult = db_connection.executeQuery("SELECT * FROM user;");
    		bicycleResult = db_connection.executeQuery("SELECT * FROM bicycle;");
    		//userBicycleResult = db_connection.executeQuery("SELECT * FROM user;");
    		
            try{
                if(userResult!=null) {
                    while(userResult.next()) {
                    	userMap.put(Integer.parseInt(userResult.getString("userid")), new Customer(Integer.parseInt(userResult.getString("userid")), userResult.getString("firstname"), userResult.getString("lastname"), userResult.getString("email_address")));
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


