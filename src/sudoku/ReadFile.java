/**	
 * class: ReadFile.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 * 
 */

package sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sudoku.exceptions.NoMoreContentException;
import sudoku.gui.Square;

import static sudoku.controller.BoardController.BOARD_WIDE;
import static sudoku.controller.BoardController.BOARD_TALL;


/**
 * A class that can be used to read external text files
 * using the InputStream and BufferedReader classes.
 * 
 * @version 1.0
 * 
 */
public class ReadFile {
	
	/** Initial String-like instance variables for later use. */
	private StringBuilder filePath = null;
	private String tmp = null;
	private String [] lineHolder = null;
	
	/** The empty Sudoku board - A 2D array of Square */
	private Square[][] sudokuBoard = new Square[BOARD_TALL][BOARD_WIDE];
	
	/**
	 * The constructor for the read file function.
	 * @param pathname - The name of the board to be read (without ".txt" suffix).
	 * 
	 */
	public ReadFile(String pathname){
		try 
		{
			if(pathname==null || pathname.length()==0){
				System.out.println("Please enter valid file name");
			}
			else{
				this.readIntoObject(pathname);
			}
		} 
		catch (IOException ioe) 
		{
			System.err.println(ioe.getMessage());
		} 
		catch (NoMoreContentException nmce) 
		{
			System.err.println(nmce.getMessage());
		}
		
	}
	
	/**
	 * 
	 * @param pathname - The name of the board to be read (without ".txt" suffix).
	 * @throws NoMoreContentException
	 * @throws IOException
	 */
	public final void readIntoObject(String pathname) throws NoMoreContentException,IOException{
		
		/* Declare a StringBuilder object with the initial path. Then
		 * add on the filename and .txt suffix to form the full relative
		 * path.
		 * */ 
		filePath = new StringBuilder("boards/");
		filePath.append(pathname);
		filePath.append(".txt");
		
		/* Create InputStream and BufferedReader for text file. 
		 * A FileNotFoundException can be thrown here.
		 * */
		InputStreamReader inputStream = new InputStreamReader(getClass().getResourceAsStream(filePath.toString()));
		BufferedReader txtReader = new BufferedReader(inputStream);
			
		/*
		 * This Try-Catch block uses the txtReader to read lines from the 
		 * chosen text-file.
		 */
		try 
		{	

			/* Check if the BufferedReader object is ready to be read.*/
			if(txtReader.ready())
			{	
				
				/* Loop through the lines of the text file. */
				for(int i = 0; i < BOARD_TALL; i++){
					
					/* Read a line of the text file. */
					tmp = txtReader.readLine();
					
					/* If the numbers have spaces between them then 
					 * split them by the space. Store the result in 
					 * a String array.
					 */
					if(tmp.length() > 9){
						lineHolder = tmp.split(" ");
					}
					/* Else split them by nothing. Store the
					 * result in a String array.
					 */
					else{
						lineHolder = tmp.split("");
					}
					
					/* Loop through each number in lineHolder 
					 * 1. Create a new Square object for an index of the board.
					 * 2. Parse the number in the String array to an Integer. 
					 * 3. Store this in the value field of the Square object.
					 * 4. If this number wasn't 0 then it is a fixed non-editable
					 * 	  field of the board. i.e. the user cannot edit this.
					 * */
						for(int j =0; j < lineHolder.length;j++){
							sudokuBoard[i][j] = new Square(20,20);
							sudokuBoard[i][j].setNum(Integer.parseInt(lineHolder[j]));
							if(sudokuBoard[i][j].getNum()!=0){
								sudokuBoard[i][j].setFixedStatus(true);
							}	
						}
				}
			}
		} 
		
		/* IOException occurs if text file cannot be read.*/
		catch (IOException e) 
		{
			System.err.println("Cannot read text file.");
		}
		
		/* NumberFormatException occurs if Integer tries to parse non-String 
		 * variable.
		 */
		catch (NumberFormatException nFE)
		{
			System.err.println("Number Format Exception");
		}
		catch (IllegalStateException ise){
			ise.printStackTrace();
		}
	}
	
	
	/**
	 * This getter method returns the sudoku-board that was populated
	 * in the constructor method.
	 * 
	 * @return Square[][] - The populated sudoku board.
	 */
	public Square[][] getBoard(){
		return this.sudokuBoard;
	}
}
