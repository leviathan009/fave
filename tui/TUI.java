package tui;

import Datenbank.DataModel;

public class TUI {

	public TUI (DataModel tui) {
		// 1. Hauptmen� schreiben (Verleih Stammdaten Beenden)
		enterMainMenu();
		// 2. Verleihmen�	
		
		
		
		
		// 3. Stammdaten (Kundenverwaltung, Inventarverwaltung)
		
		
		
		// 4. Fahrradverwaltung 
	
	}
	
	private void enterMainMenu() {
		System.out.println("\nFaVe Fahrradverwaltung"
				+ "\nHauptmen�"
				+ "\nv) Verleih"
				+ "\ns) Stammdaten"
				+ "\nb) Beenden");
		switch(i) {
		
		case 'v':
				enterLeaseMenu();
				break;
				
		case 's':
				enterBaseData();
				break;
		
		case 'b':
				enterEndMenu();
				break;
		default:
				System.out.println("Ung�ltige Eingabe! Bitte geben sie ein g�ltiges Zeichen ein!");
				break;
		}	
	}
	
	private void enterLeaseMenu() {
		System.out.println("\n --- Verleih ---"
				+ "\n Aktuelle Ausleihen:");
		if (true) {
			
		}
		else
		{
		System.out.println("\n d) Details"
				+ "\n f) Freigeben"
				+ "\n b) Besetzen");
		}
	}
	
	private void enterBaseData() {
		
	}
	
	private void enterEndMenu() {
		
		}
}












