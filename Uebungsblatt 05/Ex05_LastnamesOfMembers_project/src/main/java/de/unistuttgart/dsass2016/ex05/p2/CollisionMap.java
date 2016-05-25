package de.unistuttgart.dsass2016.ex05.p2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author 3133783 Wilhelm Buchmüller
 * @author 3149308 Daniel Wanner
 * @author 2736424 Artur Frenzen
 *
 */
public class CollisionMap {

	public Rect gridRect;
	public ArrayList<Rect> rectObstacleList;

	private ArrayList<ArrayList<ArrayList<CollisionObject>>> gridCollisionMap;

	/**
	 * Generates a CollisionMap form a list of CollisionObjects
	 * 
	 * @param rList
	 *            List if obstacles that should be placed within the
	 *            CollisionMap
	 */
	public CollisionMap(ArrayList<Rect> rList) {

		this.rectObstacleList = rList;
		this.calcBoundingRect();
		this.generateCollisionMap();

		this.fillCollisionMap();
	}

	/**
	 * Generates a Set of potential object that could lead to a collision
	 * which is more efficient than checking the ENTIRE GRID
	 * @return
	 */
	public Set<CollisionObject> getCollisionCanidates(CollisionObject obj) {
		//creating the return set
		Set<CollisionObject> ret = new HashSet<CollisionObject>();

		
		//creating our list of points that we have to check
		ArrayList<Point> objList = obj.coveredArea();
		
		//looping through the pointList
		for (int i = 0; i < objList.size(); i++) {
			
			//getting the x and y coordinates of our current index in the pointList
			int x = (int) objList.get(i).getX();
			int y = (int) objList.get(i).getY();

			//adding them all to the return list, addall incase there are multiple objects at that point
			ret.addAll(getObstaclesAtPoint(x, y));
		}
		
		return ret;
	}

	/**
	 * Fills the CollisionMap with the CollisionObjects
	 */
	// TODO: TEST THIS; ASAP
	public void fillCollisionMap() {
		/**
		 * reminder:
		 * 
		 * rectObstacleList is our list of all rectangles gridCollisionMap, is
		 * triple encapsulated imposter map which can be used like this:
		 * gridCollisionMap.getX.getY.ALL_ELEMENTS_WHICH_SHARE_THIS_DOT
		 */

		//looping over all CollisionObjects:
		for (int i = 0; i < rectObstacleList.size(); i++) {
			
			// these are all the points in the current CollisionObjects
			ArrayList<Point> dummyPointList = rectObstacleList.get(i).coveredArea();

			for (int j = 0; j < dummyPointList.size(); j++) {
				
				int dummyX = (int) dummyPointList.get(j).getX();
				int dummyY = (int) dummyPointList.get(j).getY();
				
				//inserting the object into the CollisionMap
				insertCollisionObject(dummyX, dummyY, rectObstacleList.get(i));
			}

		}

	}

	/**
	 * Inserts the object at position x, y
	 */
	public void insertCollisionObject(int x, int y, CollisionObject obj) {

		gridCollisionMap.get(x).get(y).add(obj);
	}

	/**
	 * Checks if a rectangle is colliding with something in the CollisionMap
	 * 
	 * @param rect
	 * @return
	 */
	public boolean checkCollision(Rect rect) {

		Set<CollisionObject> collisionCanidates = getCollisionCanidates(rect);

		for (CollisionObject o : collisionCanidates) {

			// check if actually a collision occurs
			if (o.collisionWith(rect)) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Returns a list of objects that are covering position x, y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<CollisionObject> getObstaclesAtPoint(int x, int y) {

		Point p = new Point(x, y);

		if (!this.gridRect.contains(p))
			return null;

		return this.gridCollisionMap.get(x).get(y);
	}

	/**
	 * Allocates memory for the CollisionMap
	 */
	public void generateCollisionMap() {

		this.gridCollisionMap = new ArrayList<ArrayList<ArrayList<CollisionObject>>>();

		for (int x = 0; x < this.gridRect.width; x++) {

			ArrayList<ArrayList<CollisionObject>> yArrayList = new ArrayList<ArrayList<CollisionObject>>();

			for (int y = 0; y < this.gridRect.height; y++) {

				yArrayList.add(new ArrayList<CollisionObject>());

			}

			this.gridCollisionMap.add(yArrayList);
		}

	}

	/**
	 * Calculates the area that is needed in order to store all
	 * CollisionObjects. Area is saved in gridArea.
	 */
	public void calcBoundingRect() {

		int min_x = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;

		int min_y = Integer.MAX_VALUE;
		int max_y = Integer.MIN_VALUE;

		for (int i = 0; i < this.rectObstacleList.size(); i++) {

			Rect tRect = this.rectObstacleList.get(i);

			for (int x = (int) tRect.x; x < Math.ceil((double) (tRect.x + tRect.width)); x++) {
				if (x < min_x) {
					min_x = x;
				}
				if (x > max_x) {
					max_x = x;
				}

				for (int y = (int) tRect.y; y < Math.ceil((double) (tRect.y + tRect.height)); y++) {

					if (y < min_y) {
						min_y = y;
					}
					if (y > max_y) {
						max_y = y;
					}
				}
			}

		}

		this.gridRect = new Rect(min_x, min_y, max_x - min_x + 1, max_y - min_y + 1);
	}

}
