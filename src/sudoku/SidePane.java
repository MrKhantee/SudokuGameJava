package sudoku;

import javafx.scene.layout.AnchorPane;

public class SidePane extends AnchorPane {
	
	//Variables for position.
	
	public SidePane(double width, double height, double xPos, double yPos){
		
		this.setPrefSize(width, height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		this.setStyle("-fx-background-color:#444444;"
					+ "-fx-border-width: 3px;"
					+ "-fx-border-color: black;");
		
	}
}
