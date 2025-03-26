package Classes2Secondary;

import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class RGBValues {

    private ZLabel red;
    private ZLabel green;
    private ZLabel blue;
    private ZLabelColored redValue;
    private ZLabelColored greenValue;
    private ZLabelColored blueValue;

    public RGBValues(ZPoint startingPoint) {

        int redX = startingPoint.getX() + 10;
        int redY = startingPoint.getY() + 10;
        this.red = new ZLabel("Red = ", redX, redY);
        int greenX = redX - 10;
        int greenY = redY + 25;
        this.green = new ZLabel("Green = ", greenX, greenY);
        int blueX = greenX + 9;
        int blueY = greenY + 25;
        this.blue = new ZLabel("Blue = ", blueX, blueY);

        int boxX = (8 * 5) + 7 + greenX;
        this.redValue = new ZLabelColored("0", boxX, redY + 5);
        this.greenValue = new ZLabelColored("0", boxX, greenY + 5);
        this.blueValue = new ZLabelColored("0", boxX, blueY + 5);
        this.redValue.getBack().setWidth((1 * 20) + 10);
        this.blueValue.getBack().setWidth((1 * 20) + 10);
        this.greenValue.getBack().setWidth((1 * 20) + 10);

    }

    public void paint(Graphics g) {

        this.red.paint(g);
        this.green.paint(g);
        this.blue.paint(g);
        this.redValue.paint(g);
        this.greenValue.paint(g);
        this.blueValue.paint(g);

    }

    public boolean updateValues(ZRectangle color) {

        int redd = color.getFillColor().getRed();
        int bluee = color.getFillColor().getBlue();
        int greenn = color.getFillColor().getGreen();
        this.redValue.setText(redd + "");
        this.blueValue.setText(bluee + "");
        this.greenValue.setText(greenn + "");
        return true;

    }

    public ZLabel getRed() {
        return red;
    }

    public void setRed(ZLabel red) {
        this.red = red;
    }

    public ZLabel getGreen() {
        return green;
    }

    public void setGreen(ZLabel green) {
        this.green = green;
    }

    public ZLabel getBlue() {
        return blue;
    }

    public void setBlue(ZLabel blue) {
        this.blue = blue;
    }

    public ZLabelColored getRedValue() {
        return redValue;
    }

    public void setRedValue(ZLabelColored redValue) {
        this.redValue = redValue;
    }

    public ZLabelColored getGreenValue() {
        return greenValue;
    }

    public void setGreenValue(ZLabelColored greenValue) {
        this.greenValue = greenValue;
    }

    public ZLabelColored getBlueValue() {
        return blueValue;
    }

    public void setBlueValue(ZLabelColored blueValue) {
        this.blueValue = blueValue;
    }

}
