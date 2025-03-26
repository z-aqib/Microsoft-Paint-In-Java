package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import java.awt.*;

/*

 */
public class ShapeTriangle extends ShapePolygon implements InterfaceShape {

    private int width; // widtn of shape
    private int height; // height of shape
    private ZPoint topLeft; // top left point of shape
    private int borderWidth; // width of border of shape

    public ShapeTriangle(int width, int height, ZPoint topLeft, Color fillColor,
            Color borderColor, int borderWidth) {

        /*
        This is a constructor with 6 parameters. 
        this constuctor intialises all the respective given values of width, height, 
        topLeft point, fill color, border color, and border width.
        then it sets the default sides of a triangle as 3. 
        then it declares all the 4 arrays of coordinate values as size 3. 
         */
        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.borderWidth = borderWidth;

        setColorsAndSides(borderColor, fillColor, 3);
//        this.xValues = new int[getSides()];
//        this.yValues = new int[getSides()];
//        this.fillX = new int[getSides()];
//        this.fillY = new int[getSides()];

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(getBorderColor());
        g.fillPolygon(getxValues(), getyValues(), getSides());
        g.setColor(getFillColor());
        g.fillPolygon(getFillX(), getFillY(), getSides());

    }

    @Override
    public String toString() {
        return "ShapeTriangle{" + "width=" + getWidth() + ", height=" + getHeight()
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

}
