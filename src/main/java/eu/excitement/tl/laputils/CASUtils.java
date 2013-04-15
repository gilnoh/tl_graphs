package eu.excitement.tl.laputils;

import org.apache.uima.jcas.JCas;

import eu.excitementproject.eop.lap.PlatformCASProber;

/**
 * The class holds various small utility static methods that might be 
 * useful in handling CASes: Like getting a new CAS, generate a new 
 * CAS by copying the provided CAS, etc. 
 * 
 * @author Gil 
 */

// TODO: set dummy AE for CAS 
// TODO: set typepath convention for UIMAFit based CAS generation. 
// TODO: Check UIMAFit CASUtil, and wrap some needed things.  

public final class CASUtils {
	/**
	 * <P>
	 * This method generates a new JCas and returns it. 
	 * The resulting CAS is empty, and holds nothing. No text, no language id, etc. The caller has to set them up. 
	 * <P>
	 * Note: Generally, making a new CAS is not really a good thing to do. It is a heavy and big object. If you can work on CAS sequentially, you should do that. This means that, using one CAS, if the work is done, reset the CAS (calling .reset()), and set a new document on the CAS, etc. (  
	 * @return JCas that can express/hold all CAS types that is known to EOP & TL Layer 
	 */
	static public JCas createNewInputCas()
	{
		JCas a = null; 
		// TODO: fill in actual code 
		return a; 
	}
	
	/**
	 *  This method dumps the content of CAS to Console (or log, if available) 
	 *  
	 */
	static public void dumpCAS(JCas aJCas)
	{
		PlatformCASProber.printAnnotations(aJCas.getCas(), System.err); 
		// TODO, dump to log, instead of console. 
	}
	
	/**
	 * 
	 */
	static public void dumpCAS2TextFile() 
	{
		
	}
	
	
}
