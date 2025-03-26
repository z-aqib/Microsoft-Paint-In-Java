package Classes5Main;

// MAIN CLASSES: The user-accessible minimal classes, which use quaternary classes to run
import Classes1Primary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/*

 */
public class DrawPanel extends JPanel implements ActionListener, MouseInputListener {

    // panel features
    private Timer timer; // so a timer will be used to keep refreshing the code and repainting it
    private int delay = 15; // the program will be refreshed after this many milliseconds
    private KeyListening keyListener; // a key listener

    // MS Paint objects
    private PaintWindow window; // a window is created which contains the entire MSPaint buttons
    private ZLabelColored mouseMovementLabel; // a label which displays what the mouse is doing

    public DrawPanel() {

        /*
        this is the constructor of the DrawPanel class. it intializes and sets the panel
        first, then intializes the objects to be painted on the panel.
         */
        intializePanelFeatures(); // method to intialize the features of panel
        intializeObjects(); // method to intialize the labels and window

    }

    private void intializePanelFeatures() {

        /*
        so this method will intialize features of the panel such as a mouse listener, 
        key listener, mouse motion listener, panel itself such as background, focusable and timer.
        this method will only be called once from the constructor
         */
        this.setBackground(Color.WHITE); // sets the background color of the panel
        this.setFocusable(true); // java frame is already set default focusable as true
        // it sets the JPanel the ability of being focused
        this.keyListener = new KeyListening();
        this.addKeyListener(getKeyListener()); // panel is now listening for keys being pressed
        this.addMouseListener(this); // panel is now listening to mouse clicks
        this.addMouseMotionListener(this); // panel is now listening to mouse movement

        this.timer = new Timer(this.delay, this); // sets a timer to refresh panel 
        getTimer().start(); // starts the timer

    }

    private void intializeObjects() {

        /*
        this method will intialize the window which contains all the buttons
        this method will only be called once from the constructor
         */
        this.window = new PaintWindow(); // intialize the window
        this.mouseMovementLabel = new ZLabelColored("", new ZPoint(5, 523));

    }

    @Override
    public void paintComponent(Graphics g) {

        /*
        this method paints the window and labels which have been intialized
         */
        super.paintComponent(g); // super call JPanel paint as it paints the feautures of the panel
        getWindow().paint(g, this); // paint the window
        getMouseMovementLabel().paint(g); // paint the mouse Movement label
        getKeyListener().paint(g); // paint the key listener label

    }

    // NOT TO BE CHANGED - for refreshing the screen constantly
    @Override
    public void actionPerformed(ActionEvent e) {

        /*
        this method paints the panel after this.delay milliseconds
         */
        Toolkit.getDefaultToolkit().sync();
        repaint();

    }

    // ABSTRACT METHODS - mouse motions
    @Override
    public void mouseClicked(MouseEvent e) {

        /*
        this method runs whenever the mouse clicks on the screen, it changes the 
        buttons state respectively
         */
        getWindow().mouseClicked(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Clicked");

    }

    @Override
    public void mousePressed(MouseEvent e) {

        /*
        this method runs whenever the mouse clicks and stays clicked i.e. mouse 
        stays pressed on the screen
         */
        getWindow().mousePressed(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Pressed");

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        /*
        this method runs whenever the mouse clicks/presses and then RELEASES the mouse
         */
        getWindow().mouseReleased(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Released");

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        /*
        this method runs whenver the mouse enters the JPanel screen
         */
        getWindow().mouseEntered(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Entered");

    }

    @Override
    public void mouseExited(MouseEvent e) {

        /*
        this method runs whenver the mouse leaves the JPanel screen
         */
        getWindow().mouseExited(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Exited");

    }

    @Override
    public void mouseDragged(MouseEvent e) {

        /*
        this method runs whenever the mouse is clicked/pressed and it is moved, i.e.
        the mouse moves while being pressed/clicked together
         */
        getWindow().mouseDragged(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Dragged");

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        /*
        this method runs whenever the mouse moves without being pressed or clicked
         */
        getWindow().mouseMoved(e.getX(), e.getY());
        getMouseMovementLabel().updateText("Mouse is Moved");

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public PaintWindow getWindow() {
        return window;
    }

    public void setWindow(PaintWindow window) {
        this.window = window;
    }

    public ZLabelColored getMouseMovementLabel() {
        return mouseMovementLabel;
    }

    public void setMouseMovementLabel(ZLabelColored mouseMovementLabel) {
        this.mouseMovementLabel = mouseMovementLabel;
    }

    public KeyListening getKeyListener() {
        return keyListener;
    }

    public void setKeyListener(KeyListening keyListener) {
        this.keyListener = keyListener;
    }

}
