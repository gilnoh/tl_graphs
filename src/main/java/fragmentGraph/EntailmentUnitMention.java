package fragmentGraph;

public class EntailmentUnitMention {
	
	// a CAS attribute with all annotations of the text fragment to which this node corresponds

	protected int documentId;
	protected int categoryId;
	protected String text;
	protected int level;
	
	// to generate a CAS from a given text we need a lap
	// protected LAP_TLAccess lap;
	
	/**
	 * textFragment -- a text fragment from which we construct a node (with the corresponding annotations)
	 */
	public EntailmentUnitMention(String textFragment) {
		text = textFragment;
		level = 0;
	}
	
	/**
	 * 
	 * @param textFragment -- a text fragment from which we construct a node (with the corresponding annotations)
	 * @param level
	 */
	public EntailmentUnitMention(String textFragment, int level) {
		text = textFragment;
		this.level = level;
	}

	/**
	 * 
	 * @return -- the text of the current node object
	 */
	public String getText() {
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
