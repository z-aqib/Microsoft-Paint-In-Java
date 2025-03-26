package Classes6Others;

import Classes3Tertiary.*;
import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;
import java.awt.Graphics;

public class ZStack {

    /*
    ZStack follow the LIFO method, last in first out. hence any old objects will be 
    added BEFORE the head node and the head node will now be the new object. so first 
    make the new object the head, then AFTER the head the old node will be stored
    when removing, the last node (the latest one) will be removed
     */
    private ZNode head;
    private int stackSize;

    public ZStack() {

        this.stackSize = 0;
        this.head = null;

    }

    public void push(InterfaceShape data) {

        /*
        this method creates a new ZNode and adds it to the stack
         */
        // create a New ZNode
        ZNode newNode = new ZNode(data);

        // save the head node into another node
        ZNode previousHead = getHeadNode();

        // make the head node the new node
        this.head = newNode;

        // now make the NEXT address of the head node, the previous head
        this.head.setNext(previousHead);

        // increment stack size
        changeStackSize(1);

    }

    public InterfaceShape pop() {

        /*
        this method removes the latest node from the stack. so the head is at the top, 
        i.e. all the other nodes are after it. so the head node moves forward one position 
        and returns the removed value
         */
        // first check if the stack contains any elements or not
        if (empty() == true) {
            System.out.println("Empty Stack");
            return null;
        } // else if it does contain elements, proceed
        else {

            // get the data that is being removed
            InterfaceShape data = getHeadNode().getShape();

            // make the head node to the position of the node after it
            this.head = getHeadNode().getNext();

            // decrement stack size as one position has been removed
            changeStackSize(-1);

            // return the data
            return data;

        }

    }

    public InterfaceShape peek() {

        /*
        this method returns the latest node's data
         */
        // check if the head node is empty, return empty stack
        if (empty() == true) {
            System.out.println("Empty Stack");
            return null;
        } // if it is not, return the data of the head node, as head node is always at the top
        else {
            InterfaceShape data = getHeadNode().getShape();
            return data;
        }

    }

    public boolean empty() {

        /*
        this method tells us if the stack is empty (true) or not (false)
         */
        boolean empty;

        if (getStackSize() == 0) {
            empty = true;
        } else {
            empty = false;
        }

        return empty;

    }

    public int getStackSize() {

        int size = this.stackSize;
        return size;

    }

    public ZNode getHeadNode() {

        ZNode headNode = this.head;
        return headNode;

    }

    public void changeStackSize(int num) {

        /*
        this method changes the stack size by num
         */
        this.stackSize = getStackSize() + num;

    }

    public String StacktoString() {

        /*
        this method will change the entire stack into a string
         */
        String str = "";

        // create a new node which will be used in replacement of the head node
        ZNode pointerNode = getHeadNode();

        // get the stack size which will change
        int size = getStackSize();

        // while the stack is not empty, get each node of the stack
        while (size != 0) {

            // get the data of the pointer node
            String data = pointerNode.getShape().toString();

            // add this data to the string and take a new line each time
            str = str + data + "\n";

            // make the pointer node the previous node
            pointerNode = pointerNode.getNext();

            // decrement the stack size
            size--;

        }

        // return the string made
        return str;

    }

    @Override
    public String toString() {

        InterfaceShape[] array = toArray();
        String s = "";
        if (array == null) {
            return "";
        }
        for (int i = array.length - 1; i >= 0; i--) {
            InterfaceShape shapeS = array[i];
            s = s + shapeS.toString() + "\n";
        }
        return s;

    }

    public InterfaceShape[] toArray() {

        /*
        this method gets each Shape in the stack and converts it into an array of shapes
        
         */
        if (empty() == true) {
            return null;
        } else {
            int size = getStackSize();
            InterfaceShape[] shapes = new InterfaceShape[size];
            ZNode pointerNode = getHeadNode();
            int i = 0;
            while (size != 0) {
                shapes[i] = pointerNode.getShape();
                size--;
                i++;
                pointerNode = pointerNode.getNext();
            }
            return shapes;
        }

    }

    public void paintStack(Graphics g) {

        InterfaceShape[] array = toArray();
        if (array == null) {

        } else {
            for (int i = (array.length - 1); i >= 0; i--) {
                InterfaceShape shapeS = array[i];
                if (shapeS != null) {
                    shapeS.paint(g);
                }
            }
        }

    }
    
    public void clear() {
        
        while (getStackSize() != 0) {
            pop();
        }
        
    }

}
