package de.unistuttgart.dsass2016.ex04.p3;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTreeIterable<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {
		// TODO implement this one thing at a time
		//return in inner anonymous class
		//TODO: implement 
		if (traversalType ==TreeTraversalType.PREORDER) {
			
		} else if (traversalType == TreeTraversalType.INORDER) {

		} else if (traversalType == TreeTraversalType.POSTORDER) {

		} else {
			// LevelOrder
			
		}
		return null;
	}

}
