package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import java.awt.*;

/*
"ShapeRectangle" is a class that declares and paints a rectangle on the graphics panel. 
It declares some basic general properties of any shape, such as width, height, topLeft point, 
filling color, border color, and border width.
Then it paints a rectangle with the given width, height and topLeft respectively. 
 */
public class ShapeRectangle implements InterfaceShape {

    private int width; // widtn of shape
    private int height; // height of shape
    private ZPoint topLeft; // top left point of shape
    private Color fillColor; // filling color of shape
    private Color borderColor; // border color of shape
    private int borderWidth; // width of border of shape

    public ShapeRectangle(int width, int height, ZPoint topLeft, Color fillColor,
            Color borderColor, int borderWidth) {

        /*
        This is a constructor with 6 parameters. 
        This constuctor intialises all the respective given values of width, height, 
        topLeft point, fill color, border color, and border width.
         */
        this.topLeft = topLeft;
        this.height = height;
        this.width = width;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;

    }

    @Override
    public void paint(Graphics g) {

        /*
        this method paints the rectangle on the screen. it first paints the circle as it 
        is in the border color. then it paints a second rectangle, this time in the 
        filling color, that is borderWidth smaller than the first rectangle. this can be
        done by using x and y coordinates that are borderWidth greater than the current 
        x and y coordinates, and with width and height that is double the borderWidth smaller 
        than the current width and height. 
         */
        // first paint the larger rectangle in the border color
        g.setColor(getBorderColor());
        g.fillRect(getTopLeft().getX(), getTopLeft().getY(),
                getWidth(), getHeight());
        // then paint the smaller rectangle in the filler color
        g.setColor(getFillColor());
        g.fillRect((getTopLeft().getX() + getBorderWidth()),
                getTopLeft().getY() + getBorderWidth(),
                getWidth() - (getBorderWidth() * 2),
                getHeight() - (getBorderWidth() * 2));

    }

    @Override
    public String toString() {
        return "ShapeRectangle{" + "width=" + getWidth() + ", height=" + getHeight()
                + ", topLeft=" + getTopLeft().toString() + ", fillColor="
                + getFillColor().toString() + ", borderColor="
                + getBorderColor().toString() + ", borderWidth=" + getBorderWidth() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZPoint getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(ZPoint topLeft) {
        this.topLeft = topLeft;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

}
