package adastra.oldclient;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Created by IntelliJ IDEA.
 * User: mroonea
 * Date: 19-May-2011
 * Time: 07:27:07
 * To change this template use File | Settings | File Templates.
 */
public class KeyboardListener implements KeyListener {

    /*
    Look through and ignore anything in here these are just some examples, multi key press handling will have to
    incorporate both the options and the action classes. Although it does mean having millions and millions
    and millions and millions and millions and millions and millions and millions and millions and millions of
    random ints and jazz.
     */
    private Action action = UsefulObjects.action;
    private KeyPressOptions option;
    private TestWindow myframe;
    private SectorController controller;

    @Deprecated
    public KeyboardListener(KeyPressOptions key, TestWindow myframe) {
        this.option = key;
        this.myframe = myframe;
    }

    public KeyboardListener(KeyPressOptions key, SectorController controller) {
        this.controller = controller;
        this.option = key;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == option.TOGGLE) {
            if (!action.toggle) {
                myframe.print("You have started toggling");
                action.toggle = true;
            }
            return;
        }

        if (key == option.MENU) {
            controller.showMenu();
            return;
        }


        if (key == option.UP_KEY) {
            if (action.verticleKeyMove <= 0) {
                action.verticleKeyMove += 1;
                myframe.print("what is the value of up " + action.verticleKeyMove);
            }
            return;
        }

        if (key == option.DOWN_KEY) {
            if (action.verticleKeyMove >= 0) {
                action.verticleKeyMove -= 1;
                myframe.print("what is the value of up " + action.verticleKeyMove);
            }
            return;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        //have to have toggle held to continue using it (if you change this to action.toggle = !action.toggle you can have a switch
        if (key == option.TOGGLE) {
            action.toggle = false;
            myframe.print("You have finished toggling");
        } 
        
        if (key == option.UP_KEY) {
            if (action.verticleKeyMove >= 0) {
                action.verticleKeyMove -= 1;
            }
            myframe.print("what is the value of up " + action.verticleKeyMove);
        }
        
        if (key == option.DOWN_KEY) {
            if (action.verticleKeyMove <= 0) {
                action.verticleKeyMove += 1;
            }
            myframe.print("what is the value of up " + action.verticleKeyMove);
        } 
        
        if (key == option.MENU) {
            action.menu = !action.menu;
            myframe.print("you want a menu? " + action.menu);
        }
    }
}
