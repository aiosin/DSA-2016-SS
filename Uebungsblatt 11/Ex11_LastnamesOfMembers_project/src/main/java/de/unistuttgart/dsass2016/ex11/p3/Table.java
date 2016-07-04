package de.unistuttgart.dsass2016.ex11.p3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Vector;

/**
 * Represents a table with a single pencil.
 */
public class Table {
	
	/**
	 * Represents a log message.
	 */
	private static class LogEntry implements Comparable<LogEntry> {
		
		/**
		 * The formatter object used to display the times in a readable way.
		 */
		private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss.SSS");
		
		/**
		 * Initializes a new instance.
		 * 
		 * @param time The time at which the event occurred.
		 * @param text The log message describing the event.
		 * @throws IllegalArgumentException if any of the arguments is null.
		 */
		public LogEntry(Calendar time, String text) {
			if (time == null) {
				throw new IllegalArgumentException("time must not be null.");
			}
			if (text == null) {
				throw new IllegalArgumentException("text must not be null.");
			}
			
			this.time = time;
			this.text = text;
		}
		
		/**
		 * The time at which the event occurred.
		 */
		private final Calendar time;
		
		/**
		 * The log message describing the event.
		 */
		private final String text;
		
		/**
		 * Returns a string representation of the message.
		 */
		@Override
		public String toString() {
			return String.format("%s: %s", timeFormat.format(time.getTime()), text);
		}
		
		/**
		 * Compares the log message to another log message based on its time.
		 */
		@Override
		public int compareTo(LogEntry o) {
			return time.compareTo(o.time);
		}
	}
	
	/**
	 * Initializes a new instance.
	 * 
	 * @param students The number of students that start working at the table.
	 * @throws IllegalArgumentException if students is zero or negative. 
	 */
	public Table(int students) {
		if (students <= 0) {
			throw new IllegalArgumentException("students must be positive.");
		}
		
		remainingStudents = students;
	}
	
	/**
	 * The pencil.
	 */
	private final Object pencil = new Object();
	
	/**
	 * Retrieves the pencil object.
	 * 
	 * @return The pencil object.
	 */
	public Object getPencil() {
		return pencil;
	}
	
	/**
	 * The number of students who are still working on their tasks.
	 */
	private int remainingStudents;
	
	/**
	 * Stores that a student has finished his or her work.
	 */
	public synchronized void notifyStudentDone() {
		remainingStudents--;
		
		if (remainingStudents <= 0) {
			Collections.sort(log);
			for (LogEntry entry : log) {
				System.out.println(entry);
			}
		}
	}
	
	/**
	 * Stores a log message.
	 * 
	 * @param text The log message.
	 * @throws IllegalArgumentException if text is null.
	 */
	public void writeLog(String text) {
		if (text == null) {
			throw new IllegalArgumentException("text must not be null.");
		}
		
		log.add(new LogEntry(Calendar.getInstance(), text));
	}
	
	/**
	 * The list of log messages.
	 */
	private final Vector<LogEntry> log = new Vector<LogEntry>();
}
