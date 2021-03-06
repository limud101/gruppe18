import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Engine extends Thread {

	static byte gamespeed = 40; // 14 ist defaultwert

	public void run() {

		while (true) {
			Arena.steuerung(); // Tastatureingaben

			Arena.levelswitch(); // Leveldaten
			Arena.Player.draw();
			StdDraw.text(Arena.w, Arena.h, time());
			if (Bombe.vis == 1) {
				Bombe.draw();
			}
		
			fr(gamespeed);

		}

	}

	public String time() {
		SimpleDateFormat seconds = new SimpleDateFormat("mm:ss");
		// Simple Date in seconds
		return seconds.format(new Date());
	}

	static void fr(byte gamespeed2) {

		// Die zwei Linien nicht �ndern oder schleifen sonst kommt es zu Fehlern
		// : show and clear Vorsicht!!!!
		StdDraw.show(gamespeed);
		StdDraw.clear();

	}

}
