package finalGraph;


import org.jgrapht.graph.DefaultEdge;

/*
 * Similarly as for the FinalGraphNode, the edge could be a simplified version
 * of the WorkGraphEdge: for example, we could compress multiple edges connecting 
 * the same two nodes (produced by different EOP configurations) into one edge.   
 */

public class FinalGraphEdge<V> extends DefaultEdge {

	V source;
	V target;
	
	double confidence;
	
	FinalGraphEdge(V source, V target, double c) {
		this.source = source;
		this.target = target;
		this.confidence = c;
	}
	
}
