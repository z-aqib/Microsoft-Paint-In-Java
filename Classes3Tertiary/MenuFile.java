package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import Classes6Others.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MenuFile extends DropDown {

    private boolean openWindowBoolean;
    private OpenWindow openWindow;

    /*
    so this class intiates File menu drop down which has three buttons to dropdown: 
    - new
    - open
    - save
     */
    public MenuFile(ZButtonToggle startingbutton) {

        super(startingbutton);
        intializeButtons();
        setOpenListener();
        this.openWindowBoolean = false;

    }

    public MenuFile(String name, ZPoint p, int width, int height,
            Image pressedImage, Image depressedImage) {

        this(new ZButtonToggle(name, p, width, height, pressedImage, depressedImage));

    }

    public MenuFile(String name, int x, int y, int width, int height,
            Image pressedImage, Image depressedImage) {

        this(new ZButtonToggle(name, new ZPoint(x, y), width, height, pressedImage, depressedImage));

    }

    @Override
    public boolean ifInBorders(int userX, int userY) {

        boolean one = super.ifInBorders(userX, userY);
        boolean two = false;
        if (this.openWindowBoolean == true) {
            two = this.openWindow.ifInBorders(userX, userY);
        }
        if (one == false && two == false) {
            return false;
        }
        return true;

    }

    private void intializeButtons() {

        // NEW BUTTON
        ImageIcon new_dp = new ImageIcon("src/PicturesMenu/new depressed.png");
        ImageIcon new_p = new ImageIcon("src/PicturesMenu/new pressedd.png");
        addZButtonToggle("New", new_p.getImage(), new_dp.getImage());

        // OPEN BUTTON
        ImageIcon open_dp = new ImageIcon("src/PicturesMenu/open depressed.png");
        ImageIcon open_p = new ImageIcon("src/PicturesMenu/open pressed.png");
        addZButtonToggle("Open", open_p.getImage(), open_dp.getImage());

        // SAVE BUTTON
        ImageIcon save_dp = new ImageIcon("src/PicturesMenu/save depressed.png");
        ImageIcon save_p = new ImageIcon("src/PicturesMenu/save pressed.png");
        addZButtonToggle("Save", save_p.getImage(), save_dp.getImage());

    }

    private void setOpenListener() {

        getButtons().get(1).setListener(
                (int x, int y) -> {
                    if (getButtons().get(1).ifClicked(x, y) == true) {
                        System.out.println("Open is pressed");
                        this.openWindow = new OpenWindow();
                        this.openWindow.activate();
                        this.openWindowBoolean = true;
                    }
                }
        );

    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {

        super.paint(g, observer);
        if (this.openWindowBoolean == true) {
            this.openWindow.paint(g);
        }

    }
    
    @Override
    public void paintToolTip(Graphics g) {
        
        super.paintToolTip(g);
        if (this.openWindowBoolean == true) {
            this.openWindow.paintToolTip(g); 
        }
        
    }

    @Override
    public boolean clicked(int userx, int usery) {

        boolean superB = super.clicked(userx, usery);
        if (this.openWindowBoolean == true) {
            boolean o = this.openWindow.clicked(userx, usery);
            if (o == true) {
                this.openWindowBoolean = false;
            }
            return o;
        }
        return superB;

    }

    @Override
    public boolean moved(int userx, int usery) {

        boolean superM = super.moved(userx, usery);
        if (this.openWindowBoolean == true) {
            boolean o = this.openWindow.moved(userx, usery);
            return o;
        }
        return superM;

    }

    @Override
    public String toString() {
        return "MenuFile{" + "openWindowBoolean=" + openWindowBoolean + ", openWindow=" + openWindow + '}';
    }

    public boolean isOpenWindowBoolean() {
        return openWindowBoolean;
    }

    public void setOpenWindowBoolean(boolean openWindowBoolean) {
        this.openWindowBoolean = openWindowBoolean;
    }

    public OpenWindow getOpenWindow() {
        return openWindow;
    }

    public void setOpenWindow(OpenWindow openWindow) {
        this.openWindow = openWindow;
    }

}
