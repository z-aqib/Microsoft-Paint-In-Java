package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;

// COMPLETED
public interface ClickListener {

    /*
    so this interface is a click listener interface. in this a method click() will be 
    made in which the programmer (me) can edit the function that will be performed for
    each button. hence it can be different for each button.
     */
    public void click(int x, int y);

}
