/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public class Technology {
    protected Technology left;
    protected Technology right;

    public Technology(Technology left, Technology right){
        this.left = left;
        this.right = right;
    }

    public void doComplete(Player p){
        //TODO write stuff here!
    }

    public boolean isLeaf(){
        return left==null&&right==null;
    }

}
