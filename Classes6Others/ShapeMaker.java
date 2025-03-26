package Classes6Others;

import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.Color;

public class ShapeMaker {

    private FactoryOfShapes shapeFactory;
    private PanelUpper upperPanel;

    public ShapeMaker(PanelUpper upperPanel) {

        this.shapeFactory = new FactoryOfShapes();
        this.upperPanel = upperPanel;

    }

    public InterfaceShape makeShape(ZPoint startingPoint, int userx, int usery) {

        Color borderColor = this.upperPanel.getColorInColor1().getFillColor();
        Color fillColor = this.upperPanel.getColorInColor2().getFillColor();
        int strokeSize = (this.upperPanel.getStrokewidth().getSelectedStroke() + 2) * 2;
        int width = Math.abs(userx - startingPoint.getX());
        int height = Math.abs(usery - startingPoint.getY());
        InterfaceShape shape = null;
        switch (this.upperPanel.getShapesPanel().getIndex()) {
            case 0 -> {
                shape = this.shapeFactory.getShape("RIGHT ANGLED TRIANGLE",
                        width, height, startingPoint, fillColor, borderColor,
                        strokeSize);
            }
            case 1 -> {
                shape = this.shapeFactory.getShape("EQUILATERAL TRIANGLE",
                        width, height, startingPoint, fillColor, borderColor,
                        strokeSize);
            }
            case 2 -> {
                shape = this.shapeFactory.getShape("Rectangle",
                        width, height, startingPoint, fillColor,
                        borderColor, strokeSize);
            }
            case 3 -> {
                shape = this.shapeFactory.getShape("Circle",
                        width, height, startingPoint, fillColor,
                        borderColor, strokeSize);
            }
            case 4 -> {
                shape = this.shapeFactory.getShape("HEXAGON",
                        width, height, startingPoint, fillColor,
                        borderColor, strokeSize);
            }
            case 5 -> {
                shape = this.shapeFactory.getShape(
                        "PENTAGRAM", width, height, startingPoint,
                        fillColor, borderColor, strokeSize);
            }

        }

        return shape;

    }

    public InterfaceShape makeFreehandShape(int userx, int usery) {

        Color borderColor = this.upperPanel.getColorInColor1().getFillColor();
        int strokeSize = (this.upperPanel.getStrokewidth().getSelectedStroke() + 2) * 2;
        InterfaceShape shape = this.shapeFactory.getShape("CIRCLE", strokeSize, strokeSize,
                new ZPoint(userx, usery), borderColor, borderColor, strokeSize);
        return shape;

    }

    public String shapeDetails(InterfaceShape shape) {

        String str = "";

        if (shape instanceof ShapeTriangleRightAngled shapeRightAngledTriangle) {
            str = "Right Angled Triangle: width="
                    + shapeRightAngledTriangle.getWidth() + " height="
                    + shapeRightAngledTriangle.getHeight();
        } else if (shape instanceof ShapeTriangleEquilateral shapeEquilateralTriangle) {
            str = "Equilateral Triangle: width="
                    + shapeEquilateralTriangle.getRadius() + " height="
                    + shapeEquilateralTriangle.getRadius();
        } else if (shape instanceof ShapeRectangle shapeRectangle) {
            str = "Rectangle: width=" + shapeRectangle.getWidth() + " height="
                    + shapeRectangle.getHeight();
        } else if (shape instanceof ShapeCircle shapeCircle) {
            str = "Circle: radius=" + shapeCircle.getRadius();
        } else if (shape instanceof ShapeHexagon shapeHexagon) {
            str = "Hexagon: radius=" + shapeHexagon.getRadius();
        } else if (shape instanceof ShapePentagram shapePentagram) {
            str = "Pentagram: radius=" + shapePentagram.getRadius();
        }
        return str;

    }

    public FactoryOfShapes getShapeFactory() {
        return shapeFactory;
    }

    public void setShapeFactory(FactoryOfShapes shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public PanelUpper getUpperPanel() {
        return upperPanel;
    }

    public void setUpperPanel(PanelUpper upperPanel) {
        this.upperPanel = upperPanel;
    }

}
