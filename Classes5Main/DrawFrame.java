package Classes5Main;

// MAIN CLASSES: The user-accessible minimal classes, which use quaternary classes to run
import java.awt.*;
import javax.swing.*;

/*

 */
public class DrawFrame extends JFrame {

    private DrawPanel panel; // a panel object to add to frame

    public void runDrawFrame() {

        /*
        this method runs the drawPanel class. it creates a panel of DrawPanel class 
        which is extended from JPanel. It then intializes properties of that JPsnel
         */
        // create a draw panel object (for all the buttons)
        this.panel = new DrawPanel();

        // add this draw panel object to this frame
        add(getPanel());

        intializeFrameProperties();

    }

    private void intializeFrameProperties() {

        /*
        this method declares the JFrame properties such as size, rescalability and background. 
         */
        // now declare frame properties
        this.pack(); // sizes the frame so that all its contents are at or above their preferred sizes
        this.setSize(900, 600); // sets the x-dimension and y-dimension of frame
        this.setResizable(false); // makes frame fixed
        this.getContentPane().setBackground(Color.WHITE); // make background white
        this.setVisible(true); // makes frame visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits out of application
        this.setTitle("ZUHA AQIB 26106 - ASSIGNMENT 3"); // set name of frame
        this.setLocationRelativeTo(null); //sets frame in the middle of laptop screen

    }

    @Override
    public String toString() {
        return "DrawFrame{" + "panel=" + getPanel().toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public DrawPanel getPanel() {
        return panel;
    }

    public void setPanel(DrawPanel panel) {
        this.panel = panel;
    }

}
