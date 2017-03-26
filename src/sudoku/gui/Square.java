package sudoku.gui;

import java.util.ArrayList;
import java.util.ListIterator;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

public class Square {
	/* The number to be held in the square. */
	private int squareNum;
	
	/* ArrayList that stores the valid possible numbers 
	 * that can be stored in the square without violating
	 * Sudoku Board
	 */
	private ArrayList<Integer> possibleNums = null;
	
	/* The list iterator for the above list */
	private ListIterator<Integer> listIterator = null;
	
	/* Status of whether the square is a fixed-value. */
	private boolean fixedStatus = false;
	
	private Label textArea = null;
	
	/**
	 * The constructor method for the square object which
	 * sets the height and width of the object.
	 * 
	 * @param width  - The width of the square object.
	 * @param height - The height of the square object.
	 */
	public Square(double width, double height){
		
		textArea = new Label();
		
		/* Setting height, width and setting wrap text = false */
		textArea.setPrefHeight(height);
		textArea.setMinHeight(height);
		textArea.setMinWidth(width);
		textArea.setPrefWidth(width);
		textArea.setWrapText(false);
		
		/* Limit the text area input to 1 character. */
		/*textArea.setTextFormatter(new TextFormatter<String>(
				change -> change.getControlNewText().length()
				<= 1 ? change:null));*/
		
		/* Set X & Y layout of the square. */
		textArea.setLayoutX(80);
		textArea.setLayoutY(20);
		
		/* Set CSS styling of the square. */
		textArea.setStyle("-fx-background-color:black;"
					+ "-fx-border-color:black;"
					+ "-fx-font-size: 26px;"
					+ "-fx-text-color:red;"
					+ "-fx-text-alignment:center");
		
		
		/* Add numbers 1-9 in the possibleNums list and 
		 * assign the iterator.
		 */
		this.possibleNums = new ArrayList<Integer>();
		possibleNums.add(1);	
		possibleNums.add(2);
		possibleNums.add(3);
		possibleNums.add(4);
		possibleNums.add(5);
		possibleNums.add(6);
		possibleNums.add(7);
		possibleNums.add(8);
		possibleNums.add(9);
		this.listIterator = possibleNums.listIterator();	
	}
}
