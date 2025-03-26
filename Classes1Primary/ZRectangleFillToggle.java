package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.*;

public class ZRectangleFillToggle extends ZRectangleToggle {

    /*
    this is another type of ZRectangle, which is a toggle button, except this button 
    will change its FILL color when clicked on. when hovered on it will change its 
    pressed/unpressed fill color and border color. when clicked, it will stay in its 
    pressed fill and pressed border color. 
     */
    private Color pressedFillColor;
    private Color unpressedFillColor;

    public ZRectangleFillToggle(String name, int x, int y, int width, int height,
            Color unpressedfillColor, Color pressedfillColor) {
        this(name, new ZPoint(x, y), width, height, unpressedfillColor, pressedfillColor);
    }

    public ZRectangleFillToggle(String name, ZPoint p, int width, int height,
            Color unpressedfillColor, Color pressedfillColor) {

        super(name, p, width, height, unpressedfillColor);
        this.pressedFillColor = pressedfillColor;
        this.unpressedFillColor = unpressedfillColor;

    }

    @Override
    public boolean ifMoved(int x, int y) {

        /*
        so this has the same functionality as ifMoved() in the ZRectangleToggle class.
        if cursor is on rectangle, it will change its fill color. otherwise, it will 
        first check if it has been clicked or not. then it will change its fill color. 
         */
        boolean moved = super.ifMoved(x, y);
        if (moved == true) {
            setFillColor(getPressedFillColor());
            return true;
        } else {
            if (isClickedStatus() == false) {
                setFillColor(getUnpressedFillColor());
            }
            return false;
        }

    }

    @Override
    public boolean ifSelected(int x, int y) {

        /*
        so this has the same functionality as ifSelected() in the ZRectangleToggle class.
        if cursor clicks the rectangle, it will change its fill color. otherwise, it will 
        change its fill color. 
         */
        boolean selected = super.ifSelected(x, y);
        if (selected == true) {
            setFillColor(getPressedFillColor());
            setClickedStatus(true);
            return true;
        } else {
            setFillColor(getUnpressedFillColor());
            setClickedStatus(false);
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

    @Override
    public String toString() {
        return "ZRectangleFillToggle{" + "pressedFillColor=" + getPressedFillColor()
                + ", unpressedFillColor=" + getUnpressedFillColor() + ", " + super.toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public Color getPressedFillColor() {
        return pressedFillColor;
    }

    public void setPressedFillColor(Color pressedFillColor) {
        this.pressedFillColor = pressedFillColor;
    }

    public Color getUnpressedFillColor() {
        return unpressedFillColor;
    }

    public void setUnpressedFillColor(Color unpressedFillColor) {
        this.unpressedFillColor = unpressedFillColor;
    }

}
