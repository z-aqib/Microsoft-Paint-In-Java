package Classes4Quaternary;

// QUATERNARY CLASS: using all three levels of classes, a quaternary class is the building block of the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class PanelLower extends ZRectangle {

    /*
    so this class will be used for the lower panel, i.e. the bottom 200 degrees of the 
    entire frame. it consists of three labels, 
    - mouse coordinates: which display the coordinates of the cursor, it changes every 
    time the cursor moves across the screen.
    - color selected: displays the name of the color currently being painted with 
    (e.x. blue) and its r,g,b values respectively.
    - shape selected: displays the current shape selected by the cursor (e.x. triangle).
    This class has been extended from the parent class PANEL, which has the specific 
    panel attributes of x,y,width,height. 
     */
    private ZLabel mouseCoordinates; //displays mouse coordinates of cursor
    private ZLabel colorSelected; //displays current color of brush
    private ZLabel shapeSelected; //displays current shape of cursor
    private ZLabel strokeSelected; // displays the current stroke size of brush

    public PanelLower(String s, int x, int y, int width, int height, Color color) {

        super(s, x, y, width, height, color);
        intializeAssets();

    }

    private void intializeAssets() {

        /*
        so this method intializes the labels. the following steps are performed:
        - step1: all the labels will be painted on the same y-coordinate. hence compute the 
        y-coordinate by adding 20 pixels to the lower panel's y-coordinate
        - step2: the first label is printed 10 pixels after the lower panel's x-coordinate.
        the mouse coordinates will be printed first, hence compute their x-coordinate accordingly
        - step3: intialize the first label
        - step4: now get the length of the first label. since each character takes 
        10 pixels (my own computation), multiply the length of the first label by 10, 
        to get the size of the first label on the screen
        - step5: the x-coordinate of the second label would be computed by adding 
        the pixelSize of the first label to the first label starting point.
        - step6: intialize the second label
        - step7: repeat step 4 and 5 with the second label
        - step8: intialize the third label
         */
        int yCoordinate = getTopLeft().getY() + 20; //y-coordinate is same for all labels
        int xCoordinate_mouse = getTopLeft().getX() + 10; //compute x-coordinate of first label
        this.mouseCoordinates = new ZLabel("Mouse Coordinates: X=0, Y=0 ",
                xCoordinate_mouse, yCoordinate); //intialize first label
        int sizeOfTextM = this.mouseCoordinates.getText().length(); //find length of first label
        int mousePixels = sizeOfTextM * 8; //compute pixel size of first label
        int xCoordinate_color = xCoordinate_mouse + mousePixels; //add pixel size to first-label-starting-point
        this.colorSelected = new ZLabel("Black: [red=0, green=0, blue=0]", xCoordinate_color,
                yCoordinate); //intialize second label
        String color = "Customized Color: [red=0, green=0, blue=0]"; //longest string of second label
        int sizeOfTextC = color.length(); //find length of second label
        int colorPixels = sizeOfTextC * 8; //compute pixel size of second label
        int xCoordinate_shape = xCoordinate_color + colorPixels; //add pixel size to second-label-starting-point
        this.shapeSelected = new ZLabel("Freehand Brush ", xCoordinate_shape,
                yCoordinate); //intialize third label
        String shape = "Shape: Right-Angled Triangle";
        int sizeOfTextS = shape.length();
        int shapePixels = sizeOfTextS * 8;
        int xCoordinate_stroke = xCoordinate_shape + shapePixels - 10;
        this.strokeSelected = new ZLabel("Stroke Size = 1",
                xCoordinate_stroke, yCoordinate);

    }

    public void paint(Graphics g) {

        /*
        this is the paint method. it will first call super.paint() which will paint the 
        background of the panel. then it will set the font, its color, and paint each 
        label. 
         */
        super.paintPanel(g);
        getMouseCoordinates().paint(g);
        getColorSelected().paint(g);
        getShapeSelected().paint(g);
        this.strokeSelected.paint(g);

    }

    public boolean mouseMoved(int x, int y) {

        /*
        whenever the mouse/cursor moves, the mouse coordinates will change.
        no other label will change whenever the cursor moves. 
         */
        getMouseCoordinates().setText("Mouse Coordinates: X=" + x + " Y=" + y);
        return true;

    }

    public void selectedShape(int i) {

        /*
        whenever the mouse/cursor clicks on a shape, the program interprets which 
        shape has been selected accordingly to the index value and changes the 
        label to that shape name respectively. 
         */
        String str;
        switch (i) {
            case 0 ->
                str = ("Shape: Right-Angled triangle");
            case 1 ->
                str = ("Shape: Equilateral triangle");
            case 2 ->
                str = ("Shape: Rectangle");
            case 3 ->
                str = ("Shape: Circle");
            case 4 ->
                str = ("Shape: Hexagon");
            case 5 ->
                str = ("Shape: Pentagram");
            default ->
                str = ("Freehand Brush");
        }
        getShapeSelected().setText(str);

    }

    public void selectedColor(ZRectangle rectangle) {

        /*
        whenever the mouse/cursor clicks on a color, the program uses the rectangle of color to 
        interprets which color has been selected and changes the label to that 
        color name respectively. 
         */
        int red = rectangle.getFillColor().getRed();
        int green = rectangle.getFillColor().getGreen();
        int blue = rectangle.getFillColor().getBlue();
        String name = rectangle.getName();
        getColorSelected().setText("" + name + ": [red=" + red + ", green="
                + green + ", blue=" + blue + "]");

    }

    public void selectedStroke(int i) {

        String str = "Stroke Size = ";
        switch (i) {
            case 0 ->
                str = str + "1";
            case 1 ->
                str = str + "2";
            case 2 ->
                str = str + "3";
            case 3 ->
                str = str + "4";
        }
        this.strokeSelected.setText(str);

    }

    @Override
    public String toString() {
        return "LowerPanel{" + "mouseCoordinates=" + getMouseCoordinates().toString() + ", "
                + "colorSelected=" + getColorSelected().toString() + ", shapeSelected="
                + getShapeSelected() + ", " + super.toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZLabel getMouseCoordinates() {
        return mouseCoordinates;
    }

    public void setMouseCoordinates(ZLabel mouseCoordinates) {
        this.mouseCoordinates = mouseCoordinates;
    }

    public ZLabel getShapeSelected() {
        return shapeSelected;
    }

    public void setShapeSelected(ZLabel shapeSelected) {
        this.shapeSelected = shapeSelected;
    }

    public ZLabel getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(ZLabel colorSelected) {
        this.colorSelected = colorSelected;
    }

}
