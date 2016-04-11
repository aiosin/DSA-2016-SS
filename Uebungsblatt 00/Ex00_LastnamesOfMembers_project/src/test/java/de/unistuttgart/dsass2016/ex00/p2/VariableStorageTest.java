package de.unistuttgart.dsass2016.ex00.p2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import de.unistuttgart.dsass2016.ex00.p2.IVariableStorage;
import de.unistuttgart.dsass2016.ex00.p2.VariableStorage;


/**
 * You should use this class to test your class {@link VariableStorage}, using
 * JUnit assertions like {@link Assert#assertEquals(Object, Object)}. For
 * additional information on how to test your code with JUnit visit 
 * http://www.vogella.com/tutorials/JUnit/article.html
 */
public class VariableStorageTest {
	final IVariableStorage<Object> varStorage = new VariableStorage<>();
	
	
	/**
	 * Just create additional tests by creating new methods according to 
	 * this pattern.
	 * 
	 *  For an example see also {@link CalculatorTest#testAdd()}.
	 */
	@Test
	public void test() {
		/* Here you should do something with the tested class and compare
		 * obtained results with expected results. */
		final int resultObtainedFromClass = 1;
		final int expectedResults = 1;
		assertEquals(expectedResults, resultObtainedFromClass);
	}

	// Add your test methods here
	@Test
	//http://www.coderanch.com/t/515213/Testing/JUnit-tests-Getters-Setters
	//TODO: do this to finish task 2
	public void testSet(){
		
	}
	
	public void testGet(){
		//varStorage.set(var);
	}
	
	
}
