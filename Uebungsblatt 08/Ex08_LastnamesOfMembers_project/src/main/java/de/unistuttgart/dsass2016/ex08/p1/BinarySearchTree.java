/*
 * TODO: AUTORENTAGS NICHT VERGESSEN 
 */
 
package de.unistuttgart.dsass2016.ex08.p1;

import de.unistuttgart.dsass2016.ex08.p1.BinaryTreeNode;
import de.unistuttgart.dsass2016.ex08.p1.IBinarySearchTree;
import de.unistuttgart.dsass2016.ex08.p1.IBinaryTreeNode;
import java.awt.Point;

public class BinarySearchTree<T extends Comparable<T>>
implements IBinarySearchTree<T> {
    private volatile IBinaryTreeNode<T> root = null;

    public void insert(T t) {
        this.root = this.insert(this.root, t, 0, null);
    }

    private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t, int lev, IBinaryTreeNode<T> par) {
        if (node == null) {
            BinaryTreeNode newNode = new BinaryTreeNode();
            newNode.setValue(t);
            return newNode;
        }
        if (t.compareTo((Comparable)node.getValue()) < 0) {
            node.setLeftChild(this.insert(node.getLeftChild(), t, lev + 1, node));
        } else if (t.compareTo((Comparable)node.getValue()) > 0) {
            node.setRightChild(this.insert(node.getRightChild(), t, lev + 1, node));
        }
        return node;
    }

    public IBinaryTreeNode<T> getRootNode() {
        return this.root;
    }

    public boolean isFull() {
        return this.isFull(this.root);
    }

    private boolean isFull(IBinaryTreeNode<T> node) {
        if (node == null) {
            return true;
        }
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        }
        if (node.getLeftChild() == null || node.getRightChild() == null) {
            return false;
        }
        if (this.isFull(node.getLeftChild()) && this.isFull(node.getRightChild())) {
            return true;
        }
        return false;
    }

    public Point calculatePositions() {
        return this.calculatePositions(this.root, -1, 0);
    }

    private Point calculatePositions(IBinaryTreeNode<T> node, int offsetX, int offsetY) {
        return null;
    }
}