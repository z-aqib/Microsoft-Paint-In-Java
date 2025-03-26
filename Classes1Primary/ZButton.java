package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;

public class ZButton {

    private String name; //name of the button
    private ZPoint topLeftCorner; //x, y coordinate of button
    private ZPoint maximum; // the maximum values of x,y coordinate of button
    private int width; //width of the button
    private int height; //height of the button
    private Image pressedImage; //image when button is pressed
    private Image depressedImage; //image when button is not pressed
    private Image currentImage; //current image of the button (pressed or depressed)

    public ZButton(String name, int x, int y, int width, int height, Image pressedImage, Image depressedImage) {

        this(name, new ZPoint(x, y), width, height, pressedImage, depressedImage);

    }

    public ZButton(String name, ZPoint p, int width, int height, Image pressedImage, Image depressedImage) {

        this.name = name;
        this.topLeftCorner = p;
        this.width = width;
        this.height = height;
        // scale the pictures to their width and height
        this.pressedImage = pressedImage.getScaledInstance(this.width,
                this.height, Image.SCALE_FAST);
        this.depressedImage = depressedImage.getScaledInstance(this.width,
                this.height, Image.SCALE_FAST);
        this.currentImage = depressedImage; // assign current image the depressed image
        computeMaximum(); // compute the maximum points

    }

    private void computeMaximum() {

        /*
        this method computes the maximum points of each image i.e. its maximum X coordinate
        and its maximum Y coordinate. this will be used for checking if the image has 
        been clicked or not
         */
        int x = getTopLeftCorner().getX() + getWidth();
        int y = getTopLeftCorner().getY() + getHeight();
        this.maximum = new ZPoint(x, y);

    }

    public String buttonBorders() {

        /*
        this method returns a string which tells us the x-coordinate minimum, maximum
        and y-coordinate minimum, maximum of a button
         */
        String str = "X-Minimum=" + getTopLeftCorner().getX() + " X-Maximium="
                + (getTopLeftCorner().getX() + getWidth()) + " Y-Minimum=" + getTopLeftCorner().getY()
                + " Y-Maximum=" + (getTopLeftCorner().getY() + getHeight());
        return str;

    }

    public void paint(Graphics g, ImageObserver observer) {

        /*
        this method paints the button i.e. it draws the current image
         */
        g.drawImage(getCurrentImage(), getTopLeftCorner().getX(), getTopLeftCorner().getY(),
                getWidth(), getHeight(), observer);
        g.setColor(Color.BLACK);
        g.drawRect(getTopLeftCorner().getX() - 1, getTopLeftCorner().getY() - 1,
                getWidth() + 1, getHeight() + 1);

    }

    public boolean IfInBorders(int userX, int userY) {

        if (userX >= getTopLeftCorner().getX()
                && userX <= getMaximum().getX()
                && userY >= getTopLeftCorner().getY()
                && userY <= getMaximum().getY()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ZButton {" + "name=" + getName() + ", topLeftCorner=" + getTopLeftCorner().toString()
                + ", maximum=" + getMaximum().toString() + ", width=" + getWidth()
                + ", height=" + getHeight() + ", pressedImage=" + getPressedImage()
                + ", depressedImage=" + getDepressedImage() + ", currentImage="
                + getCurrentImage() + ", button borders=" + buttonBorders() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZPoint getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public void setTopLeftCorner(ZPoint center) {
        this.topLeftCorner = center;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Image getPressedImage() {
        return pressedImage;
    }

    public void setPressedImage(Image pressedImage) {
        this.pressedImage = pressedImage;
    }

    public Image getDepressedImage() {
        return depressedImage;
    }

    public void setDepressedImage(Image depressedImage) {
        this.depressedImage = depressedImage;
    }

    public Image getCurrentImage() {
        return currentImage;
    }

    public void setCurrentImage(Image currentImage) {
        this.currentImage = currentImage;
    }

    public ZPoint getMaximum() {
        return maximum;
    }

    public void setMaximum(ZPoint maximum) {
        this.maximum = maximum;
    }

}
