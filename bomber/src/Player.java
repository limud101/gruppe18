public class Player {

	public static double x = 0;

	public static double y = 0;

	int dir = 4;
	static boolean alive = true;
	public static int health = 100;
	String[] inventar = new String[5];
	static double imgw = 8;
	static double imgh = 8;
	public static double delh = 0;
	public static int lastkey = 0;

	// Keycodes
	public static boolean right = false;
	public static boolean left = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean space = false;
	public static boolean click = false;
	public static boolean xkey = false;
	public static int counter = 0;
	public static boolean button1 = false;

	public static boolean button2 = false;

	public static boolean button3 = false;

	public Player(double xdir, double ydir, double deltah, int h) {

		x = xdir;
		y = ydir;
		delh = deltah;
		health = h;
	}

	public void draw() {

		// Visuelle ausg

		counter = Arena.counter;
		if (health >= 100) {
			health = 100;
		}

		if (health > 0) {
			alive = true;
			// Bombentaste

			update();
			if (space) {

				lastkey = 6;

				new Thread(new Bombe()).start();
				Bombe.trig = true;

			}

			if ((button1)) {

				StdDraw.ellipse(0, y, 3, 3);
				StdDraw.text(0, y, "Y");
				StdDraw.ellipse(x, 0, 3, 3);
				StdDraw.text(x, 0, "X");
				StdDraw.text(-15, 18, "x: " + x);
				StdDraw.text(-15, 22, "y: " + y);

			}

			if ((button3)) {
				StdDraw.setPenColor(StdDraw.GREEN);
				StdDraw.circle(8, 8, 12);
				StdDraw.setPenColor(StdDraw.BLACK);
				StdDraw.text(5, 2, "health: " + health);
				StdDraw.text(5, 4, "Player alive?: " + alive);

			}

			if (xkey) {

				for (double i = 0; i < 270; i++) {
					delh = 1;
					imgw += 0.0000005 * i;
					imgh = imgw;

					if (i >= 180) {
						y += Math.random() * 0.01;
					}

					StdDraw.picture(x, y - 7, "gif/bomb_seq06.gif", imgw * 0.5,
							imgh * 0.5, i * y);

				}

				if (imgw > 10) {
					health -= 10;
					xkey = false;
				}

			}

			if (xkey == false) {
				imgw = 8;
				imgh = imgw;
				delh = 0;

			}

			if (down && up && left && right) {

				x = 0;
				y = 0;
				lastkey = 9;

			}

			if (left) {

				x--;

				lastkey = 4;
				if (Arena.levelswitch == 99) {
					System.exit(0);
				}
			}

			if (right) {

				x++;

				lastkey = 1;
				if (Arena.levelswitch == 99) {
					Arena.levelswitch = 0;

					health = 100;
				}

			}

			if (up) {

				y++;

				lastkey = 3;

			}

			if (down) {

				y--;

				lastkey = 0;

			}
			if ((lastkey == 1)) {

				StdDraw.picture(x, y, "png/right.png", imgw, Player.imgh);

			}

			if ((lastkey == 0) || (lastkey == 6)) {

				StdDraw.picture(x, y, "png/front.png", imgw, imgh);

			}

			if ((lastkey == 3)) {

				StdDraw.picture(x, y, "png/back.png", imgw, imgh);

			}
			if ((lastkey == 4)) {

				StdDraw.picture(x, y, "png/left.png", imgw, imgh);

			}

			// boolische Multiplikation enspricht dem UND
			if ((down && up && left && right)) {
				StdDraw.picture(x, y, "gif/star.gif", 30, 30);
				// Joker: Wenn der Benutzer alle Richtunngstasten dr�ckt, steht
				// ihm
				// ein Joker bereit.
				// nach dem Benutzen des Jokers werden die Zug�nge versperrt.

			}

			if ((down) && (!up)) {

				StdDraw.picture(x, y, "png/front.png", imgw, imgh);
			}

			if ((right) && (!left)) {

				StdDraw.picture(x, y, "png/right.png", imgw, imgh);
			}
			if ((up) && (!down)) {

				StdDraw.picture(x, y, "png/back.png", imgw, imgh);
			}
			if ((left) && (!right)) {

				StdDraw.picture(x, y, "png/left.png", imgw, imgh);
			}
		} else {
			alive = false;
			Arena.levelswitch = 99;

			StdDraw.text(0, 0, "Game Over");

		}

	}

	private static void update() {

		for (int i = 0; i <= health * 0.15; i++) {

			if (health <= 45) {
				StdDraw.setPenColor(StdDraw.RED);
			} else {
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			if (i >= 14) {
				StdDraw.setPenColor(StdDraw.BLUE);
			}

			StdDraw.filledRectangle(-19 + i * 1.2, Arena.h, 0.5, 0.5);
			StdDraw.setPenColor(StdDraw.BLACK);
		}
	}

}
