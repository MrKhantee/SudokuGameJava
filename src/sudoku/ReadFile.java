package sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ReadFile {

	Scanner scanner = null;
	
	private Square[][] sudokuBoard = new Square[BoardController.BOARD_TALL][BoardController.BOARD_WIDE];
	
	public ReadFile(String pathname) throws NoMoreContentException, FileNotFoundException{
		
		try {
			String filePath = new File("").getAbsolutePath();
			filePath = filePath.concat("/src/sudoku/boards/");
			scanner = new Scanner(new FileReader(filePath.concat(pathname + ".txt")));
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("Look, an Information Dialog");
			alert.setContentText(filePath.concat(pathname + ".txt"));
			alert.showAndWait();
			
			for(int i = 0; i < BoardController.BOARD_WIDE; i++){
				for(int j = 0; j < BoardController.BOARD_TALL; j++){
					if(!scanner.hasNextInt()){
						throw new NoMoreContentException();
					}
					sudokuBoard[i][j] = new Square(20,20);
					sudokuBoard[i][j].setNum(scanner.nextInt());
					
					//If number is not zero then set fixed status to true.
					if(sudokuBoard[i][j].getNum()!=0){
						sudokuBoard[i][j].setFixedStatus(true);
					}
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
