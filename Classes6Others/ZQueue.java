package Classes6Others;

import Classes3Tertiary.*;
import Classes0FactoryDesignPattern.*;
import Classes1Primary.*;
import Classes2Secondary.*;
import Classes3Tertiary.*;
import Classes4Quaternary.*;

public class ZQueue {

    /*
    queues follow the FIFO method, i.e. first in first out. so it forms a queue/line 
    where the first person standing in the line is removed first. so now there will be 
    two nodes, one at the front of the queue and one at the back. the front node will 
    be used to remove nodes while the back node will be used to add nodes
     */
    protected ZNode frontNode;
    protected ZNode backNode;
    protected int queueSize;

    public ZQueue() {

        this.backNode = null;
        this.frontNode = null;
        this.queueSize = 0;

    }

    public void add(InterfaceShape data) {

        /*
        this method adds data to the queue, using the BACK node. so save the back node somewhere
        and make the new node the back node. now there will be no node after the back node 
        so its .next address will be empty (null). but the address before the back node 
        is the old back node which was saved. so the address after the old back node is 
        the new back node so the .next of the old back node is the new back node
        but if after the node is added and it was the first addition, then the front node 
        is also the back node. if not then the old back node is before the back node
         */
        // first create a new node of this given data
        ZNode newNode = new ZNode(data);

        // save the old back node
        ZNode oldBackNode = getBackNode();

        // now make the new node the back node
        this.backNode = newNode;

        // now make the .next of the new back node null
        this.backNode.setNext(null);

        // now if that was the first node, then make the front node the back node
        if (isEmpty() == true) {
            this.frontNode = getBackNode();
        } // else if it wasnt, then make the old back node .next the new back node
        else {
            oldBackNode.setNext(this.backNode);
        }

        // increment the queue size
        changeQueueSize(1);

    }

    public InterfaceShape remove() {

        /*
        - this method removes the latest added node. this is done by using the FRONT node, 
        save its shape somewhere, make the front node the next node in line and return the shape
        - if the queue is empty, return empty queue
         */
        if (isEmpty() == true) {
            System.out.println("Empty Queue");
            return null;
        } else {

            // save the data of the front node
            InterfaceShape data = getFrontNode().getShape();

            // make the front node the next node in line
            this.frontNode = getFrontNode().getNext();

            // decrement the size of the queue
            changeQueueSize(-1);

            // if the queue is now empty, make the back node as null
            if (isEmpty() == true) {
                this.backNode = null;
            }

            // return the shape of the removed node
            return data;

        }

    }

    public void clear() {

        while (isEmpty() != true) {

            remove();

        }

    }

    public boolean isEmpty() {

        /*
        this method returns whether or not the queue is empty (true) or not (false)
         */
        boolean empty;

        if (getQueueSize() == 0) {
            empty = true;
        } else {
            empty = false;
        }

        return empty;

    }

    public InterfaceShape first() {

        /*
        this method returns the first node's data
         */
        // if queue is empty, return empty queue
        if (isEmpty() == true) {
            System.out.println("Empty Queue");
            return null;
        } // else if not, then return the first (front node)'s data
        else {
            InterfaceShape data = getFrontNode().getShape();
            return data;
        }

    }

    public InterfaceShape latest() {

        /*
        this method returns the latest node's data
         */
        // if queue is empty, return empty queue
        if (isEmpty() == true) {
            System.out.println("Empty Queue");
            return null;
        } // else if not, then return the latest (back node)'s data
        else {
            InterfaceShape data = getBackNode().getShape();
            return data;
        }

    }

    public int getQueueSize() {

        int size = this.queueSize;
        return size;

    }

    public ZNode getFrontNode() {

        ZNode front = this.frontNode;
        return front;

    }

    public ZNode getBackNode() {

        ZNode back = this.backNode;
        return back;

    }

    public void changeQueueSize(int num) {

        /*
        this method changes the queue size by num
         */
        this.queueSize = getQueueSize() + num;

    }

    @Override
    public String toString() {

        /*
        this method gets each and every node of the queue and makes it a string
         */
        String str = "";

        // create a pointer node for the front node
        ZNode pointerNode = getFrontNode();

        // get queue size to run loop
        int size = getQueueSize();

        // while the queue is not empty,
        while (size != 0) {

            // get data of the pointernode
            String data = pointerNode.getShape().toString();

            // add this data to the string and leave a line
            str = str + data + "\n";

            // move the pointer node forwards
            pointerNode = pointerNode.getNext();

            // decrement the size
            size--;

        }

        return str;

    }

}
