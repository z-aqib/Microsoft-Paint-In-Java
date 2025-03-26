package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;

public class DoubleButton {

    /*
    this class is a double button. it features a ZRectangleToggleFill background, 
    and a ZButtonToggle and a ZRectangleToggle. 
     */
    private ZRectangleToggle colorSquare; // the color button/square
    private ZRectangleFillToggle backgroundButton; // the background of the button
    private ZButtonToggle imageButton; // a button in place of the color button/square
    private ZLabel header; // the label
    private boolean imageOrNot; // this is a boolean which shows if an image is printed or not
    private boolean pressedOrNot; // this is a boolean which shows if the double button is pressed or not

    public DoubleButton(String labelName, int x, int y, int width, int height,
            int buttonHeight, Color bckgcolor, Color buttonColor, String buttonColorName) {

        this.backgroundButton = new ZRectangleFillToggle(labelName, x, y, width, height,
                bckgcolor, Color.CYAN);
        intializeAssets(labelName, x, y, width, buttonHeight, buttonColor,
                buttonColorName);

    }

    private void intializeAssets(String str, int x, int y, int width,
            int buttonHeight, Color buttonColor, String buttonC) {

        /*
        this method declares and intialises the rectangle of color in the middle of the 
        background. then it intialises the header. it also makes image false.
         */
        int ButtonWidth = (width / 6) * 5;
        int ButtonX = x + (ButtonWidth / 7);
        int ButtonY = y + 10;
        this.colorSquare = new ZRectangleToggle(buttonC, ButtonX, ButtonY, ButtonWidth,
                buttonHeight, buttonColor);

        int x_HEADER = x + (width / 6);
        int y_HEADER = getBackgroundButton().getTopLeft().getY() + getBackgroundButton().getHeight() - 5;
        this.header = new ZLabel(str, x_HEADER, y_HEADER);
        this.imageOrNot = false;

    }

    public void intialiseImage(String str, Image pressed, Image depressed) {

        /*
        if there is a use of an image, then print an button image on top of the color 
        rectangle. make image or not true. 
         */
        this.imageButton = new ZButtonToggle(str, getColorSquare().getTopLeft(),
                getColorSquare().getWidth(), getColorSquare().getHeight(),
                pressed, depressed);
        setImageOrNot(true);

    }

    public void paint(Graphics g, ImageObserver observer) {

        /*
        first paint the background, then the button of color, then the header.
        if there is an image, print it. 
         */
        getBackgroundButton().paintRectangle(g);
        getColorSquare().paintRectangle(g);
        getHeader().paint(g);
        if (isImageOrNot() == true) {
            getImageButton().paint(g, observer);
        }

    }

    public void paintToolTip(Graphics g) {

        getBackgroundButton().paintToolTip(g);
        getColorSquare().paintToolTip(g);
        if (isImageOrNot() == true) {
            getImageButton().paintToolTip(g);
        }

    }

    public boolean clickedornot(int userX, int userY) {

        /*
        so this method first checks if the button has been clicked or not. if it has, 
        then the background is changed to its pressed color. if not, then the background is 
        changed to its depressed color. 
         */
        if (getBackgroundButton().ifSelected(userX, userY) == true) {
            if (isImageOrNot() == true) {
                getImageButton().ifClicked(userX, userY);
            }
            pressedOrNot = true;
            return true;
        } else {
            pressedOrNot = false;
            return false;
        }

    }

    public boolean movedornot(int userX, int userY) {

        boolean moved = getBackgroundButton().ifMoved(userX, userY);
        if (isImageOrNot() == true) {
            getImageButton().ifMoved(userX, userY);
        }
        return moved;

    }

    public void makeClicked() {

        getBackgroundButton().makeClicked();
        this.pressedOrNot = true;

    }

    public void makeUnClicked() {

        getBackgroundButton().makeUnClicked();
        this.pressedOrNot = false;

    }

    public ZRectangleToggle clickedRectangleUpdate(int userX, int userY) {

        /*
        so this method first checks if the button has been clicked or not. if it has, 
        then it return the ZRectangle of the color.
        if not, it returns null.
         */
        if (getBackgroundButton().ifSelected(userX, userY)) {
            return getColorSquare();
        } else {
            return null;
        }

    }

    public Color getColor() {

        return getColorSquare().getFillColor();

    }

    public boolean IfInBorders(int userX, int userY) {

        if (getBackgroundButton().IfInBorders(userX, userY) == true) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DoubleButton{" + "button=" + getColorSquare().toString() + ", background="
                + getBackgroundButton().toString() + ", ImageButton=" + getImageButton()
                + ", header=" + this.header.toString() + ", imageOrNot=" + this.imageOrNot + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZRectangleToggle getColorSquare() {
        return colorSquare;
    }

    public void setColorSquare(ZRectangleToggle colorSquare) {
        this.colorSquare = colorSquare;
    }

    public ZRectangleFillToggle getBackgroundButton() {
        return backgroundButton;
    }

    public void setBackgroundButton(ZRectangleFillToggle backgroundButton) {
        this.backgroundButton = backgroundButton;
    }

    public ZButtonToggle getImageButton() {
        return imageButton;
    }

    public void setImageButton(ZButtonToggle imageButton) {
        this.imageButton = imageButton;
    }

    public ZLabel getHeader() {
        return header;
    }

    public void setHeader(ZLabel header) {
        this.header = header;
    }

    public boolean isImageOrNot() {
        return imageOrNot;
    }

    public void setImageOrNot(boolean imageOrNot) {
        this.imageOrNot = imageOrNot;
    }

    public boolean isPressedOrNot() {
        return pressedOrNot;
    }

    public void setPressedOrNot(boolean pressedOrNot) {
        this.pressedOrNot = pressedOrNot;
    }

}
