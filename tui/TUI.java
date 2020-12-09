package tui;

import java.util.HashMap;

import Datenbank.Bicycle;
import Datenbank.Customer;
import Datenbank.DataModel;

public class TUI {
	private DataModel dataModel; 
	public TUI (DataModel dataModelArg) {
		//Variablen vom Constructor zuweisen
		this.dataModel = dataModelArg;
		
		// 1. Hauptmen� schreiben (Verleih Stammdaten Beenden)
		enterMainMenu();
		// 2. Verleihmen�	
				
		// 3. Stammdaten (Kundenverwaltung, Inventarverwaltung)
				
		// 4. Fahrradverwaltung 
	
	}
	
	private void enterMainMenu() {
		//Men� ausgeben
		System.out.println("\nFaVe Fahrradverwaltung"
				+ "\nHauptmen�"
				+ "\nv) Verleih"
				+ "\ns) Stammdaten"
				+ "\nb) Beenden");
		
		//Fallunterscheidung je nach Nutzereingabe
		String benutzereingabe = ""; //TODO: noch bef�llen
		switch(benutzereingabe ) {
		
		case "v":
				enterLeaseMenu();
				break;
				
		case "s":
				enterBaseData();
				break;
		
		case "b":
				enterEndMenu();
				break;
		default:
				System.out.println("Ung�ltige Eingabe! Bitte geben sie ein g�ltiges Zeichen ein!");
				break;
		}	
	}
	
	private void enterLeaseMenu() {
		//Men� ausgeben
		System.out.println("\n --- Verleih ---"
				+ "\n Aktuelle Ausleihen:");
		
		//aktuelle Ausleihen ausgeben
		HashMap<Bicycle, Customer> connections = dataModel.getConnectedEntities();
		if(!connections.isEmpty()) {
			for(Bicycle bike : connections.keySet()) {
				System.out.println(String.format("%s \t|%s \t|%s", bike.getBicycleID(), bike.getLabel(), connections.get(bike).getFullName()));
			}
			//Men�
			System.out.println("\n d) Details"
					+ "\n f) Freigeben"
					+ "\n b) Besetzen");
		}
		else {
			//TODO: Was wenn keine Augaben vorhanden?
		}
		
		//Men�wahl je nach Nutzereingabe
	}
	
	private void enterBaseData() {
		
	}
	
	private void enterEndMenu() {
		
		}
}












