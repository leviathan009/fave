package fave;
import javax.swing.SwingUtilities;

import Datenbank.DB_Action;
import Datenbank.DataModel;

public class FaVe{

	public static void main(String[] args) {
		new FaVe().init();		
	}
	
	public void init() {
		DataModel db = new DB_Action();
		//Call from EDT
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		    	GUI gui = new GUI(db);
			}
		});
	}

}
