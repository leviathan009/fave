package Datenbank;
import java.util.HashMap;
import java.util.UUID;

public interface DataModel {
	//Customer
	//Create
	public boolean createCustomer(String firstName, String lastName, String eMail);
	//Read
	public Customer getCustomerByID(UUID id);
	//Update
	public void updateCustomer(UUID id, String firstName, String lastName, String eMail, int deleted);
	//Delete
	public boolean deleteCustomer(UUID id);
	
	//Misc.
	public HashMap<UUID, Customer> getAllCustomers();
	public boolean hasAnyCustomers();
	
	//Bicycle
	//Create
	public boolean createBicycle(String serialNo);
	//Read
	public Bicycle getBicycleByID(UUID id);
	//Update
	public void updateBicyle(UUID id, String serialNumber, int dleted);
	//Delete
	public boolean deleteBicycle(UUID id);
	
	public HashMap<UUID, Bicycle> getAllBicycles();
	
	public void loadData();
	public void saveData();
	
	//Associations
	public boolean connectBicycleWithCustomer(UUID idBicycle, UUID idUser);
	public boolean disconnectBicycle(UUID idBicycle);
	public HashMap<Bicycle, Customer> getConnectedEntities();
	
}
