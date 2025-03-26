package Classes3Tertiary;

// SECONDARY CLASS: is a class built upon/made from primary classes
import Classes2Secondary.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;

public class Grid extends DoubleButton {

    private ZRectangle frame;
    private int clickedTimes;
    private ZLabelColored numberOfLinesLabel;

    public Grid(String labelName, int x, int y, int width, int height,
            int buttonHeight, Color bckgcolor, Color buttonColor, String buttonColorName) {

        super(labelName, x, y, width, height, buttonHeight, bckgcolor, buttonColor, buttonColorName);
        this.getHeader().moveRightLeft(+10);
        this.clickedTimes = 0;
        setNumberOfLinesLabel();

    }

    private void setNumberOfLinesLabel() {

        int x = 760;
        int y = 525;
        this.numberOfLinesLabel = new ZLabelColored("", x, y);

    }

    private ZPoint[] linesMaker(ZRectangle rectangle, int number) {

        /*
        so for a grid of 2 by 2, we make (1 horizontal, 1 vertical) 2 lines |-, which is 4 points
        so for a grid of 3 by 3, we make (2 horizontal, 2 vertical) 4 lines ||--, which is 8 points
        so for a grid of 4 by 4, we make (3 horizontal, 3 vertical) 6 lines |||---, which is 12 points
        so for a grid of 5 by 5, we make (4 horizontal, 4 vertical) 8 lines ||||----, which is 16 points
        - hence formula derived is that
        for a grid x by x, we make (x-1)*2 lines, where each line has two points hence 
        number of points for x by x is (x-1)*4
         */
        int arraySize = (number - 1) * 4;
        ZPoint[] points = new ZPoint[arraySize];
        int counterArray = 0;
        int counterVerticalPoints = 1;
        int counterHorizontalPoints = 1;

        int width = rectangle.getWidth();
        int widthDivide = (width / number) + 1;
        int height = rectangle.getHeight();
        int heightDivide = (height / number) + 1;
        int xStarting = rectangle.getTopLeft().getX() + 2;
        int yStarting = rectangle.getTopLeft().getY() + 3;
        int xEnding = rectangle.getMaximum().getX();
        int yEnding = rectangle.getMaximum().getY() - 1;

        while ((counterArray + 1) < arraySize) {
            if ((counterArray + 1) < (arraySize / 2)) {
                points[counterArray] = new ZPoint(xStarting + (widthDivide * counterVerticalPoints), yStarting);
                points[counterArray + 1] = new ZPoint(xStarting + (widthDivide * counterVerticalPoints), yEnding);
                counterVerticalPoints++;
            } else {
                points[counterArray] = new ZPoint(xStarting, yStarting + (heightDivide * counterHorizontalPoints));
                points[counterArray + 1] = new ZPoint(xEnding, yStarting + (heightDivide * counterHorizontalPoints));
                counterHorizontalPoints++;
            }
            counterArray++;
            counterArray++;
        }

        return points;

    }

    private void Linespainter(ZPoint[] points, Graphics g) {

        int length = points.length;
        int counter = 0;

        while (counter < length) {
            g.setColor(Color.DARK_GRAY);

            g.drawLine(points[counter].getX(), points[counter].getY(),
                    points[counter + 1].getX(), points[counter + 1].getY());
            counter++;
            counter++;
        }

    }

    public void setFrame(int x, int y, int width, int height, Color bckgColor) {

        this.frame = new ZRectangle("Grid Frame", new ZPoint(x, y), width, height, Color.BLUE);

    }

    public void paintButton(Graphics g, ImageObserver observer) {
        super.paint(g, observer);

        ZPoint[] buttonLines = linesMaker(getColorSquare(), 3);
        super.paint(g, observer);
        Linespainter(buttonLines, g);

    }

    public void paintGrid(Graphics g) {

        if (this.clickedTimes != 0) {
            int lines = (int) Math.pow(2, this.clickedTimes);
            ZPoint[] points = linesMaker(this.frame, lines);
            Linespainter(points, g);
            this.numberOfLinesLabel.paint(g);
        }

    }

    @Override
    public boolean clickedornot(int userx, int usery) {

        boolean clicked = super.clickedornot(userx, usery);
        if (clicked == true) {
            this.clickedTimes++;
            if (this.clickedTimes > 6 || this.clickedTimes == 0) {
                this.clickedTimes = 0;
                makeUnClicked();
                this.numberOfLinesLabel.updateText("");
            } else {
                int gridLines = (int) Math.pow(2, this.clickedTimes);
                System.out.println("Number of Grid Lines = " + gridLines);
                this.numberOfLinesLabel.updateText("Grid Lines = " + gridLines);
            }
        }
        return clicked;

    }

}
