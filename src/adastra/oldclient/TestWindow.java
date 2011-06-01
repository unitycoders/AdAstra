package adastra.oldclient;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: mroonea
 * Date: 19-May-2011
 * Time: 08:15:41
 * To change this template use File | Settings | File Templates.
 */
public class TestWindow extends JFrame {

    private KeyPressOptions keys;
    private Action action = UsefulObjects.action;

    public TestWindow(){
        windowSetup();
        keys = new KeyPressOptions("heello");
        this.addKeyListener(new KeyboardListener(keys,this));
    }

    public void windowSetup(){
        this.setSize(300,300);
        this.setFocusable(true);

    }

    public void print(String message){
        if(action.toggle)
            System.out.println(message);
        else
            System.err.println(message);
    }

    public static void main(String[] args) {
        TestWindow t = new TestWindow();
        t.setVisible(true);
    }
}
