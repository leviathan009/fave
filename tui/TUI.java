package tui;

import java.util.HashMap;
import java.util.Scanner;

import Datenbank.Bicycle;
import Datenbank.Customer;
import Datenbank.DataModel;
import fave.FaVe;

public class TUI {
	private boolean PROGRAM_IS_RUNNING=true;
	private DataModel dataModel; 
	private Scanner scanner;
	private FaVe mainProgram;
	
	public TUI (DataModel dataModelArg, FaVe mainProgram) {
		//Variablen vom Constructor zuweisen
		this.dataModel = dataModelArg;
		this.mainProgram = mainProgram;
		
		//Variablen intialisieren
		scanner = new Scanner(System.in);
		
		//Programm starten
		startTUI();
	}
	
	private void startTUI() {
		while(PROGRAM_IS_RUNNING) {
			// 1. Hauptmen� schreiben (Verleih Stammdaten Beenden)
			enterMainMenu();
			// 2. Verleihmen�	
					
			// 3. Stammdaten (Kundenverwaltung, Inventarverwaltung)
					
			// 4. Fahrradverwaltung
			
		}
		
	}
	
	private void enterMainMenu() {
		//Men� ausgeben
		System.out.println("\n\n*** FaVe Fahrradverwaltung ***\n"
				+ "\n---Hauptmen�---\n"
				+ "\n W�hlen Sie aus folgenden Optionen:"
				+ "\nv) Verleih"
				+ "\ns) Stammdaten"
				+ "\nb) Beenden");
		
		//Fallunterscheidung je nach Nutzereingabe
		String benutzereingabe = "";
		benutzereingabe = scanner.next();
		switch(benutzereingabe ) {
		
		case "v":
				enterLeaseMenu();
				break;
				
		case "s":
				enterBaseData();
				break;
		
		case "b":
				PROGRAM_IS_RUNNING=false;
				mainProgram.exitProgram();
				break;
		default:
				System.out.println("Ung�ltige Eingabe! Bitte geben sie ein g�ltiges Zeichen ein!");
				break;
		}	
	}
	
	private void enterLeaseMenu() {
		//Men�-Titel ausgeben
		System.out.println("\n --- Verleih ---");
		
		//aktuelle Ausleihen ausgeben
		System.out.println("Aktuelle Ausleihen:\n");
		HashMap<Bicycle, Customer> connections = dataModel.getConnectedEntities();
		if(!connections.isEmpty()) {
			for(Bicycle bike : connections.keySet()) {
				System.out.println(String.format("%s \t|%s \t|%s", bike.getBicycleID(), bike.getLabel(), connections.get(bike).getFullName()));
			}
		}
		else {
			System.out.println("Es sind derzeit keine Ausleihen vorhanden.");
		}
		
		//Men�
		System.out.println("\n d) Details"
				+ "\n f) Freigeben"
				+ "\n b) Besetzen");
		//Men�wahl je nach Nutzereingabe
	}
	
	private void enterBaseData() {
		
	}
}












