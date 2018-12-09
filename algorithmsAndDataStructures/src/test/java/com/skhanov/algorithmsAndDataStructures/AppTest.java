package com.skhanov.algorithmsAndDataStructures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

public class AppTest {
	
	@Test
	public void checkBracketsUtil() {
		assertTrue(Utils.checkBrackets("[(2 + 2){()}]"));
		assertFalse(Utils.checkBrackets("[(2 + 2){]"));
	}
	
	@Test
	public void stringReversUtil() {		
		assertEquals(null, "gfedcba", Utils.stringReverse("abcdefg"));
	}
	
	@Test
	public void factorialUtil() {
		assertTrue(3628800 == Utils.factorialRecursion(10));
	}
	
	@Test
	public void pow() {
		assertTrue(1024 == Utils.powRecurson(2, 10));
		assertTrue(2048 == Utils.powCicle(2, 11));
	}
	

}







