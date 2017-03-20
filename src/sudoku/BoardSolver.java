package sudoku;

public class BoardSolver extends BoardChecker {
	
	Square[][] board = null;
	
	public BoardSolver(Square[][] inputBoard) throws NullPointerException
	{
		
		if(inputBoard!=null)
		{
			this.board = inputBoard;
		}
		else
		{
			throw new NullPointerException("Input board is nullified?");
		}
		
		
		
	}
	
	private void solveBoard(){
		
	}


}
