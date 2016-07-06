package de.unistuttgart.dsass2016.ex11.p3;

/**
 * 
 * @author 3133783 Wilhelm Buchmüller 
 * @author 3149308 Daniel Wanner 
 * @author 2736424 Artur Frenzen
 *
 */

import java.util.concurrent.ThreadLocalRandom;

public class Student implements Runnable {

	private String name;
	private Table table;

	public Student(String name, Table table) {
		this.name = name;
		this.table = table;

	}

	@Override
	public void run() {
		// prewaiting before writing something accessing the
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
		} catch (InterruptedException e) {
			System.exit(0);

			System.err.println("aylmao");
		}
		synchronized (this.table) {
			table.getPencil();
			this.table.writeLog(name);
			System.out.println("aylmao");
		}
		try {
			Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
		} catch (Exception e) {
			System.exit(1);
		}
		synchronized (table) {
			table.notifyStudentDone();
		}
	}

	public void startWork() {
		Thread t = new Thread(this);
		t.start();
	}
}
