package Logik;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;


public class Bomben {
	
	boolean bombeGelegt = false; /* boole'scher Wert, um die folgende for-Schleife zu aktivieren.
	* Ist true, wenn eine Bombe gelegt wird.
	*/
	int time = 3000;
	int effektZeile = 4; // Effekte in den Zeilen
	int effektSpalte = 4; // Effekte in den Spalten
	int x,y;
	int[x][y] Position = Map[i][j];
	
	public Bomben(boolean bombeGelegt, int time, int effektZeile,
			int effektSpalte, int x, int y) {
		super();
		this.bombeGelegt = bombeGelegt;
		this.time = time;
		this.effektZeile = effektZeile;
		this.effektSpalte = effektSpalte;
		this.x = x;
		this.y = y;
	}
	
	//Ob bombeGelegt "true" ist wird über einen "Getter" und "Setter" gelöst
		while (bombeGelegt == true) { 
			//get-Methode für die Position, deren Koordinaten Position übergeben werden, sowie an die Schleifen	
				// Zeitzünder von 3 Sekunden
				Thread.sleep(time);
					// Die for-Schleifen beziehen sich auf die Felder der Karte
					for(int x = 0; x == 4; x++) {
						for(int y = 0; y == 4; y++) { 
							/* Abfragen, um welche Art Feld es sich handelt: normales,
							 * statische Mauer, zerstörbare Mauer.
							 * Die Konstanten müssen noch angepasst werden
							 * genau wie die Bilder ja noch gemalt werden müssen
							 */
							if(Position[x][y] == ZERSTÖRBAREMAUER) {
								try {
									BufferedImage Bomberman1 = ImageIO.read(new File(
											"normalesFeld"));
								} catch (java.io.IOException Exception) {
									Exception.printStackTrace();
								}
							}
							else if(Position[x][y] == STATISCHE MAUER) {
								try {
									BufferedImage Bomberman1 = ImageIO.read(new File(
											"STATISCHE MAUER"));
								} catch (java.io.IOException Exception) {
									Exception.printStackTrace();
								}
							}
							else if(Position[x][y] == NORMALESFELD {
								try {
									BufferedImage Bomberman1 = ImageIO.read(new File(
											"NORMALESFELD"));
								} catch (java.io.IOException Exception) {
									Exception.printStackTrace();
								}
							}
						
					
						}
					
					}
		bombeGelegt = false;	
		}
	
	}
	
}