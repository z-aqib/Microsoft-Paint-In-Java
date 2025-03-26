package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import java.awt.*;
import Classes1Primary.*;

/*

 */
public class ShapeHexagon extends ShapePolygon {

    private int width; // widtn of shape
    private int height; // height of shape
    private ZPoint topLeft; // top left point of shape
    private int borderWidth; // width of border of shape

    private int radius;
    private ZPoint center;

    public ShapeHexagon(int width, int height, ZPoint topLeft, Color fillColor,
            Color borderColor, int borderWidth) {

        this.width = width;
        this.height = height;
        this.topLeft = topLeft;
        this.borderWidth = borderWidth;

        setColorsAndSides(borderColor, fillColor, 6);
        computeRadius();
        this.center = new ZPoint(topLeft.getX() + getRadius(), topLeft.getY() + getRadius());
        computeHexagon();
        setFill();

    }

    private void computeRadius() {

        int diameter = Math.min(getWidth(), getHeight());
        int radiuss = diameter / 2;
        this.radius = radiuss;

    }

    private void computeHexagon() {

        int[] xValues = new int[getSides()];
        int[] yValues = new int[getSides()];
        xValues[0] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(0)));
        yValues[0] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(0)));

        xValues[1] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(60)));
        yValues[1] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(60)));

        xValues[2] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(120)));
        yValues[2] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(120)));

        xValues[3] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(180)));
        yValues[3] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(180)));

        xValues[4] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(240)));
        yValues[4] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(240)));

        xValues[5] = getCenter().getX() + (int) (getRadius() * Math.cos(Math.toRadians(300)));
        yValues[5] = getCenter().getY() + (int) (getRadius() * Math.sin(Math.toRadians(300)));
        
        setxValues(xValues);
        setyValues(yValues);

    }

    private void setFill() {

        int[] fillX = new int[getSides()];
        int[] fillY = new int[getSides()];
        // first: x dec, y same
        fillX[0] = getxValues()[0] - getBorderWidth();
        fillY[0] = getyValues()[0];
        // second: x dec, y inc
        fillX[1] = getxValues()[1] - getBorderWidth();
        fillY[1] = getyValues()[1] - getBorderWidth();
        // third: x inc, y inc
        fillX[2] = getxValues()[2] + getBorderWidth();
        fillY[2] = getyValues()[2] - getBorderWidth();
        // fourth: x inc
        fillX[3] = getxValues()[3] + getBorderWidth();
        fillY[3] = getyValues()[3];
        // fifth: x inc, y dec
        fillX[4] = getxValues()[4] + getBorderWidth();
        fillY[4] = getyValues()[4] + getBorderWidth();
        // sixth: x dec, y dec
        fillX[5] = getxValues()[5] - getBorderWidth();
        fillY[5] = getyValues()[5] + getBorderWidth();
        
        setFillX(fillX);
        setFillY(fillY);

    }

    @Override
    public String toString() {
        return "ShapeHexagon{" + "width=" + getWidth() + ", height=" + getHeight()
                + ", topLeft=" + getTopLeft().toString() + ", fillColor="
                + getFillColor().toString() + ", borderColor="
                + getBorderColor().toString() + ", borderWidth=" + getBorderWidth() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public ZPoint getCenter() {
        return center;
    }

    public void setCenter(ZPoint center) {
        this.center = center;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }

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

}
