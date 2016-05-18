package de.unistuttgart.dsass2016.ex05.p1;

import java.io.*;

public class TreeObject extends ATreeObject {

	
	private Point location;

	/**
	 * Creates default TreeObject with anchor point with x = 0 and y = 0
	 */
	public TreeObject() {
		this.location = new Point(0.0f,0.0f);
	}
	
	/**
	 * Creates TreeObject with anchor point p
	 * @param p Anchor point
	 */
	public TreeObject(Point p) {
		this.location = p;
	}

	/**
	 * Returns the anchor point of the current TreeObject
	 */
	public Point getLocation() {
		return this.location;
	}
	
	/**
	 * Implementation of the abstract load function
	 */
	public void loadObjectFormFile(BufferedReader reader){
		try {
			String[] line = reader.readLine().split(";");
			
			this.location =  new Point(Float.parseFloat(line[0]), Float.parseFloat(line[1])); 
			
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
	/**
	 * Implementation of the abstract save function
	 */
	public void writeObjectToFile(FileWriter writer){
		try {
			writer.write(""+this.location.x+";");
			writer.write(""+this.location.y);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * Implementation of the abstract TreeObject comparison function
	 */
	public boolean isEqual(ATreeObject a){
		
		return this.location.equals(a.getLocation());
	}
}
