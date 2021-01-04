package Datenbank;

//import DB_Connection.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DB_Action implements DataModel {
	
	HashMap<UUID, Customer> userMap = new HashMap<UUID, Customer>();
	HashMap<UUID, Bicycle> bicycleMap = new HashMap<UUID, Bicycle>();
	HashMap<UUID, UserBicycleAssignment> userBicycleMap = new HashMap<UUID, UserBicycleAssignment>();

	DB_Connection db_connection = new DB_Connection("localhost", "oszimt", "oszimt", "oszimt");

	
	public  DB_Action () {
		loadData();
		//System.out.println(userBicycleMap);
		/createCustomer("nana", "lolo", "nana@lolo.de");
		//saveData();
	}
	

	@Override
	public boolean createCustomer(String firstName, String lastName, String eMail) {
		// TODO Auto-generated method stub
		UUID userGuid = UUID.randomUUID();
		userMap.put(userGuid, new Customer(userGuid, firstName, lastName, eMail, 0));
		System.out.println(getCustomerByID(userGuid).getFullName());
		System.out.println("qweqwe");
		return true;
	}

	@Override
	public Customer getCustomerByID(UUID id) {
		return userMap.get(id);
	}

	@Override
	public void updateCustomer(UUID id, String firstName, String lastName, String eMail, int deleted) {
		// TODO Auto-generated method stub
		userMap.put(id, new Customer(id, firstName, lastName, eMail, deleted));
		
	}

	@Override
	public boolean deleteCustomer(UUID id) {
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
		UUID bicycleGuid = UUID.randomUUID();
		bicycleMap.put(bicycleGuid, new Bicycle(bicycleGuid, serialNo, 0));
		return true;
	}

	@Override
	public Bicycle getBicycleByID(UUID id) {
		// TODO Auto-generated method stub
		return bicycleMap.get(id);
		
	}

	@Override
	public void updateBicyle(UUID id, String serialNumber, int deleted) {
		// TODO Auto-generated method stub
		bicycleMap.put(id, new Bicycle(id, serialNumber, deleted));
	}

	@Override
	public boolean deleteBicycle(UUID id) {
		// TODO Auto-generated method stub
		
		return false;
	}
	
	@Override
	public HashMap<UUID, Bicycle> getAllBicycles() {
		return bicycleMap;
	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		userMap = new HashMap<UUID, Customer>();
		
		
		// TODO Mock Data		
		ResultSet userResult;
		ResultSet bicycleResult;
		ResultSet userBicycleResult;

    	
    	if( db_connection.openConnection() ) {
    		userResult = db_connection.executeQuery("SELECT * FROM user WHERE deleted=0;");
    		bicycleResult = db_connection.executeQuery("SELECT * FROM bicycle;");
    		userBicycleResult = db_connection.executeQuery("SELECT * FROM user_bicycle;");
    		
            try{
                if(userResult!=null) {
                    while(userResult.next()) {
                    	//FIXME implement
                    	userMap.put(UUID.fromString(userResult.getString("user_guid")), new Customer(UUID.fromString(userResult.getString("user_guid")), userResult.getString("firstname"), userResult.getString("lastname"), userResult.getString("email_address"),Integer.parseInt(userResult.getString("deleted"))));
                    }
                }
                
                if(bicycleResult!=null) {
                    while(bicycleResult.next()) {
                    	//FIXME implement
                    	bicycleMap.put(UUID.fromString(bicycleResult.getString("bicycle_guid")), new Bicycle(UUID.fromString(bicycleResult.getString("bicycle_guid")), bicycleResult.getString("serial_nr"), Integer.parseInt(bicycleResult.getString("deleted"))));
                    }
                }
                
                if(userBicycleResult!=null) {
                    while(userBicycleResult.next()) {
                    	userBicycleMap.put(UUID.fromString(userBicycleResult.getString("user_bicycleguid")), new UserBicycleAssignment(UUID.fromString(userBicycleResult.getString("user_bicycleguid")), UUID.fromString(userBicycleResult.getString("user_guid")), UUID.fromString(userBicycleResult.getString("bicycle_guid")), Integer.parseInt(userBicycleResult.getString("deleted")), userBicycleResult.getString("datum"))); 
                    }
                }
            }
            catch (SQLException e) {
    			e.printStackTrace();
    		}
        }
    	
    	// TODO db_connenction_beenden
		
	}

	@Override
	public void saveData() {
		// TODO Auto-generated method stub
		ResultSet Result;
		Customer c;
		
		for (UUID key: getAllCustomers().keySet()) {
			c = getCustomerByID(key);
			String IsGuid = "";
			Result = db_connection.executeQuery("SELECT * FROM user WHERE user_guid='"+key+"';");
            try{
                if(Result!=null) {
                    while(Result.next()) {
                    	IsGuid = Result.getString("user_guid");	
                    }
                }
            }
            catch (SQLException e) {
            	e.printStackTrace();
            }
			
			if (IsGuid.length()>0) {
				String sql = "UPDATE FROM user SET fistname=.... ;";
				db_connection.executeUpdate(sql);
			} else {
				String sql = "INSERT INTO user (`user_guid`, `firstname`, `lastname`, `email_address`, `deleted`, `lastupdate`) VALUES ('"+c.getUserID()+"','"+c.getFirstName()+"','"+c.getLastName()+"','"+c.getEmailAddress()+"','"+c.getDeleted()+"',now());";
				db_connection.executeUpdate(sql);
			}
			
		}
		
		Bicycle b;
		for (UUID key: getAllBicycles().keySet()) {
			b = getBicycleByID(key);
			String IsGuid = "";
			Result = db_connection.executeQuery("SELECT * FROM bicycle WHERE bicycle_guid='"+key+"';");
			
			try{
                if(Result!=null) {
                    while(Result.next()) {
                    	IsGuid = Result.getString("bicycle_guid");	
                    }
                }
            }
            catch (SQLException e) {
            	e.printStackTrace();
            }
			
			
			if (IsGuid.length()>0) {
				String sql = "UPDATE FROM bicycle SET serial_nr='"+b.getSerialNr()+"', deleted='"+ b.getDeleted() +"' ;";
				db_connection.executeUpdate(sql);
			} else {
				String sql = "INSERT INTO bicycle (`bicycle_guid`, `serial_nr`, `lastupdate`, `deleted`)  VALUES ("+b.getBicycleGuid()+","+b.getSerialNr()+",now(),"+b.getDeleted()+");";
				db_connection.executeUpdate(sql);
			}
		}
		
	}

	@Override
	public boolean connectBicycleWithCustomer(UUID idBicycle, UUID idUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disconnectBicycle(UUID idBicycle) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public HashMap<Bicycle, Customer> getConnectedEntities() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


