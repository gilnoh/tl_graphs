package finalGraph;

import java.util.Set;

import workGraph.WorkGraphNode;

/**
 * Since I've made the node of the work graph an equivalence class already
 * I am not sure how, or if, the node of the final graph will be at all different.
 * It might, depending on what the industrial partners want. We could drop the 
 * annotations, for example, and let our nodes contain only a set of (string)
 * text fragments
 */
public class FinalGraphNode {
	
	// let's assume that the final node contains only the texts of the nodes
	Set<String> textFragments;
	
	/**
	 * Constructor for the FinalGraphNode -- here I assumed we build
	 * a node from a WorkGraphNode that contains only the strings in the
	 * corresponding equivalence class 
	 * 
	 * @param v -- a WorkGraphNode
	 */
	public FinalGraphNode(WorkGraphNode v) {
		textFragments = v.getText();
	}	
	
}
