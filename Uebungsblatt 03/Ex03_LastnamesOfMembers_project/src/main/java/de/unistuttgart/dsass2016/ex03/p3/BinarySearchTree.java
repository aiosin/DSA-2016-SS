package de.unistuttgart.dsass2016.ex03.p3;

public class BinarySearchTree<T extends Comparable<T>> implements IBinarySearchTree<T> {
	
	IBinaryTreeNode<T> root;
	

	public BinarySearchTree() {
		root = null;
	}

	@Override
	public void insert(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return root;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}


}
