/**
 * class: BoardButton.java
 * 
 * @author Ravindra Bhadti
 * 
 */

package sudoku.gui;

import javafx.scene.control.Button;

/**
 * 
 * This class represents the Button object to be placed
 * on the GUI. 
 * 
 * @version 1.0
 *
 */
public class BoardButton extends Button {

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
	public BoardButton(double width, double height, double xPos, double yPos, String text) {
		
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		this.setText(text);

		/* Can set the CSS Styling */
		
	}

}
