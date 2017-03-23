package sudoku.controller;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import sudoku.BoardChecker;
import sudoku.ReadFile;
import sudoku.exceptions.NoMoreContentException;
import sudoku.gui.*;
public class BoardController implements Initializable {
	
	//Injectable Fields for FXML Document
	@FXML AnchorPane mainPane;
	
	//Developer added panes.
	GridPane	gridPane = new GridPane();
	SidePane   	sidePane = null;
	BottomPane 	bottomPane = null;		
	
	//Buttons for user interaction.
	BoardButton submitButton = null;
	BoardButton resetButton  = null;
	BoardButton checkButton  = null;
	BoardButton solveButton  = null;
	
	//PANE SIZE
	final double PANE_WIDTH  = 1024;
	final double PANE_HEIGHT = 768;
	
	public final static int BOARD_WIDE   = 9;
	public final static int BOARD_TALL   = 9;
	public final static int SIZE_SQUARE  = 3;
	private final double BOARD_HEIGHT = (double)(5D/7D)*PANE_HEIGHT;
	private final double BOARD_WIDTH  = (double)(5D/7D)*PANE_WIDTH;
	
	private Square sudokuBoard[][] = null;
	
	ReadFile rf = null;
	
	//Is the board valid?
	boolean isBoardValid = false;	
	
	//private String filename = "board1.txt";
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		try 
		{
			rf = new ReadFile(FrontPageController.filename);
			this.sudokuBoard = rf.getBoard();
			rf = null; 	//Reset file pointer.
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoMoreContentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialiseGridPane(BOARD_WIDTH, BOARD_HEIGHT);
		addPanes();
		initialiseBoard();
		addButtons();			
	}
	
	private void initialiseGridPane(double width, double height)
	{	
		this.gridPane.setPrefSize(width, height);
		this.gridPane.setMinSize(width, height);
		
		for(int i = 0; i < BOARD_WIDE; i++){
			gridPane.getColumnConstraints().add(new ColumnConstraints((double)(BOARD_WIDTH/9)));	
		}
		
		for(int j = 0; j < BOARD_TALL; j++){
			gridPane.getRowConstraints().add(new RowConstraints((double)(BOARD_HEIGHT/9)));
		}
		
		this.gridPane.setLayoutX(5);
		this.gridPane.setLayoutY(5);
		
		mainPane.getChildren().add(gridPane);
	}
	
	private void initialiseBoard(){
		for(int i = 0; i <BOARD_WIDE ; i++){
			for(int j = 0; j < BOARD_TALL; j++){
				this.gridPane.add(sudokuBoard[i][j], j, i);
			}
		}
	}
	
	private void addPanes(){
		//Add side-pane onto board.
		sidePane = new SidePane(PANE_WIDTH-BOARD_WIDTH-10, PANE_HEIGHT-4, BOARD_WIDTH+18, 4);
		mainPane.getChildren().add(sidePane);
		
		//Add bottom-pane onto board
		bottomPane = new BottomPane(BOARD_WIDTH+3, PANE_HEIGHT-BOARD_HEIGHT-10,0+6,BOARD_HEIGHT+10);
		mainPane.getChildren().add(bottomPane);
	}
	
	
	private void addButtons(){
		//Add the submit button to the board.
		submitButton = new BoardButton(100, 20, 620, 165, "Submit");
		resetButton  = new BoardButton(100, 20, 500, 165, "Reset");
		checkButton  = new BoardButton(100, 20, 380, 165, "Check");
		solveButton  = new BoardButton(100, 20, 260, 165, "Solve");
		
		bottomPane.getChildren().addAll(resetButton, submitButton, checkButton, solveButton);
		
		//Add Event Handlers for buttons.
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		        if(!isBoardValid){
		        	System.out.println("Please check that your board is valid and complete!");
		        }
		    }
		});
		
		//Reset button event handler.
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	Alert alert = new Alert(AlertType.CONFIRMATION);
		    	alert.setTitle("Confirm Reset Event");
		    	String s = "Do you really want to reset the board?";
		    	
		    	bottomPane.setText("The Reset Button has been pressed");
		    	
		    	alert.setContentText(s);
		    	Optional<ButtonType> result = alert.showAndWait();
		    	if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
		    		try {
		    			rf = new ReadFile(FrontPageController.filename);
						sudokuBoard = rf.getBoard();
						initialiseBoard();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						System.err.println("File Not Found");
					} catch (NoMoreContentException e1) {
						System.err.println("There inputted board is not 9x9.");
					}
		    		
		    	}
		    }
		});
		
		//Check Button
		checkButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	BoardChecker bc = new BoardChecker();
		    	
		    	boolean[] res = bc.checkBoard(sudokuBoard);
		    	
		    	isBoardValid = res[0] & res[1] & res[2];
		    	
		    	if(isBoardValid)
		    	{
		    		bottomPane.setText("");
		    		bottomPane.setText("Check Complete: Board Is Valid \n	Submit your solution!");
		    	}
		    	else
		    	{
		    		bottomPane.setText("");
		    		bottomPane.setText("Check Complete: Board is Invalid");
		    	}
		    }
		});
		
		//Solve button action listener.
		solveButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				bottomPane.setText("Attempting to Solve Board!!");
				
				//BoardSolver bs = new BoardSolver(sudokuBoard);
				 
		    }
		});
		
	}
}
