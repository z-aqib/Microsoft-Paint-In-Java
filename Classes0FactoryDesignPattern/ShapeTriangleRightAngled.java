package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ShapeTriangleRightAngled extends ShapeTriangle {

    public ShapeTriangleRightAngled(int width, int height, ZPoint topLeft,
            Color fillColor, Color borderColor, int borderWidth) {

        super(width, height, topLeft, fillColor, borderColor, borderWidth);
        computeRightAngled();
        fill();

    }

    private void computeRightAngled() {

        int[] xvalues = new int[getSides()];
        int[] yvalues = new int[getSides()];

        xvalues[0] = getTopLeft().getX();
        yvalues[0] = getTopLeft().getY();
        
        xvalues[1] = xvalues[0];
        yvalues[1] = yvalues[0] + getHeight();
        
        xvalues[2] = xvalues[1] + getWidth();
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

        // first point: x inc, y inc
        fillX[0] = originalX[0] + borderSize;
        fillY[0] = originalY[0] + (borderSize * 2);
        // second point: x inc, y dec
        fillX[1] = originalX[1] + borderSize;
        fillY[1] = originalY[1] - borderSize;
        // third point: x dec, y dec
        fillX[2] = originalX[2] - (borderSize * 3);
        fillY[2] = originalY[2] - borderSize;

        setFillX(fillX);
        setFillY(fillY);

    }

    @Override
    public String toString() {
        return "ShapeRightAngledTriangle" + super.toString();
    }
    
    
    

}
