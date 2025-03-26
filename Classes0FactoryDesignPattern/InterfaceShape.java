package Classes0FactoryDesignPattern;

// FACTORY DESIGN CLASSES: the class used for making, drawing and painting shapes
import java.awt.*;

public interface InterfaceShape {

    public void paint(Graphics g);

    @Override
    public String toString();

}
