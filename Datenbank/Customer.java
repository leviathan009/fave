package Datenbank;
import java.util.*;
public class Customer {

	private String firstName, lastName, emailAddress;
	private int deleted=0;
	private UUID userID;
	

	public Customer(UUID userID, String firstName, String lastName, String emailAddress, int deleted) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.userID = userID;
		this.deleted = deleted;
	}


	public UUID getUserID() {
		return userID;
	}


	public void setUserID(UUID userID) {
		this.userID = userID;
	}


	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public String getFullName() {
		return getLastName() + ", " + getFirstName();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	
}
