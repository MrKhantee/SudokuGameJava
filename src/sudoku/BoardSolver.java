package sudoku;

import sudoku.gui.SquareGUI;

@SuppressWarnings("unused")
public class BoardSolver extends BoardChecker {
	
	private SquareGUI[][] board = null;
	
	private boolean boardSolved = false;
	private boolean validBoard  = false;
	
	public BoardSolver(SquareGUI[][] inputBoard) throws NullPointerException
	{
		if(inputBoard!=null)
		{
			this.board = inputBoard;
			solveBoard();
		}
		else
		{
			throw new NullPointerException("Input board is null?");
		}	
	}
	
	private void solveBoard(){
		
		int i = 0;
		int j = 0;	
					//Loop Counters.
		
		//Firstly go through board and update possibilities.
		
		//Start with first editable SquareGUI input the first number.
			//do-while loop : result!=0.
			//Input the first number.
			//Check validity. 
			//If invalid iterate to the next number.
			//This is the back-tracking method.
			//Do this until result = 0. If so then go back to previous SquareGUI.
		
		
	}


}
