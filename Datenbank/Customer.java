package Datenbank;
import java.util.*;
public class Customer {
	private UUID userGuid;
	private String firstName, lastName, emailAddress;
	private int userID, deleted=0;
	

	public Customer(UUID userGuid, int userID, String firstName, String lastName, String emailAddress, int deleted) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.userID = userID;
		this.deleted = deleted;
		this.userGuid = userGuid;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public UUID getUserGuid() {
		return userGuid;
	}

	public void setUserGuid(UUID userGuid) {
		this.userGuid = userGuid;
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
