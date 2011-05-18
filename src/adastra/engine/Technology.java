/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

/**
 *
 * @author jwalto
 */
public abstract class Technology {
    protected Technology left;
    protected Technology right;

    public Technology(Technology left, Technology right){
        this.left = left;
        this.right = right;
    }

    public abstract void doComplete(Player p);

    public boolean isLeaf(){
        return left==null&&right==null;
    }

}
