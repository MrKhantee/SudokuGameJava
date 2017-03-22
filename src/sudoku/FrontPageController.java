package sudoku;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FrontPageController implements Initializable {

	@FXML AnchorPane frontPane;
	
	private SidePane backingPane 	= null;
	private SidePane topPane     	= null;
	private SidePane bottomPane 	= null;
	
	private Label title = null;
	private Label textDesc = null;
	
	private TextArea boardName = null;
	
	private MainButton easyButton    = null;
	private MainButton mediumButton  = null;
	private MainButton hardButton    = null;
	private BoardButton submitButton  = null;
	
	public static String filename = null;
	
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
		
		//Create a button for each action.
		easyButton    = new MainButton(300, 100, 30, 30, "Easy");
		mediumButton  = new MainButton(300, 100, 30, 160, "Medium");
		hardButton    = new MainButton(300, 100, 30, 290, "Hard");
		submitButton  = new BoardButton(100, 48, 550, 60, "Select");
		
		//Set Event Handlers for each of the buttons.
		easyButton.setOnAction(btnEasyPressed);
		mediumButton.setOnAction(btnMediumPressed);
		hardButton.setOnAction(btnHardPressed);
		submitButton.setOnAction(btnSubmitPressed);
		
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
	
	/*-------------------------------EVENT HANDLERS------------------------------------*/
	
	/*
	 * Event Handler for Easy, Medium 
	 * and Hard Buttons pressed
	 * 
	 */
	EventHandler <ActionEvent> btnEasyPressed = 
	new EventHandler <ActionEvent>()
	{
		@Override
		public void handle(ActionEvent arg0) 
		{
			filename = "easy1";
			System.out.println("Filename Set as: " + filename + ".txt");
			changeStage(filename);
		}
	};
	
	EventHandler <ActionEvent> btnMediumPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
			filename = "medium1";
			changeStage(filename);
		}
	};
	
	EventHandler <ActionEvent> btnHardPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
			filename = "hard1";
			changeStage(filename);
		}
	};
	
	EventHandler <ActionEvent> btnSubmitPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) 
		{	
			if(!boardName.getText().equals("") && boardName.getText()!=null)
			{
				filename = boardName.getText();
				changeStage(filename);
			}
		}
	};
	
	
	private void changeStage(String filename){
		System.out.println("Filename Set as " + filename);
		Parent page;
		Stage primaryStage = (Stage) submitButton.getScene().getWindow();
		try {
			page = (Parent)FXMLLoader.load(Main.class.getResource("MainBoard.fxml"));
			Scene scene = new Scene(page);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
