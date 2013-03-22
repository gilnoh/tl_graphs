package fragmentGraph;

public class FragmentGraphNode {
	
	// a CAS attribute with all annotations of the text fragment to which this node corresponds
//	protected JCas fragmentCAS;
	protected String text;
	protected int level;
	
	// to generate a CAS from a given text we need a lap
	// protected LAP_TLAccess lap;
	
	/**
	 * textFragment -- a text fragment from which we construct a node (with the corresponding annotations)
	 */
	public FragmentGraphNode(String textFragment) {
		// fragmentCAS = lap.generateSingleCAS(textFragment);
		text = textFragment;
		level = 0;
	}
	
	/**
	 * 
	 * @param textFragment -- a text fragment from which we construct a node (with the corresponding annotations)
	 * @param level
	 */
	public FragmentGraphNode(String textFragment, int level) {
		// fragmentCAS = ...
		text = textFragment;
		this.level = level;
	}
	/**
	 * textCAS -- a full annotation of a larger text,
	 * start -- starting index for the current fragment
	 * end -- end index for the current fragment
	 */
/*	public FragmentGraphNode(JCas textCAS, int start, int end) {
		
	}
*/		
	/**
	 * 
	 * @return -- the text of the current node object
	 */
	public String getText() {
		// return fragmentCAS.getDocumentText();
		return text;
	}
	
	/**
	 * 
	 * @return -- the level of the node (i.e. -- how many modifiers it has) -- it might be useful for merging
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * methods to obtain various annotation layers of the object 
	 */
	
	public String toString() {
		return getText();
	}
}
