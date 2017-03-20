package sudoku;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class FrontPageController implements Initializable {

	@FXML AnchorPane frontPane;
	
	SidePane backingPane 	= null;
	SidePane topPane     	= null;
	SidePane bottomPane 	= null;
	
	Label title = null;
	Label textDesc = null;
	
	TextArea boardName = null;
	
	MainButton easyButton    = null;
	MainButton mediumButton  = null;
	MainButton hardButton    = null;
	BoardButton submitButton  = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		initialisePanes();
		addButtons();
	}
	
	
	private void initialisePanes(){
		
		topPane 	= new SidePane(700, 100, 170, 20);
		bottomPane 	= new SidePane(700, 150, 170, 600);
		
		title = new Label("Welcome! Please Choose A Board Difficulty");
		title.setPrefSize(700,100);
		title.setStyle("-fx-font-size:30px;-fx-font-weight:900;");
		title.setTextFill(Color.WHITE);
		title.setAlignment(Pos.CENTER);
		
		backingPane = new SidePane(700, 420, 170, 150);
		
		topPane.getChildren().add(title);
		frontPane.getChildren().addAll(backingPane, topPane, bottomPane);
	}
	
	private void addButtons(){
		
		easyButton    = new MainButton(300, 100, 30, 30, "Easy");
		mediumButton  = new MainButton(300, 100, 30, 160, "Medium");
		hardButton    = new MainButton(300, 100, 30, 290, "Hard");
		submitButton  = new BoardButton(100, 48, 550, 60, "Select");
		
		textDesc      = new Label(" Board Name: "); 
		textDesc.setStyle("-fx-font-size:20px;-fx-border-width:3px;-fx-border-color:white;");
		textDesc.setTextFill(Color.WHITE);
		textDesc.setLayoutX(50); 
		textDesc.setLayoutY(60);
		textDesc.setPrefHeight(48);
		
		boardName     = new TextArea(); 
		boardName.setPrefWidth(300);
		boardName.setLayoutX(200); 
		boardName.setLayoutY(60);
		boardName.setMaxHeight(20);
		boardName.setWrapText(false);
		
		backingPane.getChildren().addAll(easyButton, mediumButton,hardButton);
		bottomPane.getChildren().addAll(submitButton, textDesc, boardName);
	}
	
	
	
	
}
