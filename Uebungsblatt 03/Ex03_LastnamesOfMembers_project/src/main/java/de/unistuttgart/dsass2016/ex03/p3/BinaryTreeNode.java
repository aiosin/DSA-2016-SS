package de.unistuttgart.dsass2016.ex03.p3;

public class BinaryTreeNode<T extends Comparable<T>> implements IBinaryTreeNode<T> {
	
	private T val;
	private IBinaryTreeNode<T> LeftChild;
	private IBinaryTreeNode<T> RightChild;
	
	public BinaryTreeNode() {
		// TODO: to be completed
	}

	@Override
	public void setValue(T val) {
		this.val = val;
	}

	@Override
	public T getValue() {
		return this.val;
	}

	@Override
	public void setLeftChild(IBinaryTreeNode<T> left) {
		this.LeftChild = left;
	}

	@Override
	public IBinaryTreeNode<T> getLeftChild() {
		return LeftChild;
	}

	@Override
	public void setRightChild(IBinaryTreeNode<T> right) {
		this.RightChild = right;
		
	}

	@Override
	public IBinaryTreeNode<T> getRightChild() {
		return RightChild;
	}


}
