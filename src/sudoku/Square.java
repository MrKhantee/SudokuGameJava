package sudoku;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

public class Square extends TextArea{
	
	private int squareNum;
	
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
	
	}
	
	public void setNum(int inputNum){
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
	
	public int getNum(){
		if(this.getText()!=""){
			this.squareNum = Integer.parseInt(this.getText());
			return squareNum;
		}
		else{
			return 0;
		}
	}
	
}
