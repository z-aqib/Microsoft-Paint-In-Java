package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import java.awt.*;

/*
"ShapePolygon" is a class that declares and paints a polygon on the graphics panel.
This class will be used to extend any shape that has equal to or more than three sides. 
It declares the seven basic properties of any shape, such as its number of sides, 
its array of x values, its array of y values, and two arrays of x and y values that form a smaller 
polygon so that it can be painted in the fill color. Then it declares the border color and 
the fill color of the shape. 
When constructor is called, it declares all values as 0/null. It contains a method 
of 'setValues' for the user to call and set each attribute of the polygon.
It also contains methods to set colors and arrays to set each attrbute. 
It contains a method paint, which paints the x values and y values arrays in the border 
color then repaints the fill x and fill y values arrays in the fill color.
 */
public class ShapePolygon implements InterfaceShape {

    private int sides; // number of sides of the polygon
    private int[] xValues; // original x values of the polygon
    private int[] yValues; // original y values of the polygon
    private int[] fillX; // closer x values of the polygon for filling
    private int[] fillY; // closer y values of the polygon for filling
    private Color fillColor; // color that will be used to fill the polygon
    private Color borderColor; // color that will be used for the border of the polygon

    public ShapePolygon() {

        /*
        This is a constructor with no parameters.
        Whenever this class will be called, all the attributes will be declares 0/null
        and colors will be set to default. 
         */
        this.sides = 0;
        int[] nullArray = {0};
        this.xValues = nullArray;
        this.yValues = nullArray;
        this.fillX = nullArray;
        this.fillY = nullArray;
        this.borderColor = Color.BLACK;
        this.fillColor = Color.WHITE;

    }

    public void setValues(int sides, int[] xValues, int[] yValues, int[] fillX,
            int[] fillY, Color fillColor, Color borderColor) {

        /*
        This method is to allow the progammer to set its polygon as per choice. It 
        takes all the attributes as parameters and sets them in the class object. 
         */
        setSides(sides);
        setxValues(xValues);
        setyValues(yValues);
        setFillX(fillX);
        setFillY(fillY);
        setBorderColor(borderColor);
        setFillColor(fillColor);

    }
    
    public void setColorsAndSides(Color borderColor, Color fillColor, int sides) {
        
        /*
        this method sets the colors and the sides to the polygon. 
        */
        
        setBorderColor(borderColor);
        setFillColor(fillColor);
        setSides(sides);
        
    }

    @Override
    public void paint(Graphics g) {

        /*
        this method paints the polygon. First it paints the normal polygon in border 
        color, then it paints the polygon smaller in the filling color. 
         */
        g.setColor(getBorderColor());
        g.fillPolygon(getxValues(), getyValues(), getSides());
        g.setColor(getFillColor());
        g.fillPolygon(getFillX(), getFillY(), getSides());

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

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

    public int[] getFillX() {
        return fillX;
    }

    public void setFillX(int[] fillX) {
        this.fillX = fillX;
    }

    public int[] getFillY() {
        return fillY;
    }

    public void setFillY(int[] fillY) {
        this.fillY = fillY;
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

}
