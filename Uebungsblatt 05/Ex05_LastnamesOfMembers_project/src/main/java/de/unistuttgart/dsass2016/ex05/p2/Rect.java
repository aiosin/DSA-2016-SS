package de.unistuttgart.dsass2016.ex05.p2;

import java.util.ArrayList;

public class Rect extends CollisionObject{

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
	 * @author SWAGLORD420
	 * @return GET REKT
	 */
	public Rect getRect(){
		return this;
	}
	/**
	 * Checks if point p is contained in current rectangle
	 * @param p: point to check
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
	 * @return True if parameters of the rectangle are initialized properly, else False
	 */
	public boolean isInitialized() {

		if (this.width > 0 && this.height > 0)
			return true;

		return false;
	}
	
	
	/**
	 * Implementation of the abstract function that computes the covered area of a rectangle
	 * @throws Exception 
	 */
	//TODO: test this today
	public ArrayList<Point> coveredArea() {
		
		//returnList
		
		ArrayList<Point> list= null;
		
		
		if (this.isInitialized()) {
			
			
			//points which will be used to iterate over
			
			Point top_left = new Point(this.x, this.y);
			Point top_right= new Point(this.x+this.width, this.y);
			Point bottom_left= new Point(this.x, this.y-this.height);
			Point bottom_right= new Point(this.x+ this.width,this.y-this.height);
			
			list = new ArrayList<Point>();

			float topleftindex = top_left.getX();
			float toprightindex= top_right.getX();
			float bottomleftindex = bottom_left.getY();
			
			//dont really neeed this point but w/e
			float bottomrightindex= bottom_right.getY();

			//stupid boilerplate code REEEEEEEEE
			if ((topleftindex == Math.floor(topleftindex)) && !Double.isInfinite(topleftindex)) {
				//no dothing
			}else {
				topleftindex = (float) Math.ceil(toprightindex);
			}
			
			if ((toprightindex == Math.floor(toprightindex)) && !Double.isInfinite(toprightindex)) {
				
			}else {
				toprightindex = (float) Math.floor(toprightindex);
			}
			
			if ((bottomleftindex== Math.floor(bottomleftindex)) && !Double.isInfinite(bottomleftindex)) {
				
			}else {
				bottomleftindex = (float) Math.ceil(bottomleftindex);
			}
			
			//bottom right is going to be the same as bottom left but just for verbosity's sake its going to stay
			if ((bottomrightindex == Math.floor(bottomrightindex)) && !Double.isInfinite(bottomrightindex)) {
				
			}else {
				bottomrightindex = (float) Math.ceil(bottomrightindex);
			}
			
			for (float i = topleftindex; i < toprightindex; i++) {
				for (float j = bottomleftindex; j < bottomrightindex; j++) {
					Point the_Point = new Point(i,j);
					list.add(the_Point);
				}
			}
			
		}else {
			return null;
		}
		return list;
		
	}
	
	/**
	 * Implementation of the abstract function that checks if two rectangles are colliding
	 */
	public boolean collisionWith(CollisionObject obj){
		return false;
		//TODO: Insert code for Assignment 5.2 b
	}

}
