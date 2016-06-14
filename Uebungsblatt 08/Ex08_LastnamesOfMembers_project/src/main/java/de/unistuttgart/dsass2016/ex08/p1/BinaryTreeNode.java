/*
 * TODO: AUTORENTAGS NICHT VERGESSEN 
 */
 
package de.unistuttgart.dsass2016.ex08.p1;

import de.unistuttgart.dsass2016.ex08.p1.IBinaryTreeNode;
import java.awt.Point;

public class BinaryTreeNode<T extends Comparable<T>>
implements IBinaryTreeNode<T> {
    private volatile T value = null;
    private volatile IBinaryTreeNode<T> leftChild = null;
    private volatile IBinaryTreeNode<T> rightChild = null;
    private volatile Point position = null;

    public void setValue(T val) {
        this.value = val;
    }

    public T getValue() {
        return this.value;
    }

    public void setLeftChild(IBinaryTreeNode<T> left) {
        this.leftChild = left;
    }

    public IBinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public void setRightChild(IBinaryTreeNode<T> right) {
        this.rightChild = right;
    }

    public IBinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public Point getPosition() {
        return this.position;
    }

    public void setPosition(Point p) {
        this.position = p;
    }
}