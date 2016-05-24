package de.unistuttgart.dsass2016.ex05.p1;

import java.util.ArrayList;

import de.unistuttgart.dsass2016.ex05.p1.AQuadtree;

/**
 * @author Daniel Wanner 3149308
 * @author Wilhelm Buchmüller 3133783	
 * @author Artur Frenzen 2736424
 */

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
		
		leafElements = new ArrayList<T>();
		
		//Alle zur liste hinzufügen die sich im gebiet dieses quads befinden
		for (T t : list) {
			if (area.contains(t.getLocation())) {
				leafElements.add(t);
			}
		}
		
		if (leafElements.size() > maxElementNumberInLeafs) {
			//Oberes linkes viertel
			Rect r_topleft = new Rect(area.x, area.y, area.width/2, area.height/2);
			
			//Oberes rechtes viertel
			Rect r_topright = new Rect(area.x + (area.width/2), area.y, area.width/2, area.height/2);
			
			//Unteres linkes viertel
			Rect r_bottomleft = new Rect(area.x, area.y + (area.height/2), area.width/2, area.height/2);
			
			//Unteres rechtes viertel
			Rect r_bottomright = new Rect(area.x + (area.width/2), area.y + (area.height/2), area.width/2, area.height/2);
			
			//Immer die objektliste weitergeben, die sich schon im parent befindet -> spart rechenleistung
			topleft = new Quadtree(r_topleft, maxElementNumberInLeafs, leafElements, objectType);
			topright = new Quadtree(r_topright, maxElementNumberInLeafs, leafElements, objectType);
			bottomleft = new Quadtree(r_bottomleft, maxElementNumberInLeafs, leafElements, objectType);
			bottomright = new Quadtree(r_bottomright, maxElementNumberInLeafs, leafElements, objectType);
			
			//Knotenbaum hat keine blätter
			leafElements.clear();
		}
	}
	
	/* Simple testmethode zum testen ob der Quadtree richtig konstruiert wurde.
	public String printOut(int level) {
		String s = "";
		String prefix = "";
		for (int i = 0; i < level; i++) {
			prefix += "-";
		}
		
		s += prefix + "quad ["+area.x+","+area.y+"]-["+(area.x+area.width)+", "+(area.y+area.height)+"]\n";
		
		if (!leafElements.isEmpty()) {
			for (T t : leafElements) {
				s += prefix + "quad_object ["+t.getLocation().x+", "+t.getLocation().y+"]\n";
			}
		}
		
		if (topleft != null) {
			s += ((Quadtree)topleft).printOut(level +1);
			s += ((Quadtree)topright).printOut(level +1);
			s += ((Quadtree)bottomleft).printOut(level +1);
			s += ((Quadtree)bottomright).printOut(level +1);
		}
		
		return s;
	}
	*/
	
	public static void main(String[] args) {
		ArrayList<TreeObject> list = new ArrayList<TreeObject>();
		
		list.add(new TreeObject(new Point(0, 0)));
		list.add(new TreeObject(new Point(1, 56)));
		list.add(new TreeObject(new Point(4, 65)));
		list.add(new TreeObject(new Point(5, 11)));
		list.add(new TreeObject(new Point(6, 32)));
		list.add(new TreeObject(new Point(7, 54)));
		list.add(new TreeObject(new Point(8, 3)));
		list.add(new TreeObject(new Point(9, 8)));
		list.add(new TreeObject(new Point(10, 6)));
		list.add(new TreeObject(new Point(77, 4)));
		list.add(new TreeObject(new Point(13, 12)));
		list.add(new TreeObject(new Point(51, 21)));
		list.add(new TreeObject(new Point(3, 32)));
		
		Quadtree<TreeObject> quad = new Quadtree<TreeObject>(new Rect(0, 0, 1000, 1000), 2, list, TreeObject.class);
		
		System.out.println(quad.printOut(0));
		
		System.out.println("finished!");
		try {
			System.in.read();
		} catch (Exception ex) {
			
		}
	}

}
