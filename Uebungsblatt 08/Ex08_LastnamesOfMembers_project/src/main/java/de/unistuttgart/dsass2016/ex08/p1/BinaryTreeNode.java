package de.unistuttgart.dsass2016.ex08.p1;

import java.awt.Point;

public class BinaryTreeNode<T extends Comparable<T>> implements
		IBinaryTreeNode<T> {

	private volatile T value;
	private volatile IBinaryTreeNode<T> leftChild;
	private volatile IBinaryTreeNode<T> rightChild;

	private volatile Point position;

	public BinaryTreeNode() {
		this.value = null;
		this.leftChild = null;
		this.rightChild = null;
		this.position = null;
	}

	@Override
	public void setValue(T val) {
		this.value = val;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void setLeftChild(IBinaryTreeNode<T> left) {
		this.leftChild = left;
	}

	@Override
	public IBinaryTreeNode<T> getLeftChild() {
		return this.leftChild;
	}

	@Override
	public void setRightChild(IBinaryTreeNode<T> right) {
		this.rightChild = right;
	}

	@Override
	public IBinaryTreeNode<T> getRightChild() {
		return this.rightChild;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public void setPosition(Point p) {
		this.position = p;
	}

}
