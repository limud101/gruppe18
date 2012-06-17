package edu.propra.bomberman.gameengine;

public class GameRoundThread implements Runnable {

	private GameEngine ge;
	private boolean running;
	public GameRoundThread(GameEngine ge) {
		this.ge=ge;
	}
	@Override
	public void run() {
		running=true;
		while(running){
			ge.doRound();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}