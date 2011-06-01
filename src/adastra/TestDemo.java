/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author jwalto
 */
public class TestDemo {
    int a,b,c;

    public static void main(String[] args) {
        JComponent[] objects = new JComponent[]{
            new JButton(),
            new JLabel(""),
            new JButton()
        };
        TestDemo demo = new TestDemo(objects);
    }

    public TestDemo(Component[] objects){
        for(int i=0; i<objects.length; i++){
            count(objects[i]);
        }
        System.out.println("a="+a+" b="+b+" c="+c);
    }

    public void count(JButton x){
        a++;
    }

    public void count(Object o){
        b++;
    }

    public void count(JComponent s){
        c++;
    }
}
