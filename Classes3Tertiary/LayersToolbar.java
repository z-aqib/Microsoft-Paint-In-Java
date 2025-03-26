package Classes3Tertiary;

// TERTIARY CLASS: a class which uses both secondary and primary classes and is directly implemented onto the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class LayersToolbar {

    private ZButtonToggle addButton;
    private ZButtonToggle deleteButton;
    private ZButtonToggle[] layers;
    private ZRectangle[] components;
    private int x;
    private int y;
    private int width;
    private int heightOfComponent;
    private int numberOfComponents;

    public LayersToolbar(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        /* 
        number of components:
        - add button
        - delete button
        - 6 layer buttons
        - 1 error label
        total: 9
         */
        this.numberOfComponents = 11;
        this.heightOfComponent = (height - 2) / this.numberOfComponents;
        intializeComponents();
        intializeAddButton();

    }

    private void intializeComponents() {

        this.components = new ZRectangle[this.numberOfComponents];
        for (int i = 0; i < components.length; i++) {
            this.components[i] = new ZRectangle("Component " + i, x,
                    y + i * heightOfComponent, width,
                    heightOfComponent, Color.LIGHT_GRAY);
        }

    }

    private void intializeAddButton() {

        ImageIcon pressed = new ImageIcon("src/PicturesLayers/add layer pressed.png");
        ImageIcon depressed = new ImageIcon("src/PicturesLayers/add layer depressed.png");
        this.addButton = new ZButtonToggle("add button", this.components[1].getTopLeft().getX() + 5,
                this.components[1].getTopLeft().getY() + 4, this.components[1].getWidth() - 10,
                this.components[1].getHeight() - 8, pressed.getImage(),
                depressed.getImage());

    }

    private void intializeLayers() {

        this.components = new ZRectangle[11];
        for (int i = 0; i < components.length; i++) {
            this.components[i] = new ZRectangle("Layer " + i, x, y + i * heightOfComponent, width,
                    heightOfComponent, Color.LIGHT_GRAY);
        }

    }

    public void paint(Graphics g, ImageObserver observer) {

        for (int i = 0; i < components.length; i++) {
            ZRectangle component = components[i];
            component.paintRectangle(g);
        }
        Font font = new Font("SansSerif", Font.BOLD, 14);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("To add Layer: ", this.components[0].getTopLeft().getX() + 10,
                this.components[0].getTopLeft().getY() + this.heightOfComponent - 10);
        this.addButton.paint(g, observer);
        g.drawString("To delete Layer: ", this.components[2].getTopLeft().getX() + 10,
                this.components[2].getTopLeft().getY() + this.heightOfComponent - 10);

    }

    public void clicked(int userX, int userY) {
        this.addButton.getListener().click(userX, userY);
    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZButtonToggle getAddButton() {
        return addButton;
    }

    public void setAddButton(ZButtonToggle addButton) {
        this.addButton = addButton;
    }

    public ZButtonToggle getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(ZButtonToggle deleteButton) {
        this.deleteButton = deleteButton;
    }

    public ZButtonToggle[] getLayers() {
        return layers;
    }

    public void setLayers(ZButtonToggle[] layers) {
        this.layers = layers;
    }

    public ZRectangle[] getComponents() {
        return components;
    }

    public void setComponents(ZRectangle[] components) {
        this.components = components;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeightOfComponent() {
        return heightOfComponent;
    }

    public void setHeightOfComponent(int heightOfComponent) {
        this.heightOfComponent = heightOfComponent;
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public void setNumberOfComponents(int numberOfComponents) {
        this.numberOfComponents = numberOfComponents;
    }

}
