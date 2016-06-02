package de.unistuttgart.dsass2016.ex07.p1;

import java.util.ArrayList;
import java.util.Iterator;

public class WeightedGraph implements IWeightedGraph {

	private final int numVertices;
	private volatile int numEdges;
	private final ArrayList<IEdge>[] adjacencyList;

	/**
	 * Initializes an empty weighted graph with <tt>V</tt> vertices and 0
	 * directed edges.
	 * 
	 * @param n
	 *            the number of vertices
	 * 
	 * @throws java.lang.IllegalArgumentException
	 *             if <tt>V</tt> < 0
	 */
	@SuppressWarnings("unchecked")
	public WeightedGraph(int numVertices) {
		if (numVertices < 0)
			throw new IllegalArgumentException(
					"Number of vertices in a graph must be nonnegative");
		this.numVertices = numVertices;
		this.numEdges = 0;
		this.adjacencyList = (ArrayList<IEdge>[]) new ArrayList[numVertices];
		for (int i = 0; i < numVertices; i++)
			this.adjacencyList[i] = new ArrayList<IEdge>();
	}

	@Override
	public int numberOfVertices() {
		return this.numVertices;
	}

	@Override
	public int numberOfEdges() {
		return this.numEdges;
	}

	@Override
	public void addEdge(IEdge edge) {
		int source = edge.getSource();
		this.adjacencyList[source].add(edge);
		this.numEdges++;
	}

	@Override
	public Iterator<IEdge> edgeIterator() {
		ArrayList<IEdge> edgeList = new ArrayList<IEdge>();
		for (int i = 0; i < this.numVertices; i++) {
			edgeList.addAll(this.adjacencyList[i]);
		}
		return edgeList.iterator();
	}

}
