package Logik;

/**
 * @author jens
 *
 */
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;


/*
 * Die Charakterklasse. Diese wird von IDrawable erben. Enthalten sind Methoden für die Steuerung 
* mit zugehöriger Exception. 
*
*
*/
public class Charakter extends Steuerung implements IDrawable {

	
	// Variablen für die Charaktere Bombertux und weitere Spieler
	public String name;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public boolean lebend = true;
	public boolean rennend = true;
	public boolean tot = false;
	public boolean spaceGedrückt = true;
	int i,j;
	public int position_ij = Map[i][j]; //Definition der Position durch die Arrayvariablen

	public int getPosition_ij() {
		return position_ij;
	}


	public void setPosition_ij(int position_ij) {
		this.position_ij = position_ij;
	}


	//Array für Bomben
	int M = 50;
	Bomben[] arr_bomben = new Bomben[M]; // Array für Bomben
	
	
//_____________________________________________________________________________________________
	
	// Methoden und Funktionen
	
	// Das Array wird mit Objekten der Klasse Bomben gefüllt.
	for(i=0; i<=arr_bomben.length; i++) {
		
		Bomben bumbum = new Bomben(false, time, effektZeile, effektSpalte, x, y);
		arr_bomben[i] = bumbum;
	}
	
	
	// Die Methode zu platzieren der Bomben
	public Bomben BombenPlatzieren (lebend,  rennend) {
		// Prüfen, ob Leertaste gedrückt und der Charakter am leben ist
		if (k.getKeyCode() == KeyEvent.VK_SPACE && (lebend || rennend)) {
			getPosition_ij(); // Hole die Position von Charakter
			Bomben.Position = setPosition_ij(); // Übergebe die Position an Bombe
			Bomben liegendeBombe = new Bomben(false, time, effektZeile, effektSpalte, x, y); // Erzeugen der Bombe
			
			else  { 
				System.out.print(getName() "ist tot!HAHAHA"); // Ausgabe, wenn der Charakter tot ist
				
			}
		}
		
	}
	
	// Konstruktor für Charakter

	
}
