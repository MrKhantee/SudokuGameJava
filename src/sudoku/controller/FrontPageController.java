/**
 * 
 * class: FrontPageController.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 * 
 */

package sudoku.controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sudoku.Main;
import sudoku.gui.BoardButton;
import sudoku.gui.MainButton;
import sudoku.gui.SidePane;


/**
 * This class acts a controller class for 'FrontPage.fxml'. It
 * dictates the actions that occur on this page and sets up the 
 * GUI components on this page.
 * 
 * @version 1.0
 *
 */
public class FrontPageController implements Initializable {
	
	/* Injectable Fields for FXML Document */
	@FXML AnchorPane frontPane;
	
	/* Panes for the content. These will be placed on the stage. */
	private SidePane backingPane 	= null;
	private SidePane topPane     	= null;
	private SidePane bottomPane 	= null;
	
	/* Labels for the title and text description. */
	private Label title = null;
	private Label textDesc = null;
	
	/* Text-area for user to specify particular board games. */
	private TextArea boardName = null;
	
	/* Buttons to be placed on the GUI (Stage) */
	private MainButton easyButton    = null;
	private MainButton mediumButton  = null;
	private MainButton hardButton    = null;
	private BoardButton submitButton  = null;
	
	/* Filename of the text-file to read from. */
	public static String filename = null;
	
	/**
	 * This method is run when the FXML Template is loaded. It
	 * initialises the panes and the adds the buttons onto the 
	 * stage.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initialisePanes();
		addButtons();
	}
	
	/**
	 * This method initialises the Anchor panes on the GUI page. 
	 * It also adds the titles onto the stage.
	 */
	private void initialisePanes(){
		/* The top and bottom Anchor Panes. */
		topPane 	= new SidePane(700, 100, 170, 20);
		bottomPane 	= new SidePane(700, 150, 170, 600);
		
		/* The title text for the front page and its formatting. */
		title = new Label("Welcome! Please Choose A Board Difficulty");
		title.setPrefSize(700,100);
		title.setStyle("-fx-font-size:30px;-fx-font-weight:900;");
		title.setTextFill(Color.WHITE);
		title.setAlignment(Pos.CENTER);
		
		/* Declare the background pane. */
		backingPane = new SidePane(700, 420, 170, 150);
		
		/* Add title to the top pane. */
		topPane.getChildren().add(title);
		/* Add the panes onto the front pane. */
		frontPane.getChildren().addAll(backingPane, topPane, bottomPane);
	}
	
	/**
	 * This method adds buttons onto the GUI and sets
	 * their EventHandlers.
	 */
	private void addButtons(){
		
		/* Create button objects and set: size, position & text. */
		easyButton    = new MainButton(300, 100, 30, 30, "Easy");
		mediumButton  = new MainButton(300, 100, 30, 160, "Medium");
		hardButton    = new MainButton(300, 100, 30, 290, "Hard");
		submitButton  = new BoardButton(100, 48, 550, 60, "Select");
		
		/* Assign Action Event to a button. */
		easyButton.setOnAction(btnEasyPressed);
		mediumButton.setOnAction(btnMediumPressed);
		hardButton.setOnAction(btnHardPressed);
		submitButton.setOnAction(btnSubmitPressed);
		
		/* Create a simple text label. */
		textDesc      = new Label(" Board Name: "); 
		textDesc.setStyle("-fx-font-size:20px;-fx-border-width:3px;-fx-border-color:white;");
		textDesc.setTextFill(Color.WHITE);
		textDesc.setLayoutX(50); 
		textDesc.setLayoutY(60);
		textDesc.setPrefHeight(48);
		
		/* Generate TextArea for user to text into. This will
		 * take as input the text-file the user wants to read from.
		 */
		boardName     = new TextArea(); 
		boardName.setPrefWidth(300);
		boardName.setLayoutX(200); 
		boardName.setLayoutY(60);
		boardName.setMaxHeight(20);
		boardName.setWrapText(false);
		
		/* Add buttons to the backing pane and bottom pane. */
		backingPane.getChildren().addAll(easyButton, mediumButton,hardButton);
		bottomPane.getChildren().addAll(submitButton, textDesc, boardName);
	}
	
	/*-------------------------------EVENT HANDLERS------------------------------------*/
	
	/**
	 * If the user clicks the 'Easy' 
	 * option on the front page. It loads an 
	 * easy difficulty Sudoku board.
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
	
	/**
	 * If the user clicks the
	 * 'Medium' option on the front page. It loads a 
	 * medium difficulty Sudoku board.
	 */
	EventHandler <ActionEvent> btnMediumPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
			filename = "medium1";
			changeStage(filename);
		}
	};
	
	/**
	 * If the user clicks the 'Hard' option on the
	 * front page. It loads a hard difficulty 
	 * Sudoku board.
	 */
	EventHandler <ActionEvent> btnHardPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) {
			filename = "hard1";
			changeStage(filename);
		}
	};
	
	/**
	 * The 'Submit' button takes the user's input
	 * from the TextArea-boardName and attempts to
	 * load a file with that name.
	 */
	EventHandler <ActionEvent> btnSubmitPressed = 
	new EventHandler <ActionEvent>(){
		@Override
		public void handle(ActionEvent arg0) 
		{	
			
			/* Check the user input is not empty and/or NULL. */
			if(!boardName.getText().equals("") && boardName.getText()!=null)
			{
				filename = boardName.getText();
				changeStage(filename);
			}
		}
	};
	
	/**
	 * This method changes the main stage. It loads the MainBoard.fxml
	 * template onto the GUI. The BoardController.java class takes over 
	 * and populates the board with the user's choice of text file. 
	 * 
	 * @param filename - The text-file containing the sudoku numbers
	 * 					 to be displayed. 
	 */
	private void changeStage(String filename)
	{
		Parent page;
		Stage primaryStage = (Stage) submitButton.getScene().getWindow();
		
		try {
			/* Load the new FXML template onto the main stage. */
			page = (Parent)FXMLLoader.load(Main.class.getResource("MainBoard.fxml"));		
			Scene scene = new Scene(page);
			scene.getStylesheets().add(getClass().getResource("../application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		
		/* Catch the 2 possible exceptions. */
		catch (NullPointerException  nPE){
			System.err.println("FXML/CSS NullPointerException has occured.");
		}
		catch (IOException e) {
			System.err.println("FXML/CSS IOException has occured.");
			e.printStackTrace();
		}
	}
}
