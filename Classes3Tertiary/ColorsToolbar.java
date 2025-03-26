package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class ColorsToolbar {

    private DoubleButton colorGradientButton;
    private ColorGradient colorgradientWindow;
    private boolean colorgradientStatus;
    private DoubleButton color1;
    private DoubleButton color2;
    private ColorOptions colorsOptions;
    private int ColorOptionsIndex;

    public ColorsToolbar(int x_coordinate_color1, int y_coordinate_all, int height_panels, int height_buttons,
            int width_panels, int width_buttons, int spacing, Color color) {

        // then comes the color2 button
        int x_coordinate_color2 = x_coordinate_color1 + width_buttons + spacing;
        // then comes the colors panel
        int x_coordinate_colorspanel = x_coordinate_color2 + width_buttons + spacing;
        // then comes the color gradient button
        int x_coordinate_colorgradient = x_coordinate_colorspanel + width_panels - 15;

        this.colorsOptions = new ColorOptions(x_coordinate_colorspanel, y_coordinate_all,
                width_panels, height_panels, color);

        intializeColorGradient(x_coordinate_colorgradient, y_coordinate_all,
                width_buttons, height_panels, height_buttons, color);

        intializeColor1(x_coordinate_color1, y_coordinate_all,
                width_buttons, height_panels, height_buttons,
                color, Color.BLACK);

        intializeColor2(x_coordinate_color2, y_coordinate_all, width_buttons,
                height_panels, height_buttons, color, Color.WHITE);

        this.ColorOptionsIndex = 20;

    }

    private void intializeColor1(int x, int y, int width, int TotalHeight,
            int ButtonHeight, Color color, Color buttonColor) {

        this.color1 = new DoubleButton("Color 1", x, y,
                width, TotalHeight, ButtonHeight,
                color, buttonColor, "Black");
        this.color1.makeClicked();

    }

    private void intializeColor2(int x, int y, int width, int TotalHeight,
            int ButtonHeight, Color color, Color buttonColor) {

        this.color2 = new DoubleButton("Color 2", x, y,
                width, TotalHeight, ButtonHeight,
                color, buttonColor, "White");

    }

    private void intializeColorGradient(int x, int y, int width, int Theight, int Bheight, Color color) {

        ImageIcon pressed = new ImageIcon("src/PicturesUpperPanelButtons/color gradient pressed.png");
        ImageIcon depressed = new ImageIcon("src/PicturesUpperPanelButtons/color gradient depressed.png");
        this.colorGradientButton = new DoubleButton("Edit Color", x, y, width,
                Theight, Bheight, color, color, "Multi");
        this.colorGradientButton.intialiseImage("colorGradient", pressed.getImage(),
                depressed.getImage());
        this.colorGradientButton.getHeader().getPosition().setX(x + 7);
        this.colorgradientWindow = new ColorGradient(color);

    }

    public void moved(int x, int y) {

        this.color1.movedornot(x, y);
        this.color2.movedornot(x, y);
        this.colorsOptions.moved(x, y);
        this.colorGradientButton.movedornot(x, y);
        if (this.colorgradientStatus == true) {
            this.colorgradientWindow.moved(x, y);
        }

    }

    public void clicked(int userx, int usery) {

        if (this.colorsOptions.IfInBorders(userx, usery) == true) {
            this.colorsOptions.checkIfClicked(userx, usery);
            if (getColor1().getBackgroundButton().isClickedStatus() == true) {
                getColor1().getColorSquare().setFillColor(
                        this.colorsOptions.getCurrentColor().getFillColor());
                getColor1().getColorSquare().setName(this.colorsOptions.getCurrentColor().getName());
            } else if (getColor2().getBackgroundButton().isClickedStatus() == true) {
                getColor2().getColorSquare().setFillColor(
                        this.colorsOptions.getCurrentColor().getFillColor());
                getColor2().getColorSquare().setName(this.colorsOptions.getCurrentColor().getName());
            }
        }
        if (getColor1().IfInBorders(userx, usery) == true
                || getColor2().IfInBorders(userx, usery) == true) {
            getColor1().clickedornot(userx, usery);
            getColor2().clickedornot(userx, usery);
        }

        this.colorGradientButton.clickedornot(userx, usery);

        if (this.colorgradientWindow.isPrintStatus() == true) {
            this.colorgradientWindow.clicked(userx, usery);
            if (this.colorgradientWindow.getWindow().isOkWasClicked() == true) {
                ZRectangle newColor = this.colorgradientWindow.newColor();
                updateColorOptions(newColor);
                if (getColor1().getBackgroundButton().isClickedStatus() == true) {
                    getColor1().getColorSquare().setFillColor(newColor.getFillColor());
                    getColor1().getColorSquare().setName(newColor.getName());
                } else if (getColor2().getBackgroundButton().isClickedStatus() == true) {
                    getColor2().getColorSquare().setFillColor(newColor.getFillColor());
                    getColor2().getColorSquare().setName(newColor.getName());
                }
            }
        }

        if (this.colorGradientButton.clickedornot(userx, usery) == true) {
            this.colorgradientStatus = true;
            this.colorgradientWindow.getWindow().activate();
            this.colorgradientWindow.setPrintStatus(true);
        }
        if ((this.colorgradientStatus == true && this.colorgradientWindow.isPrintStatus() == true)
                || this.colorGradientButton.isPressedOrNot() == true) {
            this.colorgradientStatus = true;
        } else {
            this.colorgradientStatus = false;

        }

    }

    private void updateColorOptions(ZRectangle color) {

        this.colorsOptions.changeColorOfButton(this.ColorOptionsIndex, color);
        this.ColorOptionsIndex++;
        if (this.ColorOptionsIndex >= 30) {
            this.ColorOptionsIndex = 20;
        }

    }

    public void paint(Graphics g, ImageObserver observer) {

        // now paint the colors panel
        this.colorsOptions.paint(g);
        // now paint color gradient
        this.colorGradientButton.paint(g, observer);
        // if the color gradient has been pressed, print its color gradient panel
        if (this.colorgradientStatus == true) {
            this.colorgradientWindow.paint(g);
        }
        // now print color1, color2
        getColor1().paint(g, observer);
        getColor2().paint(g, observer);

    }

    public void paintToolTip(Graphics g) {

        this.colorsOptions.paintToolTip(g);
        this.colorGradientButton.paintToolTip(g);
        if (this.colorgradientStatus == true) {
            this.colorgradientWindow.paintToolTip(g);
        }
        getColor1().paintToolTip(g);
        getColor2().paintToolTip(g);

    }

    public boolean isColorgradientStatus() {
        return colorgradientStatus;
    }

    public void setColorgradientStatus(boolean colorgradientStatus) {
        this.colorgradientStatus = colorgradientStatus;
    }

    public DoubleButton getColor1() {
        return color1;
    }

    public void setColor1(DoubleButton color1) {
        this.color1 = color1;
    }

    public DoubleButton getColor2() {
        return color2;
    }

    public void setColor2(DoubleButton color2) {
        this.color2 = color2;
    }

    public DoubleButton getColorGradientButton() {
        return colorGradientButton;
    }

    public void setColorGradientButton(DoubleButton colorGradientButton) {
        this.colorGradientButton = colorGradientButton;
    }

    public ColorGradient getColorgradientWindow() {
        return colorgradientWindow;
    }

    public void setColorgradientWindow(ColorGradient colorgradientWindow) {
        this.colorgradientWindow = colorgradientWindow;
    }

    public ColorOptions getColorsOptions() {
        return colorsOptions;
    }

    public void setColorsOptions(ColorOptions colorsOptions) {
        this.colorsOptions = colorsOptions;
    }

}
