package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import javax.swing.*;

public class MenuEdit extends DropDown {

    /*
    so this class intiates File edit drop down which has two buttons to dropdown: 
    - undo
    - redo
     */
    public MenuEdit(ZButtonToggle startingbutton) {
        super(startingbutton);
        intializeButtons();
    }

    public MenuEdit(String name, ZPoint p, int width, int height,
            Image pressedImage, Image depressedImage) {
        this(new ZButtonToggle(name, p, width, height, pressedImage, depressedImage));
    }

    public MenuEdit(String name, int x, int y, int width, int height,
            Image pressedImage, Image depressedImage) {
        this(new ZButtonToggle(name, new ZPoint(x, y), width, height, pressedImage, depressedImage));
    }

    private void intializeButtons() {

        // UNDO BUTTON
        ImageIcon undop = new ImageIcon("src/PicturesMenu/undo pressed.png");
        ImageIcon undodp = new ImageIcon("src/PicturesMenu/undo depressed.png");
        addZButtonToggle("Undo", undop.getImage(), undodp.getImage());

        // REDO BUTTON
        ImageIcon redop = new ImageIcon("src/PicturesMenu/redo pressed.png");
        ImageIcon redodp = new ImageIcon("src/PicturesMenu/redo depressed.png");
        addZButtonToggle("Redo", redop.getImage(), redodp.getImage());

    }

    @Override
    public String toString() {
        return "MenuEdit{" + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
}
