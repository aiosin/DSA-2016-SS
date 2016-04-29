package de.unistuttgart.dsass2016.ex03.p3;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public void insert(T t) {
		//creating a insertion node 
		IBinaryTreeNode<T> insertionNode = new BinaryTreeNode<T>();
		insertionNode.setValue(t);
		//check if there are elements in the root node
		//if there are not: then the root node will be the first node
		if (root == null) {
			root = insertionNode;
			return;
		} else if (root != null) {
			//if the root node is not empty then use the recurisveInsertNode method
			
			recursiveInsertNode(root, insertionNode);
			return;
		} else {
			//if this happens youre fucked
			throw new RuntimeException();
		}
	}
	//this method decides where to put the given node in the tree
	//if the value is lower than the higher node, node gets sent left
	//if the value is higher than the higher node, node gets sent right
	public void recursiveInsertNode(IBinaryTreeNode<T> root, IBinaryTreeNode<T> node){
		//left right statement
		if (root.getValue().compareTo(node.getValue())< 0) {
			//if we recursively reached our desired end, we simple put the value at the point and break; 
			if (root.getLeftChild() == null) {
				root.setLeftChild(node);
				
				//TODO: find out if return is necessary
				return;
			} else {
				recursiveInsertNode(root.getLeftChild(), node);
			}
		//same story for the right side as for the left side
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(node);
				return;
			} else {
				recursiveInsertNode(root.getRightChild(), node);
			}
		}
		//CRASHING THIS METHOD;
		//WITH NO SURVIVORS
		return;
		
	}
	@Override
	public IBinaryTreeNode<T> getRootNode() {
		//WAS GETTING ROOT PART OF YOUR PLAN ?
		return root;
		//WELL CONGRATULATIONS YOU GOT YOURSELF CAUGHT
	}

	@SuppressWarnings("unused")
	@Override
	public boolean isFull() {
		//maybe put every Node in existance in a LinkedList and check if either both nodes
		//and not null or have some data
		//if even only one fails this test we're going to return false
		if (root == null) {
			return true;
		} else {
			//Getting all the Nodes into an ArrayList
			for (IBinaryTreeNode<T> node : returnBSTinOrder(root)) {
				if (nodeQualifiesForFull(node) == true ) {
					 
				}else {
					return false;
				}
			}
		}
		return false;
		
		
		
	}
	//instead of 
	public boolean nodeQualifiesForFull(IBinaryTreeNode<T> node){
		if (node.getLeftChild() != null || node.getRightChild() != null) {
			return true;
		} else if(node.getLeftChild() == null && node.getRightChild() == null) {
			return true;
		}else {
			return false;
		}
	}
	//HORRIBLY INEFFICIENT AND POSSIBLY DANGEROUS AVOID AT ALL COSTS
	//method scans the branches of a node and returns them all in 
	public List<IBinaryTreeNode<T>> returnBSTinOrder(IBinaryTreeNode<T> node){
		//temporary workaroound HORRIBLY INEFFICIENT (O(2n)) out of place
		Stack<IBinaryTreeNode<T>> s = new Stack<IBinaryTreeNode<T>>();
		List<IBinaryTreeNode<T>> returnList = new ArrayList<IBinaryTreeNode<T>>();
		
		if(node == null){
			return null;
		}
		IBinaryTreeNode<T> currentNode = root;
		while(!s.isEmpty() || currentNode != null ){
			if (currentNode !=null) {
				s.push(currentNode);
				currentNode = currentNode.getLeftChild();
			} else {
				IBinaryTreeNode<T> n = s.pop();
				returnList.add(n);
				currentNode = n.getRightChild();
			}
		}
		
		
		
		return returnList;
		
	}

}
