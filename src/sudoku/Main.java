/**	
 * class: Main.java
 * 
 * @author Ravindra Bhadti
 * 
 * @since 23-03-2017
 * 
 */
package sudoku;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * This class is the main application runner. It loads
 * the first page of the FXML document.
 * 
 * @version 1.0
 *
 */
public class Main extends Application {
	
	/**
	 * The 'start' method launches the GUI.
	 * 
	 * @param primaryStage - The stage object to be displayed.
	 * 
	 * @exception LoadException - If the FXML Template cannot be loaded.
	 * @exception Exception     - The super-class: Used if any exception occurs.
	 */
	@Override
	public void start(Stage primaryStage) throws LoadException, Exception{
		
		
		
		try 
		{	
			/* 
			 * Load page using FXMLLoader and set it to the parent.
			 * Then. The window is set to 
			 * non-resizeable and then the .show() method displays the GUI.
			 */
			Parent page = (Parent)FXMLLoader.load(Main.class.getResource("FrontPage.fxml"));
			
			/* Add a scene + CSS Stylesheet*/
			Scene scene = new Scene(page);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			/* Set Window size to non-resizeable and display the stage after
			 * setting the scene.
			 */
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		
		/*
		 * This exception occurs if the FXML Template
		 * can't be loaded. 
		 */
		catch(LoadException lE)
		{
			lE.printStackTrace();
		}
		/*
		 * This exception is a generic exception which
		 * is the superclass of the LoadException.
		 */
		catch(Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * This is the main launching method.
	 * 
	 * @param args - Arguments from the command line.
	 * 
	 * @throws Exception - This exception could be thrown due to
	 * 				invalid command line arguments.
	 */
	public static void main(String[] args) throws Exception{
		Application.launch(args);
	}
}