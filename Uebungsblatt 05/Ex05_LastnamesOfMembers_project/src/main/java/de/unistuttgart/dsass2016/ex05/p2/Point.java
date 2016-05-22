package de.unistuttgart.dsass2016.ex05.p2;

public class Point {
	
	public  float x;
	public  float y;
	
	public Point(float x, float y) {
		this.x = x;
		this.y = y;
	}
	public void setX(float value){
		this.x = value;
	}
	public void setY(float value){
		this.y = value;
	}
	
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
	/**
	 * Checks if obj is a Point and if is equal to this point
	 */
	@Override
	public boolean equals(Object obj){
		
		if(!(obj instanceof Point))
			return false;
		
		if( ( ((Point)obj).x == this.x ) && ( ((Point)obj).y == this.y )){
			return true;
		}
		
		return false;	
	}
}
