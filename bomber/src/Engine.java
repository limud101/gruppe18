public class Engine extends Thread {

	public void run() {

		try {
			
		
			while (true) {
				Arena.steuerung(); // Tastatureingaben
				Arena.levelswitch(); // Leveldaten
				Arena.plr.draw(Arena.lastkey); // Player zeichne
				Arena.bo.draw(); // Bombe Zeichnen
				Engine.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Ende der Messung

	}

}