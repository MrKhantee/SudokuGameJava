# The Ultimate Sudoku Game (Java)

## **Introduction**
Sudoku is a Japanese numbers game in which the player attempts to fill in a 9x9 grid with the numbers 1-9 while following certain rules. The board can be seen as 9 rows, 9 columns or 9 3x3 sub-grids.

1. Each row must contain numbers 1-9. (i.e. No repetitions)
2. Each column must contain numbers 1-9. (i.e. No repetitions)
3. Each 3x3 sub-grid must contain numbers 1-9. (i.e. No repetitions)

The [Sudoku Wiki](https://en.wikipedia.org/wiki/Sudoku) explains these concepts in more detail.

This program is a simple Sudoku game with a graphical user interface (GUI). The logic is written using the Java Programming language. The GUI component of the application is created using the JavaFX libraries which are provided with Java 1.8.

## **Getting Started**

### Program Capabilities
This application gives the user a simple interface to play the Sudoku game.

* Users can attempt a wide variety of Sudoku boards ranging from easy to hard difficulties.
* Users can check the validity of their solution at any stage of the game.
* Users can choose to solve the board automatically using the in-built board solver.

### Prerequisites
For running the application, the following is required:
* Java (JDK V1.8+)
* Administrative rights on the system

To edit or re-compile the source code, the following is required:
* An IDE, such as Eclipse or NetBeans
* JavaFX 2.2+ (and Java 1.8+)
* JavaFX SceneBuilder 2.0+

## **Directory Structure**
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

## **Installing**


## **Running**
There are 2 ways to run the output ```.jar``` file from the previous stage.

### One-Click Run
The simplest method. The pre-packaged application can be run by double-clicking on the Runnable JAR file:
```
/SudokuV1_0.jar
```
### Command Line Run
The program can also be run from the Windows command line ```cmd```. This displays any debug print statements and any exceptions that may occur during compile & runtime.

Navigate to the directory of the ```.jar``` file by doing the following.

```
cd C:\PATH\TO\SUDOKU\JAR\
```

Then use the following command to run the application.
```
java SudokuV1_0.jar {optional args}
```

## **Documentation**

### In-Line Documentation
The code contains inline documentation to help describe functionality. This can be separated into 3 areas:
```
// Single Line Comments
```
```
/*
 * Single  
 * & Multi-Line
 * Comment
 */
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

## **JUnit Testing**
The JUnit tests are located in the ```test/...``` directory.

### Board Checker Testing

### Board Solver Testing

### Future Testing
It would be desirable to use specific JavaFX test frameworks rather than relying on simple JUnit testing. As JUnit testing does not consider the UI functionality.

## **Authors**
* Ravindra Bhadti - Version 1.0
