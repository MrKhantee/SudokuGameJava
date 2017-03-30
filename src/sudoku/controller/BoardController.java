/**
 * 
 * class: BoardController.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 * 
 */
package sudoku.controller;

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
import sudoku.gui.*;

/**
 * This class acts as a controller class for the 
 * file 'MainBoard.fxml'. It dictates the actions for 
 * each user interaction on the GUI as well as the placement
 * of GUI components.
 * 
 * It adds 1 GridPane, a lower Anchor Pane and side Anchor Pane.
 * 
 * 
 * @version 1.0
 *
 */
public class BoardController implements Initializable {
	
	/* Injectable Fields for FXML Document */
	@FXML AnchorPane mainPane;
	
	/* Panes for the content. These will be placed on the stage. */
	GridPane	gridPane = new GridPane();
	SidePane   	sidePane = null;
	BottomPane 	bottomPane = null;		
	
	/* Buttons to be placed on the GUI (Stage) */
	BoardButton submitButton = null;
	BoardButton resetButton  = null;
	BoardButton checkButton  = null;
	BoardButton solveButton  = null;
	
	/* The size of the application window (fixed)*/
	final double PANE_WIDTH  = 1024;
	final double PANE_HEIGHT = 768;
	
	/*The width and height of the board.*/
	public final static int BOARD_WIDE   = 9;
	public final static int BOARD_TALL   = 9;
	
	/* The length/width of a sub-square */
	public final static int SIZE_SQUARE  = 3;
	
	/* The dimensions of the Sudoku Grid on the GUI. Set to be 5/7 
	 * of the total size.
	 */
	private final double BOARD_HEIGHT = (double)(5D/7D)*PANE_HEIGHT;
	private final double BOARD_WIDTH  = (double)(5D/7D)*PANE_WIDTH;
	
	/* The sudoku board. This will hold the puzzle.*/
	private Square sudokuBoard[][] = null;
	
	/* The ReadFile object initialised to null */
	ReadFile rf = null;
	
	/*Holds status of whether board is valid or not.*/
	boolean isBoardValid = false;	
	
	/**
	 * This method is run when the FXML template is loaded. It
	 * reads the text file into the GUI and lays out all the buttons,
	 * panes and other GUI components. 
	 * 
	 * @param location  - NOT USED.
	 * @param resources - NOT USED.
	 * 	
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{	
		rf = new ReadFile(FrontPageController.filename);
		this.sudokuBoard = rf.getBoard();
		rf = null; 	//Reset file pointer.
		
		/* Initialise the GridPane which will hold the Sudoku Board */
		initialiseGridPane(BOARD_WIDTH, BOARD_HEIGHT);
		/* Add panes onto the stage */
		addPanes();
		/* Add contents of the 2D Array sudokuBoard[][] onto the pane. */
		initialiseBoard();
		/* Add buttons onto the board. */
		addButtons();
				
	}
	
	/**
	 * This method sets up the 9x9 grid on the GUI.
	 * 
	 * @param width  - The width of the Sudoku Board on the main GUI.
	 * @param height - The height of the Sudoku Board on the main GUI.
	 */
	private void initialiseGridPane(double width, double height)
	{	
		/* Set size of grid. */
		this.gridPane.setPrefSize(width, height);
		this.gridPane.setMinSize(width, height);
		
		/* Add columns and rows to form 9x9 grid. */
		for(int i = 0; i < BOARD_WIDE; i++){
			gridPane.getColumnConstraints().add(new ColumnConstraints((double)(BOARD_WIDTH/9)));	
		}
		for(int j = 0; j < BOARD_TALL; j++){
			gridPane.getRowConstraints().add(new RowConstraints((double)(BOARD_HEIGHT/9)));
		}
		
		/* Set offset from the top left origin of the stage. */
		this.gridPane.setLayoutX(5);
		this.gridPane.setLayoutY(5);
		
		/* Add the grid pane to the main Anchor Pane. */
		mainPane.getChildren().add(gridPane);
	}
	
	/**
	 * This method transfers the 2D grid sudokuBoard and
	 * puts it on the GUI for the user to see. 
	 *  
	 */
	private void initialiseBoard(){
		/* Loop through Sudoku Board and add Square object
		 * to each grid box.
		 */
		for(int i = 0; i <BOARD_WIDE ; i++){
			for(int j = 0; j < BOARD_TALL; j++){
				this.gridPane.add(sudokuBoard[i][j], j, i);
			}
		}
	}
	
	/**
	 * This method adds the bottom and side anchor panes 
	 * onto the main stage.
	 */
	private void addPanes(){
		/*Add side-pane onto board.*/
		sidePane = new SidePane(PANE_WIDTH-BOARD_WIDTH-10, PANE_HEIGHT-4, BOARD_WIDTH+18, 4);
		mainPane.getChildren().add(sidePane);
		
		/*Add bottom-pane onto board.*/
		bottomPane = new BottomPane(BOARD_WIDTH+3, PANE_HEIGHT-BOARD_HEIGHT-10,0+6,BOARD_HEIGHT+10);
		mainPane.getChildren().add(bottomPane);
	}
	
	/**
	 * This method adds the buttons onto the main board and 
	 * adds the EventHandlers for each button.
	 * 
	 */
	private void addButtons(){
		/* Create button objects and set: size, position & text. */
		submitButton = new BoardButton(100, 20, 620, 165, "Submit");
		resetButton  = new BoardButton(100, 20, 500, 165, "Reset");
		checkButton  = new BoardButton(100, 20, 380, 165, "Check");
		solveButton  = new BoardButton(100, 20, 260, 165, "Solve");
		
		/* Add all buttons onto the bottom pane */
		bottomPane.getChildren().addAll(resetButton, submitButton, checkButton, solveButton);
		
/*--------------------------------EVENT HANDLERS FOR BUTTONS-------------------------------------------------------------------*/
		
		/* Event Handler for Submit button. */
		submitButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		        /* If board is not valid then don't submit. */
		    	if(!isBoardValid){
		        	System.out.println("Please check that your board is valid and complete!");
		        }
		    	
		    }
		});
		
		/* Event Handler for Reset Button */
		/**
		 * @exception FileNotFoundException - The file cannot be found.
		 */
		resetButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	/* Confirm whether the user really wants to reset the board! */
		    	Alert alert = new Alert(AlertType.CONFIRMATION);
		    	alert.setTitle("Confirm Reset Event");
		    	String s = "Do you really want to reset the board?";
		    	bottomPane.setText("The Reset Button has been pressed");
		    	alert.setContentText(s);
		    	Optional<ButtonType> result = alert.showAndWait();
		    	
		    	/* User wishes to reset the board, thus re-read the original text-file. 
		    	 * This removes the users current progress. */
		    	if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
	    			rf = new ReadFile(FrontPageController.filename);
					sudokuBoard = rf.getBoard();
					initialiseBoard();
		    	}
		    }
		});
		
		/* Event Handler for Check Button */
		checkButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
		    	
		    	/*Create board checker object.*/
		    	BoardChecker bc = new BoardChecker();
		    	
		    	/*Call checkBoard() to check if board is valid.*/
		    	isBoardValid = bc.checkBoard(sudokuBoard);
		    	
		    	/*Inform the user about whether their submitted
		    	 * board is valid or not.
		    	 */
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
		    	
		    	/* BoardChecker object ready for Garbage collection.*/
		    	bc = null;
		    }
		});
		
		/* Event Handler for the Solve Button. */
		solveButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				
		    	bottomPane.setText("Attempting to Solve Board!!");
				
				//BoardSolver bs = new BoardSolver(sudokuBoard);
				 
		    }
		});
/*---------------------------------------END--------------------------------------------------------------------------*/
	
	}
}
