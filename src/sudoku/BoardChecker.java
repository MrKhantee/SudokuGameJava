package sudoku;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.fxml.Initializable;

public class BoardChecker implements BoardChecking, Initializable {

	private boolean[] checkStatus = new boolean[4];
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
	}
	
	@Override
	public boolean[] checkBoard(Square[][] board) {
		
		checkStatus[0] = checkRows(board);
		checkStatus[1] = checkColumns(board); 
		checkStatus[2] = checkSquares(board);
		checkStatus[3] = checkZeros(board);
		
		return checkStatus;
	}

	@Override
	public boolean checkColumns(Square[][] board) {	
		
		for(int i = 0; i < BoardController.BOARD_WIDE; i++){	
			
			Square[] rowHolder = board[i];
			Set<Integer> numHolder = new HashSet<Integer>();
	
			for(Square s: rowHolder){
				if( numHolder.add(s.getNum()) == false){
					return false;
				}
			}
		}
		
		return true;
	}
	
	@Override
	public boolean checkRows(Square[][] board){
		Square temp[][] = new Square[BoardController.BOARD_WIDE][BoardController.BOARD_TALL];
		
		//Rotate the board.
		//Swap elements.
		for(int i = 0; i < BoardController.BOARD_WIDE; i++){
			for(int j = 0; j < BoardController.BOARD_TALL; j ++){
				temp[i][j] = board[j][i];
			}
		}
		//The rows are now columns.
		return checkColumns(temp);
	}
	
	@Override
	public boolean checkSquares(Square[][] board) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean checkZeros(Square[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
