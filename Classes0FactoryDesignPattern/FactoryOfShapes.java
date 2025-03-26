package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import java.awt.*;

/*
"Factory of Shapes" is a class that implements FactoryDesignPattern.
It creates a shape based on the name, width, height, topLeft point, fillColor, 
borderColor, and borderWidth and then returns the shape. 
It only contains one method to create a return a shape.
 */
public class FactoryOfShapes {

    public InterfaceShape getShape(String str, int width, int height, ZPoint topLeft,
            Color fillColor, Color borderColor, int borderWidth) {

        /*
        so a shape is created and declared null. Then, based on the name of the shape, 
        the shape is created and return.
        if the name does not equal to any shape, then the shape returned is null. 
         */
        InterfaceShape shape = null;

        if (str.equalsIgnoreCase("RIGHT ANGLED TRIANGLE")
                || str.equalsIgnoreCase("ShapeRightAngledTriangle")) {
            shape = new ShapeTriangleRightAngled(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        } else if (str.equalsIgnoreCase("EQUILATERAL TRIANGLE")
                || str.equalsIgnoreCase("ShapeEquilateralTriangle")) {
            shape = new ShapeTriangleEquilateral(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        } else if (str.equalsIgnoreCase("RECTANGLE")
                || str.equalsIgnoreCase("ShapeRectangle")) {
            shape = new ShapeRectangle(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        } else if (str.equalsIgnoreCase("CIRCLE")
                || str.equalsIgnoreCase("ShapeCircle")) {
            shape = new ShapeCircle(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        } else if (str.equalsIgnoreCase("HEXAGON")
                || str.equalsIgnoreCase("ShapeHexagon")) {
            shape = new ShapeHexagon(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        } else if (str.equalsIgnoreCase("PENTAGRAM")
                || str.equalsIgnoreCase("ShapePentagram")) {
            shape = new ShapePentagram(width, height, topLeft,
                    fillColor, borderColor, borderWidth);
        }

        return shape;

    }

}
