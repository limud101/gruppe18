import java.awt.Color;

public class Arena {

	static byte w = 25;
	static byte h = 25;

	static Color color;
	static byte levelswitch = 0;

	static double y = 0;
	static double a = 0.7; // Beschleunigung
	static int n = 0;

	static double[][] feld = new double[w][h];
	public static boolean space = false;

	// counter
	public static int counter = 0;
	public static int obst = 0;
	public static byte cxy = 0; // Information wurde obere oder untere Wand
								// getroffen?

	// Konstruktoren

	static double[] inventar = new double[5];

	public static Player Player = new Player(0, 0);

	public static Apple apple = new Apple(0, 0);

	static String signal;

	public static boolean run = true;

	public static boolean help = false;

	public static boolean esc = false;
	public static boolean right = false;

	// ////////////////////////////////////////////////////////////////////////////////
	// / main
	// test test
	public static void main(String[] args) {

		draw();

		new Player(0, 0);
		new Engine().start();

	}


	// Initialisiere Screen

	static void draw() {
		StdDraw.setCanvasSize(w * 25, h * 25);
		StdDraw.setXscale(-w, w);
		StdDraw.setYscale(-h, h);
	

	}

	// ////////////////////////////////////////////////////////////////////////////////
	// / Steuerung
	// ///////////////////////////////////////////////////////////////////////////////

	private static void tasten(byte levelswitch2) {

		if (esc) {

			StdDraw.text(0, 0, "Spiel wird in wenigen Sekunden beendet...");
			StdDraw.show(500);
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.text(0, 0, "Wird das Spiel beendet ???");
			StdDraw.show(500);
			StdDraw.show(500);
			StdDraw.clear(StdDraw.BLACK);
			StdDraw.text(0, 0, "Spiel beendet wird.");
			StdDraw.show(500);

			StdDraw.clear(StdDraw.BLUE);
			StdDraw.text(0, 0, "ALLES GUTE!");
			StdDraw.show(500);
			System.exit(0);

		}
		if ((right)) {
			if (levelswitch == 99) {
				Player.health = 100;
				levelswitch = 0;
			}
		}

		if (StdDraw.mousePressed()) {

			counter++;

		}

	}

	static void steuerung() {
		Engine.interrupted();
		collision();
		tasten(levelswitch);

		// Levelswitch f�r das schnelle wechseln von Levels

	}

	// ////////////////////////////////////////////////////////////////////////////////
	// / Kollision
	// ///////////////////////////////////////////////////////////////////////////////

	private static void collision() {

		// Arena.x = Player.x;
		// Arena.y = Player.y;

		if (Player.x >= w) {

			Player.x = w;

			if (levelswitch == 0)
				colorwall();
		}
		if (Player.x <= -w) {
			Player.x = -w;

		}
		if (Player.y >= h) {
			Player.y = h;

		}
		if (Player.y <= -h) {
			Player.y = -h;

			if (levelswitch <= 1)
				if (Player.health <= 90) {
					apfel();
				}

		}

	}

	// /////////////////////
	// / Levels
	// //////////////////////

	private static void welcome() {

		String message = "";

		StdDraw.setPenColor(StdDraw.WHITE);

		counter = 200;

		while (counter > 1) {
			counter--;
			steuerung();

			StdDraw.picture(0, 0, "jpg/introscreen.jpg", 0.1 * Math.PI
					* Math.PI * counter, 0.1 * counter, -counter * 4.5);
			message = "BOMBR";
			if (space) {/* Do something */
			}
			StdDraw.textLeft(-counter * 4, h + Math.sin(counter), message);
			StdDraw.textRight(counter * 4, -h + Math.cos(counter), message);

			StdDraw.show(0.5);
		}
		counter = 0;

		StdDraw.show(50);
		String kette = "Die Position des Spielers ist ";
		StdDraw.textLeft(-w, 0, message);
		StdDraw.show(100);

		message = "Steuer das Spiel mit Pfeil oben, unten, rechts, x und Space.";

		if (Player.y <= 0) {
			kette += " unterhalb";
		} else {
			kette += " oberhalb";
		}

		if (Player.x <= w / 8) {
			kette += " und mittig";
		} else {
			kette += " und aussen";
		}

		if (Player.x <= 0) {
			kette += " links im Feld";

		} else {
			kette += " rechts im Feld.";
		}

		StdDraw.textLeft(-w, -10, message);
		StdDraw.textLeft(-w, -12, kette);
		StdDraw.show(4000);

	}

	static void levelswitch() {

		gate1();

		gate3();
		gate4();

		if (levelswitch == 0) {
			mainlevel();

		}
		if (levelswitch == 1) {
			setuplevel();
		}

		if (levelswitch == 3) {
			laserlevel();
		}

		if (obst >= 3) {
			levelswitch = 2;
			obstlevel();
		}

		if (levelswitch == 99) {
			StdDraw.clear();

			gameover();
		}

	}

	private static void setuplevel() {

		gate2();
		StdDraw.picture(0, 0, "jpg/boden.jpg", w * 3, h * 3);
		StdDraw.picture(0, h - 4, "gif/pfeil_oben.gif");
		StdDraw.setPenColor(color);
		String message = "Setup Level: Ausr�stung / PowerUps";
		StdDraw.text(0, -h, message);

	}

	private static void laserlevel() {
		double x = Player.x;
		double y = Player.y;

		Player.allowed = false;
		gate2();

		counter++;
		double ang = Math.atan2(y, x) * 180 / Math.PI + 90;
		double speed = 12;
		double angRad = Math.toRadians(ang - 90);
		double movx = Math.cos(angRad) * speed;

		double movy = Math.sin(angRad) * speed;
		StdDraw.text(0, h, String.valueOf(ang));

		StdDraw.picture(0, -h, "png/flame.png", w, h);
		StdDraw.picture(-w, -h, "png/flame.png", w, h);
		StdDraw.picture(w, -h, "png/flame.png", w, h);
		StdDraw.picture(0, 0, "png/iris2.png", 10, 10);

		movx += movx / -counter;
		movy += movy / -counter;

		StdDraw.circle(movx, movy, Math.abs(1 - counter * 0.2));
		StdDraw.picture(0, 0, "png/fuzzy.png", 5, 5, ang);
		StdDraw.picture(0, h - 4, "gif/pfeil_oben.gif");

		StdDraw.setPenColor(color);

		if (counter >= 10) {
			counter = 1;

		}

	}

	private static void levelbrand() {
		StdDraw.picture(-w, h, "png/unicorn.png", 6, 6);
		// StdDraw.picture(w - 4, h - 2, "png/blocks.png", 16, 16, -30);
		StdDraw.picture(w - 4, h - 2, "png/blocks.png", 0, 0, 30);
	}

	private static void mainlevel() {
		Player.allowed = true;
		StdDraw.setPenColor(color);
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.filledSquare(0, 0, w);

		StdDraw.picture(Player.x, Player.y, "gif/teleport.gif");
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.filledSquare(0, 0, w - 1);

		StdDraw.setPenColor(color);
		StdDraw.filledSquare(0, 0, w - 1);

		StdDraw.picture(w - 7, -h + 7, "gif/Jabba_Granate.gif", 15, 15);

		String message = "Kampflevel: Erprobe deine Skills";
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0, -h - 1, message);

		levelbrand();
	}

	private static void gameover() {

		StdDraw.text(0, 5, "GAME OVER");
		StdDraw.text(0, -5,
				"Continue?? HOLD ESC for exit // RIGHT for continue");
		StdDraw.picture(0, 0, "gif/deko1.gif");
		StdDraw.show(400);

		StdDraw.picture(0, 0, "gif/deko.gif");
		StdDraw.show(400);

		StdDraw.show(1200);

		Player.x = -w;
		Player.y = 0;

	}

	private static void obstlevel() {

		counter++;
		StdDraw.picture(0, 0, "png/chip.png", w * 4, h * 4, -counter * 0.3);

		StdDraw.picture(-w, h, "gif/apple.gif", 6, 6, Math.sin(counter * 1.36));

		StdDraw.picture(w - 5, -h + 5, "png/wolke.png", 50, 100, 0);
		Player.lastkey = 0;

		// Exitbedingung des Levels
		if (apple.anzahl == 5) {

			apple.anzahl = 0;
			levelswitch = 3;
			Arena.obst = 0;
			Player.y = 0;
			a = 1;

			counter = 0;

		}

		// Ausgangsbedingung des Levels
		if (n == 0) {
			// LR

			if (cxy == 1) {
				apple.y = Math.random() * h;

			}
			// OU
			if (cxy == 2) {
				apple.x = Math.random() * w;

			}

			n++;
			cxy = 0;
		}

		StdDraw.text(Player.x, h + 1, "�pfel: " + apple.anzahl);

		// Apfelkollision (mit dem Spieler)

		if ((Math.abs(apple.x - Player.x) <= w * 0.1)
				&& (Math.abs(apple.y - Player.y) <= h * 0.1)) {
			StdDraw.text(apple.x, apple.y + 5, "Apfel gefunden!");
			Player.health += 7;

			apple.anzahl++;
			a *= 1.5;
			n = 0;

		}
		apple.run();

		// Beschleunigung des Apfels
		if (apple.anzahl % 2 == 0) {
			apple.x += Arena.a;

		} else {
			apple.y += Arena.a;

		}

		// Apfelkollision (mit der Wand)

		// mit LR
		if ((apple.x > w + 4) || (apple.x < -w - 15)) {
			a = a * -1; // Wenn apple die Wand trifft �ndere die Richtung der
						// Beschleunigung a
			apple.y += Math.random() * 10;
			if (apple.y > h) {
				apple.y = -h;
			}

			if (cxy == 1) {

				apple.x = apple.y;

			}
			cxy = 1;
		}
		// mit OU
		if ((apple.y > h + 15) || (apple.y < -h - 4)) {

			a = a * -1; // Wenn apple die Wand trifft �ndere die Richtung der
						// Beschleunigung a

			apple.x += Math.random() * 10;
			if (apple.x > w) {
				apple.y = -w;
			}
			if (cxy == 2) {
				Arena.y = apple.y;
				apple.y = apple.x;
				apple.x = Arena.y;
			}
			cxy = 2;
		}

		String message = "Obstlevel: Sammel �pfel ein!";
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0, -h - 1, message);

	}

	// ////////////////////////////////////////////////////////////////////////////////
	// /Events
	// ///////////////////////////////////////////////////////////////////////////////

	private static void colorwall() {
		// Rechter Rand Event

		Player.health -= 10;
		counter++;
		Player.x = 0;
		Player.y--;
		if (counter == 1) {
			Player.x = w / 2;
		}

		double r = (Math.random() * 9);

		int R = (int) (Math.random() * 256);
		int G = (int) (Math.random() * 256);
		int B = (int) (Math.random() * 256);
		Color randomColor = new Color(R, G, B);
		StdDraw.setPenColor(randomColor);

		StdDraw.filledCircle(Player.x, Player.y * r, 5 * r);
		StdDraw.circle(Player.x, Player.y * r, 2 * r);
		color = randomColor;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(-4, -h - 1,
				"Dieser Level scheint gerade verschlossen zu sein.");
		StdDraw.show(30);

		counter = 0;
	}

	private static void apfel() {
		// Unterer Rand Event
		counter++;
		obst++;
		n = 0;
		if (counter >= 1) {
			Player.y = -h + 3;
		}

		StdDraw.picture(Player.x, 6, "gif/apple.gif", 3, 3, 45);

		StdDraw.picture(Player.x, -8, "gif/apple.gif", 4, 4, 120);

		StdDraw.picture(Player.x, Player.y + 5, "gif/apple.gif", 6, 6, 200);
		StdDraw.picture(Player.x - 1, Player.y + 3, "gif/star.gif", 2, 2, 200);
		StdDraw.picture(Player.x + 1, Player.y + 2, "gif/star.gif", 1, 1, 180);
		StdDraw.text(0, 0, "Obst: " + obst);
		StdDraw.show(80);
		counter = 0;
	}

	/*
	 * Spezialaktion Gelangt der Spieler in eine Ecke kann er sich in // die
	 * gegen�berliegende Ecke teleportieren.
	 */

	private static void gate1() {
		if ((Player.x == w) && (Player.y == h)) {

			Player.y = -h;
			Player.x = -w;
			levelswitch = 1;

		}
	}

	private static void reset() {
		Player.x = 0;
		Player.y = 0;

	}

	// Kamplevelteleporter

	private static void gate2() {

		if ((Player.x == 0) && (Player.y == h)) {

			Player.y = -h;
			Player.x = 0;

			levelswitch = 0;
			reset();
		}
	}

	// Unicornteleporter

	private static void gate3() {
		if ((Player.x == -w) && (Player.y == h)) {

			Player.y = -h;
			Player.x = w;

			levelswitch = 1;
		}

	}

	private static void gate4() {
		if ((Player.x == w - 2) && (Player.y == -h)) {

			Player.y = -h;
			Player.x = w;

		}

	}

}
