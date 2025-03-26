package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ColorOptions extends ZRectangleActiveArray {

    /*
    this class consists of the displayed color buttons. it creates a color, creates a 
    rectangle button, adds it to an array list, and paints all of them.
    it is extended from the rectangles layout
     */
    private ZRectangle colorsToolbar; // this will save the features of the colors panel and paint it accordingly
    private int widthOfButtons; // width of each button (determined by toolbar width)
    private int heightOfButtons; // height of each button (determined by toolbar height)
    private ZLabel colorsPanelHeader; // colors toolbar header
    private final int colorsPanelHeaderHeight; // the height of headers is typically 20

    public ColorOptions(int x, int y, int width, int height, Color color) {

        super();
        this.colorsPanelHeaderHeight = 20;
        intializeColorsPanelFeatures(x, y + 1, width, height, color);
        computeWidthOfButtons();
        computeHeightOfButtons();
        int newwidth = (getWidthOfButtons() * 10) + (getXStarting()
                - getColorsToolbar().getTopLeft().getX() + 1);
        this.colorsToolbar.setWidth(newwidth);
        intializeColorsPanelHeader();
        intializeColors();

    }

    private void intializeColorsPanelFeatures(int x, int y, int width, int height, Color color) {

        this.colorsToolbar = new ZRectangle("Colors Toolbar", x, y, width, height, color);

    }

    private void computeWidthOfButtons() {

        this.widthOfButtons = (int) (Math.floor(getColorsToolbar().getWidth() / 10) - 1);

    }

    private void computeHeightOfButtons() {

        this.heightOfButtons = (int) (Math.floor((getColorsToolbar().getHeight()
                - getColorsPanelHeaderHeight()) / 3) - 1);

    }

    private void intializeColorsPanelHeader() {

        int x_HEADER = getColorsToolbar().getTopLeft().getX()
                + (getColorsToolbar().getWidth() / 4);
        int y_HEADER = getColorsToolbar().getTopLeft().getY()
                + getColorsToolbar().getHeight() - 5;
        this.colorsPanelHeader = new ZLabel("Colors Toolbar", x_HEADER, y_HEADER);

    }

    private void intializeColors() {

        /*
        this method intializes the colors toolbar buttons. first it creates 20 fixed 
        colors using specific RGB values, then it creates 20 buttons using those colors
        then adds these 20 buttons to the arraylist. then it creates 10 non-color
        identical buttons and adds each of them to the arraylist
         */
        // first intialize 20 fixed colors 
        Color black = new Color(0, 0, 0);           //1
        Color dark_gray = new Color(127, 127, 127);    //2
        Color maroon = new Color(136, 0, 21);       //3
        Color red = new Color(237, 28, 36);         //4
        Color orange = new Color(255, 127, 39);     //5
        Color yellow = new Color(255, 242, 0);      //6
        Color dark_green = new Color(34, 177, 76);     //7
        Color medium_blue = new Color(0, 162, 232);      //8
        Color dark_blue = new Color(63, 72, 204);      //9
        Color purple = new Color(163, 73, 164);     //10    
        Color white = new Color(255, 255, 255);     //11
        Color light_gray = new Color(195, 195, 195);    //12
        Color light_brown = new Color(185, 122, 87);    //13
        Color pink = new Color(255, 174, 201);      //14
        Color light_orange = new Color(255, 201, 14);   //15
        Color peach = new Color(239, 228, 176);     //16
        Color light_green = new Color(181, 230, 29);    //17
        Color light_blue = new Color(153, 217, 234);    //18
        Color deep_blue = new Color(112, 146, 190); //19
        Color light_purple = new Color(200, 191, 231);  //20

        // make 20 fixed buttons of each color
        ZRectangleActive b1 = makeButton("Black", black, 1);
        ZRectangleActive b2 = makeButton("Dark Gray", dark_gray, 2);
        ZRectangleActive b3 = makeButton("Maroon", maroon, 3);
        ZRectangleActive b4 = makeButton("Red", red, 4);
        ZRectangleActive b5 = makeButton("Orange", orange, 5);
        ZRectangleActive b6 = makeButton("Yellow", yellow, 6);
        ZRectangleActive b7 = makeButton("Dark Green", dark_green, 7);
        ZRectangleActive b8 = makeButton("Medium Blue", medium_blue, 8);
        ZRectangleActive b9 = makeButton("Dark Blue", dark_blue, 9);
        ZRectangleActive b10 = makeButton("Purple", purple, 10);
        ZRectangleActive b11 = makeButton("White", white, 11);
        ZRectangleActive b12 = makeButton("Light Gray", light_gray, 12);
        ZRectangleActive b13 = makeButton("Light Brown", light_brown, 13);
        ZRectangleActive b14 = makeButton("Pink", pink, 14);
        ZRectangleActive b15 = makeButton("Light Orange", light_orange, 15);
        ZRectangleActive b16 = makeButton("Peach", peach, 16);
        ZRectangleActive b17 = makeButton("Light Green", light_green, 17);
        ZRectangleActive b18 = makeButton("Light Blue", light_blue, 18);
        ZRectangleActive b19 = makeButton("Deep Blue", deep_blue, 19);
        ZRectangleActive b20 = makeButton("Light Purple", light_purple, 20);

        // add each color button to the arraylist
        addButton(b1);
        addButton(b2);
        addButton(b3);
        addButton(b4);
        addButton(b5);
        addButton(b6);
        addButton(b7);
        addButton(b8);
        addButton(b9);
        addButton(b10);
        addButton(b11);
        addButton(b12);
        addButton(b13);
        addButton(b14);
        addButton(b15);
        addButton(b16);
        addButton(b17);
        addButton(b18);
        addButton(b19);
        addButton(b20);

        // now start a loop for the last 10 non-color buttons
        for (int i = 0; i < 10; i++) {
            ZRectangleActive b = new ZRectangleActive("Customized Color",
                    new ZPoint(getXStarting() + i * getWidthOfButtons(),
                            getYStarting() + 2 * getHeightOfButtons()), getWidthOfButtons(),
                    getHeightOfButtons(), Color.LIGHT_GRAY);
            addButton(b); // add 10 buttons to the arraylist
        }

    }

    private ZRectangleActive makeButton(String name, Color c, int i) {

        /*
        this button makes/intialises a rectangle button, using the index the button 
        is on.
        - so example I have button index i = 10. so the third else 
        statement would be used, the x-change would be 9 and the y-change would be 
        0, i.e. the 10th button would be in the first row, 10th column.
        - example i have 21. so the second if-else statement would be 
        used, the x-change would be 0, while the y-change would be 2. 
         */
        int xChange;
        int yChange;
        if (i > 20) { // if the number is in the third row
            xChange = (i - 1) - 20;
            yChange = 2;
        } else if (i > 10) { // if the number is in the second row
            xChange = (i - 1) - 10;
            yChange = 1;
        } else { // if the number is in the first row
            xChange = i - 1;
            yChange = 0;
        }
        ZRectangleActive rect = new ZRectangleActive(name, new ZPoint(getXStarting()
                + xChange * getWidthOfButtons(), getYStarting() + yChange
                * getHeightOfButtons()), getWidthOfButtons(), getHeightOfButtons(), c);
        return rect;

    }

    @Override
    public void paint(Graphics g) {

        /*
        this is the paint method. first it creates the colors toolbar border. then it 
        paints the header line of the colors toolbar. then it paints each button in 
        the arraylist, then it paints a border around the color buttons. 
         */
        // first paint the toolbar's panel
        getColorsToolbar().paintPanel(g);
        // then paint the color toolbar's label
        getColorsPanelHeader().paint(g);
        // now paint all the colors
        super.paint(g);

        g.setColor(Color.BLACK);
        // compute the colors height by subtracting the headers height
        int colorsHeight = getColorsToolbar().getHeight() - getColorsPanelHeaderHeight();
        // border around the buttons
        g.drawRect(getColorsToolbar().getTopLeft().getX(), getColorsToolbar().getTopLeft().getY(),
                getColorsToolbar().getWidth(), colorsHeight);

    }

    public boolean IfInBorders(int userX, int userY) {

        boolean inBorders = getColorsToolbar().IfInBorders(userX, userY);
        return inBorders;

    }

    public int getXStarting() {
        return getColorsToolbar().getTopLeft().getX() + 2;
    }

    public int getYStarting() {
        return getColorsToolbar().getTopLeft().getY() + 2;
    }

    @Override
    public String toString() {
        return "ColorButtons{" + "colorsToolbar=" + getColorsToolbar().toString() + ", widthOfButtons="
                + getWidthOfButtons() + ", heightOfButtons=" + getHeightOfButtons() + ", colorsPanelHeader="
                + getColorsPanelHeader() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZLabel getColorsPanelHeader() {
        return colorsPanelHeader;
    }

    public void setColorsPanelHeader(ZLabel colorsPanelHeader) {
        this.colorsPanelHeader = colorsPanelHeader;
    }

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

    public int getColorsPanelHeaderHeight() {
        return colorsPanelHeaderHeight;
    }

    public ZRectangle getColorsToolbar() {
        return colorsToolbar;
    }

    public void setColorsToolbar(ZRectangle colorsToolbar) {
        this.colorsToolbar = colorsToolbar;
    }

}
