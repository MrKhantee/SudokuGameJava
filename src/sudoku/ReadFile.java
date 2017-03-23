package sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ReadFile {

	private StringBuilder filePath = null;
	private String tmp = null;
	private String [] lineHolder = null;
	
	private Square[][] sudokuBoard = new Square[BoardController.BOARD_TALL][BoardController.BOARD_WIDE];
	
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
				for(int i = 0; i < BoardController.BOARD_TALL; i++){
					
					tmp = txtReader.readLine();
					
					String[] result = tmp.split(" ");
					
					for(int j =0; j < result.length;j++){
						sudokuBoard[i][j] = new Square(20,20);
						sudokuBoard[i][j].setNum(Integer.parseInt(result[j]));
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
		catch (NumberFormatException nFE){
			System.err.println("Number Format Exception");
		}
	
	}
	
	public Square[][] getBoard(){
		return sudokuBoard;
	}
		
}
