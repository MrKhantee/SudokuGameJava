package sudoku;

import java.util.ArrayList;
import java.util.ListIterator;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

public class Square extends TextArea{
	
	private int squareNum;
	
	//Stores possible integers that can be put into the board.
	ArrayList<Integer> possibleNums = null;
	
	//The List Iterator for the arrayList.
	ListIterator<Integer> listIterator = null;
	
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
		
		
		this.possibleNums = new ArrayList<Integer>();
		
		resetList();
	
	}
	
	public int getElementFromList(int index){
		return this.possibleNums.get(index);
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
	
}
