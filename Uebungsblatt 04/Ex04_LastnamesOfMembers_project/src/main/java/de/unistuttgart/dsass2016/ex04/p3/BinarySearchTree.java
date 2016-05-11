package de.unistuttgart.dsass2016.ex04.p3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	@SuppressWarnings("unused")
	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) {
		// TODO very messy code
		// TODO: cleanup
		final IBinarySearchTree<T> dummyList = this;

		if (traversalType == TreeTraversalType.PREORDER) {
			return new Iterator<T>() {

				int index = 0;

				List<IBinaryTreeNode<T>> iteratorList = returnBSTpreOrder(dummyList.getRootNode(), null);

				// todo this iteratorstuff
				public boolean hasNext() {
					return (((index + 1) <= iteratorList.size()) && (iteratorList.get(index + 1) != null));
				}

				@Override
				public T next() {
					return iteratorList.get(index++).getValue();
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		} else if (traversalType == TreeTraversalType.INORDER) {
			return new Iterator<T>() {
				// TODO this is inorder
				int index = 0;

				List<IBinaryTreeNode<T>> iteratorList = returnBSTinOrder(dummyList.getRootNode(), null);

				@Override
				public boolean hasNext() {
					return (((index + 1) <= iteratorList.size()) && (iteratorList.get(index + 1) != null));
				}

				@Override
				public T next() {
					return iteratorList.get(index++).getValue();
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			};

		} else if (traversalType == TreeTraversalType.POSTORDER) {
			return new Iterator<T>() {
				int index = 0;
				List<IBinaryTreeNode<T>> iteratorList = returnBSTpostOrder(dummyList.getRootNode(), null);

				@Override
				public boolean hasNext() {
					return (((index + 1) <= iteratorList.size()) && (iteratorList.get(index + 1) != null));
				}

				@Override
				public T next() {
					return iteratorList.get(index++).getValue();
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			};

		} else {
			// LevelOrder
			return new Iterator<T>() {
				int index = 0;
				List<IBinaryTreeNode<T>> iteratorList = returnBSTlevelOrder(dummyList.getRootNode(), null);

				@Override
				public boolean hasNext() {
					return (((index + 1) <= iteratorList.size()) && (iteratorList.get(index + 1) != null));
				}

				@Override
				public T next() {
					return iteratorList.get(index++).getValue();
				}

				public void remove() {
					throw new UnsupportedOperationException();
				}
			};
		}

	}

	public List<IBinaryTreeNode<T>> returnBSTinOrder(IBinaryTreeNode<T> node, List<IBinaryTreeNode<T>> list) {
		if (list == null) {
			list = new ArrayList<IBinaryTreeNode<T>>();
		}
		if (node != null) {
			returnBSTinOrder(node.getLeftChild(), list);
			list.add(node);
			returnBSTinOrder(node.getRightChild(), list);
		}
		return list;
	}

	public List<IBinaryTreeNode<T>> returnBSTpreOrder(IBinaryTreeNode<T> node, List<IBinaryTreeNode<T>> list) {
		if (list == null) {
			list = new ArrayList<IBinaryTreeNode<T>>();
		}
		if (node != null) {
			list.add(node);
			returnBSTpreOrder(node.getLeftChild(), list);
			returnBSTpreOrder(node.getRightChild(), list);
		}
		return list;
	}

	public List<IBinaryTreeNode<T>> returnBSTpostOrder(IBinaryTreeNode<T> node, List<IBinaryTreeNode<T>> list) {
		if (list == null) {
			list = new ArrayList<IBinaryTreeNode<T>>();
		}
		if (node != null) {
			returnBSTpostOrder(node.getLeftChild(), list);
			returnBSTpostOrder(node.getRightChild(), list);
			list.add(node);
		}
		return list;
	}

	// eh, not very efficient what this is doing but meh
	// its also not recursive but w/e
	public List<IBinaryTreeNode<T>> returnBSTlevelOrder(IBinaryTreeNode<T> node, List<IBinaryTreeNode<T>> list) {
		if (list == null) {
			list = new ArrayList<IBinaryTreeNode<T>>();
			
		}
		
		Queue<IBinaryTreeNode<T>> levelQueue  = new LinkedList<IBinaryTreeNode<T>>();
		levelQueue.add(node);
		while(!levelQueue.isEmpty()){
			IBinaryTreeNode<T> tempNode = levelQueue.poll();
			list.add(tempNode);
			if (tempNode.getLeftChild()!= null) {
				levelQueue.add(tempNode.getLeftChild());
			}
			if(tempNode.getRightChild() != null){
				levelQueue.add(tempNode.getRightChild());
			}
			
			
		}
		
		
		return list;
	}

}
