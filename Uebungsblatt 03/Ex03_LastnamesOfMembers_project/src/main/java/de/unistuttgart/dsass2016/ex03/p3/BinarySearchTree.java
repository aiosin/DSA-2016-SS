package de.unistuttgart.dsass2016.ex03.p3;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public void insert(T t) {
		// creating a insertion node
		IBinaryTreeNode<T> insertionNode = new BinaryTreeNode<T>();
		insertionNode.setValue(t);
		// check if there are elements in the root node
		// if there are not: then the root node will be the first node
		if (root == null) {
			root = insertionNode;
			return;
		} else if (root != null) {
			// if the root node is not empty then use the recurisveInsertNode
			// method

			recursiveInsertNode(root, insertionNode);
			return;
		} else {
			// if this happens youre fucked
			throw new RuntimeException();
		}
	}

	private void recursiveInsertNode(IBinaryTreeNode<T> root, IBinaryTreeNode<T> node) {
		// left right statement
		if (root.getValue().compareTo(node.getValue()) < 0) {
			// if we recursively reached our desired end, we simple put the
			// value at the point and break;
			if (root.getLeftChild() == null) {
				root.setLeftChild(node);
				return;
			} else {
				recursiveInsertNode(root.getLeftChild(), node);
			}
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(node);
				return;
			} else {
				recursiveInsertNode(root.getRightChild(), node);
			}
		}
		return;

	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return root;
	}

	@Override
	public boolean isFull() {
		if (root == null) {
			return true;
		} else {
			for (IBinaryTreeNode<T> currentNode : returnBSTinOrder(root)) {
				if (nodeQualifiesForFull(currentNode) == true) {
					continue;
				} else {
					return false;
				}
			}
			return true;

		}

	}

	public boolean nodeQualifiesForFull(IBinaryTreeNode<T> node) {
		if (node.getLeftChild() != null || node.getRightChild() != null) {
			return true;
		} else if (node.getLeftChild() == null && node.getRightChild() == null) {
			return true;
		} else {
			return false;
		}
	}

	public List<IBinaryTreeNode<T>> returnBSTinOrder(IBinaryTreeNode<T> rootNode) {
		List<IBinaryTreeNode<T>> returnList = new ArrayList<IBinaryTreeNode<T>>();
		while (rootNode != null) {
			returnBSTinOrder(rootNode.getLeftChild());
			returnList.add(rootNode);
			returnBSTinOrder(rootNode.getRightChild());
		}
		return returnList;

	}
	
	public static void main(String[] args) {
		System.out.println("initiating");
		BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
		System.out.println("beginning");
		tree.insert(new Integer(2));
		tree.insert(new Integer(22));
		tree.insert(new Integer(23));
		tree.insert(new Integer(12));
		tree.insert(new Integer(1232));
		tree.insert(new Integer(212));
		tree.insert(new Integer(123332));
		System.out.println(tree.returnBSTinOrder(tree.root).toString());
		System.out.println("end now");
		System.out.println("isfull");
		System.out.println(tree.isFull());
		System.out.println("is full end");
	}
}
