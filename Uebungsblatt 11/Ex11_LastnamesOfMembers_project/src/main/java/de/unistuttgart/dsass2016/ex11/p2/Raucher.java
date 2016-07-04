package de.unistuttgart.dsass2016.ex11.p2;

class Raucher extends Thread {
	private final int nr;
	private final Tisch t;

	Raucher(int nr, Tisch t) {
		super("Rauchernr. " + nr);
		this.t = t;
		this.nr = nr;
	}

	private void rauchen() {
		System.out.println("Raucher " + nr + " raucht.");
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			warten();
			t.nimmZutaten(nr);
			rauchen();
			t.zuruecklegen(nr);
		}
	}

	private void warten() {
		System.out.println("Raucher " + nr + " wartet.");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
