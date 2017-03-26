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
import sudoku.gui.SquareGUI;

import static sudoku.controller.BoardController.BOARD_WIDE;
import static sudoku.controller.BoardController.BOARD_TALL;
import static sudoku.controller.BoardController.SIZE_SQUARE;


/**
 * This class implements the Board Checker object. Once instanciated it 
 * allows a user to pass in a Sudoku board and carry out row, column, 
 * sub-SquareGUI and zero check operations.
 *	
 * @version 1.0
 */
public class BoardChecker{
	
	private boolean rowStatus;
	private boolean columnStatus;
	private boolean SquareStatus;
	private boolean zeroStatus;
	
	/**
	 * The default no-arg constructor method. 
	 */
	public BoardChecker(){
		//No body here.
	}
	
	
	/**
	 * This method calls the checkZeros, checkRows, checkColumns and 
	 * checkSquareGUIs method in order to check if the full board is valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean[] - An array of booleans which show
	 */
	public boolean checkBoard(SquareGUI[][] board) {
		return checkZeros(board) && checkRows(board) && checkColumns(board) && checkSquareGUIs(board);
	}
	
	/**
	 * This method checks if the columns of the Sudoku board
	 * are valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean - The status for if all columns are valid. 
	 */
	private boolean checkColumns(SquareGUI[][] board) {	
		
		for(int i = 0; i < BOARD_WIDE; i++){	
			
			SquareGUI[] rowHolder = board[i];
			Set<Integer> numHolder = new HashSet<Integer>();
	
			for(SquareGUI s: rowHolder){
				if( numHolder.add(s.getNum()) == false){
					this.columnStatus = false;
					return this.columnStatus;
				}
			}
		}
		
		return this.columnStatus;
	}
	
	/**
	 * This method checks if the rows of the Sudoku board
	 * are valid.
	 * 
	 * @param board - The input sudoku board.
	 * @return boolean - The status for if all rows are valid.
	 */
	private boolean checkRows(SquareGUI[][] board){
		SquareGUI temp[][] = new SquareGUI[BOARD_WIDE][BOARD_TALL];
		
		//Rotate the board.
		//Swap elements.
		for(int i = 0; i < BOARD_WIDE; i++){
			for(int j = 0; j < BOARD_TALL; j ++){
				temp[i][j] = board[j][i];
			}
		}
		//The rows are now columns.
		this.rowStatus = checkColumns(temp);
		
		return this.rowStatus;
	}	
	
	
	/**
 	 * This method checks if the sub-SquareGUIs of the 
 	 * Sudoku board are valid.
	 * 
	 * @param board - The input Sudoku board.
	 * @return boolean - The status for if all sub-SquareGUIs are valid.
	 * 
	 */
	private boolean checkSquareGUIs(SquareGUI[][] board) 
	{
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
			 * Obtain a subSquareGUI using this loop.
			 */
			for(j = k; j < k+SIZE_SQUARE; j++)
			{
				if(numHolder.add(board[i][j].getNum()) == false){
					System.out.println("Returned false in SquareGUI check.");
					this.SquareStatus = false;
					return this.SquareStatus;
				}
			}
			
			//Check if you are at column 2.
			if( (i+1)%SIZE_SQUARE == 0 && (j%SIZE_SQUARE==0) )
			{				
				//Clear the set.
				numHolder.clear();
				
				if(j==BOARD_WIDE)
				{
					//You're at the end of the line.
					i = i+1;//Move to next row.
					k = 0;
				}
				
				else{
					i = i - 2;	//Change back to column 0
								//in SquareGUI.
					k = k + SIZE_SQUARE;
				}
			}
			
			else
			{
				i++;	//Increment to column 1 or 2. 
			}	
		}
		
		this.SquareStatus = true;
		
		return this.SquareStatus;
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
	private boolean checkZeros(SquareGUI[][] board) {
		
		//Check if there are any zeros on the board.
		for(int i = 0; i < BOARD_TALL; i++){
			for(int j = 0; j < BOARD_WIDE; j++){
				if(board[i][j].getNum()==0){
					this.zeroStatus = false;
					return this.zeroStatus;
				}
			}
		}
		
		return this.zeroStatus;
	}

	public boolean getStatus(String statusType){
		
		boolean result = false;
		
		if("rows".equalsIgnoreCase(statusType)){
			result = this.rowStatus;
		}
		else if ("columns".equalsIgnoreCase(statusType)){
			result = this.columnStatus;
		}
		else if ("SquareGUIs".equalsIgnoreCase(statusType)){
			result = this.SquareGUIStatus;
		}
		else if ("zeros".equalsIgnoreCase(statusType)){
			result = this.zeroStatus;
		}
		
		return result;
		
	}
	
}
