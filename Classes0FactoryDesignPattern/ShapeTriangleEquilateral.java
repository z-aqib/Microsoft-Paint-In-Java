package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.Color;

public class ShapeTriangleEquilateral extends ShapeTriangle {

    private int radius;

    public ShapeTriangleEquilateral(int width, int height, ZPoint topLeft,
            Color fillColor, Color borderColor, int borderWidth) {

        super(width, height, topLeft, fillColor, borderColor, borderWidth);
        this.radius = Math.min(width, height);
        computeEquilateral();
        fill();

    }

    private void computeEquilateral() {

        int[] xvalues = new int[getSides()];
        int[] yvalues = new int[getSides()];

        // first x point is midway of topleft and width, y point is same as topleft
        xvalues[0] = getTopLeft().getX() + (this.radius / 2);
        yvalues[0] = getTopLeft().getY();
        // second x point is same as topleft, y point is topleft+height
        xvalues[1] = getTopLeft().getX();
        yvalues[1] = yvalues[0] + this.radius;
        // third x point is topleft+width, y point is same as second y point
        xvalues[2] = xvalues[1] + this.radius;
        yvalues[2] = yvalues[1];

        setxValues(xvalues);
        setyValues(yvalues);

    }

    private void fill() {

        int[] originalX = getxValues();
        int[] originalY = getyValues();
        int[] fillX = new int[getSides()];
        int[] fillY = new int[getSides()];
        int borderSize = getBorderWidth();

        // first point: x same, y inc
        fillX[0] = originalX[0];
        fillY[0] = originalY[0] + borderSize;
        // second point: x inc, y dec
        fillX[1] = originalX[1] + (borderSize * 2);
        fillY[1] = originalY[1] - borderSize;
        // third point: x dec, y dec
        fillX[2] = originalX[2] - (borderSize * 2);
        fillY[2] = originalY[2] - borderSize;

        setFillX(fillX);
        setFillY(fillY);

    }

    @Override
    public String toString() {
        return "ShapeEquilateralTriangle" + super.toString();
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
