package de.unistuttgart.dsass2016.ex05.p1;

import java.io.*;

import de.unistuttgart.dsass2016.ex05.p1.Point;

public abstract class ATreeObject {
	
	/**
	 * Returns the anchor point of an TreeObject
	 * @return anchor point
	 */
	public abstract Point getLocation();
	
	/**
	 * Function loads the content of a TreeObject form a reader
	 * @param reader Reference to a opened file
	 */
	public abstract void loadObjectFormFile(BufferedReader reader);
	
	/**
	 * Function writes the content of a TreeObject to a opened file
	 * @param writer Reference to a opened file
	 */
	public abstract void writeObjectToFile(FileWriter writer);
	
	/**
	 * Test if to TreeObjects are equal
	 * @param a this object is compared to a
	 * @return true if this object is equal a
	 */
	public abstract boolean isEqual(ATreeObject a);
	
}
