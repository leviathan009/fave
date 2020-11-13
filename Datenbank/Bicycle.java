package Datenbank;

public class Bicycle {
	int bicycleid, userid;
	String serial_nr;
		
	public Bicycle(int bicycleid, int userid, String serial_nr) {
		super();
		this.bicycleid = bicycleid;
		this.userid = userid;
		this.serial_nr = serial_nr;
	}
	
	public int getBicycleid() {
		return bicycleid;
	}
	
	public void setBicycleid(int bicycleid) {
		this.bicycleid = bicycleid;
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getSerial_nr() {
		return serial_nr;
	}
	
	public void setSerial_nr(String serial_nr) {
		this.serial_nr = serial_nr;
	}
	
	
}
