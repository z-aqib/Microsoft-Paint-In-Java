package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;

// COMPLETED
public class ZPoint {

    /*
    this is a basic point class used to store x and y coordinates. 
     */
    private int x;
    private int y;

    public ZPoint() {

        this.x = 0;
        this.y = 0;

    }

    public ZPoint(int x, int y) {

        this.x = x;
        this.y = y;

    }

    public ZPoint(ZPoint p) {

        this.x = p.x;
        this.y = p.y;

    }

    @Override
    public String toString() {

        return "ZPoint {" + "x = " + getX() + ", y = " + getY() + "}";

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
