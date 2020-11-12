
//import Datenbank;
import Datenbank.*;
import java.util.HashMap;
import java.util.Map;

public class test {
	
    public static void main(String[] args) {
    	
    	
    	DataModel db = new DB_Action();
    	GUI gui = new GUI(db);
    	
    	//DB_Connection db_connection = new DB_Connection("localhost", "oszimt", "oszimt", "oszimt");
        //ResultSet resultSet;
        //String insert = "INSERT INTO `user`(`firstname`, `lastname`, `email_adrese`) VALUES ('Ali','Rmayid','ar@phlux.de')";
    
        //if(db_connection.openConnection()) {
            //resultSet = db_connection.executeQuery("SELECT * FROM cms__menu WHERE menuid='1';");
            
        	//db_connection.executeUpdate(insert);
            //try {
            	
                //if(resultSet!=null && resultSet.next()) {
                  //  System.out.println( resultSet.getString("menu"));
                //}
            	    
            //}
            //catch (SQLException e) {
              //  System.out.println("Fehler beim DB-Zugriff!" + e.toString());
            //}
            //finally { 
            	//Falls eine Exception geworfen wird, die keine SQLException ist, werden Anweisungen, die auf das try-catch-Konstrukt folgen, nicht mehr ausgeführt. Anweisungen im finally-Block werden jedoch auch in diesem Fall ausgeführt.
                //db_connection.closeConnection();
            	//System.out.println("finsch");
            //}
        //}
    	
    	
    	DB_Action  db_action = new DB_Action();
		Map<String, String> user = new HashMap<String, String>();
		
    	
		user = db_action.getUser(1);
    	
    	System.out.println(user.get("firstname"));
    	System.out.println(user.get("lastname"));
    	System.out.println(user.get("email_adrese"));
    	
    	user.put("firstname", "chris");
    	
    	
    	//db_action.setUser(1, user);
    	
    	System.out.println(user.get("firstname"));
    	
    }    
}	
    
