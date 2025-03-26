package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class ShapesToolbar extends ZButtonToggleArray {

    private ZLabel shapesPanelHeader;
    private ZRectangle shapesPanel;
    private int widthOfButtons;
    private int heightOfButtons;
    private int shapesPanelHeaderHeight;

    public ShapesToolbar(int x, int y, int width, int height, Color backgroundColor) {

        super();
        this.shapesPanelHeaderHeight = 20;

        // SAMPLE SHAPES PANEL COORDINATES: 270, 0, 200, 98
        this.shapesPanel = new ZRectangle("Shapes Panel", x, y, width, height, backgroundColor);
        computeWidthOfButtons();
        computeHeightOfButtons();

        intializeShapesPanelHeader(x, y, width, height);

        intializeRightAngleTriangle();
        intializeEquilateralTriangle();
        intializeRectangle();
        intializeCircle();
        intializeHexagon();
        intializePentagram();

    }

    private void computeWidthOfButtons() {

        this.widthOfButtons = ((getShapesPanel().getWidth()) / 3) - 1;

    }

    private void computeHeightOfButtons() {

        this.heightOfButtons = ((getShapesPanel().getHeight() - getShapesPanelHeaderHeight()) / 2) - 1;

    }

    private void intializeRightAngleTriangle() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/right angled triangle depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/right angled triangle pressed.png");
        ZButtonToggle rightAngleTriangle = new ZButtonToggle("Right Angled Triangle",
                getXS(), getYS(), getWidthOfButtons(), getHeightOfButtons(),
                p.getImage(), dp.getImage());
        addButton(rightAngleTriangle);

    }

    private void intializeEquilateralTriangle() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/equilateral triangle depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/equilateral triangle pressed.png");
        ZButtonToggle equilateralTriangle = new ZButtonToggle("Equilateral Triangle",
                getXS() + getWidthOfButtons(), getYS(),
                getWidthOfButtons(), getHeightOfButtons(),
                p.getImage(), dp.getImage());
        addButton(equilateralTriangle);

    }

    private void intializeRectangle() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/rectangle depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/rectangle pressed.png");
        ZButtonToggle rectangle = new ZButtonToggle("Rectangle", getXS() + 2 * getWidthOfButtons(), getYS(),
                getWidthOfButtons(), getHeightOfButtons(),
                p.getImage(), dp.getImage());
        addButton(rectangle);

    }

    private void intializeCircle() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/circle depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/circle pressed.png");
        ZButtonToggle circle = new ZButtonToggle("Circle", getXS(), (getYS() + getHeightOfButtons()),
                getWidthOfButtons(),
                getHeightOfButtons(), p.getImage(), dp.getImage());
        addButton(circle);

    }

    private void intializeHexagon() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/hexagon depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/hexagon pressed.png");
        ZButtonToggle hexagon = new ZButtonToggle("Hexagon", getXS() + getWidthOfButtons(), getYS() + getHeightOfButtons(),
                getWidthOfButtons(), getHeightOfButtons(),
                p.getImage(), dp.getImage());
        addButton(hexagon);

    }

    private void intializePentagram() {

        ImageIcon dp = new ImageIcon("src/PicturesShapes/pentagram depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesShapes/pentagram pressed.png");
        ZButtonToggle pentagram = new ZButtonToggle("Pentagram", getXS() + 2 * getWidthOfButtons(),
                getYS() + getHeightOfButtons(), getWidthOfButtons(), getHeightOfButtons(),
                p.getImage(), dp.getImage());
        addButton(pentagram);

    }

    private void intializeShapesPanelHeader(int x, int y, int width, int height) {

        int x_header = x + width / 4;
        int y_header = y + height - 6;

        this.shapesPanelHeader = new ZLabel("Shapes Toolbar", x_header, y_header);

    }

    @Override
    public void paint(Graphics g, ImageObserver observer) {

        getShapesPanel().paintPanel(g); // paint the panel first 
        g.setColor(Color.BLACK);
        Font font = new Font("SansSerif", Font.BOLD, 13);
        g.setFont(font);
        getShapesPanelHeader().paint(g); // then paint the label

        super.paint(g, observer); // paint the buttons

        g.setColor(Color.BLACK);
        // border around one row of buttons
        g.drawRect(getShapesPanel().getTopLeft().getX(),
                getShapesPanel().getTopLeft().getY(),
                getShapesPanel().getWidth(), getHeightOfButtons() + 2);
        // border around two rows of buttons
        g.drawRect(getShapesPanel().getTopLeft().getX(),
                getShapesPanel().getTopLeft().getY(),
                getShapesPanel().getWidth(), (getHeightOfButtons() * 2) + 1);
        // border around first column of buttons
        g.drawRect(getShapesPanel().getTopLeft().getX(),
                getShapesPanel().getTopLeft().getY(),
                (getWidthOfButtons() * 1) + 1, (getHeightOfButtons() * 2) + 1);
        // border around second column of buttons
        g.drawRect(getShapesPanel().getTopLeft().getX(),
                getShapesPanel().getTopLeft().getY(),
                getWidthOfButtons() * 2 + 1, (getHeightOfButtons() * 2) + 1);

    }

    public boolean IfInBorders(int userX, int userY) {

        boolean ifInBorders = getShapesPanel().IfInBorders(userX, userY);
        return ifInBorders;

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getWidthOfButtons() {
        return widthOfButtons;
    }

    public void setWidthOfButtons(int widthOfButtons) {
        this.widthOfButtons = widthOfButtons;
    }

    public int getHeightOfButtons() {
        return heightOfButtons;
    }

    public void setHeightOfButtons(int heightOfButtons) {
        this.heightOfButtons = heightOfButtons;
    }

    public ZLabel getShapesPanelHeader() {
        return shapesPanelHeader;
    }

    public void setShapesPanelHeader(ZLabel shapesPanelHeader) {
        this.shapesPanelHeader = shapesPanelHeader;
    }

    public int getXS() {
        return getShapesPanel().getTopLeft().getX() + 2;
    }

    public int getYS() {
        return getShapesPanel().getTopLeft().getY() + 2;
    }

    public ZRectangle getShapesPanel() {
        return shapesPanel;
    }

    public void setShapesPanel(ZRectangle shapesPanel) {
        this.shapesPanel = shapesPanel;
    }

    public int getShapesPanelHeaderHeight() {
        return shapesPanelHeaderHeight;
    }

    public void setShapesPanelHeaderHeight(int shapesPanelHeaderHeight) {
        this.shapesPanelHeaderHeight = shapesPanelHeaderHeight;
    }

}
