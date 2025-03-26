package Classes6Others;

import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import Classes5Main.*;
import java.awt.Color;
import java.io.*;
import java.util.*;

public class FileReader {

    public File[] getFiles() {

        File folder = new File("src/Files");
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;

    }

    public void readFile(File file) {

        String fileName = file.getName();

        DrawFrame frame = new DrawFrame();
        frame.runDrawFrame();

        PaintWindow window = frame.getPanel().getWindow();
        FactoryOfShapes shapeFactory = window.getMiddleArea().getShapeMaker().getShapeFactory();
        ColorOptions options = window.getUpperpanel().getColorsToolbar().getColorsOptions();
        ZStack stack = window.getMiddleArea().getStack();

        window.getFilename().setText("File Name: " + fileName + ".png");

        try {
//         declare reader to read file
            Scanner myReader = new Scanner(file);
            boolean startColors = false;
            int colorCounter = 20;

            while (myReader.hasNext() == true) {

                String str = myReader.nextLine();
                if (str.equals("")) {
                    startColors = true;
                } else if (startColors == true) {
                    String[] strBreak = str.split("\\[");
                    String colorDetails = strBreak[1];
                    String[] colorDeets = colorDetails.split(",");
                    int red = 0;
                    int green = 0;
                    int blue = 0;
                    for (int i = 0; i < colorDeets.length; i++) {
                        String colorDeet = colorDeets[i];
                        String[] colorValue = colorDeet.split("=");
                        switch (i) {
                            case 0 ->
                                red = Integer.parseInt(colorValue[1]);
                            case 1 ->
                                green = Integer.parseInt(colorValue[1]);
                            case 2 -> {
                                blue = Integer.parseInt(colorValue[1].substring(
                                        0, colorValue[1].length() - 1));
                            }
                        }
                    }
                    Color color = new Color(red, green, blue);
                    options.getRectangles().get(colorCounter).setFillColor(color);
                    colorCounter++;
                } else {
                    // necessary values
                    int width, height;
                    int x, y;
                    int redFill, greenFill, blueFill;
                    int redBorder, greenBorder, blueBorder;
                    int borderWidth;
                    String[] strBreak = str.split("\\{");
                    // first strbreak
                    String shapeType = strBreak[0];
                    // second strbreak
                    String[] widthHeight = strBreak[1].split(",");
                    String[] widthComponents = widthHeight[0].split("=");
                    width = Integer.parseInt(widthComponents[1]);
                    String[] heightComponents = widthHeight[1].split("=");
                    height = Integer.parseInt(heightComponents[1]);
                    // third strbreak
                    String[] strBreak2 = strBreak[2].split("\\}");
                    // first strBreak2
                    String[] xyValues = strBreak2[0].split(",");
                    String[] xValues = xyValues[0].split("=");
                    x = Integer.parseInt(xValues[1].strip());
                    String[] yValues = xyValues[1].split("=");
                    y = Integer.parseInt(yValues[1].strip());
                    // second strBreak2
                    String[] strBreak3 = strBreak2[1].split("\\[");
                    // second strBreak3
                    String[] strBreak4 = strBreak3[1].split("\\]");
                    // first strBreak4
                    String[] rgbFill = strBreak4[0].split(",");
                    String[] redValueFill = rgbFill[0].split("=");
                    redFill = Integer.parseInt(redValueFill[1]);
                    String[] greenValueFill = rgbFill[1].split("=");
                    greenFill = Integer.parseInt(greenValueFill[1]);
                    String[] blueValueFill = rgbFill[2].split("=");
                    blueFill = Integer.parseInt(blueValueFill[1]);
                    // second strBreak4
                    String[] strBreak5 = strBreak3[2].split("\\]");
                    // first strBreak 5
                    String[] rgbBorder = strBreak5[0].split(",");
                    String[] redValueBorder = rgbBorder[0].split("=");
                    redBorder = Integer.parseInt(redValueBorder[1]);
                    String[] greenValueBorder = rgbBorder[1].split("=");
                    greenBorder = Integer.parseInt(greenValueBorder[1]);
                    String[] blueValueBorder = rgbBorder[2].split("=");
                    blueBorder = Integer.parseInt(blueValueBorder[1]);
                    // second strBreak 5
                    String[] borderw = strBreak5[1].split("=");
                    borderWidth = Integer.parseInt(borderw[1]);

                    InterfaceShape shape = shapeFactory.getShape(shapeType, width, height,
                            new ZPoint(x, y), new Color(redFill, greenFill, blueFill),
                            new Color(redBorder, greenBorder, blueBorder), borderWidth);
                    stack.push(shape);

                }

            }

            System.out.println("File '" + file.getName() + "' has been read. ");

        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File '" + file.getName() + "' not found. ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: Index is out of bounds. File is unable to be read. ");
        } catch (NullPointerException e) {
            System.out.println("ERROR: Pointer is null. File is unable to be read. ");
        } catch (IllegalStateException e) {
            System.out.println("ERROR: There is an illegal state present. File is unable to be read. ");
        } catch (RuntimeException e) {
            System.out.println("ERROR: Run time error. File is unable to be read. ");
        } catch (Exception e) {
            System.out.println("ERROR: File cannot be read. ");
        }
    }

}
