package de.unistuttgart.dsass2016.ex07.p1;

import java.util.Iterator;

public interface IWeightedGraph {

	/**
	 * Returns the number of edges in the weighted graph.
	 * 
	 * @return the number of edges in the weighted graph
	 */
	public int numberOfEdges();

	/**
	 * Returns the number of vertices in the weighted graph.
	 * 
	 * @return the number of vertices in the weighted graph
	 */
	public int numberOfVertices();

	/**
	 * Adds the edge <tt>e</tt> to the weighted graph.
	 * 
	 * @param e
	 *            the directed edge
	 */
	public void addEdge(IEdge e);

	/**
	 * Returns an iterator of all edges in the weighted graph.
	 * 
	 * @return an iterator that iterates through all edges in the weighted
	 *         graph.
	 */
	public Iterator<IEdge> edgeIterator();
}
