package Classes6Others;

import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class FileCreator {

    public boolean createFile(ZStack stack, PanelUpper upperPanel) {

        File file = null;
        String dateTime = getDateAndTime();
        try {
            file = new File("src/Files/" + dateTime + ".txt");
            if (file.createNewFile() == true) {
                System.out.println("File '" + file.getName() + "' has been created. ");
            } else {
                System.out.println("File '" + file.getName() + "' already exists. ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File '" + file.getName() + "' not found. ");
        } catch (IOException e) {
            System.out.println("ERROR: File not created. ");
        }

        try {

            // create a file writer
            FileWriter myWriter = new FileWriter(file);
            String str = "";

            str = str + stack.toString();
            str = str + "\n";
            str = str + customizedColorsToString(upperPanel);

            // write all the details and close writer
            myWriter.write(str);
            myWriter.close();

            // display that the writing is done
            System.out.println("File '" + file.getName() + "' has been written to. ");

        } catch (IOException e) {
            System.out.println("ERROR: File could not be written. ");
            return false;
        } catch (Exception e) {
            System.out.println("ERROR: General Exception thrown. ");
            return false;
        }

        return true;

    }

    public String getDateAndTime() {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTime = dtf.format(now);
        String[] datetime = dateTime.split(" ");
        String str = "Date " + datetime[0] + " Time " + datetime[1];
        return str;

    }

    public String customizedColorsToString(PanelUpper upperPanel) {

        Color[] colors = getCustomizedColors(upperPanel);
        String str = "";
        for (int i = 0; i < colors.length; i++) {
            Color color = colors[i];
            str = str + color.toString() + "\n";
        }
        return str;

    }

    public Color[] getCustomizedColors(PanelUpper upperPanel) {

        ArrayList<ZRectangleActive> rectangles
                = upperPanel.getColorsToolbar().getColorsOptions().getRectangles();
        Color[] colors = new Color[10];
        int arrayListCounter = 20;
        for (int i = 0; i < colors.length; i++, arrayListCounter++) {
            ZRectangleActive rectangle = rectangles.get(arrayListCounter);
            colors[i] = rectangle.getFillColor();
        }
        return colors;

    }

}
