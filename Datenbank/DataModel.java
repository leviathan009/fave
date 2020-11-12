package Datenbank;
import java.util.ArrayList;

public interface DataModel {
	//Customer
	//Create
	public boolean createCustomer(String firstName, String lastName, String eMail);
	//Read
	public Customer getCustomerByID();
	//Update
	public void updateCustomer(int id, String firstName, String lastName, String eMail);
	//Delete
	public boolean deleteCustomer(int id);
	
	//Misc.
	public ArrayList<Customer> getAllCustomers();
	public boolean hasAnyCustomers();
	
	//Bicycle
	//Create
	public boolean createBicycle(String serialNo);
	//Read
	public Bicycle getBicycleByID(int id);
	//Update
	public void updateBicyle(int id, String serialNumber, String description);
	//Delete
	public boolean deleteBicycle(int id);
	
	public void loadData();
	public void saveData();
	
	//Associations
	public boolean connectBicycleWithCustomer(int idBicycle, int idUser);
	public boolean disconnectBicycle(int idBicycle);
}
