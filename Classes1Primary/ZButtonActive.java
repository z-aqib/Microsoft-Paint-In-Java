package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

// NOT USED
public class ZButtonActive extends ZButton {

    /*
    an active button is a button which changes pressed depressed state constantly when mouse 
    touches it. when clicked, nothing happens. 
    this active button is only applicable for COLOR BUTTONS. shapes are toggle as when 
    cursor moves on them they deflect but when clicked they are pressed until 
    something else is clicked. menu buttons are also toggle buttons. 
     */
    // this class has not been used as color buttons are defined in ZRectangle. 
    public ZButtonActive(String name, int x, int y, int width, int height, Image pressedImage, Image depressedImage) {
        super(name, x, y, width, height, pressedImage, depressedImage);
    }

    public ZButtonActive(String name, ZPoint p, int width, int height, Image pressedImage, Image depressedImage) {
        super(name, p, width, height, pressedImage, depressedImage);
    }

    @Override
    public String toString() {
        return "ZButtonActive{" + super.toString() + '}';
    }

}
