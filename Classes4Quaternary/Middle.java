package Classes4Quaternary;

// QUATERNARY CLASS: using all three levels of classes, a quaternary class is the building block of the program
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import Classes6Others.*;
import Classes0FactoryDesignPattern.*;
import java.awt.*;

public class Middle implements MouseListener {

    private PanelUpper upperPanel;
    private ShapeMaker shapeMaker;
    private ZStack stack;
    private ZQueue queue;
    private ZPoint startingPoint;
    private InterfaceShape pendingShape;
    private ZLabelColored pendingShapeDetails;
    private ZLabelColored randomLabel;
    private boolean printRandomLabel;
    private Freehand pendingFreehand;

    public Middle(PanelUpper upper) {

        this.upperPanel = upper;
        this.stack = new ZStack();
        this.queue = new ZQueue();
        this.pendingShapeDetails = new ZLabelColored("", 150, 523);
        this.shapeMaker = new ShapeMaker(this.upperPanel);
        this.randomLabel = new ZLabelColored("", 200, 400);
        this.printRandomLabel = false;
        this.pendingFreehand = new Freehand();

    }

    @Override
    public boolean mouseClicked(int userX, int userY) {

        if (this.upperPanel.IfInBorders(userX, userY) == false) {

            if (this.upperPanel.getFreehandPanel().isPressedOrNot() == true) {
                this.pendingFreehand.addShape(shapeMaker.makeFreehandShape(userX, userY));
            } else {
                this.startingPoint = new ZPoint(userX, userY);
            }

        }

        // UNDO
        if (this.upperPanel.getEdit().getButtons().get(0).isClickedStatus() == true) {
            removeLastShape();
        }
        // REDO
        if (this.upperPanel.getEdit().getButtons().get(1).isClickedStatus() == true) {
            redoLastShape();
        }
        // SAVE BUTTON
        if (this.upperPanel.getFile().getButtons().get(2).isClickedStatus() == true) {
            FileCreator fileCreator = new FileCreator();
            boolean created = fileCreator.createFile(stack, upperPanel);
            if (created == true) {
                this.randomLabel.updateText("File has been successfully saved "
                        + "with current date and time!");
                this.printRandomLabel = true;
            }
            this.upperPanel.getFile().getButtons().get(2).setClickedStatus(false);
        }

        // 
        return true;

    }

    public void removeLastShape() {

        if (stack.empty() == false) {
            InterfaceShape lastShape = stack.pop();
            this.queue.add(lastShape);
        } else {
            this.randomLabel.updateText("UNDO IS EMPTY");
            this.printRandomLabel = true;
        }
    }

    public void redoLastShape() {

        if (queue.isEmpty() == false) {
            InterfaceShape lastShape = queue.remove();
            this.stack.push(lastShape);
        } else {
            this.randomLabel.updateText("REDO IS EMPTY");
            this.printRandomLabel = true;
        }

    }

    @Override
    public boolean mousePressed(int userX, int userY) {
        
        mouseClicked(userX, userY);
        return true;

    }

    @Override
    public boolean mouseReleased(int userX, int userY) {

        if (this.upperPanel.IfInBorders(userX, userY) == false) {

            if (this.upperPanel.getFreehandPanel().isPressedOrNot() == true) {
                this.pendingFreehand.addShape(shapeMaker.makeFreehandShape(userX, userY));
                this.stack.push(this.pendingFreehand);
                //this.pendingFreehand.clearFreehand();
            } else {
                InterfaceShape shape = this.shapeMaker.makeShape(startingPoint, userX, userY);
                if (shape != null) {
                    this.stack.push(shape);
                }
                this.pendingShape = null;
                this.pendingShapeDetails.updateText("");
            }
        }

        return true;

    }

    @Override
    public boolean mouseEntered(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseExited(int userX, int userY) {

        return true;

    }

    @Override
    public boolean mouseDragged(int userX, int userY) {

        if (this.upperPanel.IfInBorders(userX, userY) == false) {
            if (this.upperPanel.getFreehandPanel().isPressedOrNot() == true) {
                this.pendingFreehand.addShape(shapeMaker.makeFreehandShape(userX, userY));
            } else {
                this.pendingShape = this.shapeMaker.makeShape(startingPoint,
                        userX, userY);
                this.pendingShapeDetails.updateText(this.shapeMaker.shapeDetails(
                        this.pendingShape));
            }
        }

        return true;

    }

    @Override
    public boolean mouseMoved(int userX, int userY) {

        this.printRandomLabel = false;
        this.randomLabel.updateText("");
        return false;

    }

    public void paintStack(Graphics g) {

        this.stack.paintStack(g);
        if (this.pendingShape != null) {
            this.pendingShape.paint(g);
        }
        if (this.printRandomLabel == true) {
            this.randomLabel.paint(g);
        }

    }

    public void paintPendingShape(Graphics g) {

        if (this.pendingShape != null) {
            this.pendingShapeDetails.paint(g);
        }

    }

    public PanelUpper getUpperPanel() {
        return upperPanel;
    }

    public void setUpperPanel(PanelUpper upperPanel) {
        this.upperPanel = upperPanel;
    }

    public ZPoint getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(ZPoint startingPoint) {
        this.startingPoint = startingPoint;
    }

    public InterfaceShape getPendingShape() {
        return pendingShape;
    }

    public ZLabelColored getRandomLabel() {
        return randomLabel;
    }

    public void setRandomLabel(ZLabelColored randomLabel) {
        this.randomLabel = randomLabel;
    }

    public boolean isPrintRandomLabel() {
        return printRandomLabel;
    }

    public void setPrintRandomLabel(boolean printRandomLabel) {
        this.printRandomLabel = printRandomLabel;
    }

    public Freehand getPendingFreehand() {
        return pendingFreehand;
    }

    public void setPendingFreehand(Freehand pendingFreehand) {
        this.pendingFreehand = pendingFreehand;
    }

    public void setPendingShape(InterfaceShape pendingShape) {
        this.pendingShape = pendingShape;
    }

    public ZLabelColored getPendingShapeDetails() {
        return pendingShapeDetails;
    }

    public void setPendingShapeDetails(ZLabelColored pendingShapeDetails) {
        this.pendingShapeDetails = pendingShapeDetails;
    }

    public ShapeMaker getShapeMaker() {
        return shapeMaker;
    }

    public void setShapeMaker(ShapeMaker shapeMaker) {
        this.shapeMaker = shapeMaker;
    }

    public ZStack getStack() {
        return stack;
    }

    public void setStack(ZStack stack) {
        this.stack = stack;
    }

    public ZQueue getQueue() {
        return queue;
    }

    public void setQueue(ZQueue queue) {
        this.queue = queue;
    }

}
