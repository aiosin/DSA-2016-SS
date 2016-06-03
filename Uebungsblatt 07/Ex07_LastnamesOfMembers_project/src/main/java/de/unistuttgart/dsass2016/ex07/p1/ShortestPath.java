package de.unistuttgart.dsass2016.ex07.p1;

import java.util.Iterator;
import java.util.Stack;

public class ShortestPath implements IShortestPath {

	private final IWeightedGraph graph;
	private final int startVertex;


	/**
	 * Initializes the shortest path for weighted graph <tt>graph</tt> from
	 * starting vertex <tt>startVertex</tt>. Calls the bellmanFord(graph,
	 * startVertex) method to execute the Bellman Ford algorithm.
	 * 
	 * @param graph
	 *            the weighted graph
	 * @param startVertex
	 *            the starting vertex
	 */
	public ShortestPath(IWeightedGraph graph, int startVertex) {
		this.graph = graph;
		this.startVertex = startVertex;
		bellmanFord(this.graph, this.startVertex);
	}


	
	@Override
	public void bellmanFord(IWeightedGraph graph, int startVertex) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean hasNegativeCycle() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public double distanceTo(int destination) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean existsPathTo(int destination) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<IEdge> pathTo(int destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
