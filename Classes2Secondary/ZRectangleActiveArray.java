package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.util.*;

public class ZRectangleActiveArray {

    /*
    this is the exact same class as BUTTONSLAYOUT except this is for ZRectangles and 
    not ZButtons. this is for ZRectangleActive buttons. 
    - this will be used in the ColorButtons class by being extended, and 
    the ColorGradient class. 
     */
    private ArrayList<ZRectangleActive> rectangles; // an arraylist of rectangle
    private ZRectangleActive currentColor; //this saves the selected rectangles color in the variable
    private ZRectangleActive movedColor;

    public ZRectangleActiveArray() {

        this.rectangles = new ArrayList<>();
        this.currentColor = new ZRectangleActive("Black", 0, 0,
                0, 0, Color.BLACK);
        this.movedColor = new ZRectangleActive("Black", 0, 0,
                0, 0, Color.BLACK);

    }

    public void paint(Graphics g) {

        /*
        this method paints all the rectangles in the array list
         */
        for (int i = 0; i < getRectangles().size(); i++) {
            getRectangles().get(i).paintRectangle(g);
        }

    }

    public void paintToolTip(Graphics g) {

        this.movedColor.paintToolTip(g);

    }

    public void addButton(ZRectangleActive rect) {

        /*
        this method adds a rectangle to the arraylist of rectangles
         */
        getRectangles().add(rect);

    }

    public boolean checkIfClicked(int x, int y) {

        /*
        this method checks each rectangle in the arraylist if it is clicked or not. 
        if it is clicked, it returns the color of the rectangle selected 
        if it is not clicked, it returns black
         */
        boolean b = false;

        for (int i = 0; i < getRectangles().size(); i++) {
            // if the button has been clicked, return its color
            if (getRectangles().get(i).ifSelected(x, y) == true) {
                this.currentColor = getRectangles().get(i);
                b = true;
                break;
            }
        }
        // otherwise declare color black
        return b;
    }

    public boolean moved(int x, int y) {

        /*
        this method checks each rectangle in the array list if the cursor is moving on 
        it or not, if yes, then it makes the moved color its rectangle otherwise it 
        returns false and the moved color is the last color moved. 
         */
        for (int i = 0; i < getRectangles().size(); i++) {
            getRectangles().get(i).ifMoved(x, y);
        }

        for (int i = 0; i < getRectangles().size(); i++) {
            if (getRectangles().get(i).ifMoved(x, y) == true) {
                this.movedColor = getRectangles().get(i);
                return true;
            }
        }
        return false;

    }

    public void changeColorOfButton(int index, ZRectangle color) {

        this.rectangles.get(index).setFillColor(color.getFillColor());

    }

    @Override
    public String toString() {
        return "ZRectangleActiveArray{" + "rectangles="
                + rectangles + ", currentColor=" + currentColor + ", movedColor="
                + movedColor + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ArrayList<ZRectangleActive> getRectangles() {
        return rectangles;
    }

    public void setRectangles(ArrayList<ZRectangleActive> rectangles) {
        this.rectangles = rectangles;
    }

    public ZRectangleActive getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(ZRectangleActive currentColor) {
        this.currentColor = currentColor;
    }

    public ZRectangleActive getMovedColor() {
        return movedColor;
    }

    public void setMovedColor(ZRectangleActive movedColor) {
        this.movedColor = movedColor;
    }

}
