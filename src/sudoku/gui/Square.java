/**
 * class: Square.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 * 
 */
package sudoku.gui;

import java.util.ArrayList;
import java.util.ListIterator;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

/**
 * This class is for the square object. Each square
 * represents a space in the 9x9 sudoku grid. It extends
 * the TextArea class of the JavaFX8 library so by default
 * it allows user to enter text.
 * 
 * @version 1.0
 * 
 */
public class Square extends TextArea{
	
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
	
	
	/**
	 * The constructor method for the square object which
	 * sets the height and width of the object.
	 * 
	 * @param width  - The width of the square object.
	 * @param height - The height of the square object.
	 */
	public Square(double width, double height){
		
		/* Setting height, width and setting wrap text = false */
		this.setPrefHeight(height);
		this.setMinHeight(height);
		this.setMinWidth(width);
		this.setPrefWidth(width);
		this.setWrapText(false);
		
		/* Limit the text area input to 1 character. */
		this.setTextFormatter(new TextFormatter<String>(
				change -> change.getControlNewText().length()
				<= 1 ? change:null));
		
		/* Set X & Y layout of the square. */
		this.setLayoutX(80);
		this.setLayoutY(20);
		
		/* Set CSS styling of the square. */
		this.setStyle("-fx-background-color:black;"
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
	
	/**
	 * This getter method returns the next valid 
	 * number that can be placed in the square.
	 * 
	 * @return int - The next element in the list or
	 * the number 0 if no more possibilities are there.
	 */
	public int getNextElement(){
		if(this.listIterator.hasNext())
		{	
			return listIterator.nextIndex();
		}
		else{	
			resetList();
			return 0;
		}
	}
	
	/**
	 * This method resets the list iterator.
	 */
	private void resetList()
	{
		//Reset list iterator.
		this.listIterator = possibleNums.listIterator();
	}
	
	/**
	 * This setter method inputs a number into the Sudoku
	 * square object. 
	 * 
	 * @param inputNum - The number to put into the square.
	 */
	public void setNum(int inputNum)
	{
		//Set the current number for the square.
		this.squareNum = inputNum;
		//Set string in text area as well.
		
		if(inputNum!=0){
			this.setText(Integer.toString(squareNum));	
		}
		else{
			this.setText("");
		}
	}

	/**
	 * The getter method which returns the current 
	 * number in the square.
	 * 
	 * @return int squareNum - The number that is held 
	 * in the square.
	 */
	public int getNum(){
		if(!this.getText().equals("")){
			this.squareNum = Integer.parseInt(this.getText());
			return squareNum;
		}
		else{
			return 0;
		}
	}
	
	/**
	 * This is the getter method for the boolean 
	 * variable 'fixedStatus'.
	 * 
	 * @return boolean fixedStatus - The boolean 
	 * value of whether this square is fixed or not.
	 */
	public boolean getFixedStatus(){
		return this.fixedStatus;
	}
	
	/**
	 * This is the setter method for the boolean 
	 * variable 'fixedStatus'
	 * 
	 * @param val - The boolean value which dictates
	 * if the board is fixed (true) or not (false).
	 */
	public void setFixedStatus(boolean val){
		this.fixedStatus = val;
		this.setEditable(!val);
	}
	
}
