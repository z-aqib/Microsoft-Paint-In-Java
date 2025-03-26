package Classes1Primary;

// PRIMARY CLASS: a basic initial class which does not depend on anything, 
// everything depends on them
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;

public class ZLabelColored extends ZLabel {

    private ZRectangle back;

    public ZLabelColored(String text, ZPoint position) {

        super(text, new ZPoint(position.getX() + 5, position.getY() - 5));
        int characters = text.length();
        int width = (characters * 10);
        int height = 20;
        int topY = getPosition().getY() - (height / 2) - 5;
        int topX = getPosition().getX() - 5;
        this.back = new ZRectangle("Back of Label '" + getText() + "' ",
                new ZPoint(topX, topY), width, height, Color.WHITE);

    }

    public ZLabelColored(String text, int x, int y) {

        this(text, new ZPoint(x, y));

    }

    public void updateText(String str) {

        this.setText(str);
        int length = str.length();
        int width = (length * 8);
        this.back.setWidth(width);

    }

    @Override
    public void paint(Graphics g) {

        this.back.paintPanel(g);
        super.paint(g);

    }

    @Override
    public void setPosition(ZPoint newPosition) {

        super.setPosition(newPosition);
        int height = 20;
        int topY = getPosition().getY() - (height / 2) - 5;
        int topX = getPosition().getX() - 5;
        this.back.setTopLeft(new ZPoint(topX, topY));

    }

    @Override
    public String toString() {
        return super.toString() + "ZLabelColored{" + "back=" + back + '}';
    }

    public ZRectangle getBack() {
        return back;
    }

    public void setBack(ZRectangle back) {
        this.back = back;
    }

}
