package workGraph;

import java.io.File;
import java.util.Set;

import org.jgrapht.EdgeFactory;
import org.jgrapht.Graph;
import org.jgrapht.graph.DirectedMultigraph;

import fragmentGraph.FragmentGraph;

/*
 * Multigraphs allow us to have multiple edges between two nodes
 */
public class WorkGraph<V,E> extends
		DirectedMultigraph<V,E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3274655854206417667L;
	/*
	 * To build the work graph we need to know the configuration,
	 * and in particular the EDA and LAP to use (and possibly other stuff)
	 * 
	 * We might want to initialize the configuration through the constructors
	 */
	CommonConfig config;
	EDAbasic<?> eda;
	LAP_TLAccess lap;
		
	/**
	 * 
	 * @param arg0 -- the class for the edges (in our case this would be FragmentGraphEdge.class)
	 */
	public WorkGraph(Class<? extends E> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param arg0 -- edge factory
	 */
	public WorkGraph(EdgeFactory<V,E> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/*
	 * a constructor for initializing a graph from a (xml) file
	 */
	/**
	 * 
	 * @param file -- a file (possibly xml) from which to load a previously produced graph
	 */
	public WorkGraph(File file){
		// to do
		loadGraphFromFile(file);
	}
	
	public WorkGraph(FragmentGraph<V,E> fg) {
		super();
		
	}
	
	public Set<V> getBaseStatements(){
		return baseStatements;
	}
	
	/*
	 * In the figure Gil drew in Trento, there is a separate box for "Graph Merge", 
	 * which could mean that "Graph Merge" will be a class. However, I think the merge part
	 * could be a method of the work graph
	 */
	/**
	 * merge a graph into the current object
	 * 
	 * @param g -- a graph to be merged with this object (could be FragmentGraph or WorkGraph) 
	 * 
	 */
	public void mergeGraph(FragmentGraph<V,E> g) {
		
		// merge base statements first
		mergePairs(g, 0);
		
		// If there is entailment between base statements, compare nodes from the next level
		
		if( ... entailment at level 0 found ...) {
			mergePairs(g, 1);
		}
		
		// add the other nodes of g to "this" graph, based on entailment decisions at levels 0 and 1
		
	}
	
	/**
	 * 
	 * @param g	-- graph to be merge with this object (could be FragmentGraph or WorkGraph)
	 * @param level -- level=0 would correspond to base statement (0 modifiers), level=1 BS + 1 modifier, ...
	 */
	private void mergePairs(FragmentGraph<V,E> g, int level) {
		Set<V[]> thPairs = makePairs(g, level);
		for (V[] pair: thPairs) {	
			JCas pairCas = lap.generateTHPair(pair[1],pair[2]);
			this.addEdge(pair[1], pair[2], eda.process(pairCas));
		}
	}

}
