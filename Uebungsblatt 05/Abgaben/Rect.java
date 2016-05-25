package de.unistuttgart.dsass2016.ex05.p2;

import java.util.ArrayList;

/**
 * 
 * @author 3133783 Wilhelm Buchmüller
 * @author 3149308 Daniel Wanner
 * @author 2736424 Artur Frenzen
 *
 */
public class Rect extends CollisionObject {

	// parameter of a rect
	public float x;
	public float y;

	public float width;
	public float height;

	/**
	 * Creates a new rectangle
	 * 
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
	 * @author SWAGLORD420
	 * @return GET REKT
	 */
	public Rect getRect() {
		return this;
	}

	/**
	 * Checks if point p is contained in current rectangle
	 * 
	 * @param p:
	 *            point to check
	 */
	public boolean contains(Point p) {
		if (p.x >= this.x && p.y >= this.y) {
			if (p.x < (this.x + this.width) && p.y < (this.y + this.height)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Checks if rectangle is initialized with proper values
	 * 
	 * @return True if parameters of the rectangle are initialized properly,
	 *         else False
	 */
	public boolean isInitialized() {

		if (this.width > 0 && this.height > 0)
			return true;

		return false;
	}

	/**
	 * Implementation of the abstract function that computes the covered area of
	 * a rectangle
	 * 
	 * @throws nothing
	 */
	@SuppressWarnings("unused")
	public ArrayList<Point> coveredArea() {

		// returnList status: I N I T I A L I Z E D

		ArrayList<Point> list = null;

		if (this.isInitialized()) {

			// points which will be used to iterate over

			Point top_left = new Point(this.x, this.y);
			Point top_right = new Point(this.x + this.width, this.y);
			Point bottom_left = new Point(this.x, this.y - this.height);

			// bit of a fuckup there whith this point
			Point bottom_right = new Point(this.x + this.width, this.y - this.height);

			list = new ArrayList<Point>();

			float topleftindex = top_left.getX();
			float toprightindex = top_right.getX();
			float bottomleftindex = bottom_left.getY();

			float bottomtopindex = top_right.getY();

			// check if number is an integer, if not we'll make it one
			// stupid boilerplate code REEEEEEEEE
			if ((topleftindex == Math.floor(topleftindex)) && !Double.isInfinite(topleftindex)) {
				// no dothing
			} else {
				topleftindex = (float) Math.ceil(toprightindex);
			}

			if ((toprightindex == Math.floor(toprightindex)) && !Double.isInfinite(toprightindex)) {

			} else {
				toprightindex = (float) Math.floor(toprightindex);
			}

			if ((bottomleftindex == Math.floor(bottomleftindex)) && !Double.isInfinite(bottomleftindex)) {

			} else {
				bottomleftindex = (float) Math.ceil(bottomleftindex);
			}

			if ((bottomtopindex == Math.floor(bottomtopindex)) && !Double.isInfinite(bottomtopindex)) {

			} else {
				bottomtopindex = (float) Math.ceil(bottomtopindex);
			}

			// from the bottomleft point, these loops go through the rectangle
			// and add the points into
			// the list

			/**
			 * explanation: were looping every column from the bottom left to
			 * the top right
			 */
			for (float i = topleftindex; i < toprightindex; i++) {
				for (float j = bottomleftindex; j < toprightindex; j++) {
					Point the_Point = new Point(i, j);
					list.add(the_Point);
				}
			}

		} else {
			return null;
		}
		return list;

	}

	/**
	 * Implementation of the abstract function that checks if two rectangles are
	 * colliding
	 */
	public boolean collisionWith(CollisionObject obj) {

		ArrayList<Point> thisRect = this.coveredArea();
		ArrayList<Point> thatRect = obj.coveredArea();

		// """"""temporary workaround"""""""
		// but basically just checks if a points exists in the one or other
		for (int i = 0; i < thisRect.size(); i++) {
			if (thisRect.get(i).getX() == thatRect.get(i).getX() && thisRect.get(i).getY() == thatRect.get(i).getY()) {
				return true;
			}
		}

		return false;
	}

}
