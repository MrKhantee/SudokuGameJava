package sudoku.gui;

import java.util.ArrayList;
import java.util.ListIterator;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

public class Square extends TextArea{
	
	private int squareNum;
	
	//Stores possible integers that can be put into the board.
	private ArrayList<Integer> possibleNums = null;
	
	private boolean fixedStatus = false;
	
	//The List Iterator for the arrayList.
	private ListIterator<Integer> listIterator = null;
	
	public Square(double width, double height){
		this.setPrefHeight(height);
		this.setMinHeight(height);
		this.setMinWidth(width);
		this.setPrefWidth(width);
		this.setWrapText(false);
		
		
		this.setTextFormatter(new TextFormatter<String>(
				change -> change.getControlNewText().length()
				<= 1 ? change:null));
		
		this.setLayoutX(80);
		this.setLayoutY(20);
		
		this.setStyle("-fx-background-color:black;"
					+ "-fx-border-color:black;"
					+ "-fx-font-size: 26px;"
					+ "-fx-text-color:red;"
					+ "-fx-text-alignment:center");
		
		
		//Add numbers 0-9 to the list and assign
		//ListIterator.
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
	
	//Initialise the list for this Square.
	public void resetList()
	{
		//Reset list iterator.
		this.listIterator = possibleNums.listIterator();
	}
	
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

	//Retrieve number held in current square.
	public int getNum(){
		if(!this.getText().equals("")){
			this.squareNum = Integer.parseInt(this.getText());
			return squareNum;
		}
		else{
			return 0;
		}
	}
	
	//Check if current square is fixed or not.
	public boolean getFixedStatus(){
		return this.fixedStatus;
	}
	
	public void setFixedStatus(boolean val){
		this.fixedStatus = val;
		this.setEditable(!val);
	}
	
}
