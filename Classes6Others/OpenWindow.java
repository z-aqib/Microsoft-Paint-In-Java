package Classes6Others;

import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import Classes5Main.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.*;

public class OpenWindow extends PopUpWindow {

    private File[] files;
    private ZRectangleActive[] rectangles;
    private ZLabel[] fileNames;
    private FileReader fileReader;

    public OpenWindow() {

        super();
        
        fileReader = new FileReader();
        this.files = fileReader.getFiles();
        ZRectangle totalArea = new ZRectangle("open window back",
                getTopBorder().getTopLeft().getX() + 5,
                getTopBorder().getMaximum().getY() + 5,
                getBack().getWidth() - 5,
                getOkButton().getTopLeft().getY() - getTopBorder().getMaximum().getY() - 5,
                getBack().getFillColor());
        int oneSide = (int) Math.floor(this.files.length / 2) + 1;
        if (oneSide == 0) {
            oneSide = 1;
        }
        int heightOfBox = totalArea.getHeight() / oneSide;
        int widthOfBox = totalArea.getWidth() / 2;
        this.rectangles = new ZRectangleActive[this.files.length];
        this.fileNames = new ZLabel[this.files.length];

        int x = totalArea.getTopLeft().getX();
        int rectangleCounter = 0;

        for (int i = 0; i < this.files.length; i++) {
            if (i == oneSide) {
                x = x + widthOfBox;
                rectangleCounter = 0;
            }
            int y = totalArea.getTopLeft().getY() + (rectangleCounter * heightOfBox);
            ZRectangleActive rectangle = new ZRectangleActive("File " + i, x, y, widthOfBox,
                    heightOfBox, Color.ORANGE);
            this.rectangles[i] = rectangle;
            File file = files[i];
            String fileName = file.getName();
            int xLabel = rectangle.getTopLeft().getX() + (widthOfBox / 6);
            int yLabel = rectangle.getTopLeft().getY() + (heightOfBox / 2);
            ZLabel label = new ZLabel(fileName, xLabel, yLabel);
            this.fileNames[i] = label;
            rectangleCounter++;
        }

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        for (int i = 0; i < rectangles.length; i++) {
            ZRectangleActive rectangle = rectangles[i];
            rectangle.paintRectangle(g);
            ZLabel label = fileNames[i];
            label.paint(g);
        }

    }

    @Override
    public boolean moved(int userx, int usery) {

        super.moved(userx, usery);
        for (int i = 0; i < this.rectangles.length; i++) {
            ZRectangleActive rectangle = rectangles[i];
            rectangle.ifMoved(userx, usery);
        }
        return true;

    }

    @Override
    public void paintToolTip(Graphics g) {

        for (int i = 0; i < rectangles.length; i++) {
            ZRectangleActive rectangle = rectangles[i];
            File file = files[i];
            rectangle.getToolTip().getLabel().updateText(file.getName()); 
            rectangle.paintToolTip(g);
        }

    }

    @Override
    public boolean clicked(int userx, int usery) {

        for (int i = 0; i < rectangles.length; i++) {
            ZRectangleActive rectangle = rectangles[i];
            boolean b = rectangle.ifSelected(userx, usery);
            if (b == true) {
                File file = files[i];
                fileReader.readFile(file);
            }
        }
        return super.clicked(userx, usery);

    }

}
