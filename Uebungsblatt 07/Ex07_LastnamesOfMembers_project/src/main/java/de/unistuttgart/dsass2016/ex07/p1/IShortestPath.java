package de.unistuttgart.dsass2016.ex07.p1;

import java.util.Iterator;

public interface IShortestPath {

	/**
	 * Computes the Bellman Ford algorithm on the weighted graph <tt>graph</tt>
	 * from starting vertex <tt>startVertex</tt>. This method is started after
	 * initializing a ShortPath object.
	 * 
	 * @param graph
	 *            the weighted graph
	 * @param startVertex
	 *            the starting vertex
	 */
	public void bellmanFord(IWeightedGraph graph, int startVertex);

	/**
	 * Returns a boolean whether there is a negative cycle reachable from the
	 * starting vertex <tt>startVertex</tt>
	 * 
	 * @return <tt>true</tt> if there is a negative cycle reachable from the
	 *         starting vertex <tt>startVertex</tt>, and <tt>false</tt>
	 *         otherwise
	 */
	public boolean hasNegativeCycle();

	/**
	 * Returns the distance of the shortest path from the starting vertex
	 * <tt>startVertex</tt> to vertex <tt>destination</tt>.
	 * 
	 * @param destination
	 *            the destination vertex
	 * @return the length of a shortest path from the starting vertex
	 *         <tt>startVertex</tt> to vertex <tt>destination</tt>;
	 *         <tt>Double.POSITIVE_INFINITY</tt> if no such path exists
	 * @throws IllegalStateException
	 *             if there is a negative cost cycle reachable from the starting
	 *             vertex <tt>startVertex</tt>
	 */
	public double distanceTo(int destination);

	/**
	 * Returns a boolean whether there is a path from the starting vertex
	 * <tt>startVertex</tt> to vertex <tt>destination</tt>?
	 * 
	 * @param destination
	 *            the destination vertex
	 * @return <tt>true</tt> if there is a path from the starting vertex
	 *         <tt>startVertex</tt> to vertex <tt>destination</tt>, and
	 *         <tt>false</tt> otherwise
	 */
	public boolean existsPathTo(int destination);

	/**
	 * Returns the shortest path from the starting vertex <tt>startVertex</tt>
	 * to vertex <tt>destination</tt> in reverse order. Example: A path exists
	 * <tt>s--->u--->x--->y</tt> then the iterator will begin with vertex
	 * <tt>y</tt>, then vertex <tt>x</tt> and then vertex <tt>u</tt>.
	 * 
	 * @param destination
	 *            the destination vertex
	 * @return a shortest path from the starting vertex <tt>startVertex</tt> to
	 *         vertex <tt>destination</tt> as an iterator of the edges, and
	 *         <tt>null</tt> if no such path exists
	 * @throws IllegalStateException
	 *             if there is a negative cost cycle reachable from the starting
	 *             vertex <tt>startVertex</tt>
	 */
	public Iterator<IEdge> pathTo(int destination);

}
