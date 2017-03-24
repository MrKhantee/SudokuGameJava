/**
 * class: MainButton.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 */

package sudoku.gui;

import javafx.scene.control.Button;

/**
 * This class is for the large buttons on the front
 * FXML page. It extends the Button class from the
 * JavaFX8 library.
 * 
 * @version 1.0
 *
 */
public class MainButton extends Button{
	
	/**
	 * This constructor method initialises the properties of
	 * the button. 
	 * 
	 * @param width  - The width of the button.
	 * @param height - The height of the button.
	 * @param xPos - The horizontal offset from parent.
	 * @param yPos - The vertical offset from parent.
	 * @param text - The text to be placed in the button.
	 */
	public MainButton(double width, double height, double xPos, double yPos, String text){
		
		/* This sets the width, height and layout of the button. */
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		/* Set the text of the button. */
		this.setText(text);
		
		/* Set the CSS styling for this button. */
		this.setStyle("-fx-font-weight:bold;-fx-font-size:34px;");
	}

}

