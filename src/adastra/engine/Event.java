/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public class Event {

    public String getDescription(){
        return "Do things...";
    }
    
    public void run(){
        System.out.println("things happened!");
    }

    public boolean isComplete(){
        return true;
    }

}