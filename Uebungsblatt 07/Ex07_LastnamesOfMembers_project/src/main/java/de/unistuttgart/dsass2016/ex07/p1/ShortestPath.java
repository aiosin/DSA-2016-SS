package de.unistuttgart.dsass2016.ex07.p1;

import java.util.Iterator;
import java.util.Stack;

public class ShortestPath
  implements IShortestPath
{
  private final IWeightedGraph graph;
  private final int startVertex;
  private volatile double[] distance;
  private volatile boolean hasNegativeCycle;
  private volatile IEdge[] backtrace;
  
  public ShortestPath(IWeightedGraph graph, int startVertex)
  {
    this.graph = graph;
    this.startVertex = startVertex;
    bellmanFord(this.graph, this.startVertex);
  }
  
  public void bellmanFord(IWeightedGraph graph, int startVertex)
  {
    int numberOfVertices = graph.numberOfVertices();
    this.distance = new double[numberOfVertices];
    this.backtrace = new Edge[numberOfVertices];
    for (int i = 0; i < numberOfVertices; i++) {
      this.distance[i] = Double.POSITIVE_INFINITY;
    }
    this.distance[startVertex] = 0.0D;
    for (int i = 1; i < numberOfVertices - 1; i++)
    {
      Iterator<IEdge> edges = graph.edgeIterator();
      while (edges.hasNext())
      {
        IEdge edge = (IEdge)edges.next();
        if (this.distance[edge.getSource()] + edge.getWeight() < this.distance[edge.getDestination()])
        {
          this.distance[edge.getDestination()] = 
            (this.distance[edge.getSource()] + edge.getWeight());
          this.backtrace[edge.getDestination()] = edge;
        }
      }
    }
    Iterator<IEdge> edges = graph.edgeIterator();
    while (edges.hasNext())
    {
      IEdge e = (IEdge)edges.next();
      if (this.distance[e.getSource()] + e.getWeight() < this.distance[e.getDestination()]) {
        this.hasNegativeCycle = true;
      }
    }
  }
  
  public boolean hasNegativeCycle()
  {
    return this.hasNegativeCycle;
  }
  
  public double distanceTo(int vertex)
  {
    if (hasNegativeCycle()) {
      throw new IllegalStateException("Negative cycle found");
    }
    return this.distance[vertex];
  }
  
  public boolean existsPathTo(int vertex)
  {
    return this.distance[vertex] < Double.POSITIVE_INFINITY;
  }
  
  public Iterator<IEdge> pathTo(int vertex)
  {
    if (hasNegativeCycle()) {
      throw new IllegalStateException("Negative cycle found");
    }
    if (!existsPathTo(vertex)) {
      return null;
    }
    Stack<IEdge> path = new Stack();
    for (IEdge edge = this.backtrace[vertex]; edge != null; edge = this.backtrace[edge
          .getSource()]) {
      path.push(edge);
    }
    return path.iterator();
  }
}
