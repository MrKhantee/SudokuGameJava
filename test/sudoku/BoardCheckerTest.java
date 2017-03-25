/**
 * class:BoardCheckerTest.java
 * 
 * @author Ravindra Bhadti
 * 
 */

package sudoku;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sudoku.controller.BoardController;
import sudoku.exceptions.NoMoreContentException;
import sudoku.gui.*;

/**
 * 
 * This class carries out JUnit testing on 
 * the BoardChecker class of the Sudoku Application.
 * 
 * @version 1.0
 */

public class BoardCheckerTest {
	
	
	private BoardChecker boardChecker = null;
	private ReadFile rf = null;
	private Square[][] board = null;
	
	@Before
	public void setup(){
		boardChecker = new BoardChecker();
	}
	
	@Test
	public void testCheckZeros_Positive()
	{
		
		try{
			rf = new ReadFile("solved1");
			board = rf.getBoard();
		}
		catch(IOException ioe)
		{
			System.err.println("File cannot be read successfully.");
		}
		catch(NoMoreContentException nmce)
		{
			System.err.println("Incorrectly Formatted Sudoku Board");
		}
		
		//boardChecker.checkBoard(board);
		//assertFalse(boardChecker.getStatus("zeros"));
		
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
