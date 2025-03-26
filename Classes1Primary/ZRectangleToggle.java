package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ZRectangleToggle extends ZRectangle {

    /*
    a toggle rectangle is the same as a toggle button. it will change state when hovered, 
    but will remain in the pressed state when pressed. 
    it will extend ZRectangle. 
     */
    private boolean movedStatus;
    private boolean clickedStatus;
    private ToolTip toolTip;

    public ZRectangleToggle(String name, int x, int y, int width, int height, Color c) {
        this(name, new ZPoint(x, y), width, height, c);
    }

    public ZRectangleToggle(String name, ZPoint p, int width, int height, Color c) {

        super(name, p, width, height, c);
        this.movedStatus = false;
        this.clickedStatus = false;
        this.toolTip = ToolTip.getToolTip();
        this.toolTip.declareLabel(name, p);

    }

    public boolean ifMoved(int userX, int userY) {

        /*
        this method will be used to change state of button when hovered/cursor moves on it. 
        but when the cursor moves away from it, the program will first check if it was
        clicked or not. if yes, then the button will remain pressed, otherwise will 
        switch to depressed. 
         */
        if (userX >= getTopLeft().getX()
                && userX <= getMaximum().getX()
                && userY >= getTopLeft().getY()
                && userY <= getMaximum().getY()) {

            setMovedStatus(true);
            setCurrentBorderColor(getPressedBorderColor());
            this.toolTip.declareLabel(getName(), new ZPoint(userX, userY));
            return true;

        } else {

            setMovedStatus(false);
            if (isClickedStatus() == false) {
                setCurrentBorderColor(getUnpressedBorderColor());
            }
            return false;

        }

    }

    public boolean ifSelected(int userX, int userY) {

        /*
        if the rectangle is clicked, it will make clicked status true and will display 
        that it was clicked. if not, it will make clicked status false. 
         */
        if (userX >= getTopLeft().getX()
                && userX <= getMaximum().getX()
                && userY >= getTopLeft().getY()
                && userY <= getMaximum().getY()) {

            setClickedStatus(true);
            System.out.println("" + getName() + " is clicked. ");
            setCurrentBorderColor(getPressedBorderColor());
            return true;
        } else {
            setClickedStatus(false);
            setCurrentBorderColor(getUnpressedBorderColor());
            return false;
        }

    }

    @Override
    public String toString() {
        return "ZRectangleToggle {" + "movedStatus=" + isMovedStatus()
                + ", clickedStatus=" + isClickedStatus() + ", " + super.toString() + '}';
    }

    public void paintToolTip(Graphics g) {

        if (this.movedStatus == true) {
            this.toolTip.paint(g);
        }

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public boolean isMovedStatus() {
        return movedStatus;
    }

    public void setMovedStatus(boolean movedStatus) {
        this.movedStatus = movedStatus;
    }

    public boolean isClickedStatus() {
        return clickedStatus;
    }

    public void setClickedStatus(boolean clickedStatus) {
        this.clickedStatus = clickedStatus;
    }

}
