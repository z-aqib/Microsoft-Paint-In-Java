package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ColorGradient extends ZRectangleActiveArray {

    private ZPoint topLeftCornerGradient;
    private boolean printStatus;
    private PopUpWindow window;
    private ZRectangle selectedColor;
    private ZRectangle movingColor;
    private ColorValues selectedRGB;
    private ColorValues movedRGB;
    private ZRectangleActiveArray colorBrightness;

    public ColorGradient(Color c) {

        super();

        this.topLeftCornerGradient = new ZPoint(425, 200);
        this.window = new PopUpWindow();
        this.printStatus = false;
        this.selectedColor = new ZRectangle("Selected Color: ", 210, 210, 90,
                90, Color.BLACK);
        this.movingColor = new ZRectangle("Demo Color: ", 320, 210,
                70, 70, Color.BLACK);
        this.selectedRGB = new ColorValues(new ZPoint(
                this.selectedColor.getTopLeft().getX(), this.selectedColor.getMaximum().getY() + 30));
        this.movedRGB = new ColorValues(new ZPoint(
                this.movingColor.getTopLeft().getX() - 5, this.selectedColor.getMaximum().getY() + 30));
        intialiseColorBrightness(this.selectedColor.getFillColor());

        intializeColors();

    }

    private void intializeColors() {

        for (int h = 0; h < 256; h++) {
            float hue = (float) h / 256;
            for (int s = 0, count = 0; count < 256; s += 2, count++) {
                if (s >= 256) {
                    s = 256;
                }
                float saturation = (float) s / 256;
                Color random = Color.getHSBColor(hue, saturation, 1.0f);
                ZRectangleActive rectangle = new ZRectangleActive("Custom Color",
                        getTopLeftCornerGradient().getX() + h,
                        getTopLeftCornerGradient().getY() + (256 - count), 1,
                        1, random);
                rectangle.setUnpressedBorderColor(random);
                rectangle.setCurrentBorderColor(random);
//                rectangle.setPressedBorderColor(random);
                addButton(rectangle);
            }
        }

    }

    @Override
    public void paintToolTip(Graphics g) {

        this.window.paintToolTip(g);
        this.colorBrightness.paintToolTip(g);
        super.paintToolTip(g);

    }

    @Override
    public void paint(Graphics g) {

        this.window.paint(g);
        this.selectedColor.paintRectangle(g);
        this.movingColor.paintRectangle(g);
        g.drawString(this.selectedColor.getName(),
                this.selectedColor.getTopLeft().getX() + 5,
                this.selectedColor.getTopLeft().getY() - 5);
        g.drawString(this.movingColor.getName(),
                this.movingColor.getTopLeft().getX() + 5,
                this.movingColor.getTopLeft().getY() - 5);
        this.selectedRGB.paint(g);
        this.movedRGB.paint(g);
        this.colorBrightness.paint(g);
        super.paint(g);

    }

    @Override
    public boolean moved(int userx, int usery) {

        if (ifInBordersOfColorGradient(userx, usery) == true) {
            ifMoved(userx, usery);
            this.movingColor.setFillColor(getMovedColor().getFillColor());
            this.movedRGB.updateValues(this.movingColor);
            return true;
        }
        this.window.moved(userx, usery);
        if (this.colorBrightness.moved(userx, usery) == true) {
            this.movingColor.setFillColor(
                    this.colorBrightness.getMovedColor().getFillColor());
            this.movedRGB.updateValues(this.movingColor);
        }
        return false;

    }

    private boolean ifInBordersOfColorGradient(int userX, int userY) {

        if (userX >= getTopLeftCornerGradient().getX()
                && userX <= (getTopLeftCornerGradient().getX() + 256)
                && userY >= getTopLeftCornerGradient().getY()
                && userY <= (getTopLeftCornerGradient().getY() + 256)) {
            return true;
        } else {
            return false;
        }

    }

    private boolean ifClicked(int userx, int usery) {

        int[] Right = new int[7];
        int[] Left = new int[7];
        int[] Up = new int[7];
        int[] Down = new int[7];
        boolean iIsFound = false;

        for (int i = 0; i < getRectangles().size(); i++) {

            if (iIsFound == false) {

                if (getRectangles().get(i).ifSelected(userx, usery) == true) {

                    getRectangles().get(i).makeUnClicked();
                    iIsFound = true;
                    setCurrentColor(getRectangles().get(i));

                    int counter = 0;
                    Right[counter] = i + (256 * 10);
                    Left[counter] = i - (256 * 10);
                    int iDownCheck = (i % 256) + 10;
                    Down[counter] = i + 10;
                    int iUpCheck = (i % 256) - 10;
                    Up[counter] = i - 10;

                    while (counter <= 5) {
                        if (Right[counter] < getRectangles().size()) {
                            getRectangles().get(Right[counter]).makeClicked();
                        }
                        if (Left[counter] >= 0) {
                            getRectangles().get(Left[counter]).makeClicked();
                        }
                        if (iDownCheck <= 256) {
                            getRectangles().get(Down[counter]).makeClicked();
                        }
                        if (iUpCheck >= 0) {
                            getRectangles().get(Up[counter]).makeClicked();
                        }

                        counter++;
                        Right[counter] = Right[counter - 1] + 256;
                        Left[counter] = Left[counter - 1] - 256;
                        iDownCheck = (Down[counter - 1] % 256) + 1;
                        Down[counter] = Down[counter - 1] + 1;
                        iUpCheck = (Up[counter - 1] % 256) - 1;
                        Up[counter] = Up[counter - 1] - 1;

                    }

                }

            } else {

                boolean right = compareIntAndArray(i, Right);
                boolean left = compareIntAndArray(i, Left);
                boolean up = compareIntAndArray(i, Up);
                boolean down = compareIntAndArray(i, Down);
                if (right == false && left == false && up == false && down == false) {
                    getRectangles().get(i).makeUnClicked();
                }

            }

        }

        return true;

    }

    public boolean ifMoved(int userx, int usery) {

        for (int i = 0; i < getRectangles().size(); i++) {
            if (getRectangles().get(i).IfInBorders(userx, usery) == true) {
                setMovedColor(getRectangles().get(i));
                String str = "r=" + getMovedColor().getFillColor().getRed() + ", g="
                        + getMovedColor().getFillColor().getGreen() + ", b="
                        + getMovedColor().getFillColor().getBlue();
                getMovedColor().getToolTip().declareLabel(str, new ZPoint(userx, usery));
                getMovedColor().setToolTipPrint(true);
                return true;
            }
        }
        return false;

    }

    private boolean compareIntAndArray(int index, int[] values) {

        boolean same = false;
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            if (index == value) {
                same = true;
            }
        }
        return same;

    }

    public boolean clicked(int userx, int usery) {

        if (getWindow().clicked(userx, usery) == true) {
            this.printStatus = false;
            System.out.println("ColorGradient is closed");
            return false;
        } else {
            this.printStatus = true;
            if (ifInBordersOfColorGradient(userx, usery) == true) {
                ifClicked(userx, usery);
                this.selectedColor.setFillColor(getCurrentColor().getFillColor());
                this.selectedRGB.updateValues(this.selectedColor);
                intialiseColorBrightness(this.selectedColor.getFillColor());
            }
            if (ifInBordersOfColorBrightness(userx, usery) == true) {
                this.colorBrightness.checkIfClicked(userx, usery);
                this.selectedColor.setFillColor(this.colorBrightness.getCurrentColor().getFillColor());
                this.selectedRGB.updateValues(this.selectedColor);
            }
            return true;
        }

    }

    private Color modifyBrightness(Color c, float brightness) {

        float hsbVals[] = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        return Color.getHSBColor(hsbVals[0], hsbVals[1], brightness);

    }

    public void intialiseColorBrightness(Color color) {

        this.colorBrightness = new ZRectangleActiveArray();
        int xStarting = 700;
        int yStarting = 200;
        int width = 30;
        int height = 256;

        for (int i = 0; i < height; i++) {
            color = modifyBrightness(color, (256f - i) / 256f);
            for (int j = 0; j < width; j++) {
                ZRectangleActive rectangle = new ZRectangleActive("Custom Color",
                        xStarting + j, yStarting + i, 1, 1, color);
                rectangle.setUnpressedBorderColor(color);
                rectangle.setCurrentBorderColor(color);
                this.colorBrightness.addButton(rectangle);
            }
        }

    }

    private boolean ifInBordersOfColorBrightness(int userX, int userY) {

        if (userX >= 700 && userX <= 730
                && userY >= 200 && userY <= (200 + 256)) {
            return true;
        } else {
            return false;
        }

    }

    public ZRectangle newColor() {

        return this.selectedColor;

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public boolean isPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(boolean printStatus) {
        this.printStatus = printStatus;
    }

    public ZPoint getTopLeftCornerGradient() {
        return topLeftCornerGradient;
    }

    public void setTopLeftCornerGradient(ZPoint topLeftCornerGradient) {
        this.topLeftCornerGradient = topLeftCornerGradient;
    }

    public PopUpWindow getWindow() {
        return window;
    }

    public void setWindow(PopUpWindow window) {
        this.window = window;
    }

    public ZRectangle getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(ZRectangle selectedColor) {
        this.selectedColor = selectedColor;
    }

    public ColorValues getSelectedRGB() {
        return selectedRGB;
    }

    public void setSelectedRGB(ColorValues selectedRGB) {
        this.selectedRGB = selectedRGB;
    }

    public ColorValues getMovedRGB() {
        return movedRGB;
    }

    public void setMovedRGB(ColorValues movedRGB) {
        this.movedRGB = movedRGB;
    }

}
