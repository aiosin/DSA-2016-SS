package de.unistuttgart.dsass2016.ex03.p3;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {

	IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public void insert(T t) {
		IBinaryTreeNode<T> insertionNode = new BinaryTreeNode<T>();
		insertionNode.setValue(t);
		if (root == null) {
			root = insertionNode;
			return;
		} else if (root != null) {
			recursiveInsertNode(root, insertionNode);
			return;
		} else {
			throw new RuntimeException();
		}
	}

	private void recursiveInsertNode(IBinaryTreeNode<T> root, IBinaryTreeNode<T> node) {
		if (root.getValue().compareTo(node.getValue()) < 0) {
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
			for (IBinaryTreeNode<T> currentNode : returnBSTinOrder(root, null)) {
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
		if (node.getLeftChild() == null && node.getLeftChild() == null) {
			return true;
		} else if (node.getLeftChild() != null && node.getLeftChild() != null) {
			return true;
		} else return false;
	}

	public List<IBinaryTreeNode<T>> returnBSTinOrder(IBinaryTreeNode<T> rootNode, List<IBinaryTreeNode<T>> list) {
		if (list == null)
		{
			list = new ArrayList<IBinaryTreeNode<T>>();
		}
		if (rootNode != null) {
			returnBSTinOrder(rootNode.getLeftChild(), list);
			list.add(rootNode);
			returnBSTinOrder(rootNode.getRightChild(), list);
		}
		return list;

	}
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		System.out.println("start");
		tree.insert(new Integer (4));
		tree.insert(new Integer (3));
		tree.insert(new Integer (5));

		
		System.out.println("end insert");
		
		System.out.println(tree.getRootNode().getValue());
		
		System.out.println("start is full");
		System.out.println(tree.isFull());
		List<IBinaryTreeNode<Integer>> list = tree.returnBSTinOrder(tree.getRootNode(), null);
		for(IBinaryTreeNode<Integer> node : list)
		{
			System.out.println(node.getValue());
		}
		System.out.println("left child: " + tree.getRootNode().getLeftChild().getValue());
		System.out.println("right child: " + tree.getRootNode().getRightChild().getValue());
		System.out.println("end of file");
		System.exit(0);
	}

}
