package de.unistuttgart.dsass2016.ex05.p1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		ArrayList<TreeObject> tList = new ArrayList<TreeObject>();


		tList.add(new TreeObject(new Point(0.5f, 0.5f)));
		tList.add(new TreeObject(new Point(1.5f, 1.5f)));
		
		tList.add(new TreeObject(new Point(2.5f, 0.5f)));
		tList.add(new TreeObject(new Point(2.5f, 1.5f)));

		tList.add(new TreeObject(new Point(1.5f, 2.5f)));
		tList.add(new TreeObject(new Point(1.5f, 3.5f)));

		tList.add(new TreeObject(new Point(3.5f, 2.5f)));
		tList.add(new TreeObject(new Point(2.5f, 3.5f)));
		tList.add(new TreeObject(new Point(3.5f, 3.5f)));

		Quadtree<TreeObject> tree = new Quadtree<TreeObject>(new Rect(0, 0, 4, 4), 1, tList, TreeObject.class);
		
		tree.inorder();
		System.out.println("");
	
		System.out.println("Done");
		
	}
	
	
}