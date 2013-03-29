package finalGraph;


import org.jgrapht.graph.DefaultEdge;

/*
 * Similarly as for the EquivalenceClass, the edge could be a simplified version
 * of the EntailmentRelation: for example, we could compress multiple edges connecting 
 * the same two nodes (produced by different EOP configurations) into one edge.   
 */

public class EntailmentRelationCollapsed<V> extends DefaultEdge {

	V source;
	V target;
	
	double confidence;
	
	EntailmentRelationCollapsed(V source, V target, double c) {
		this.source = source;
		this.target = target;
		this.confidence = c;
	}
	
}
