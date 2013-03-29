package finalGraph;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

import workGraph.WorkGraph;
import workGraph.EntailmentUnit;

public class EntailmentGraphCollapsed<V,E> extends DefaultDirectedWeightedGraph<V,E>{
	
	Class<? extends V> vertexClass;
	
	public EntailmentGraphCollapsed(EdgeFactory<V, E> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EntailmentGraphCollapsed(Class<? extends E> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Converts an input work graph to a format that would be useful to the end users
	 * This might mean changing the nodes from complex annotated objects to sets of strings
	 * and compressing multiple edges into one
	 * @param <WV>
	 * @param <WE>
	 * 
	 * @param wg
	 */
	public <WV, WE> void convertGraph(WorkGraph<WV, WE> wg) {
		// iterate over wg's vertices and build the corresponding EntailmentGraphCollapsed nodes,
		// and over all edges starting from the current vertex, and either choose
		// not to include them in the final graph, or compress multiple edges 
		// connecting the same two vertices into one
		
		Constructor<?> vconstr;
		try {
			vconstr = vertexClass.getConstructor();
		
			Map<WV,V> nodeMap = new HashMap<WV,V>();
			for(WV wv: wg.vertexSet()) {
				V v = (V) vconstr.newInstance(wv);  //(V) new EquivalenceClass((EntailmentUnit) wv);
				nodeMap.put(wv, v);
				this.addVertex(v);
				for (WE we: wg.outgoingEdgesOf(wv)) {
					WV _wv = wg.getEdgeTarget(we);
					V _v;
					if (! nodeMap.containsKey(_wv)) {
						_v = (V) vconstr.newInstance(_wv);
						nodeMap.put(_wv,_v);
					} else {
						_v = nodeMap.get(_wv);
					}
					this.addEdge(v,_v);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
