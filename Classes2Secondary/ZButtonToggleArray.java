package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import java.util.*;

public class ZButtonToggleArray {

    /*
    this class is an arraylist of buttons, toggle buttons to be specific. it also 
    has a property to store the currently selected index. 
     */
    private ArrayList<ZButtonToggle> buttons; // an arraylist of buttons
    private int index; // the button index that is currently selected 
    private ZButtonToggle movedButton;
    private ZButtonToggle lastButton;

    public ZButtonToggleArray() {

        this.buttons = new ArrayList<>();
        this.index = -1;
        this.lastButton = null;

    }

    public void paint(Graphics g, ImageObserver observer) {

        /*
        this method paints all the buttons in the array list
         */
        for (int i = 0; i < getButtons().size(); i++) {
            getButtons().get(i).paint(g, observer);
        }

    }

    public void paintToolTip(Graphics g) {

        if (movedButton != null) {
            this.movedButton.paintToolTip(g);
        }

    }

    public void addButton(ZButtonToggle button) {

        /*
        this method adds a ZButton to the arraylist of buttons
         */
        this.buttons.add(button);
        this.index = getButtons().size();
        this.lastButton = button;

    }

    public boolean checkAllIfClicked(int x, int y) {

        /*
        this method checks each button in the arraylist if it is clicked or not. 
        if it is clicked, it changes the instance variable index to which one is currently pressed
        if NONE are pressed, then the index is made -1.
        this method returns if any of them are clicked or not
         */
        boolean oneOfThemIsClicked = false;
        for (int i = 0; i < getButtons().size(); i++) {
            getButtons().get(i).getListener().click(x, y); // first click each button to get its state
        }

        for (int i = 0; i < getButtons().size(); i++) {
            // if the button has been clicked, change its index
            if (getButtons().get(i).isClickedStatus() == true) {
                setIndex(i);
                oneOfThemIsClicked = true;
            }
        }

        // if none of them are selected, make index -1
        if (oneOfThemIsClicked == false) {
            setIndex(-1);
        }

        return oneOfThemIsClicked;

    }

    public boolean checkAllIfMoved(int userX, int userY) {

        /*
        this method checks if any buttons were moved / cursor was hovered on
         */
        boolean moved = false;
        for (int i = 0; i < getButtons().size(); i++) {
            getButtons().get(i).ifMoved(userX, userY);
            if (getButtons().get(i).ifMoved(userX, userY) == true) {
                moved = true;
                this.movedButton = getButtons().get(i);
            }
        }
        return moved;

    }

    public boolean checkAllIfInBorder(int userX, int userY) {

        boolean border = false;
        for (int i = 0; i < getButtons().size(); i++) {
            getButtons().get(i).IfInBorders(userX, userY);
            if (getButtons().get(i).IfInBorders(userX, userY) == true) {
                border = true;
            }
        }
        return border;

    }

    @Override
    public String toString() {
        return "ZButtonLayout{" + "buttons=" + getButtons().toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<ZButtonToggle> getButtons() {
        return buttons;
    }

    public void setButtons(ArrayList<ZButtonToggle> buttons) {
        this.buttons = buttons;
    }

    public ZButtonToggle getMovedButton() {
        return movedButton;
    }

    public void setMovedButton(ZButtonToggle movedButton) {
        this.movedButton = movedButton;
    }

    public ZButtonToggle getLastButton() {
        return lastButton;
    }

    public void setLastButton(ZButtonToggle lastButton) {
        this.lastButton = lastButton;
    }

}
