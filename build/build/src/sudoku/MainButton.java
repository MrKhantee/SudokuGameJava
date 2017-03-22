package sudoku;

import javafx.scene.control.Button;

public class MainButton extends Button{
	
	public MainButton(double width, double height, double xPos, double yPos, String text){
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		this.setText(text);
		
		this.setStyle("-fx-font-weight:bold;-fx-font-size:34px;");
		

		// Set CSS Styling as well.		
	}

}

