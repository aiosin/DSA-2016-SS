package de.unistuttgart.dsass2016.ex05.p1;

import java.util.ArrayList;

import de.unistuttgart.dsass2016.ex05.p1.AQuadtree;

public class Quadtree<T extends ATreeObject> extends AQuadtree<T>{

	/**
	 * Creates new Quadtree with a covered area, a max number of elements for each leaf node
	 * 
	 * @param area
	 * @param maxElementNumberInLeafs
	 * @param list: TreeObjects that are used to create the Quadtree
	 * @param cls: Reflection of T
	 */
	public Quadtree(Rect area, int maxElementNumberInLeafs, ArrayList<T> list, Class<T> cls) {

		this.objectType = cls;
		
		// set area
		if (!area.isInitialized()){
			System.out.println("Area not initialized!");
			return;
		}
		this.area = area;

		// set maxElementNumberInLeafs
		if (maxElementNumberInLeafs <= 0){
			System.out.println("Invalide value of maxElementNumberInLeafs!");
			return;
		}
		this.maxElementNumberInLeafs = maxElementNumberInLeafs;

		// set leafElements
		if (list.size() <= this.maxElementNumberInLeafs) {
			this.leafElements = list;
			return;
		}

		// set child Quadtrees
		createChildQuadtrees(list);

	}

	/**
	 * Creates child nodes of current node with a set of TreeObjects
	 * @param list: Set of TreeObjects
	 */
	private void createChildQuadtrees(ArrayList<T> list) {
		
		//TODO Insert code for Assignment 5.1 a
	}

}
