package de.unistuttgart.dsass2016.ex08.p1;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author 3133783 Wilhelm Buchmüller 
 * @author 3149308 Daniel Wanner 
 * @author 2736424 Artur Frenzen
 *
 */
public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t, 0, null);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t, int lev, IBinaryTreeNode<T> par) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}

		if (t.compareTo(node.getValue()) < 0) {
			// Go left
			node.setLeftChild(this.insert(node.getLeftChild(), t, lev + 1, node));
		} else if (t.compareTo(node.getValue()) > 0) {
			// Go right
			node.setRightChild(this.insert(node.getRightChild(), t, lev + 1, node));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	@Override
	public boolean isFull() {
		return this.isFull(this.root);
	}

	private boolean isFull(IBinaryTreeNode<T> node) {
		if (node == null) {
			return true;
		} else if ((node.getLeftChild() == null) && (node.getRightChild() == null)) {
			return true;
		} else if ((node.getLeftChild() == null) || (node.getRightChild() == null)) {
			return false;
		}
		return this.isFull(node.getLeftChild()) && this.isFull(node.getRightChild());
	}

	@Override
	/**
	 * method calculatePositions()
	 * determines and sets the nodes location in the tree
	 */
	public void calculatePositions() {
		
		
		//the queue ist going to be used for determining the x value of a node
		//anything with a foo.size() could have been used
		Queue<IBinaryTreeNode<T>> q = new LinkedList<IBinaryTreeNode<T>> ();
		
		inorderPositionCalculation(this.root, 0, q);

	}
	
	/**
	 * 
	 * @param node - selfexplanatory
	 * @param depth - for better understanding should be named height but decides the height/depth of the point (y-pos)
	 * @param q - queue for x-pos
	 */
	private void inorderPositionCalculation(IBinaryTreeNode<T> node, int depth, Queue<IBinaryTreeNode<T>>  q){
		if (node != null) {
			
			inorderPositionCalculation(node.getLeftChild(), depth+1,q);
			
			node.setPosition(new Point(q.size(),depth));
			//the queue is solely for the determination of the x value, we are not iterating over it or something
			q.add(node);
			
			inorderPositionCalculation(node.getRightChild(), depth+1, q);
			
		}
	}

}
