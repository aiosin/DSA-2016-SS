package de.unistuttgart.dsass2016.ex00.p1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * You should use this class to test your class {@link Calculator}, using
 * JUnit assertions like {@link Assert#assertEquals(Object, Object)}. For
 * additional information on how to test your code with JUnit visit 
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
public class CalculatorTest {
	final ICalculator cal = new Calculator();

	/**
	 * Just create additional tests by creating new methods according to 
	 * this pattern. 
	 */
	@Test
	public void testAdd() {
		assertEquals(2+5, cal.add(2,5));
		assertEquals(3+4, cal.add(3,4));
	}
	
	// Add your test methods here
	@Test
	public void testSubtract(){
		assertEquals(4-3, cal.subtract(4, 3) );
	}
	
	@Test
	public void testMultiply(){
		assertEquals(123*123, cal.multiply(123, 123));
		
	}
	@Test
	public void testMax(){
		assertEquals(1337, cal.max(1223, 1337));
	}
	
}
