package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import java.awt.*;

/*
"ShapeCircle" is a class that declares and paints a circle on the graphics panel. 
It declares some basic general properties of any shape, such as width, height, topLeft point, 
filling color, border color, and border width.
Then it computes the radius of the circle by finding the minimum value of width and height and dividing by 2
as diameter is double of radius
Then it paints a circle with the calculated radius * 2 and the given topLeft point respectively. 
 */
public class ShapeCircle implements InterfaceShape {

    private int width; // widtn of shape
    private int height; // height of shape
    private ZPoint topLeft; // top left point of shape
    private Color fillColor; // filling color of shape
    private Color borderColor; // border color of shape
    private int borderWidth; // width of border of shape

    private int radius; // radius of circle

    public ShapeCircle(int width, int height, ZPoint topLeft, Color fillColor,
            Color borderColor, int borderWidth) {

        /*
        This is a constructor with 6 parameters. 
        this constuctor intialises all the respective given values of width, height, 
        topLeft point, fill color, border color, and border width.
        then it calculates and intialises the radius of the circle. 
         */
        this.width = width;
        this.height = height;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.topLeft = topLeft;
        this.borderWidth = borderWidth;

        computeRadius();

    }

    private void computeRadius() {

        /*
        this method computes the diameter of the circle by finding the minimumm of width 
        and height of shape. then it computes the radius by halving the diameter. 
        then it intialises the attribute of circle 'radius' as its value. 
         */
        int diameter = Math.min(getWidth(), getHeight());
        this.radius = diameter / 2;

    }

    @Override
    public void paint(Graphics g) {

        /*
        this method paints the circle on the screen. it first paints the circle as it 
        is in the border color. then it paints a second circle, this time in the 
        filling color, that is borderWidth smaller than the first circle. this can be
        done by using x and y coordinates that are borderWidth greater than the current 
        x and y coordinates, and with radius that is double the borderWidth smaller 
        than the current radius. 
         */
        // first paint the first circle in border color
        g.setColor(getBorderColor());
        g.fillOval(getTopLeft().getX(), getTopLeft().getY(),
                getRadius() * 2, getRadius() * 2);

        // then paint the second circle in fill color
        g.setColor(getFillColor());
        g.fillOval(getTopLeft().getX() + getBorderWidth(),
                getTopLeft().getY() + getBorderWidth(),
                (getRadius() * 2) - (2 * getBorderWidth()),
                (getRadius() * 2) - (2 * getBorderWidth()));

    }

    @Override
    public String toString() {
        return "ShapeCircle{" + "width=" + getWidth() + ", height=" + getHeight()
                + ", topLeft=" + getTopLeft().toString() + ", fillColor="
                + getFillColor().toString() + ", borderColor="
                + getBorderColor().toString() + ", borderWidth=" + getBorderWidth() + '}';
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

    public ZPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(ZPoint topLeft) {
        this.topLeft = topLeft;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
