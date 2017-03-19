package sudoku;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BoardButton extends Button {

	private int buttonWidth;
	private int buttonHeight;

	private String buttonText;

	public BoardButton(double width, double height, double xPos, double yPos, String text) {
		
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		this.setText(text);

		// Set CSS Styling as well.
		
	}

}
