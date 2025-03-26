package Classes5Main;

// MAIN CLASSES: The user-accessible minimal classes, which use quaternary classes to run

/*
 * Subject - Object Oriented Programming Assignment 4
 * Name - Zuha Aqib
 * Date - 31st May 2023
 */

 /*
this class is the starting main class of the entire project. it creates a frame
and then runs it. 
 */
public class Assignment4_zuhaaqib {

    public static void main(String[] args) {
        // TODO code application logic here

        /*
        so this will create a frame object of the DrawFrame class and all the work will
        be done there.
         */
        DrawFrame frame = new DrawFrame();
        frame.runDrawFrame();

    }

}
