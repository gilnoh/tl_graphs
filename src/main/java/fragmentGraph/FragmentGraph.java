package fragmentGraph;

import java.util.HashSet;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

public class FragmentGraph<V,E> extends DefaultDirectedWeightedGraph<V,E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4631493969220124299L;
	/*
	 * apart from the graph's structure, we might benefit from keeping track 
	 * of the base statements (what WP2 calls "base predicates", but that confused us
	 * so I renamed them to what we called them in our meeting)
	 */
	V baseStatement;
	
	public FragmentGraph(EdgeFactory<V,E> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public FragmentGraph(Class<? extends E> edgeClass) {
		this(new ClassBasedEdgeFactory<V, E>(edgeClass));
		// TODO Auto-generated constructor stub
	}
	
/*	
	public void addNode(V v) {
		this.addNode(v);
	}
*/	
	/**
	 * 
	 * @return the base statements of the fragment graph (useful for merging methods) -- for compatibility upwards (with WorkGraph)
	 */
	public Set<V> getBaseStatements(){
		return getNodes(0);
	}

	/**
	 * This might be a useful method for the graph merging part, if we follow the
	 * implementation ideas from WP2
	 * 
	 * @param level -- the number of modifiers on top of the base statement
	 * @return -- the set of nodes with "level" number of modifiers 
	 */
/*	public Set<V> getNodes(int level) {
		Set<V> nodes = new HashSet<V>();
		nodes.add(baseStatement);
		return getNodes(level, nodes);
	}
	
	public Set<V> getNodes(int level, Set<V> nodes){
		if (level == 0)
			return nodes;
		
		Set<V> newNodes = new HashSet<V>();
		for(V n: nodes) {
			for(E e: this.edgesOf(n)) {
				newNodes.add(this.getEdgeTarget(e));
			}
		}
		return getNodes(level-1,newNodes);
	}
*/
	
	public Set<V> getNodes(int level) {
		Set<V> nodes = new HashSet<V>();
		
		for(V v: this.vertexSet()) {
			if (((FragmentGraphNode) v).getLevel() == level) {
				nodes.add(v);
			}
		}
		return nodes;
	}
	
	/*
	 * most of the graph related methods are inherited from the parent class, we'll see what we need to add
	 */

	@Override
	public String toString() {
		String str = "";
		for(V v : this.vertexSet()) {
			str += "vertex: " + v.toString() + "\n";
			for(V x: this.vertexSet()) {
				if (this.containsEdge(v, x))
				str += "\tedge to: " + x.toString() + "\n";
			}
		}
		return str;
	}	

}
