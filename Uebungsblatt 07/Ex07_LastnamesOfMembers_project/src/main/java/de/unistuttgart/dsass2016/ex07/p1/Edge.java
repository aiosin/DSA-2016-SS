package de.unistuttgart.dsass2016.ex07.p1;

public class Edge implements IEdge {
	private final int source;
	private final int destination;
	private final double weight;

	/**
	 * Initializes a directed edge from vertex <tt>source</tt> to vertex
	 * <tt>dest</tt> with the given <tt>weight</tt>.
	 * 
	 * @param source
	 *            the tail (source) vertex
	 * @param dest
	 *            the head (destination) vertex
	 * @param weight
	 *            the weight of the directed edge
	 * @throws java.lang.IndexOutOfBoundsException
	 *             if either <tt>v</tt> or <tt>w</tt> is a negative integer
	 * @throws IllegalArgumentException
	 *             if <tt>weight</tt> is <tt>NaN</tt>
	 */
	public Edge(int source, int dest, double weight) {
		if (source < 0)
			throw new IndexOutOfBoundsException(
					"The name of the Vertex must be non negative integers");
		if (dest < 0)
			throw new IndexOutOfBoundsException(
					"The name of the Vertex must be non negative integers");
		if (Double.isNaN(weight))
			throw new IllegalArgumentException("Weight is NaN");
		this.source = source;
		this.destination = dest;
		this.weight = weight;
	}

	@Override
	public int getSource() {
		return source;
	}

	@Override
	public int getDestination() {
		return destination;
	}

	@Override
	public double getWeight() {
		return weight;
	}
}
