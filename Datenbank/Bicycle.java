package Datenbank;
import java.util.*;

public class Bicycle {
	int bicycleID, deleted=0;
	String serialNr, label;
	UUID bicycleGuid;
	
	public Bicycle(int bicycleID, int deleted, String serialNr, UUID bicycleGuid, String labelArg) {
		super();
		this.bicycleID = bicycleID;
		this.deleted = deleted;
		this.serialNr = serialNr;
		this.bicycleGuid = bicycleGuid;
		this.label = labelArg;
	}
	
	
	public int getBicycleID() {
		return bicycleID;
	}
	public void setBicycleID(int bicycleID) {
		this.bicycleID = bicycleID;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getSerialNr() {
		return serialNr;
	}
	public void setSerialNr(String serialNr) {
		this.serialNr = serialNr;
	}
	public UUID getBicycleGuid() {
		return bicycleGuid;
	}
	public void setBicycleGuid(UUID bicycleGuid) {
		this.bicycleGuid = bicycleGuid;
	}


	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
