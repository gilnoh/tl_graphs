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
		// generate CAS from CASutils 
		// (testing createNewInputCas()) 
		JCas aJCas = CASUtils.createNewInputCas(); 
		assertNotNull(aJCas); 

		// set some text 
		aJCas.setDocumentLanguage("EN");
		aJCas.setDocumentText("This is a text sentence."); 
		
		// make sure we can use any LAP, like TreeTaggerEN 
		// (checking that the CAS can hold/access generic LAP annotation types) 
		LAPAccess l = null; 
		l = new TreeTaggerEN(); 
		l.addAnnotationOn(aJCas); 				
		//  Dump the result... (if you want)  
		CASUtils.dumpCAS(aJCas);  
		
		// check that we can add TL types, too... 
		
		}
		catch (Exception e)
		{
			fail(e.getMessage()); 
		}
	}

}
