package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ColorValues {

    private RGBValues rgb;
    private HSBValues hsb;

    public ColorValues(ZPoint startingPoint) {

        this.rgb = new RGBValues(startingPoint);
        this.hsb = new HSBValues(new ZPoint(startingPoint.getX(), startingPoint.getY() + 75));

    }

    public void paint(Graphics g) {

        this.hsb.paint(g);
        this.rgb.paint(g);

    }

    public void updateValues(ZRectangle color) {

        this.rgb.updateValues(color);
        this.hsb.updateValues(color);

    }

}
