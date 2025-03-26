package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class StrokeSize extends DoubleButton {

    /*
    so this class intiates stroke width/size drop down which has four buttons to dropdown: 
    - size 1 
    - size 2
    - size 3
    - size 4
     */
    private DropDown strokeDropDown;

    public StrokeSize(String labelName, int x, int y, int width, int height,
            int buttonHeight, Color bckgcolor, Color buttonColor, String buttonC) {

        super(labelName, x, y, width, height, buttonHeight, bckgcolor,
                buttonColor, buttonC);

        intializeImage();
        this.strokeDropDown.setIndex(0);

    }

    private void intializeImage() {

        // FIRST BUTTON
        ImageIcon sizepressed = new ImageIcon("src/PicturesStrokeSize/size pressed.png");
        ImageIcon sizedepressed = new ImageIcon("src/PicturesStrokeSize/size depressed.png");
        this.intialiseImage("Stroke Button", sizepressed.getImage(), sizedepressed.getImage());

        this.strokeDropDown = new DropDown(getImageButton());
        this.strokeDropDown.setPaintStartingButton(false);
        this.strokeDropDown.setDropDownStartingY(
                getBackgroundButton().getMaximum().getY());

        intializeButtons();
    }

    private void intializeButtons() {

        // SIZE 1 BUTTON
        ImageIcon size1pressed = new ImageIcon("src/PicturesStrokeSize/1st size pressed.png");
        ImageIcon size1depressed = new ImageIcon("src/PicturesStrokeSize/1st size depressed.png");
        this.strokeDropDown.addZButtonToggle("size 1", size1pressed.getImage(), size1depressed.getImage());

        // SIZE 2 BUTTON
        ImageIcon size2pressed = new ImageIcon("src/PicturesStrokeSize/2nd size pressed.png");
        ImageIcon size2depressed = new ImageIcon("src/PicturesStrokeSize/2nd size depressed.png");
        this.strokeDropDown.addZButtonToggle("size 2", size2pressed.getImage(), size2depressed.getImage());

        // SIZE 3 BUTTON
        ImageIcon size3pressed = new ImageIcon("src/PicturesStrokeSize/3rd size pressed.png");
        ImageIcon size3depressed = new ImageIcon("src/PicturesStrokeSize/3rd size depressed.png");
        this.strokeDropDown.addZButtonToggle("size 3", size3pressed.getImage(), size3depressed.getImage());

        // SIZE 4 BUTTON
        ImageIcon size4pressed = new ImageIcon("src/PicturesStrokeSize/4th size pressed.png");
        ImageIcon size4depressed = new ImageIcon("src/PicturesStrokeSize/4th size depressed.png");
        this.strokeDropDown.addZButtonToggle("size 4", size4pressed.getImage(), size4depressed.getImage());

    }

    public int getSelectedStroke() {

        return this.strokeDropDown.getIndex();

    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {

        super.paint(g, observer);
        this.strokeDropDown.paint(g, observer);

    }

    @Override
    public void paintToolTip(Graphics g) {

        super.paintToolTip(g);
        this.strokeDropDown.paintToolTip(g);

    }

    public void moved(int userx, int usery) {

        super.movedornot(userx, usery);
        this.strokeDropDown.moved(userx, usery);

    }

    public void clicked(int userx, int usery) {

        int index = this.strokeDropDown.getIndex();
        if (index == -1) {
            index = 0;
        }
        super.clickedornot(userx, usery);
        this.strokeDropDown.clicked(userx, usery);
        if (this.strokeDropDown.getIndex() == -1) {
            this.strokeDropDown.setIndex(index);
        }

    }

    @Override
    public boolean IfInBorders(int userx, int usery) {

        boolean b = super.IfInBorders(userx, usery);
        boolean c = this.strokeDropDown.ifInBorders(userx, usery);
        if (b == false && c == false) {
            return false;
        } else {
            return true;
        }

    }

    public DropDown getStrokeDropDown() {
        return strokeDropDown;
    }

    public void setStrokeDropDown(DropDown strokeDropDown) {
        this.strokeDropDown = strokeDropDown;
    }

}
