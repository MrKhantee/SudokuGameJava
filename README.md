# The Ultimate Sudoku Game (Java)


## **Getting Started**

### Prerequisites
For running the application, the following is required:
* Java JDK Version 1.8 or greater
* Administrative rights on the system

To edit, compile or view the source code, the following is required:
* An IDE, such as Eclipse or NetBeans
* JavaFX 2.2+ (and Java 1.8+)
* JavaFX SceneBuilder 2.0+

## **Directory Structure**
The project directory structure is shown below. The ```src``` folder contains all the source code and packages for the project. The ```test``` folder contains the JUnit test cases in their respective packages.
```
Sudoku
├── src
|   |── sudoku
|       |── BoardChecker.java
|       |── BoardSolver.java
|       |── Main.java
|       |── ReadFile.java
|       |── FrontPage.fxml
|       |── MainBoard.fxml
|       |── application.css
|       |── controller
|       |   |── BoardController.java
|       |   |── FrontPageController.java
|       |── gui
|       |   |── BoardButton.java
|       |   |── BottomPane.java
|       |   |── MainButton.java
|       |   |── SidePane.java
|       |   |── Square.java
|       |── exceptions
|       |   |──NoMoreContentException.java
|       |── boards
|       |   |── board1.txt
|       |   ...
|       |___|── board10.txt
|
|── test
|   |── sudoku
|       |── controller
|       |── gui
|       |── exceptions
|       |── testboards
|       |   |── testboard1.txt
|       |   |── ...
|       |___|── testboard10.txt
|
|── docs
|    |── ...JavaDoc Documentation...
```
## **Installing & Running**

### One-Click Run
The JAR file ```Sudoku.jar``` is a Runnable JAR file that can be opened by simply double-clicking on it.

### Manual Installation

## **Documentation**

### In-Line Documentation
The code contains inline documentation to help describe functionality. This can be separated into 3 areas:
```
// Single Line Comments
```
```
/* Single Line Comment */
```
The Javadoc comments will be published as described below.
```
/** Javadoc Documents */
```

### Javadoc Documentation
The source for the ```javadoc``` documentation is contained in the ```docs``` folder. This is generated from the ```javadoc``` comment styles in the code.
```
.../Sudoku/docs/index.html
```
This allows for the viewing of:

* Application Classes
* Application Packages
* Class Relations
* Method Parameters and Exceptions

## Testing

## **Authors**
* Ravindra Bhadti - Version 1.0
