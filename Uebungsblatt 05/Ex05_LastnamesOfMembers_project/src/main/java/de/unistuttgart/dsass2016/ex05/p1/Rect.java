package de.unistuttgart.dsass2016.ex05.p1;

import de.unistuttgart.dsass2016.ex05.p1.Point;

/**
 * 
 * @author Daniel Wanner 3149308
 * @author Wilhelm Buchmüller 3133783	
 * @author Artur Frenzen 2736424
 */
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
	 * Checks if this rectangle intersects with rectangle r
	 * @param r: rectangle to check
	 */
	public boolean intersects(Rect r) {
		return (Math.abs(x - r.x) * 2 < (width + r.width)) &&
		         (Math.abs(y - r.y) * 2 < (height + r.height));
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
