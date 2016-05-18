package de.unistuttgart.dsass2016.ex05.p1;

import de.unistuttgart.dsass2016.ex05.p1.Point;

public class Rect {

	//parameter of a rect
	public float x;
	public float y;

	public float width;
	public float height;

	/**
	 * Creates a new rectangle
	 * @param x
	 * @param y
	 * @param width
	 * @param heigth
	 */
	public Rect(float x, float y, float width, float heigth) {
		this.x = x;
		this.y = y;

		this.width = width;
		this.height = heigth;
	}

	
	/**
	 * Checks if point p is contained in current rectangle
	 * @param p: point to check
	 */
	public boolean contains(Point p) {
		if (p.x >= this.x && p.y >= this.y) {
			if (p.x <= (this.x + this.width) && p.y <= (this.y + this.height)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if rectangle is initialized with proper values
	 * @return True if parameters of the rectangle are initialized properly, else False
	 */
	public boolean isInitialized() {

		if (this.width > 0 && this.height > 0)
			return true;

		return false;
	}
	

}
