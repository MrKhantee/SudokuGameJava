package sudoku;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class BottomPane extends AnchorPane{
	
	private Label bottomLabel = null;
	
	public BottomPane(double width, double height, double xPos, double yPos){
		this.setPrefSize(width, height);
		this.setLayoutX(xPos);
		this.setLayoutY(yPos);
		
		this.setStyle("-fx-background-color:#444444;"
				+ "-fx-border-width: 3px;"
				+ "-fx-border-color: black;");
		
		//Setting label.
		bottomLabel = new Label();
		bottomLabel.setPrefSize(0.9*width, 0.6*height);
		bottomLabel.setStyle("-fx-background-color:#333333;-fx-font-size:24px;");
		bottomLabel.setTextFill(Color.WHITE);
		bottomLabel.setLayoutX(0.05*width);
		bottomLabel.setLayoutY(0.08*height);
		bottomLabel.setText("");
		bottomLabel.setAlignment(Pos.CENTER);
		bottomLabel.setVisible(true);
		
		this.getChildren().add(bottomLabel);
		
	}
	
	public Label getLabel(){
		return bottomLabel;
	}
	
	public void setText(String text){
		this.bottomLabel.setText(text);
		
	}
	
}
