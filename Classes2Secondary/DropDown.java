package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;

public class DropDown extends ZButtonToggleArray {

    /*
    this class is for DROP DOWN buttons. examples are File, Edit, StrokeWidth etc.
    when these buttons are clicked, multiple buttons are painted underneath that 
    clicked button. all the buttons underneath have the same width and height of the clicked 
    button. 
     */
    private ZButtonToggle startingButton;
    private int dropDownStartingY;
    private boolean pressed;
    private boolean paintStartingButton;
    private ZButtonToggle movedButton;

    public DropDown(ZButtonToggle startingbutton) {

        super();
        this.startingButton = startingbutton;
        this.paintStartingButton = true;
        this.dropDownStartingY = this.startingButton.getTopLeftCorner().getY()
                + this.startingButton.getHeight();
        this.movedButton = null;

    }

    public DropDown(String name, ZPoint p, int width, int height, Image pressedImage, Image depressedImage) {
        this(new ZButtonToggle(name, p, width, height, pressedImage, depressedImage));
    }

    public DropDown(String name, int x, int y, int width, int height, Image pressedImage, Image depressedImage) {
        this(new ZButtonToggle(name, new ZPoint(x, y), width, height, pressedImage, depressedImage));
    }

    public void addZButtonToggle(String name, Image pressed, Image depressed) {

        /*
        so this method creates a drop down button that has the same X-coordinate, width 
        and height of the first starting button. but, the y coordinate will be different, 
        in this sense that it will add height of button to it. it will add height the numebr 
        of times that a button is present.
        meaning if im adding the first button, it will add height once to Y-coordinate.
        it will take only images and string as its parameters. 
         */
        ZButtonToggle newbutton = new ZButtonToggle(name,
                getStartingButton().getTopLeftCorner().getX(),
                this.dropDownStartingY + ((getButtons().size()) * getStartingButton().getHeight()),
                getStartingButton().getWidth(), getStartingButton().getHeight(),
                pressed, depressed);
        addButton(newbutton);

    }

    public boolean clicked(int userX, int userY) {

        // so if the starting button is not pressed till yet
        if (isPressed() == false) {
            // then check if the click done right now has clicked that button or not
            getStartingButton().getListener().click(userX, userY);
        } // but if the starting button has been clicked
        else {
            // then check each button in the arraylist if it has been clicked or not
            getStartingButton().getListener().click(userX, userY);
            super.checkAllIfClicked(userX, userY);
        }
        // now if any of the buttons in the array list are currently clicked,
        if (getStartingButton().isClickedStatus() == true
                || (super.checkAllIfInBorder(userX, userY) == true
                && isPressed() == true)) {
            // then make the pressed() boolean true, to display drop-down
            setPressed(true);
        } // but if the cursor clicks between dropDownStartingY
        else if (userX >= getStartingButton().getTopLeftCorner().getX()
                && userX <= getStartingButton().getMaximum().getX()
                && userY >= getStartingButton().getTopLeftCorner().getY()
                && userY <= getDropDownStartingY()) {
            // then make the pressed() boolean true, to display drop down
            setPressed(true);
        } // otherwise if no button is clicked (the starting and all the drop down ones)
        else {
            // the make the pressed() boolean false
            setPressed(false);
        }
        // return pressed boolean
        return isPressed();

    }

    public boolean moved(int userX, int userY) {

        // so if the dropdown is open, check is any button's have cursor moving on it
        boolean moved = false;
        boolean st = this.startingButton.ifMoved(userX, userY);
        if (st == true) {
            this.movedButton = this.startingButton;
        } else {
            this.movedButton = null;
        }
        if (isPressed() == true) {
            moved = super.checkAllIfMoved(userX, userY);
            if (moved == true) {
                this.movedButton = super.getMovedButton();
            }
        }
        return moved;

    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {

        if (this.paintStartingButton == true) {
            getStartingButton().paint(g, observer); // always paint the starting button
        }
        if (isPressed() == true) { // if dropdown is open, then print the rest of the buttons
            super.paint(g, observer);
        }

    }

    @Override
    public void paintToolTip(Graphics g) {

        if (this.movedButton != null) {
            this.movedButton.paintToolTip(g);
        }

    }

    public boolean ifInBorders(int userX, int userY) {

        // minimum line = starting button ke x, y
        // maximum line = last button ke x, y
        ZPoint minimum = this.startingButton.getTopLeftCorner();
        ZPoint maximum;
        if (getLastButton() == null) {
            maximum = this.startingButton.getMaximum();
        } else {
            maximum = getLastButton().getMaximum();
        }

        if (userX >= minimum.getX() && userX <= maximum.getX()
                && userY >= minimum.getY() && userY <= maximum.getY()) {
            return true;
        } else {
            return false;
        }

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZButtonToggle getStartingButton() {
        return startingButton;
    }

    public void setStartingButton(ZButtonToggle startingButton) {
        this.startingButton = startingButton;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean isPaintStartingButton() {
        return paintStartingButton;
    }

    public void setPaintStartingButton(boolean paintStartingButton) {
        this.paintStartingButton = paintStartingButton;
    }

    public int getDropDownStartingY() {
        return dropDownStartingY;
    }

    public void setDropDownStartingY(int dropDownStartingY) {
        this.dropDownStartingY = dropDownStartingY;
    }

}
