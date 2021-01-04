package fave;
import java.util.UUID;

import javax.swing.SwingUtilities;

import Datenbank.DB_Action;
import Datenbank.DataModel;
import tui.TUI;

public class FaVe{
	private static FaVe fave;
	public static void main(String[] args) {
		fave = new FaVe();
		UUID userGuid = UUID.randomUUID();
		System.out.println(userGuid);
		fave.init();		
	}
	
	public void init() {
		DataModel dm = new DB_Action();
		//DataModel dm = new JSON_Action();
		//Call from EDT
    	SwingUtilities.invokeLater(new Runnable() {
			public void run() {
		    	GUI gui = new GUI(dm);
		    	//TUI tui = new TUI(dm, fave);
			}
		});
	}
	
	public void exitProgram() {
		System.out.println("Programm wird beendet.");
		System.exit(0);
	}
}
