package fragmentGraph;

import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;
import org.jgrapht.generate.GraphGenerator;

public class FragmentGraphGenerator<V,E> implements GraphGenerator<V, E, V> {

	// roles for the nodes
	public static final String BASE_STATEMENT = "Base statement"; 
	
	/*
	 * (non-Javadoc)
	 * @see org.jgrapht.generate.GraphGenerator#generateGraph(org.jgrapht.Graph, org.jgrapht.VertexFactory, java.util.Map)
	 * 
	 * we could generate a FragmentGraph with EntailmentUnitMention and FragmentGraphEdge, and FragmentGraphEdgeFactory,
	 * we can use the map to give specific roles to the nodes (e.g. -- base statements, and whatnot)
	 */
	public void generateGraph(Graph<V, E> arg0, VertexFactory<V> arg1,
			Map<String, V> arg2) {
		// TODO Auto-generated method stub
		
	}

}
