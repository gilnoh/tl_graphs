package fragmentGraph;

import org.jgrapht.graph.DefaultEdge;

/*
 * The edge of a Fragment graph is very simple. It is only a directed edge, without weight.
 */

public class FragmentGraphEdge<V> extends DefaultEdge{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2082959681128417819L;
	
	V source;
	V target;
	
	double weight = 1;
	
	FragmentGraphEdge(V v1, V v2, double w) {
		source = v1;
		target = v2;
		weight = w;
	}
	
	public double getWeight(){
		return weight;
	}
	
}
