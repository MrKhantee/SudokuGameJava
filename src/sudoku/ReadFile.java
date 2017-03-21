package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {

	Scanner scanner = null;
	
	private Square[][] sudokuBoard = new Square[BoardController.BOARD_TALL][BoardController.BOARD_WIDE];
	
	public ReadFile(String pathname) throws NoMoreContentException, FileNotFoundException{
		
		try {
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat("/src/sudoku/boards/");
			scanner = new Scanner(new FileReader(filePath.concat(pathname + ".txt")));
			
			for(int i = 0; i < BoardController.BOARD_WIDE; i++){
				for(int j = 0; j < BoardController.BOARD_TALL; j++){
					if(!scanner.hasNextInt()){
						System.exit(0);
						throw new NoMoreContentException();
					}
					sudokuBoard[i][j] = new Square(20,20);
					sudokuBoard[i][j].setNum(scanner.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Cannot find file, please verify directory");
		}
	}
	
	public Square[][] getBoard(){
		return sudokuBoard;
	}
		
}
