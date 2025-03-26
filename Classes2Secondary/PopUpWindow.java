package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class PopUpWindow {

    /*
    this class prints a popup window in the middle of the screen. the values for the 
    popup window are fixed. 
     */
    private ZRectangle back;
    private ZRectangle topBorder;
    private ZRectangleFillToggle crossButton;
    private ZLabel X;
    private ZRectangleFillToggle okButton;
    private ZLabel OK;
    private boolean okWasClicked;
    private boolean printOrNot;

    public PopUpWindow() {

        // the back of the window must be grey
        this.back = new ZRectangle("Back", 200, 150, 550,
                350, Color.LIGHT_GRAY);

        // intialise necessary values
        int xStarting = this.back.getTopLeft().getX();
        int yStarting = this.back.getTopLeft().getY();
        int xEnding = this.back.getMaximum().getX();
        int yEnding = this.back.getMaximum().getY();
        int width = this.back.getWidth();

        // it will have a top border yellow
        this.topBorder = new ZRectangle("Top Border", xStarting + 1,
                yStarting, width + 1, 30, Color.YELLOW);
        // the top right has a cross button 'X' which will turn red when hovered
        this.crossButton = new ZRectangleFillToggle("X", xEnding - 63, yStarting + 1,
                60, 25, Color.WHITE, Color.RED);
        // 'X' will be displayed on the cross button
        this.X = new ZLabel(this.crossButton.getName(),
                this.crossButton.getTopLeft().getX() + (this.crossButton.getWidth() / 2) - 2,
                this.crossButton.getTopLeft().getY() + (this.crossButton.getHeight() / 2) + 7);
        // the 'X' font size should be set to 15, so that it is visible
        this.X.setFont("SansSherif", 15);
        // the bottom left has a 'ok' button which will turn light pink when hovered
        this.okButton = new ZRectangleFillToggle("OK", xEnding - 65, yEnding - 30,
                60, 25, Color.WHITE, Color.PINK);
        // 'OK' will be displayed on the ok button
        this.OK = new ZLabel(this.okButton.getName(),
                this.okButton.getTopLeft().getX() + (this.okButton.getWidth() / 2) - 5,
                this.okButton.getTopLeft().getY() + (this.okButton.getHeight() / 2) + 5);
        // set printornot boolean as originally false
        this.printOrNot = false;
        // set okwasclicked boolean as originally flase
        this.okWasClicked = true;

    }

    public boolean ifInBorders(int userx, int usery) {

        boolean b = this.back.IfInBorders(userx, usery);
        return b;

    }

    public void activate() {

        /*
        this method will be used to print the popup window whenever necessary.
         */
        setPrintOrNot(true);
        this.okWasClicked = false;
        System.out.println("Pop-up Window is opened. ");

    }

    public void paint(Graphics g) {

        if (isPrintOrNot() == true) {
            // paint the back first
            getBack().paintPanel(g);
            // then paint the top border
            getTopBorder().paintPanel(g);
            // then paint the back of the cross button
            getCrossButton().paintRectangle(g);
            // then paint the 'X' on the cross button
            getX().paint(g);
            // then paint the back of the ok button
            getOkButton().paintRectangle(g);
            // then paint the 'OK' on the ok button
            getOK().paint(g);

        }

    }

    public void paintToolTip(Graphics g) {

        if (isPrintOrNot() == true) {
            getCrossButton().paintToolTip(g);
            // then paint the back of the ok button
            getOkButton().paintToolTip(g);
        }

    }

    public boolean moved(int userX, int userY) {

        /*
        check the cross button, if cursor hovers on it, change color. 
         */
        boolean x = getCrossButton().ifMoved(userX, userY);
        boolean ok = getOkButton().ifMoved(userX, userY);
        if (x == true || ok == true) {
            return true;
        } else {
            return false;
        }

    }

    public boolean clicked(int userX, int userY) {

        /*
        if the window is clicked, and the cross button is clicked, then stop printing
        the window.
         */
        boolean x = getCrossButton().ifSelected(userX, userY);
        boolean ok = getOkButton().ifSelected(userX, userY);
        if (ok == true) {
            this.okWasClicked = true;
        }
        if (x == true || ok == true) {
            setPrintOrNot(false);
            System.out.println("Pop-up Window is closed. ");
            return true;
        }
        return false;

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZRectangleFillToggle getCrossButton() {
        return crossButton;
    }

    public void setCrossButton(ZRectangleFillToggle crossButton) {
        this.crossButton = crossButton;
    }

    public ZLabel getX() {
        return X;
    }

    public void setX(ZLabel X) {
        this.X = X;
    }

    public boolean isPrintOrNot() {
        return printOrNot;
    }

    public void setPrintOrNot(boolean printOrNot) {
        this.printOrNot = printOrNot;
    }

    public ZRectangleFillToggle getOkButton() {
        return okButton;
    }

    public void setOkButton(ZRectangleFillToggle okButton) {
        this.okButton = okButton;
    }

    public ZLabel getOK() {
        return OK;
    }

    public void setOK(ZLabel OK) {
        this.OK = OK;
    }

    public boolean isOkWasClicked() {
        return okWasClicked;
    }

    public void setOkWasClicked(boolean okWasClicked) {
        this.okWasClicked = okWasClicked;
    }

    public ZRectangle getBack() {
        return back;
    }

    public void setBack(ZRectangle back) {
        this.back = back;
    }

    public ZRectangle getTopBorder() {
        return topBorder;
    }

    public void setTopBorder(ZRectangle topBorder) {
        this.topBorder = topBorder;
    }

}
