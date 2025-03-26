package Classes2Secondary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ToolTip {

    private ZLabelColored label;
    static ToolTip toolTip = new ToolTip();

    // make constructor private so the instance is not instantiated from outside
    private ToolTip() {

    }

    public static ToolTip getToolTip() {

        return toolTip;

    }

    public void declareLabel(String text, ZPoint position) {

        this.label = new ZLabelColored(text, position);
        this.label.decrementSize();
        this.label.decrementSize();
        this.label.getBack().setWidth((text.length() * 7));

    }

    public void paint(Graphics g) {

        if (this.label == null) {
            this.label = new ZLabelColored("", new ZPoint());
        }
        this.label.paint(g);

    }

    public void setPosition(ZPoint newPosition) {

        if (this.label == null) {
            this.label = new ZLabelColored("", new ZPoint());
        }
        this.label.setPosition(newPosition);

    }

    @Override
    public String toString() {
        return "ToolTip{" + "label=" + label + '}';
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZLabelColored getLabel() {
        return label;
    }

    public void setLabel(ZLabelColored label) {
        this.label = label;
    }

}
