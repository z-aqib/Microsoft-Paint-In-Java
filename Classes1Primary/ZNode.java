package Classes1Primary;

import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;

public class ZNode {

    private InterfaceShape shape;
    private ZNode next;

    public ZNode(InterfaceShape shape) {

        /*
        this class creates a random node
         */
        this.shape = shape;
        this.next = null;

    }

    public InterfaceShape getShape() {

        /*
        this method returns the data of a node
         */
        InterfaceShape shapee = this.shape;
        return shapee;

    }

    public void setData(InterfaceShape shape) {

        /*
        this method sets the shape of a node
         */
        this.shape = shape;

    }

    public ZNode getNext() {
        return next;
    }

    public void setNext(ZNode next) {
        this.next = next;
    }

}
