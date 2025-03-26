package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ZRectangleActive extends ZRectangle {

    /*
    an active rectangle is a rectangle which changes pressed depressed state constantly when mouse 
    touches it. when clicked, nothing happens, it remains depressed. . 
    this active rectangle is only applicable for COLOR BUTTONS. color1 color2 are toggle as when 
    cursor moves on them they deflect but when clicked they are pressed until 
    something else is clicked.
     */
    private ToolTip toolTip;
    private boolean toolTipPrint;

    public ZRectangleActive(String name, int x, int y, int width, int height, Color c) {

        this(name, new ZPoint(x, y), width, height, c);

    }

    public ZRectangleActive(String name, ZPoint p, int width, int height, Color c) {

        super(name, p, width, height, c);
        this.toolTip = ToolTip.getToolTip();
        this.toolTip.declareLabel(name, p);
        this.toolTipPrint = false;

    }

    public boolean ifMoved(int userX, int userY) {

        /*
        so if the cursor moves on the rectangle (cursor coordinates are within the rectangle),
        then the border color will change. but when the cursor moves away from the rectangle, 
        it would change back to its unpressed border color
         */
        if (userX >= getTopLeft().getX()
                && userX <= getMaximum().getX()
                && userY >= getTopLeft().getY()
                && userY <= getMaximum().getY()) {

            setCurrentBorderColor(getPressedBorderColor());
            this.toolTipPrint = true;
            String str = "r=" + getFillColor().getRed() + ", g="
                    + getFillColor().getGreen() + ", b=" + getFillColor().getBlue();
            this.toolTip.declareLabel(str, new ZPoint(userX, userY));
            return true;

        } else {

            setCurrentBorderColor(getUnpressedBorderColor());
            this.toolTipPrint = false;
            return false;

        }

    }

    public boolean ifSelected(int userX, int userY) {

        /*
        if the user clicks on a button, it will display that the button has been clicked. 
        it has the same functionality as ifMoved()
         */
        boolean mouse = ifMoved(userX, userY);
        if (mouse == true) {
//            System.out.println("" + getName() + " is clicked. ");
            return true;
        } else {
            return false;
        }

    }

    public void makeClicked() {

        int randomx = (getTopLeft().getX() + getMaximum().getX()) / 2;
        int randomy = (getTopLeft().getY() + getMaximum().getY()) / 2;
        ifSelected(randomx, randomy);

    }

    public void makeUnClicked() {

        int randomx = (getTopLeft().getX() + getMaximum().getX());
        int randomy = (getTopLeft().getY() + getMaximum().getY());
        ifSelected(randomx, randomy);

    }

    public void paintToolTip(Graphics g) {

        if (this.toolTipPrint == true) {
            this.toolTip.paint(g);
        }

    }

    @Override
    public String toString() {
        return "ZRectangleActive{" + super.toString() + '}';
    }

    public ToolTip getToolTip() {
        return toolTip;
    }

    public void setToolTip(ToolTip toolTip) {
        this.toolTip = toolTip;
    }

    public boolean isToolTipPrint() {
        return toolTipPrint;
    }

    public void setToolTipPrint(boolean toolTipPrint) {
        this.toolTipPrint = toolTipPrint;
    }

}
