package Classes4Quaternary;

// QUATERNARY CLASS: using all three levels of classes, a quaternary class is the building block of the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PaintWindow implements MouseListener {

    private PanelLower lowerpanel;
    private PanelUpper upperpanel;
    private PanelRight rightpanel;
    private Middle middleArea;
    private ZRectangle header;
    private ZLabel filename;

    public PaintWindow() {

        /*
        the constructor intializes the panels (x,y,height, width, color)
         */
        intializeAssets();

    }

    private void intializeAssets() {

        this.header = new ZRectangle("Header", 0, 0, 900,
                20, Color.LIGHT_GRAY);
        String name = "untitled";
        this.filename = new ZLabel("File Name: " + name + ".png", 0, 15);
        this.upperpanel = new PanelUpper("Upper Panel", 0, 20, 900,
                100, Color.LIGHT_GRAY);
        this.rightpanel = new PanelRight("Right Panel", 700, 150,
                200, 347, Color.LIGHT_GRAY);
        this.lowerpanel = new PanelLower("Lower Panel", 0, 530,
                900, 200, Color.LIGHT_GRAY);
        this.upperpanel.getGrid().setFrame(-2, 118, 900, 420, Color.WHITE);
        this.middleArea = new Middle(this.upperpanel);

        // to change name of file, the user will press File>New
        this.upperpanel.getFile().getButtons().get(0).setListener(
                (int x, int y) -> {
                    if (this.upperpanel.getFile().getButtons().get(0).
                            ifClicked(x, y) == true) {
                        System.out.println("New is pressed");
                        intializeAssets();
                    }
                }
        );

    }

    public void paint(Graphics g, ImageObserver observer) {

        this.middleArea.paintStack(g);
        getUpperpanel().paint(g, observer);
        this.middleArea.paintPendingShape(g);
        getLowerpanel().paint(g);
        getRightpanel().paint(g, observer);

        getHeader().paintPanel(g);
        getFilename().paint(g);

        // now paint everyones tooltips
        this.getUpperpanel().paintToolTip(g);

    }

    @Override
    public boolean mouseMoved(int x, int y) {

        boolean l = getLowerpanel().mouseMoved(x, y);
        boolean u = getUpperpanel().mouseMoved(x, y);
        this.middleArea.mouseMoved(x, y);
        //boolean r = getRightpanel().moved(x, y);
        if (l == true && u == true) {
            return true;
        }

        return false;

    }

    @Override
    public boolean mouseClicked(int x, int y) {

        this.upperpanel.mouseClicked(x, y);
        getRightpanel().clicked(x, y);
        getLowerpanel().selectedShape(getUpperpanel().getShapesPanel().getIndex());
        getLowerpanel().selectedColor(getUpperpanel().getCurrentSelectedColor());
        getLowerpanel().selectedStroke(getUpperpanel().getStrokewidth().getSelectedStroke());
        this.middleArea.mouseClicked(x, y);
        return true;

    }

    @Override
    public boolean mousePressed(int userX, int userY) {

        this.upperpanel.mousePressed(userX, userY);
        this.middleArea.mousePressed(userX, userY);
        return true;

    }

    @Override
    public boolean mouseReleased(int userX, int userY) {

        this.upperpanel.mouseReleased(userX, userY);
        this.middleArea.mouseReleased(userX, userY);
        return true;

    }

    @Override
    public boolean mouseEntered(int userX, int userY) {

        this.upperpanel.mouseEntered(userX, userY);
        this.middleArea.mouseEntered(userX, userY);
        return true;

    }

    @Override
    public boolean mouseExited(int userX, int userY) {

        this.upperpanel.mouseExited(userX, userY);
        this.middleArea.mouseExited(userX, userY);
        return true;

    }

    @Override
    public boolean mouseDragged(int userX, int userY) {

        this.upperpanel.mouseDragged(userX, userY);
        this.middleArea.mouseDragged(userX, userY);
        return true;

    }

    @Override
    public String toString() {
        return "Window{" + "lowerpanel=" + lowerpanel + ", \nupperpanel="
                + upperpanel + ", \nrightpanel=" + rightpanel + ", \nheader="
                + header + ", \nfilename=" + filename + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public PanelLower getLowerpanel() {
        return lowerpanel;
    }

    public void setLowerpanel(PanelLower lowerpanel) {
        this.lowerpanel = lowerpanel;
    }

    public PanelUpper getUpperpanel() {
        return upperpanel;
    }

    public void setUpperpanel(PanelUpper upperpanel) {
        this.upperpanel = upperpanel;
    }

    public PanelRight getRightpanel() {
        return rightpanel;
    }

    public void setRightpanel(PanelRight rightpanel) {
        this.rightpanel = rightpanel;
    }

    public ZRectangle getHeader() {
        return header;
    }

    public void setHeader(ZRectangle header) {
        this.header = header;
    }

    public ZLabel getFilename() {
        return filename;
    }

    public void setFilename(ZLabel filename) {
        this.filename = filename;
    }

    public Middle getMiddleArea() {
        return middleArea;
    }

    public void setMiddleArea(Middle middleArea) {
        this.middleArea = middleArea;
    }

}
