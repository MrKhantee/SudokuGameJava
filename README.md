# The Ultimate Sudoku Game (Java)

## **Getting Started**

### What is Sudoku?
Sudoku is a Japanese numbers game that...

### Program Capabilities
This application gives the user a simple interface to play the Sudoku game.

* Users can attempt a wide variety of Sudoku boards ranging from easy to hard difficulties.
* Users can check the validity of their solution at any stage of the game.
* Users can choose to solve the board automatically using the in-built board solver.

### Prerequisites
For running the application, the following is required:
* Java (JDK V1.8+)
* Administrative rights on the system

To edit, compile or view the source code, the following is required:
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
## **Installaing & Running**

### Packaging the Program
Do this only if **changes** have been made to the **source code** or to the current version of the application. These steps export the current project into a ```.jar``` file. There are then 2 ways to run it.

### One-Click Run
The simplest method. The pre-packaged application can be run by double-clicking on the Runnable JAR file:
```
/SudokuV1_0.jar
```
### Command Line Run
The program can also be run from the Windows command line. This displays any debug print statements and any exceptions that may occur during compile & runtime.

Start by typing:
 ```
 cmd

 ```
 in the windows search box. Preferably run as administrator.

Navigate to the directory of the ```.jar``` file by doing the following.

```
cd C:\PATH_TO_FILE\Sudoku\
```
Where ```PATH_TO_FILE``` is the absolute location of the file on the system.

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
