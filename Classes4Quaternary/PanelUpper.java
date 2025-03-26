package Classes4Quaternary;

// QUATERNARY CLASS: using all three levels of classes, a quaternary class is the building block of the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PanelUpper extends ZRectangle implements MouseListener {

    private MenuFile file;
    private MenuEdit edit;
    private ShapesToolbar shapesPanel;
    private DoubleButton freehandPanel;
    private StrokeSize strokewidth;
    private ColorsToolbar colorsToolbar;
    private Grid grid;

    public PanelUpper(String name, int x, int y, int width, int height, Color color) {

        super(name, x, y, width, height, color);
        intializeAssets(x, y, height, color);

    }

    private void intializeAssets(int x, int y, int height, Color bckgcolor) {

        final int y_coordinate_all = y;
        final int height_panels = height - 2;
        final int height_buttons = (height / 5) * 3;
        final int width_buttons = 65;
        final int width_panels = 170;
        final int spacing = 5;

        // first comes the menu panel which has two buttons: File and Edit
        int x_coordinate_filemenu = x;
        int x_coordinate_editmenu = x_coordinate_filemenu + width_buttons + spacing;
        // then comes the freehand drawing button
        int x_coordinate_freehand = x_coordinate_editmenu + width_buttons + spacing;
        // then comes the stroke width button
        int x_coordinate_strokewidth = x_coordinate_freehand + width_buttons + spacing;
        // then comes the shapes panel
        int x_coordinate_shapespanel = x_coordinate_strokewidth + width_buttons + spacing;
        // then comes the color 1 button
        int x_coordinate_color1 = x_coordinate_shapespanel + width_panels;
        int x_coordinate_color2 = x_coordinate_color1 + width_buttons;
        int x_coordinate_colorOptions = x_coordinate_color2 + width_buttons;
        int x_coordinate_colorGradient = x_coordinate_colorOptions + width_panels;
        int x_coordinate_grid = x_coordinate_colorGradient + width_buttons;

        intializeFile(x_coordinate_filemenu, y_coordinate_all, width_buttons, height_buttons);
        intializeEdit(x_coordinate_editmenu, y_coordinate_all, width_buttons, height_buttons);

        this.shapesPanel = new ShapesToolbar(x_coordinate_shapespanel, y_coordinate_all,
                width_panels, height_panels, bckgcolor);

        this.colorsToolbar = new ColorsToolbar(x_coordinate_color1, y_coordinate_all, height_panels,
                height_buttons, width_panels, width_buttons, spacing, bckgcolor);

        intializeFreehand(x_coordinate_freehand, y_coordinate_all, width_buttons,
                height_panels, height_buttons, bckgcolor);

        this.strokewidth = new StrokeSize("Stroke", x_coordinate_strokewidth,
                y_coordinate_all, width_buttons,
                height_panels, height_buttons,
                bckgcolor, bckgcolor, "Light Gray");

        this.grid = new Grid("Grid", x_coordinate_grid, y_coordinate_all,
                width_buttons, height_panels, height_buttons,
                bckgcolor, Color.WHITE, "white");

    }

    private void intializeEdit(int x, int y, int width, int height) {

        ImageIcon editp = new ImageIcon("src/PicturesMenu/edit pressed.png");
        ImageIcon editdp = new ImageIcon("src/PicturesMenu/edit depressed.png");
        ZButtonToggle editButton = new ZButtonToggle("Edit", x, y, width, height,
                editp.getImage(), editdp.getImage());
        this.edit = new MenuEdit(editButton);

    }

    private void intializeFile(int x, int y, int width, int height) {

        ImageIcon file_p_dp = new ImageIcon("src/PicturesMenu/file.depressed.png");
        ZButtonToggle fileButton = new ZButtonToggle("File", x, y, width, height,
                file_p_dp.getImage(), file_p_dp.getImage());
        this.file = new MenuFile(fileButton);

    }

    private void intializeFreehand(int x, int y, int width, int Totalheight, int Buttonheight, Color color) {

        ImageIcon freehandpressed = new ImageIcon("src/PicturesUpperPanelButtons/freehand pressed.png");
        ImageIcon freehanddepressed = new ImageIcon("src/PicturesUpperPanelButtons/freehand depressed.png");
        this.freehandPanel = new DoubleButton("Freehand", x, y, width,
                Totalheight, Buttonheight, color,
                color, "Light Gray");
        this.freehandPanel.intialiseImage("Freehand", freehandpressed.getImage(),
                freehanddepressed.getImage());
        this.freehandPanel.getHeader().moveRightLeft(-2);
        this.freehandPanel.makeClicked();

    }

    public void paint(Graphics g, ImageObserver observer) {

        // first paint the upper panel
        super.paintPanel(g);
        this.grid.paintButton(g, observer);
        this.grid.paintGrid(g);

        // now paint the shapes panel
        getShapesPanel().paint(g, observer);
        // now paint the freehand panel
        getFreehandPanel().paint(g, observer);

        // now paint the colors toolbar
        this.colorsToolbar.paint(g, observer);
        // now paint the stroke width
        this.strokewidth.paint(g, observer);

        this.file.paint(g, observer);
        this.edit.paint(g, observer);

    }

    public void paintToolTip(Graphics g) {

        this.grid.paintToolTip(g);

        // now paint the shapes panel
        getShapesPanel().paintToolTip(g);
        // now paint the freehand panel
        getFreehandPanel().paintToolTip(g);

        // now paint the colors toolbar
        this.colorsToolbar.paintToolTip(g);
        // now paint the stroke width
        this.strokewidth.paintToolTip(g);

        this.file.paintToolTip(g);
        this.edit.paintToolTip(g);

    }

    public ZRectangle getColorInColor1() {

        ZRectangle color = this.colorsToolbar.getColor1().getColorSquare();
        return color;

    }

    public ZRectangle getColorInColor2() {

        ZRectangle color = this.colorsToolbar.getColor2().getColorSquare();
        return color;

    }

    public ZRectangle getCurrentSelectedColor() {

        ZRectangle color = null;
        if (this.colorsToolbar.getColor1().isPressedOrNot() == true) {
            color = this.getColorInColor1();
        } else if (this.colorsToolbar.getColor2().isPressedOrNot() == true) {
            color = this.getColorInColor2();
        }
        return color;

    }

    @Override
    public boolean mouseClicked(int userx, int usery) {

        if (getFreehandPanel().IfInBorders(userx, usery) == true
                || getShapesPanel().IfInBorders(userx, usery) == true) {
            getFreehandPanel().clickedornot(userx, usery);
            getShapesPanel().checkAllIfClicked(userx, usery);
        }

        this.strokewidth.clicked(userx, usery);
        this.grid.clickedornot(userx, usery);
        this.file.clicked(userx, usery);
        this.edit.clicked(userx, usery);

        this.colorsToolbar.clicked(userx, usery);
        return true;

    }

    @Override
    public boolean mouseMoved(int x, int y) {

        getFile().moved(x, y);
        getEdit().moved(x, y);
        getShapesPanel().checkAllIfMoved(x, y);
        this.freehandPanel.movedornot(x, y);
        this.colorsToolbar.moved(x, y);
        this.strokewidth.moved(x, y);
        this.grid.movedornot(x, y);
        return true;

    }

    @Override
    public boolean mousePressed(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseReleased(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseEntered(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseExited(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseDragged(int userX, int userY) {

        return true;

    }

    @Override
    public boolean IfInBorders(int userX, int userY) {

        boolean one = super.IfInBorders(userX, userY);
        boolean two = false;
        if (getFile().isPressed() == true) {
            two = getFile().ifInBorders(userX, userY);
        }
        boolean three = false;
        if (getEdit().isPressed() == true) {
            three = getEdit().ifInBorders(userX, userY);
        }
        boolean four = false;
        if (this.strokewidth.getStrokeDropDown().isPressed() == true) {
            four = this.strokewidth.IfInBorders(userX, userY);
        }
        if (one == false && two == false && three == false && four == false) {
            return false;
        }
        return true;

    }

    @Override
    public String toString() {
        return "PanelUpper{" + "file=" + file + ", edit=" + edit + ", "
                + "shapesPanel=" + shapesPanel + ", freehandPanel="
                + freehandPanel + ", strokewidth=" + strokewidth
                + ", colorsToolbar=" + colorsToolbar + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ShapesToolbar getShapesPanel() {
        return shapesPanel;
    }

    public void setShapesPanel(ShapesToolbar shapesPanel) {
        this.shapesPanel = shapesPanel;
    }

    public DoubleButton getFreehandPanel() {
        return freehandPanel;
    }

    public void setFreehandPanel(DoubleButton freehandPanel) {
        this.freehandPanel = freehandPanel;
    }

    public MenuFile getFile() {
        return file;
    }

    public void setFile(MenuFile file) {
        this.file = file;
    }

    public MenuEdit getEdit() {
        return edit;
    }

    public void setEdit(MenuEdit edit) {
        this.edit = edit;
    }

    public StrokeSize getStrokewidth() {
        return strokewidth;
    }

    public void setStrokewidth(StrokeSize strokewidth) {
        this.strokewidth = strokewidth;
    }

    public ColorsToolbar getColorsToolbar() {
        return colorsToolbar;
    }

    public void setColorsToolbar(ColorsToolbar colorsToolbar) {
        this.colorsToolbar = colorsToolbar;
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

}
