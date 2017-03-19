package sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BoardControllerTest {
	
	BoardChecker bc = null;
	
	Square board[][] = new Square[BoardController.BOARD_WIDE][BoardController.BOARD_TALL];
	
	@Before
	public void before()
	{
		//Read sudoku board from file.
	}
	
	@Test
	public void testBoardChecker_Positive() {
		
	}
	
	@Test
	public void testBoardChecker_Negative(){
		
	}
	
	@After
	public void after(){
		
	}

}
