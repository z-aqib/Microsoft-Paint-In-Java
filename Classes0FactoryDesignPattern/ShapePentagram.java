package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import java.awt.*;

public class ShapePentagram implements InterfaceShape {

    private int width; // widtn of shape
    private int height; // height of shape
    private ZPoint topLeft; // top left point of shape
    private Color fillColor; // filling color of shape
    private Color borderColor; // border color of shape
    private int borderWidth; // width of border of shape

    private int[] xValues;
    private int[] yValues;
//    private int[] fillX;
//    private int[] fillY;
    private int sides;
    private int radius;
    private ZPoint center;

    public ShapePentagram(int width, int height, ZPoint topLeft, Color fillColor,
            Color borderColor, int borderWidth) {

        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.topLeft = topLeft;
        this.borderWidth = borderWidth;

        this.sides = 5;
        computeRadius();
        this.center = new ZPoint(topLeft.getX() + getRadius(), topLeft.getY() + getRadius());
        computePentagon();
        computePentagram();

    }

    private void computeRadius() {

        int diameter = Math.min(getWidth(), getHeight());
        int radiuss = diameter / 2;
        this.radius = radiuss;

    }

    private void computePentagon() {

        this.xValues = new int[sides];
        this.yValues = new int[sides];
        int counter = 0;
        while (counter < sides) {
            this.xValues[counter] = ((center.getX()
                    + (int) (getRadius() * Math.cos(Math.toRadians((counter) * 72)))));
            this.yValues[counter] = ((center.getY()
                    + (int) (getRadius() * Math.sin(Math.toRadians((counter) * 72)))));
            counter++;
        }

    }

    private void computePentagram() {

        int[] x_pentagram = {xValues[0], xValues[2], xValues[4], xValues[1], xValues[3]};
        int[] y_pentagram = {yValues[0], yValues[2], yValues[4], yValues[1], yValues[3]};
        this.xValues = x_pentagram;
        this.yValues = y_pentagram;

    }
//    public void fillValues() {
//        
//        this.fillX = new int[sides];
//        this.fillY = new int[sides];
//        
//        // so the first point moves borderwidth x inc, y dec
//        this.fillX[0] = this.xValues[0] + borderWidth;
//        this.fillY[0] = this.yValues[0] - borderWidth;
//        // second: xdec, y inc
//        this.fillX[1] = this.xValues[1] - borderWidth;
//        this.fillY[1] = this.yValues[1] + borderWidth;
//        // third: xdec, y dec
//        this.fillX[2] = this.xValues[2] - borderWidth;
//        this.fillY[2] = this.yValues[2] - borderWidth;
//        // fourth: x inc, y inc
//        this.fillX[3] = this.xValues[3] + borderWidth;
//        this.fillY[3] = this.yValues[3] + borderWidth;
//        // fifth: xdec, y dec
//        this.fillX[4] = this.xValues[4] - borderWidth;
//        this.fillY[4] = this.yValues[4] - borderWidth;
//        
//        
//    }
    @Override
    public void paint(Graphics g) {

        g.setColor(getBorderColor());
        g.fillPolygon(getxValues(), getyValues(), getSides());

//        g.setColor(this.fillColor);
//        g.fillPolygon(fillX, fillY, sides);
    }

    @Override
    public String toString() {
        return "ShapePentagram{" + "width=" + getWidth() + ", height=" + getHeight()
                + ", topLeft=" + getTopLeft().toString() + ", fillColor="
                + getFillColor().toString() + ", borderColor="
                + getBorderColor().toString() + ", borderWidth=" + getBorderWidth() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int[] getxValues() {
        return xValues;
    }

    public void setxValues(int[] xValues) {
        this.xValues = xValues;
    }

    public int[] getyValues() {
        return yValues;
    }

    public void setyValues(int[] yValues) {
        this.yValues = yValues;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
