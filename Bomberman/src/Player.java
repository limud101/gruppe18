public class Player {
	double x, y = 0;

	int dir = 4;
	boolean alive = true;
	String[] inventar = new String[5];

	public Player(double xdir, double ydir) {

		x = xdir;
		y = ydir;

	}

	public void draw(int lastkey) {

		Arena.x = x;

		Arena.y = y;
		if ((lastkey == 1)) {

			StdDraw.picture(x, y, "gif/right.gif");

		}

		if ((lastkey == 0)) {

			StdDraw.picture(x, y, "gif/front.gif");

		}

		if ((lastkey == 3)) {

			StdDraw.picture(x, y, "gif/back.gif");

		}
		if ((lastkey == 4)) {

			StdDraw.picture(x, y, "gif/left.gif");

		}

		// boolische Multiplikation enspricht dem UND
		if ((Arena.down && Arena.up && Arena.left && Arena.right)) {
			StdDraw.picture(x, y, "gif/star.gif");
			// Joker: Wenn der Benutzer alle Richtunngstasten dr�ckt, steht ihm
			// ein Joker bereit.
			// nach dem Benutzen des Jokers werden die Zug�nge versperrt.
			Arena.gate = 0;
		}

		if ((Arena.down) && (!Arena.up)) {

			StdDraw.picture(x, y, "gif/front.gif");
		}

		if ((Arena.right) && (!Arena.left)) {

			StdDraw.picture(x, y, "gif/right.gif");
		}
		if ((Arena.up) && (!Arena.down)) {

			StdDraw.picture(x, y, "gif/back.gif");
		}
		if ((Arena.left) && (!Arena.right)) {

			StdDraw.picture(x, y, "gif/left.gif");
		}

		if (Arena.space) {
			// StdDraw.picture(x, y, "gif/orange_bomb.gif");
		}

	}

}
