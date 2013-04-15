package eu.excitement.tl.laputils;

import static org.junit.Assert.*;

import org.apache.uima.jcas.JCas;
import org.junit.Test;

import eu.excitementproject.eop.lap.LAPAccess;
import eu.excitementproject.eop.lap.dkpro.TreeTaggerEN;

public class CASUtilsTest {

	@Test
	public void test() {

		try {
		// TODO generate CAS from CASutils 
		
		// TODO run TreeTagger.addAnnotationON() to test annotate 
		LAPAccess l = null; 
		l = new TreeTaggerEN(); 
		JCas a = l.generateSingleTHPairCAS("hello world", "goodbye world"); 
		assertNotNull(a); 
		
		// TODO Dump the result... 
		CASUtils.dumpCAS(a);  
		
		// TODO generate CAS by UIMAFit util. 
		}
		catch (Exception e)
		{
			fail(e.getMessage()); 
		}
	}

}
