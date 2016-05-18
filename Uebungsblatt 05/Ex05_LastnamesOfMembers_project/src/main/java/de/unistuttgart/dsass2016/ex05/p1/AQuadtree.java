package de.unistuttgart.dsass2016.ex05.p1;

import java.util.ArrayList;

import de.unistuttgart.dsass2016.ex05.p1.Rect;

import java.io.*;

public abstract class AQuadtree<T extends ATreeObject > {

	protected Class<T> objectType;
     
    Class<T> getType(){
    	return objectType;
    }
	
	/**
	 * Quadtree-Nodes that cover a sub area  of the current are
	 */
	protected AQuadtree<T> topleft;
	protected AQuadtree<T> topright;
	protected AQuadtree<T> bottomleft;
	protected AQuadtree<T> bottomright;

	/**
	 * Holds the current area
	 */
	protected Rect area;

	/**
	 * Holds the maximum number of elements in a leaf before a leaf node is being splitted
	 */
	protected int maxElementNumberInLeafs;

	
	/**
	 * Elements that are hold be a leaf node
	 */
	protected ArrayList<T> leafElements;
	
	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Checks if to Quadtrees have the same structure and the same elements stored
	 */
	public boolean equals(Object obj){
		
		
		//check if object is valid
		if(obj == null)
			return false;
		
		AQuadtree<T> b;
		
		try{
			// type cast to AQuadtree
			b = (AQuadtree<T>)obj;
		}catch(ClassCastException e){
			//if cast fails, obj is not a AQuadtree
			return false;
		}

		//two trees a equal if their subtrees are equal
		if(this.getLeafElements() == null && b.getLeafElements() == null){
			
			ArrayList<Boolean> subTreeEquality = new ArrayList<Boolean>();
			
			subTreeEquality.add(this.getTopleft().equals(b.getTopleft()));
			subTreeEquality.add(this.getTopright().equals(b.getTopright()));
			subTreeEquality.add(this.getBottomleft().equals(b.getBottomleft()));
			subTreeEquality.add(this.getBottomright().equals(b.getBottomright()));
			
			
			for(int i = 0; i < subTreeEquality.size(); i++){
				if(!subTreeEquality.get(i)){
					return false;
				}
			}

		}else{
			
			//compare only saved elements of leaf nodes
			
			if((this.getLeafElements() == null && b.getLeafElements() != null)||(this.getLeafElements() != null && b.getLeafElements() == null)){
				return false;
			}
			if(this.getLeafElements().size() != b.getLeafElements().size()){
				return false;
			}
		
			// two trees are equal if leaf nodes are equal
			for(int i = 0; i < this.getLeafElements().size(); i++){
				
				boolean elementIsInBothLists = false;
				
				for(int j = 0; j < b.getLeafElements().size(); j++){
					if(this.getLeafElements().get(i).isEqual(b.getLeafElements().get(j))){
						elementIsInBothLists = true;
					}
				}
				
				if(!elementIsInBothLists)
					return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * Retrieves all points in the selectedArea
	 * 
	 * @param resultList: List that is used to store the elements that are contained in the selecedArea
	 * @param selecedArea: The method is looking for elements that are possible located in the area 
	 */
	
	public void rangeQuery(ArrayList<T> resultList, Rect selecedArea){
		//TODO Insert code for Assignment 5.1 b
	}
	
	/**
	 * Saves the Tree at location fileURL
	 * 
	 * @param fileUrl
	 */
	public void saveQuadTree(String fileUrl){
		File file = new File(fileUrl);
		
		String separator = ";";
		
		
		try {
			FileWriter writer = new FileWriter(file ,false);
			saveNodesRecursive(writer, separator);
			
			
			 writer.flush();
			 writer.close();
			 
		} catch (IOException e) {
		    e.printStackTrace();
		}
		

	}
	
	/**
	 * Internal function that is used to save the tree recursively 
	 * 
	 * @param writer: Specifies a reference to a FileWriter
	 * @param sep: Specifies a separator
	 */
	private void saveNodesRecursive(FileWriter writer, String sep){
		
		try {
			if(this.leafElements == null){
				
				writer.write("O;"+this.area.x+sep+this.area.y+sep+this.area.width+sep+this.area.height+sep+this.maxElementNumberInLeafs);
				
				if(this.topleft == null){
					writer.write(sep+" ERROR ");
					writer.write(System.getProperty("line.separator"));
					return;
				}
				writer.write(System.getProperty("line.separator"));
				
				this.topleft.saveNodesRecursive(writer, sep);
				this.topright.saveNodesRecursive(writer, sep);
				this.bottomleft.saveNodesRecursive(writer, sep);
				this.bottomright.saveNodesRecursive(writer, sep);
				
			}else{
				writer.write("B;"+this.area.x+sep+this.area.y+sep+this.area.width+sep+this.area.height+sep+this.maxElementNumberInLeafs+sep);
				if(this.leafElements == null)
					writer.write("0");
				else
					writer.write(""+this.leafElements.size());
				
				writer.write(System.getProperty("line.separator"));
				
				for(int i = 0 ; i < this.leafElements.size(); i++){
					
					this.leafElements.get(i).writeObjectToFile(writer);
					writer.write(System.getProperty("line.separator"));
				}
				
			}
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	/**
	 * Outputs the size of the leaf elements to the console. The tree is traversed inorder.
	 */
	public void inorder() {
		if (this.getLeafElements() != null) {
			
			System.out.print("" + this.getLeafElements().size() + ",");

		} else {
			this.getTopleft().inorder();
			this.getTopright().inorder();
			this.getBottomleft().inorder();
			this.getBottomright().inorder();
		}
	}
	
	public AQuadtree<T> getTopleft() {
		return topleft;
	}

	public AQuadtree<T> getTopright() {
		return topright;
	}

	public AQuadtree<T> getBottomleft() {
		return bottomleft;
	}

	public AQuadtree<T> getBottomright() {
		return bottomright;
	}

	public Rect getArea() {
		return area;
	}

	public ArrayList<T> getLeafElements() {
		return leafElements;
	}
	
}


