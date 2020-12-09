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
		
		// 1. Hauptmenü schreiben (Verleih Stammdaten Beenden)
		enterMainMenu();
		// 2. Verleihmenü	
				
		// 3. Stammdaten (Kundenverwaltung, Inventarverwaltung)
				
		// 4. Fahrradverwaltung 
	
	}
	
	private void enterMainMenu() {
		//Menü ausgeben
		System.out.println("\nFaVe Fahrradverwaltung"
				+ "\nHauptmenü"
				+ "\nv) Verleih"
				+ "\ns) Stammdaten"
				+ "\nb) Beenden");
		
		//Fallunterscheidung je nach Nutzereingabe
		String benutzereingabe = ""; //TODO: noch befüllen
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
				System.out.println("Ungültige Eingabe! Bitte geben sie ein gültiges Zeichen ein!");
				break;
		}	
	}
	
	private void enterLeaseMenu() {
		//Menü ausgeben
		System.out.println("\n --- Verleih ---"
				+ "\n Aktuelle Ausleihen:");
		
		//aktuelle Ausleihen ausgeben
		HashMap<Bicycle, Customer> connections = dataModel.getConnectedEntities();
		if(!connections.isEmpty()) {
			for(Bicycle bike : connections.keySet()) {
				System.out.println(String.format("%s \t|%s \t|%s", bike.getBicycleID(), bike.getLabel(), connections.get(bike).getFullName()));
			}
			//Menü
			System.out.println("\n d) Details"
					+ "\n f) Freigeben"
					+ "\n b) Besetzen");
		}
		else {
			//TODO: Was wenn keine Augaben vorhanden?
		}
		
		//Menüwahl je nach Nutzereingabe
	}
	
	private void enterBaseData() {
		
	}
	
	private void enterEndMenu() {
		
		}
}












