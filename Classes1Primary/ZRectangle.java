package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ZRectangle {

    /*
    these are same as buttons, except instead of images, they are filled with a color. 
    when clicked/moved, they change their border color. originally each ZRectangle is 
    white bordered, when clicked or hovered on, they change border color to black. 
    there are two types of ZRectangle: active and toggle. 
    it is basically the fillRect method, except it is also a button
     */
    private String name; // the name of the color button
    private ZPoint topLeft; // its topleft point
    private ZPoint maximum; // maximum point of the rectangle
    private int width; // width of the rectangle
    private int height; // height of the rectangle
    private Color fillColor; // fill color of the rectangle
    private Color unpressedBorderColor; // depressed state
    private Color pressedBorderColor; // pressed state
    private Color currentBorderColor; // current state

    public ZRectangle(String name, int x, int y, int width, int height, Color c) {

        this(name, new ZPoint(x, y), width, height, c);

    }

    public ZRectangle(String name, ZPoint p, int width, int height, Color c) {

        this.name = name;
        this.topLeft = new ZPoint(p.getX() - 1, p.getY() - 2);
        this.width = width - 1;
        this.height = height + 1;
        this.fillColor = c;
        this.unpressedBorderColor = Color.WHITE; // default unpressed is white
        this.pressedBorderColor = Color.BLACK; // default pressed is black
        this.currentBorderColor = this.unpressedBorderColor;
        computeMaximum(); // compute maximum point of ZRectangle

    }

    private void computeMaximum() {

        /*
        this point computes the maximum point of the ZRectangle.
        the max x point is found by topLeft + width
        the max y point is found by topLeft + height
         */
        int maxX = getTopLeft().getX() + getWidth();
        int maxY = getTopLeft().getY() + getHeight();
        this.maximum = new ZPoint(maxX, maxY);

    }

    public void paintRectangle(Graphics g) {

        // first create a normal rectangle of the given size but in border color. 
        g.setColor(getCurrentBorderColor());
        g.fillRect((getTopLeft().getX() + 1), (getTopLeft().getY() + 2),
                (getWidth() + 1), (getHeight() - 1));

        // now create another rectangle (to create a border around the color). the previous border is size 1
        g.setColor(getPressedBorderColor());
        g.fillRect(((getTopLeft().getX() + 1) + 1), (getTopLeft().getY() + 2) + 1,
                (getWidth() + 1) - 2, (getHeight() - 1) - 2);

        // now create the last rectangle of the fill color. the previous border is also size 1
        g.setColor(getFillColor());
        g.fillRect((getTopLeft().getX() + 1) + 2, (getTopLeft().getY() + 2) + 2,
                (getWidth() + 1) - (2 * 2), (getHeight() - 1) - (2 * 2));

        // set the color back to black
        g.setColor(Color.BLACK);

    }

    public void paintPanel(Graphics g) {

        /*
        this method paints the panel of the specified border color, by filling a 
        rectangle of the required coordinates, width and height.
        then it paints a black border around the entire panel
         */
        // first it will paint the background color of a rectangle
        g.setColor(getFillColor());
        g.fillRect(getTopLeft().getX(), getTopLeft().getY(),
                getWidth(), getHeight());
        // then it will paint a border
        g.setColor(Color.BLACK);
        g.drawRect(getTopLeft().getX(), getTopLeft().getY(),
                getWidth(), getHeight());
        // then it sets the color back to black
        g.setColor(Color.BLACK);

    }

    public boolean IfInBorders(int userX, int userY) {

        if (userX >= getTopLeft().getX()
                && userX <= getMaximum().getX()
                && userY >= getTopLeft().getY()
                && userY <= getMaximum().getY()) {
            return true;
        } else {
            return false;
        }
    }

    public void setTopLeft(ZPoint topLeft) {

        this.topLeft = topLeft;
        computeMaximum();

    }

    @Override
    public String toString() {
        return "ZRectangle{" + "name=" + getName() + ", topLeft=" + getTopLeft().toString() + ", maximum="
                + getMaximum().toString() + ", width=" + getWidth() + ", height=" + getHeight() + ", fillColor="
                + getFillColor().toString() + ", unpressedBorderColor=" + getUnpressedBorderColor().toString()
                + ", pressedBorderColor=" + getPressedBorderColor().toString() + ", currentBorderColor="
                + getCurrentBorderColor() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getUnpressedBorderColor() {
        return unpressedBorderColor;
    }

    public void setUnpressedBorderColor(Color unpressedBorderColor) {
        this.unpressedBorderColor = unpressedBorderColor;
    }

    public Color getPressedBorderColor() {
        return pressedBorderColor;
    }

    public void setPressedBorderColor(Color pressedBorderColor) {
        this.pressedBorderColor = pressedBorderColor;
    }

    public Color getCurrentBorderColor() {
        return currentBorderColor;
    }

    public void setCurrentBorderColor(Color currentBorderColor) {
        this.currentBorderColor = currentBorderColor;
    }

    public ZPoint getMaximum() {
        return maximum;
    }

    public void setMaximum(ZPoint maximum) {
        this.maximum = maximum;
    }

    public ZPoint getTopLeft() {
        return topLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
