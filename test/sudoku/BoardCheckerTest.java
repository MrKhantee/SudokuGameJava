package sudoku;

/*
 * Static imports
 */
import static org.junit.Assert.*;
import static sudoku.controller.BoardController.BOARD_TALL;
import static sudoku.controller.BoardController.BOARD_WIDE;
import static sudoku.controller.BoardController.SIZE_SQUARE;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

import javax.swing.SwingUtilities;

/*
 * Normal Imports
 */
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import javafx.embed.swing.JFXPanel;
import sudoku.ReadFile;
import sudoku.gui.Square;

public class BoardCheckerTest{

	
	private ReadFile rf = null;
	private Square[][] sudokuBoard = null;
	private BoardChecker boardChecker = null;
	
	/*
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//To carry out GUI Testing, 
		//load the stage as you normally would.
	}*/
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            new JFXPanel(); // initializes JavaFX environment
            latch.countDown();
        });
		
        
	}
	
	@Before
	public void setUp() throws Exception{
		boardChecker = new BoardChecker();
	}
	
	
	@Test
	public void testCheckZeros_Positive(){
	
        if(!readBoard("testZerosPositive")){
        	fail("Fail: The input board to testCheckZeros_Positive() could not "
        			+ "be read.");
        };
		
        //The correct location for the test-board to return an error.
        int [] incorrectLoc = {8,7};
        
		boardChecker.checkZeros(sudokuBoard);
		assertTrue(!boardChecker.getStatus("zeros") && Arrays.equals(incorrectLoc, boardChecker.getInvalidCoord()));
	}
	
	@Test
	public void testCheckZeros_Negative()
	{
		
		//Make sure we can read the board.
		if(!readBoard("testZerosNegative")){
        	fail("Test-failed, the input board to testCheckZeros_Positive() could not "
        			+ "be read.");
        }
		
		boardChecker.checkZeros(sudokuBoard);
		assertFalse(boardChecker.getStatus("zeros"));
	}

	
	@Test
	public void testCheckColumns_Positive()
	{
		if(!readBoard("testColumnsPositive"))
		{
			fail("Test-failed, the input board to testCheckZeros_Positive() could not "
        			+ "be read.");
		}
		
		int [] incorrectLoc = {3,2};
		
		boardChecker.checkColumns(sudokuBoard);
		assertTrue(!boardChecker.getStatus("columns") && Arrays.equals(incorrectLoc, boardChecker.getInvalidCoord()));
		
	}
	
	@After
	public void tearDown() throws Exception 
	{
		rf = null;
		sudokuBoard = null;
		boardChecker = null;
	}
	
	private boolean readBoard(String pathname)
	{
		
		//Setup Thread function.
		Thread thread1 = new Thread() 
        {
			public void run()
			{	
				boardChecker = new BoardChecker();
				rf = new ReadFile(pathname);
				sudokuBoard = rf.getBoard();
			}
		};
		
		//Run thread at low priority.
		thread1.run();
		thread1.setPriority(Thread.MIN_PRIORITY);
		
		//Signal that we no longer require this
		//thread.
		Thread.currentThread().interrupt();
		
		
		//Return status of read function.
		return !(sudokuBoard==null);
		
		
	}

}
