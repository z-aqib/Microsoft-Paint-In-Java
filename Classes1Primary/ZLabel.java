package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ZLabel {

    /*
    this class is a ZLabel class. it is basically a g.drawString class, in which you 
    enter the text you need to be printed on what coordinate and it will print it 
    accordingly in the color BLACK. size/font can be adjusted as per choice. 
     */
    private String text; // text of the label
    private ZPoint position; // position/placing of the label
    private Font font; // this is the font of the label

    public ZLabel(String text, ZPoint position) {

        this.text = text;
        this.position = position;
        // the default font will be set, which can be adjusted later on
        Font fontDefault = new Font("SansSherif", Font.BOLD, 12);
        this.font = fontDefault;

    }

    public ZLabel(String text, int x, int y) {

        this(text, new ZPoint(x, y));

    }

    public void paint(Graphics g) {

        g.setFont(getFont());
        g.setColor(Color.BLACK);
        g.drawString(getText(), getPosition().getX(), getPosition().getY());

    }

    public void setFont(String nameOfFont, int size) {

        /*
        this method sets the font of the label according to the buttons choice. 
         */
        this.font = new Font(nameOfFont, Font.BOLD, size);

    }

    public void moveRightLeft(int num) {

        this.position.setX(this.position.getX() + num);

    }

    public void incrementSize() {

        this.font = new Font(this.font.getFontName(), Font.BOLD, this.font.getSize() + 1);

    }

    public void decrementSize() {

        this.font = new Font(this.font.getFontName(), Font.BOLD, this.font.getSize() - 1);

    }

    @Override
    public String toString() {
        return "Label {" + "text = '" + getText() + "', " + getPosition().toString() + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZPoint getPosition() {
        return position;
    }

    public void setPosition(ZPoint position) {
        this.position = position;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

}
