package de.unistuttgart.dsass2016.ex11.p2;

public class Simulation {

	public static void main(String[] args) {
		Tisch t = new Tisch();
		Thread raucher[] = new Thread[3];
		for (int i = 0; i < raucher.length; i++) {
			raucher[i] = new Raucher(i, t);
		}
		for (int i = 0; i < raucher.length; i++) {
			raucher[i].start();
		}
		for (int i = 0; i < raucher.length; i++) {
			try {
				raucher[i].join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
