package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import sudoku.exceptions.NoMoreContentException;
import sudoku.gui.Square;

import static sudoku.controller.BoardController.BOARD_WIDE;
import static sudoku.controller.BoardController.BOARD_TALL;

public class ReadFile {

	private StringBuilder filePath = null;
	private String tmp = null;
	private String [] lineHolder = null;
	
	private Square[][] sudokuBoard = new Square[BOARD_TALL][BOARD_WIDE];
	
	public ReadFile(String pathname) throws NoMoreContentException, FileNotFoundException{
		
		filePath = new StringBuilder("boards/");
		filePath.append(pathname);
		filePath.append(".txt");
		
		InputStreamReader inputStream = new InputStreamReader(getClass().getResourceAsStream(filePath.toString()));
		BufferedReader txtReader = new BufferedReader(inputStream);
		
		try 
		{
			if(txtReader.ready())
			{
				for(int i = 0; i < BOARD_TALL; i++){
					
					tmp = txtReader.readLine();
					
					if(tmp.length() > 9){
						lineHolder = tmp.split(" ");
					}
					else{
						lineHolder = tmp.split("");
					}
					
					
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
		
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			System.err.println("Cannot read text file.");
		}
		
		catch (NumberFormatException nFE)
		{
			System.err.println("Number Format Exception");
		}
		
	}
	
	public Square[][] getBoard(){
		return sudokuBoard;
	}
		
}
