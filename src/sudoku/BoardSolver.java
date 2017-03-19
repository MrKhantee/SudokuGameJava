package sudoku;

public class BoardSolver implements BoardChecking {
	
	public boolean[] res = new boolean[3];
	
	@Override
	public boolean[] checkBoard(Square[][] board) {
		// TODO Auto-generated method stub
		return res;
	}

	@Override
	public boolean checkRows(Square board[][]) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean checkColumns(Square board[][]){
		return true;
	}

	@Override
	public boolean checkSquares(Square board[][]) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkZeros(Square[][] board) {
		// TODO Auto-generated method stub
		return false;
	}



}
