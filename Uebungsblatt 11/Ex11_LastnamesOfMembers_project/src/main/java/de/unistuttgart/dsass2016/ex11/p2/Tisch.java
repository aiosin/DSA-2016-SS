package de.unistuttgart.dsass2016.ex11.p2;

import java.util.concurrent.Semaphore;

class Tisch {

	private static final int RAUCHEN = 1;
	private static final int WARTEN = 0;
	private static final int[] raucher = new int[3];
	private static final Semaphore[] zutaten = new Semaphore[3];

	static {
		for (int i = 0; i < raucher.length; i++) {
			raucher[i] = WARTEN;
		}
		for (int i = 0; i < zutaten.length; i++) {
			zutaten[i] = new Semaphore(1);
		}
	}

	void nimmZutaten(int nr) {
		try {
			zutaten[(nr + 1) % 3].acquire();
			zutaten[(nr + 2) % 3].acquire();
			raucher[nr] = RAUCHEN;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	void zuruecklegen(int nr) {
		zutaten[(nr + 2) % 3].release();
		zutaten[(nr + 1) % 3].release();
		raucher[nr] = WARTEN;
	}

}
