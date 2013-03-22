package workGraph;

import org.jgrapht.graph.DefaultEdge;


public class WorkGraphEdge<V> extends DefaultEdge {
	
	V source;
	V target;
	
	/*
	 * The TEdecision object contains the label, confidence score, ...
	 */
	TEdecision edge;
	
	/*
	 * we might decide to have on each edge information about the configuration 
	 * (EDA, lexical resource, ...) that was used to produce this edge 
	 */
	EDABasic<?> eda;
	
	/*
	 * EOP lap
	 */
//	LAPAccess lap;
	
	public WorkGraphEdge(V source, V target) {
		this.source = source;
		this.target = target;
		
		computeTEdecision();
	}
	
	protected computeTEdecision() {
//		JCas pairCAS = lap.generateSingleTHPairCAS(from.getText(), to.getText());
		JCas pairCAS = generateTHPairCAS();
		edge = eda.process(pairCAS);
	}
	
	/**
	 * 
	 * @return -- a JCas object representing the text and hypothesis pair, 
	 *            obtained by extracting the necessary annotations from "from" and "to"
	 */
	protected JCas generateTHPairCAS(){
		// extract annotations from "from" and "to" to form the JCas object that is used as input to the EDA
	}
	
	public TEdecision getTEdecision() {
		return edge;
	}
	
	/**
	 * 
	 * @return -- the confidence part of the TEdecision object
	 */
	public double getConfidence() {
		return edge.getConfidence();
	}
	
	/**
	 * 
	 * @return -- the decision label from the TEdecision object
	 */
	public DecisionLabel getLabel() {
		return edge.getDecision();
	}
}
