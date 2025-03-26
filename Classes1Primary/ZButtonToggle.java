package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes2Secondary.ClickListener;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class ZButtonToggle extends ZButton {

    /*
    a toggle button is a button which changes pressed/depressed state constantly when mouse 
    touches it. when clicked, it remains in the pressed state until another is selected.
    the menu buttons, shape buttons, color1 color2, color gradient and layers are all
    toggle buttons. 
    whereas color buttons are active buttons, that do not remain in pressed state when clicked, 
    instead they remain in the depressed state. 
     */
    private boolean clickedStatus; //whether or not the button is pressed
    private boolean movedStatus; // whether or not the button is moved
    private ClickListener listener; //each button has a click function defined in the interface
    private ToolTip toolTip;

    public ZButtonToggle(String name, int x, int y, int width, int height, Image pressedImage, Image depressedImage) {
        this(name, new ZPoint(x, y), width, height, pressedImage, depressedImage);
    }

    public ZButtonToggle(String name, ZPoint p, int width, int height, Image pressedImage, Image depressedImage) {

        super(name, p, width, height, pressedImage, depressedImage);
        this.movedStatus = false; // all buttons are by standard, depressed. 

        // intialise the listener of each button
        ClickListener list = (int x, int y) -> {
            ifClicked(x, y);
            if (isClickedStatus() == true) { // when a button is pressed, display that they are pressed. 
                System.out.println("" + getName() + " is clicked. ");
            }
        };
        this.listener = list; // apply the listener to the button
        this.toolTip = ToolTip.getToolTip();

    }

    public boolean ifClicked(int userX, int userY) {

        /*
        if the user (x,y parameters) clicks the button, then change the button to pressed image, 
        make pressed status true and return true from this method. if the button has 
        not been clicked, then change button to depressed image, make pressed status false 
        and return false from this method.
        to check if the button has been clicked or not, we will check is the user has 
        clicked on the button or not. ie users x will be between the center.x point and
        center.x + width; and the users y will be between the center.y point and 
        center.y + height. 
         */
        if (userX > getTopLeftCorner().getX()
                && userX < getMaximum().getX()
                && userY > getTopLeftCorner().getY()
                && userY < getMaximum().getY()) {

            setCurrentImage(getPressedImage());
            setClickedStatus(true);
            return true;

        } else {

            setCurrentImage(getDepressedImage());
            setClickedStatus(false);
            return false;

        }

    }

    public void paintToolTip(Graphics g) {

        if (this.movedStatus == true) {
            this.toolTip.paint(g);
        }

    }

    public boolean ifMoved(int userX, int userY) {

        /*
        this is the same as ifClicked. except there is a few changes: so if the user 
        touches the buttons then it changes state from depressed to pressed. and then 
        if the user moves its cursor from the button, the program will first check if 
        it has been clicked or not. this will be done by checking the clicked status. 
        if it had, then the button will REMAIN IN PRESSED STATE. otherwise it will change 
        back to its depressed state. this is the main functionality of a toggle button. 
         */
        if (userX > getTopLeftCorner().getX()
                && userX < getMaximum().getX()
                && userY > getTopLeftCorner().getY()
                && userY < getMaximum().getY()) {

            setMovedStatus(true);
            setCurrentImage(getPressedImage());
            this.toolTip.declareLabel(getName(), new ZPoint(userX, userY));
            return true;

        } else {

            setMovedStatus(false);
            if (isClickedStatus() == false) { // if the button had not been clicked, THEN change state
                setCurrentImage(getDepressedImage());
            }// otherwise DO NOT change state
            return false;

        }

    }

    public String pressedStatus() {

        /*
        this method returns the string version if the button is clicked or not
         */
        if (isClickedStatus() == true) {
            return "pressed";
        } else {
            return "not pressed";
        }

    }

    @Override
    public String toString() {
        return "ZButtonToggle{" + "clickedStatus=" + isClickedStatus() + ", movedStatus="
                + isMovedStatus() + ", listener=" + getListener() + ", pressedStatus = "
                + pressedStatus() + ", " + super.toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public boolean isMovedStatus() {
        return movedStatus;
    }

    public void setMovedStatus(boolean movedStatus) {
        this.movedStatus = movedStatus;
    }

    public ClickListener getListener() {
        return listener;
    }

    public void setListener(ClickListener listener) {
        this.listener = listener;
    }

    public boolean isClickedStatus() {
        return clickedStatus;
    }

    public void setClickedStatus(boolean clickedStatus) {
        this.clickedStatus = clickedStatus;
    }

}
