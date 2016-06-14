package de.unistuttgart.dsass2016.ex08.p1;

import java.awt.Point;

public class BinarySearchTree<T extends Comparable<T>> implements
		IBinarySearchTree<T> {

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t, 0, null);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t, int lev,
			IBinaryTreeNode<T> par) {
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
			node.setRightChild(this.insert(node.getRightChild(), t, lev + 1,
					node));
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
		} else if ((node.getLeftChild() == null)
				&& (node.getRightChild() == null)) {
			return true;
		} else if ((node.getLeftChild() == null)
				|| (node.getRightChild() == null)) {
			return false;
		}
		return this.isFull(node.getLeftChild())
				&& this.isFull(node.getRightChild());
	}

	@Override
	public void calculatePositions() {
		// TODO calculate the position for each node in the tree
		// - the position of a node on the x-axis is calculated by its position in the in-order traversal (first node has x = 0)
		// - the position of a node on the y-axis is calculated by its level in the tree (root has y = 0)
	}


}
