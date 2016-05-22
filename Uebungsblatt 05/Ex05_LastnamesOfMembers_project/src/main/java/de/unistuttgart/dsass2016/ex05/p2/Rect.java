package de.unistuttgart.dsass2016.ex05.p2;

import java.util.ArrayList;
import java.util.List;

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
	public ArrayList<Point> coveredArea() {
		
		//returnList
		
		List<Point> list;
		
		//check floating point cases
		
		
		if (this.isInitialized()) {
			//points which will be used to iterate over
			
			Point top_left = new Point(this.x, this.y);
			Point top_right= new Point(this.x+this.width, this.y);
			Point bottom_left= new Point(this.x, this.y-this.height);
			Point bottom_right= new Point(this.x+ this.width,this.y-this.height);
			
			list = new ArrayList<Point>();
			
			
			for (float i = Math.round(top_left.getX()); i < Math.round(top_right.getX()); i++) {
				for (float j = Math.round(bottom_left.getY()); j < Math.round(bottom_right.getY()); j++) {
					Point dummyPoint = new Point(i,j);
					list.add(dummyPoint);
				}
			}
			
		}else {
			return null;
		}
		
			return null;		
		
	}
	
	/**
	 * Implementation of the abstract function that checks if two rectangles are colliding
	 */
	public boolean collisionWith(CollisionObject obj){
		return false;
		//TODO: Insert code for Assignment 5.2 b
	}

}
