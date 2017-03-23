/**
 * 
 * class: BoardChecker.java
 * 
 * @author Ravindra Bhadti
 *
 * @since 23-03-2017
 * 
 * */
package sudoku;

import java.util.HashSet;
import java.util.Set;
import sudoku.gui.Square;

import static sudoku.controller.BoardController.BOARD_WIDE;
import static sudoku.controller.BoardController.BOARD_TALL;
import static sudoku.controller.BoardController.SIZE_SQUARE;


/**
 * This class implements the Board Checker object. Once instanciated it 
 * allows a user to pass in a Sudoku board and carry out row, column, 
 * sub-square and zero check operations.
 *	
 * @version 1.0
 */
public class BoardChecker{

	/**
	 * The default no-arg constructor method. 
	 * @param
	 * @return
	 */
	public BoardChecker(){
		//No body here.
	}
	
	
	/**
	 * This method calls the checkZeros, checkRows, checkColumns and 
	 * checkSquares method in order to check if the full board is valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean[] - An array of booleans which show
	 */
	public boolean checkBoard(Square[][] board) {
		return checkZeros(board) && checkRows(board) && checkColumns(board) && checkSquares(board);
	}
	
	/**
	 * This method checks if the columns of the Sudoku board
	 * are valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean - The status for if all columns are valid. 
	 */
	private boolean checkColumns(Square[][] board) {	
		
		for(int i = 0; i < BOARD_WIDE; i++){	
			
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
	
	/**
	 * This method checks if the rows of the Sudoku board
	 * are valid.
	 * 
	 * @param board - The input sudoku board.
	 * @return boolean - The status for if all rows are valid.
	 */
	private boolean checkRows(Square[][] board){
		Square temp[][] = new Square[BOARD_WIDE][BOARD_TALL];
		
		//Rotate the board.
		//Swap elements.
		for(int i = 0; i < BOARD_WIDE; i++){
			for(int j = 0; j < BOARD_TALL; j ++){
				temp[i][j] = board[j][i];
			}
		}
		//The rows are now columns.
		return checkColumns(temp);
	}
	
	
	/**
 	 * This method checks if the sub-squares of the 
 	 * Sudoku board are valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean - The status for if all sub-squares are valid.
	 * 
	 */
	private boolean checkSquares(Square[][] board) {

		int i = 0; 
		int j = 0;
		int k = 0;
		
		boolean result = true;
		
		Set<Integer> numHolder = new HashSet<Integer>();
		
		/**
		 * A while-loop which obtains a 3x3 sub-grid from
		 * the board and checks its validity. As soon as the
		 * first flaw is detected, the method returns false.
		 * 
		 */
		while(i < BOARD_TALL && result == true){
			
			/**
			 * Obtain a subsquare using this loop.
			 */
			for(j = k; j < k+SIZE_SQUARE; j++){
				if(numHolder.add(board[i][j].getNum()) == false){
					System.out.println("Returned false in square check.");
					return false;
				}
			}
			
			//Check if you are at column 2.
			if( (i+1)%SIZE_SQUARE == 0 && (j%SIZE_SQUARE==0) ){
				
				//Clear the set.
				numHolder.clear();
				
				if(j==BOARD_WIDE){
					//You're at the end of the line.
					i = i+1;//Move to next row.
					k = 0;
				}
				
				else{
					i = i - 2;	//Change back to column 0
								//in square.
					k = k+SIZE_SQUARE;	//Need to go to next major column.
				}
				
			}
			
			else{
				i++;	//Increment to column 1 or 2. 
			}	
		}
		
		return true;
	}
	
	/**
	 * 
	 * This method checks if any zeros are still in
	 * any of the board fields. If so then the board 
	 * isn't technically complete.
	 * 
	 * @param board - The input Sudoku board.
	 * @return The status for if any zeros are in the board.
	 * 
	 */
	private boolean checkZeros(Square[][] board) {
		
		//Check if there are any zeros on the board.
		for(int i = 0; i < BOARD_TALL; i++){
			for(int j = 0; j < BOARD_WIDE; j++){
				if(board[i][j].getNum()==0){
					return false;
				}
			}
		}
		
		return true;
	}

}
