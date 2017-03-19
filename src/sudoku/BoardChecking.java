package sudoku;

public interface BoardChecking {
	
	boolean isValidRows = false;
	boolean isValidColumns = false;
	boolean isValidSquares = false;
	boolean isValid = false;
	
	//Methods to check the board.
	boolean[] checkBoard(Square board[][]);
	boolean checkColumns(Square board[][]);
	boolean checkSquares(Square board[][]);
	boolean checkRows(Square board[][]);
	boolean checkZeros(Square board[][]);
}
