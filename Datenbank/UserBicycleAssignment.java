package Datenbank;
import java.util.*;

public class UserBicycleAssignment {
	private UUID userBicycleGuid, bicycleGuid, userGuid;
	private int deleted=0;
	private String datum;
	
	
	public UserBicycleAssignment(UUID userBicycleGuid, UUID bicycleGuid, UUID userGuid, int deleted, String datum) {
		super();
		this.userBicycleGuid = userBicycleGuid;
		this.bicycleGuid = bicycleGuid;
		this.userGuid = userGuid;
		this.deleted = deleted;
		this.datum = datum;
	}
	
	
	public UUID getUserBicycleGuid() {
		return userBicycleGuid;
	}
	public void setUserBicycleGuid(UUID userBicycleGuid) {
		this.userBicycleGuid = userBicycleGuid;
	}
	public UUID getBicycleGuid() {
		return bicycleGuid;
	}
	public void setBicycleGuid(UUID bicycleGuid) {
		this.bicycleGuid = bicycleGuid;
	}
	public UUID getUserGuid() {
		return userGuid;
	}
	public void setUserGuid(UUID userGuid) {
		this.userGuid = userGuid;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	
}
