/**
 * class:BoardCheckerTest.java
 * 
 * @author Ravindra Bhadti
 * 
 */

package sudoku;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This class carries out JUnit testing on 
 * the BoardChecker class of the Sudoku Application.
 * 
 * @version 1.0
 */
public class BoardCheckerTest {
	
	
	BoardChecker boardChecker = null;
	
	@Before
	public void setup(){
		//
		boardChecker = new BoardChecker();
	}
	
	@Test
	public void testCheckZeros_Positive(){
		
	}
	
	@Test
	public void testCheckZeros_Negative(){
		
	}
	
	@Test
	public void testCheckRows_Positive() {
		
	}
	
	@Test
	public void testCheckRows_Negative() {
		
	}
	
	@Test
	public void testCheckColumns_Positive(){
		
	}
	
	@Test
	public void testCheckColumns_Negative(){
		
	}
	
	@Test
	public void testCheckSquares_Positive(){
		
	}
	
	@Test
	public void testCheckSquares_Negative(){
		
	}
	
	
	/**
	 * This method cleans up the resources used
	 * during testing.
	 */
	@After
	public void tearDown(){
		boardChecker = null;
	}
	
}
