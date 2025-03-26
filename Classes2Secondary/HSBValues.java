package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class HSBValues {

    private ZLabel hue;
    private ZLabel saturation;
    private ZLabel brightness;
    private ZLabelColored hueValue;
    private ZLabelColored saturationValue;
    private ZLabelColored brightnessValue;

    public HSBValues(ZPoint startingPoint) {

        int hueX = startingPoint.getX() + 10;
        int hueY = startingPoint.getY() + 10;
        this.hue = new ZLabel("Hue = ", hueX, hueY);
        int satX = hueX;
        int satY = hueY + 25;
        this.saturation = new ZLabel("Sat = ", satX, satY);
        int briX = satX - 5;
        int briY = satY + 25;
        this.brightness = new ZLabel("Lum = ", briX, briY);

        int boxX = (8 * 5) + 2 + briX;
        this.hueValue = new ZLabelColored("0", boxX, hueY + 5);
        this.saturationValue = new ZLabelColored("0", boxX, satY + 5);
        this.brightnessValue = new ZLabelColored("0", boxX, briY + 5);
        this.hueValue.getBack().setWidth((1 * 20) + 10);
        this.saturationValue.getBack().setWidth((1 * 20) + 10);
        this.brightnessValue.getBack().setWidth((1 * 20) + 10);

    }

    public void paint(Graphics g) {

        this.hue.paint(g);
        this.saturation.paint(g);
        this.brightness.paint(g);
        this.hueValue.paint(g);
        this.saturationValue.paint(g);
        this.brightnessValue.paint(g);

    }

    public boolean updateValues(ZRectangle color) {

        Color c = color.getFillColor();
        float[] HSBValues = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);

        this.hueValue.setText((int) (HSBValues[0] * 255) + "");
        this.saturationValue.setText((int) (HSBValues[1] * 255) + "");
        this.brightnessValue.setText((int) (HSBValues[2] * 255) + "");
        return true;

    }

}
