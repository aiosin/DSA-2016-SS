package de.unistuttgart.dsass2016.ex04.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
		//this has to be final, also you dont want anything asynchronous to happen
		final IBinarySearchTree<T> dummyList = this;
		
		if (traversalType == TreeTraversalType.PREORDER) {
			return new Iterator<T>() {
				
				int index = 0;
				
				public List<T> recReturnInorder(IBinarySearchTree<T> list){
					List<T> returnList = new ArrayList<T>();
						
						
						return null;
					
				}
				
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}
				
				public void remove(){
					throw new UnsupportedOperationException();
				}
			};
		} else if (traversalType == TreeTraversalType.INORDER) {
			return new Iterator<T>() {

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}
			};

		} else if (traversalType == TreeTraversalType.POSTORDER) {
			return new Iterator<T>() {

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}
			};

		} else {
			// LevelOrder
			return new Iterator<T>() {

				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public T next() {
					return null;
				}
			};
		}

	}

}
