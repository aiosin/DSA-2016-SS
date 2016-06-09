package de.unistuttgart.dsass2016.ex08.p1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Canvas to display a binary search tree
 */
public class TreePanel extends JPanel {

	private static final long serialVersionUID = 5941353085731723624L;

	/**
	 * Binary search tree that should be drawn
	 */
	private IBinarySearchTree<Integer> bst;

	/**
	 * Horizontal margin (left)
	 */
	private static final int X_MARGIN = 20;

	/**
	 * Vertical margin (top)
	 */
	private static final int Y_MARGIN = 20;

	/**
	 * Horizontal stretch factor
	 */
	private static final int X_STRETCH = 30;

	/**
	 * Vertical stretch factor
	 */
	private static final int Y_STRETCH = 60;

	/**
	 * Constructor to set the binary search tree and initialize the canvas
	 * 
	 * @param bst
	 *            Binary search tree that should be drawn
	 */
	public TreePanel(IBinarySearchTree<Integer> bst) {
		this.bst = bst;

		// initialize canvas
		setSize(600, 300);
		setBackground(Color.white);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// drawing routine for the tree
		drawTreeNodes(g, bst.getRootNode(), null);
	}

	/**
	 * Recursive drawing routine to draw the tree
	 * 
	 * @param g
	 *            Graphics object
	 * @param treeNode
	 *            Current tree node
	 */
	public void drawTreeNodes(Graphics g, IBinaryTreeNode<Integer> treeNode,
			Point parentPosition) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if (treeNode != null && treeNode.getPosition() != null) {
			Point p = treeNode.getPosition();
			// draw a connection line if node has a parent
			if (parentPosition != null) {
				g.setColor(Color.black);
				g2d.drawLine((int) p.getX() * X_STRETCH + X_STRETCH / 2
						+ X_MARGIN, (int) p.getY() * Y_STRETCH + X_STRETCH / 2
						+ Y_MARGIN, (int) parentPosition.getX() * X_STRETCH
						+ X_STRETCH / 2 + X_MARGIN, (int) parentPosition.getY()
						* Y_STRETCH + X_STRETCH / 2 + Y_MARGIN);
			}
			// draw the left child node
			drawTreeNodes(g, treeNode.getLeftChild(), treeNode.getPosition());
			// draw the right child node
			drawTreeNodes(g, treeNode.getRightChild(), treeNode.getPosition());

			// draws an ellipse for the node with the value
			g.setColor(Color.black);
			Ellipse2D circle = new Ellipse2D.Double(p.getX() * X_STRETCH
					+ X_MARGIN, p.getY() * Y_STRETCH + Y_MARGIN, X_STRETCH,
					X_STRETCH);
			g2d.fill(circle);
			g.setColor(Color.white);
			g2d.drawString(String.valueOf(treeNode.getValue()), (int) p.getX()
					* X_STRETCH + X_STRETCH / 3 + X_MARGIN, (int) p.getY()
					* Y_STRETCH + Y_STRETCH / 3 + Y_MARGIN);
		}
	}

	/**
	 * Main method to draw a sample tree
	 * 
	 * @param args
	 *            Command line arguments (ignored)
	 */
	public static void main(String[] args) {

		// create a binary search tree for drawing
		IBinarySearchTree<Integer> bst = new BinarySearchTree<>();

		// sample tree
		bst.insert(51);
		bst.insert(55);
		bst.insert(21);
		bst.insert(12);
		bst.insert(33);
		bst.insert(15);
		bst.insert(91);
		bst.insert(72);
		bst.insert(95);
		bst.insert(35);
		bst.insert(53);

		// calculate the position for all nodes
		bst.calculatePositions();

		// create a new tree drawer
		TreePanel treeCanvas = new TreePanel(bst);
		// create a new frame and add the tree drawer
		JFrame frame1 = new JFrame();
		frame1.setSize(400, 300);
		frame1.add(treeCanvas);
		frame1.setVisible(true);

	}

}
