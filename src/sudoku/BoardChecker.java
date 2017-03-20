package sudoku;

import java.util.HashSet;
import java.util.Set;

public class BoardChecker{

	public boolean[] checkBoard(Square[][] board) {
		return new boolean[]{checkZeros(board), checkRows(board), checkColumns(board), checkSquares(board)};
		/*checkStatus[0] = checkZeros(board);
		checkStatus[1] = checkRows(board);
		checkStatus[2] = checkColumns(board); 
		checkStatus[3] = checkSquares(board);
		*/
		
		//return checkStatus;
	}
	
	private boolean checkColumns(Square[][] board) {	
		
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
	
	private boolean checkRows(Square[][] board){
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
	
	
	private boolean checkSquares(Square[][] board) {

		int i = 0; 
		int j = 0;
		int k = 0;
		
		boolean result = true;
		
		Set<Integer> numHolder = new HashSet<Integer>();
		
		while(i < BoardController.BOARD_TALL && result == true){
			
			//Fill in a 3x3 subgrid.
			for(j = k; j < k+BoardController.SIZE_SQUARE; j++){
				if(numHolder.add(board[i][j].getNum()) == false){
					System.out.println("Returned false in square check.");
					return false;
				}
			}
			
			//Check if you are at column 2.
			if( (i+1)%BoardController.SIZE_SQUARE == 0 && (j%BoardController.SIZE_SQUARE==0) ){
				
				//Clear the set.
				numHolder.clear();
				
				if(j==BoardController.BOARD_WIDE){
					//You're at the end of the line.
					i = i+1;//Move to next row.
					k = 0;
				}
				
				else{
					i = i - 2;	//Change back to column 0
								//in square.
					k = k+BoardController.SIZE_SQUARE;	//Need to go to next major column.
				}
				
			}
			
			else{
				i++;	//Increment to column 1 or 2. 
			}	
		}
		
		return true;
	}

	private boolean checkZeros(Square[][] board) {
		
		//Check if there are any zeros on the board.
		for(int i = 0; i < BoardController.BOARD_TALL; i++){
			for(int j = 0; j < BoardController.BOARD_WIDE; j++){
				if(board[i][j].getNum()==0){
					return false;
				}
			}
		}
		
		return true;
	}

}
