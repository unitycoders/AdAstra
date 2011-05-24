/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

/**
 *
 * @author webpigeon
 */
public abstract class Module {
    
    public abstract void init(CliMain main);
    public abstract void invoke(String[] args);
    
}
