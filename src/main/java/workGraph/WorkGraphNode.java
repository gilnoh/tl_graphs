package workGraph;

import java.util.HashSet;
import java.util.Set;

import fragmentGraph.FragmentGraphNode;

/*
 * I implemented this structure according to my proposal that 
 * the nodes of the WorkGraph are in fact equivalence classes.
 * I think this would make the implementation more flexible 
 * (as I said in our discussions, you could initialize the work graph 
 * from either a Fragment-style graph (with singleton nodes), or from
 * a collapsed graph). If you want the nodes to be singletons, from 
 * an implementation point of view nothing would change, the equivalence class 
 * can contain only one node.
 * 
 * If we extend the FragmentGraphNode, the JCas attribute could be the "canonical"
 * JCas object for this node -- that means, when merging edges that connect WorkGraphNode-s,
 * we do not iterate over each of the nodes in the equivalence class, but just use the "canonical"
 * one. 
 * 
 */
public class WorkGraphNode{

	Set<FragmentGraphNode> node = null;
	
	/**
	 * initialize the JCas attribute -- make the first fragment added to the 
	 * WorkGraphNode object the "canonical" element
	 * 
	 * @param textCAS -- JCas object of the type defined for the TL
	 * @param start	-- start index of the fragment
	 * @param end -- end index of the fragment
	 */
	WorkGraphNode(JCas textCAS, int start, int end) {
		FragmentGraphNode n = new FragmentGraphNode(textCAS, start, end);
		
		node = new HashSet<FragmentGraphNode>();
		node.add(n);
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Same as before -- this will be the "canonical" element
	 * 
	 * @param textFragment -- generate node directly from the text fragment
	 */
	WorkGraphNode(String textFragment) {
		FragmentGraphNode n = new FragmentGraphNode(textFragment);
		
		node = new HashSet<FragmentGraphNode>();
		node.add(n);		
	}
		
	/**
	 * Add a new node to the equivalence class
	 * 
	 * @param n -- the node to be added
	 */
	public void addNode(FragmentGraphNode n) {
		node.add(n);
	}
	
	/**
	 * Returns the texts of all objects in this equivalence class
	 * 
	 * @return
	 */
	public Set<String> getText() {
		Set<String> texts = new HashSet<String>();
		
		for(FragmentGraphNode n : node) {
			texts.add(n.getText());
		}
		
		return texts;
	}
	
}
