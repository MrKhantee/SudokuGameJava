package sudoku.exceptions;

public class NoMoreContentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMoreContentException(){
		System.err.println("The file does not contain anymore numbers! \nThe Sudoku input board is too short.");
	}
	
}
