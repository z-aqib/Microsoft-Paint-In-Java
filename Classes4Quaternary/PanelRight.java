package Classes4Quaternary;

// QUATERNARY CLASS: using all three levels of classes, a quaternary class is the building block of the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class PanelRight extends ZRectangle {

    /*
    so this is the daughter class of ZPanel. it is the right side of the frame. 
    it will be used to display buttons of layers. 
     */
    private LayersToolbar layers; // 
    private ZButtonToggle layersButton;
    private boolean layersButtonClicked;

    public PanelRight(String name, int x, int y, int width, int height, Color color) {
        this(name, new ZPoint(x, y), width, height, color);
    }

    public PanelRight(String s, ZPoint p, int width, int height, Color color) {

        super(s, p, width, height, color);

        /*
        so the size of the right panel is point p, width, height. first there will be 
        a layers button which will be 
         */
        intializeLayersButton(782, 120, 100, 28);
        intializeLayers(p.getX(), p.getY(), width - 25, height - 5);

    }

    private void intializeLayersButton(int x, int y, int width, int height) {

        ImageIcon dp = new ImageIcon("src/PicturesLayers/layers depressed.png");
        ImageIcon p = new ImageIcon("src/PicturesLayers/layers pressed.png");
        this.layersButton = new ZButtonToggle("Layers", x, y, width, height,
                p.getImage(), dp.getImage());

    }

    private void intializeLayers(int x, int y, int width, int height) {
        this.layers = new LayersToolbar(x, y, width, height);
    }

    public boolean clicked(int userX, int userY) {

        if (getLayersButton().ifClicked(userX, userY) == true) {
            this.layersButtonClicked = true;
        }

        if (this.layersButtonClicked == true && getLayersButton().ifClicked(userX, userY) == true) {
            this.layersButtonClicked = true;
            this.layers.clicked(userX, userY);
        } else if (this.layersButtonClicked == true) {
            this.layersButtonClicked = true;
            this.layers.clicked(userX, userY);
        } else {
            this.layersButtonClicked = false;
            return false;
        }
        return true;

    }

    public void paint(Graphics g, ImageObserver observer) {

        this.layersButton.paint(g, observer);

        if (this.layersButtonClicked == true) {
            super.paintPanel(g);
            this.layers.paint(g, observer);
        }

    }

    public LayersToolbar getLayers() {
        return layers;
    }

    public void setLayers(LayersToolbar layers) {
        this.layers = layers;
    }

    public ZButtonToggle getLayersButton() {
        return layersButton;
    }

    public void setLayersButton(ZButtonToggle layersButton) {
        this.layersButton = layersButton;
    }

    public boolean isLayersButtonClicked() {
        return layersButtonClicked;
    }

    public void setLayersButtonClicked(boolean layersButtonClicked) {
        this.layersButtonClicked = layersButtonClicked;
    }

}
