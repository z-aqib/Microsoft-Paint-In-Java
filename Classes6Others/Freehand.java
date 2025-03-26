package Classes6Others;

import Classes1Primary.*;
import Classes0FactoryDesignPattern.*;
import java.awt.*;

public class Freehand implements InterfaceShape {

    private ZStack circles = new ZStack();
    private FactoryOfShapes shapeFactory;

    public Freehand() {

        this.shapeFactory = new FactoryOfShapes();

    }

    public void addShape(int width, int height, ZPoint topLeft, Color fillcolor,
            Color bordercolor, int borderSize) {

        InterfaceShape shape = this.shapeFactory.getShape("CIRCLE", width, height, topLeft,
                fillcolor, bordercolor, borderSize);
        this.circles.push(shape);

    }

    public void addShape(InterfaceShape shape) {

        this.circles.push(shape);

    }

    public void clearFreehand() {

        this.circles.clear();

    }

    @Override
    public void paint(Graphics g) {

        circles.paintStack(g); 

    }

    @Override
    public String toString() {
        return circles.toString();
    }
    
    

}
