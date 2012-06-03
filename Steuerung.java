package Logik;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Grafik.GamePanel;

public class Steuerung extends GamePanel implements KeyListener {

	
	private static final long serialVersionUID = -7529775006814980657L;
	protected static final Exception IOException = null;
	 
	

	// Spieler2 wird definiert, mit einem Haken in einer Checkbox im Fenster
	public boolean CheckSpieler2 = false;

	/*
	 * Diese Abfrage sollte in die Main-Methode if (CheckSpieler2 == true) {
	 * public Charakter SPIELER2 = new Charakter(M, M, M, arr_energie, M,
	 * arr_bomben);}
	 */

	// else {return void}
	
	
	
	
	/*____________________________________________________________________________________________________
	 * Aktion auf den Tasten W, A, S, D für den Spieler1 - erfolgen über einen
	 * KeyListener.Da sollte vielleicht noch eine "Repaint" Methode rein.
	 */

	public void keyPressed(KeyEvent k) {
		if (k.getKeyCode() == KeyEvent.VK_W) {
			try {
				BufferedImage SPIELER1 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j++]; An Nadescha: Die Arrayvariable musst du
			// vielleicht anpassen ;-)
			redraw();
		} 
		else if (k.getKeyCode() == KeyEvent.VK_A) {
			try {
				BufferedImage SPIELER1 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i--][j];
			redraw();
		}
		else if (k.getKeyCode() == KeyEvent.VK_S) {
			try {
				BufferedImage SPIELER1 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i++][j];
			redraw();
		}
		else if (k.getKeyCode() == KeyEvent.VK_D) {
			try {
				BufferedImage SPIELER1 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j--];
			redraw();
		}
		else if (k.getKeyCode() == KeyEvent.VK_SPACE) {
			try {
				BufferedImage BOMBE = ImageIO.read(new File("Bombe.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j--];
			redraw();
		}
	}

	public void keyReleased(KeyEvent k) {
	}

	public void keyTyped(KeyEvent k) {
	}

	/* ______________________________________________________________________________________________________
	* Aktion auf den Pfeiltasten für den Spieler2. 
	* Die Bilder müssen natürlich noch abgeändert werden
	*/

	public void keyPressed1(KeyEvent z) {
		if (z.getKeyCode() == KeyEvent.VK_UP) {
			try {
				BufferedImage SPIELER2 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j++]; An Nadescha: Die Arrayvariable musst du
			// vielleicht anpassen ;-)
			redraw();
		} 
		else if (z.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				BufferedImage SPIELER2 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i--][j];
			redraw();
		}
		else if (z.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				BufferedImage SPIELER2 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i++][j];
			redraw();
		}
		else if (z.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				BufferedImage SPIELER2 = ImageIO.read(new File("Bomberman.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j--];
			redraw();
		}
		else if (z.getKeyCode() == KeyEvent.VK_SPACE) {
			try {
				BufferedImage BOMBE = ImageIO.read(new File("Bombe.png"));
			} catch (java.io.IOException Exception) {
				Exception.printStackTrace();
			}
			// Map[i][j] = Map[i][j--];
			redraw();
		}
		
	}

	public void keyReleased1(KeyEvent z) {
	}

	public void keyTyped1(KeyEvent z) {
	}

	/*
	 * Der Konstruktor für diese Klasse
	 * __________________________________________________________________________________________________________
	 */
	
	public Steuerung(boolean checkSpieler2) {
		super();
		CheckSpieler2 = checkSpieler2;
	}

}
