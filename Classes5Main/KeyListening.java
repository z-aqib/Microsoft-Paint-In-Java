package Classes5Main;

import java.awt.event.*;
import Classes1Primary.*;
import java.awt.*;

/*
"Key Listening" is a class that will be used to listen to keys pressed and released by 
the user. 
If a user pressed or releases a key, the program will display the key that has been 
pressed or released. 
 */
public class KeyListening extends KeyAdapter {

    private ZLabelColored keyListenerLabel; // a label which displays what key has been pressed

    public KeyListening() {

        /*
        this constructor declares the label at a specific position
         */
        this.keyListenerLabel = new ZLabelColored("Key is null", new ZPoint(5, 498));

    }

    @Override
    public void keyReleased(KeyEvent e) {

        /*
        this method gets the integer value of the key released. then it gets the string 
        format of the key (gets its name or character) and then updates the label 
        that this key + string of key + has been released. 
         */
        int keyReleased = e.getKeyCode();
        getKeyListenerLabel().updateText("Key '" + getKey(keyReleased) + "' is released. ");

    }

    @Override
    public void keyPressed(KeyEvent e) {

        /*
        this method gets the integer value of the key pressed. then it gets the string 
        format of the key (gets its name or character) and then updates the label 
        that this key + string of key + has been pressed. 
         */
        int keyPressed = e.getKeyCode();
        getKeyListenerLabel().updateText("Key '" + getKey(keyPressed) + "' is pressed. ");

    }

    private String getKey(int key) {

        /*
        this method determines which key has been pressed/released according to its 
        integer value. a switch case is being run which checks the integer of which 
        key it is, if it is none, then it converts the integer to a character.
        it then returns the key name. 
         */
        String keyString;
        switch (key) {
            case 0 ->
                keyString = "Unknown Key";
            case 8 ->
                keyString = "Backspace";
            case 10 ->
                keyString = "Enter";
            case 16 ->
                keyString = "Shift";
            case 17 ->
                keyString = "Ctrl";
            case 18 ->
                keyString = "Alt";
            case 20 ->
                keyString = "Caps Lock";
            case 27 ->
                keyString = "Esc";
            case 32 ->
                keyString = "Spacebar";
            case 33 ->
                keyString = "Page Up";
            case 34 ->
                keyString = "Page Down";
            case 37 ->
                keyString = "Left";
            case 38 ->
                keyString = "Up";
            case 39 ->
                keyString = "Right";
            case 40 ->
                keyString = "Down";
            case 127 ->
                keyString = "Delete";
            case 144 ->
                keyString = "F5";
            case 145 ->
                keyString = "F6";
            case 155 ->
                keyString = "Insert";
            case 524 ->
                keyString = "F8/Windows";
            default ->
                keyString = (char) key + "";
        }
        return keyString;

    }

    public void paint(Graphics g) {

        /*
        this method paints the current status of key pressing/releasing of user, 
        which is stored in a label.
         */
        getKeyListenerLabel().paint(g);

    }

    // --------------------------GETTERS AND SETTERS--------------------------
    public ZLabelColored getKeyListenerLabel() {
        return keyListenerLabel;
    }

    public void setKeyListenerLabel(ZLabelColored keyListenerLabel) {
        this.keyListenerLabel = keyListenerLabel;
    }

}
