/*
 * TODO: AUTORENTAGS NICHT VERGESSEN 
 */
 
package de.unistuttgart.dsass2016.ex08.p1;

import de.unistuttgart.dsass2016.ex08.p1.BinarySearchTree;
import de.unistuttgart.dsass2016.ex08.p1.IBinarySearchTree;
import de.unistuttgart.dsass2016.ex08.p1.IBinaryTreeNode;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TreePanel
extends JPanel {
    private static final long serialVersionUID = 5941353085731723624L;
    private IBinarySearchTree<Integer> bst;
    private static final int X_MARGIN = 20;
    private static final int Y_MARGIN = 20;
    private static final int X_STRETCH = 30;
    private static final int Y_STRETCH = 60;

    public TreePanel(IBinarySearchTree<Integer> bst) {
        this.bst = bst;
        this.setSize(600, 300);
        this.setBackground(Color.white);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.drawTreeNodes(g, this.bst.getRootNode(), null);
    }

    public void drawTreeNodes(Graphics g, IBinaryTreeNode<Integer> treeNode, Point parentPosition) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (treeNode != null && treeNode.getPosition() != null) {
            Point p = treeNode.getPosition();
            if (parentPosition != null) {
                g.setColor(Color.black);
                g2d.drawLine((int)p.getX() * 30 + 15 + 20, (int)p.getY() * 60 + 15 + 20, (int)parentPosition.getX() * 30 + 15 + 20, (int)parentPosition.getY() * 60 + 15 + 20);
            }
            this.drawTreeNodes(g, treeNode.getLeftChild(), treeNode.getPosition());
            this.drawTreeNodes(g, treeNode.getRightChild(), treeNode.getPosition());
            g.setColor(Color.black);
            Ellipse2D.Double circle = new Ellipse2D.Double(p.getX() * 30.0 + 20.0, p.getY() * 60.0 + 20.0, 30.0, 30.0);
            g2d.fill(circle);
            g.setColor(Color.white);
            g2d.drawString(String.valueOf(treeNode.getValue()), (int)p.getX() * 30 + 10 + 20, (int)p.getY() * 60 + 20 + 20);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert((Comparable)Integer.valueOf(51));
        bst.insert((Comparable)Integer.valueOf(55));
        bst.insert((Comparable)Integer.valueOf(21));
        bst.insert((Comparable)Integer.valueOf(12));
        bst.insert((Comparable)Integer.valueOf(33));
        bst.insert((Comparable)Integer.valueOf(15));
        bst.insert((Comparable)Integer.valueOf(91));
        bst.insert((Comparable)Integer.valueOf(72));
        bst.insert((Comparable)Integer.valueOf(95));
        bst.insert((Comparable)Integer.valueOf(35));
        bst.insert((Comparable)Integer.valueOf(53));
        bst.calculatePositions();
        TreePanel treeCanvas = new TreePanel((IBinarySearchTree<Integer>)bst);
        JFrame frame1 = new JFrame();
        frame1.setSize(400, 300);
        frame1.add(treeCanvas);
        frame1.setVisible(true);
    }
}