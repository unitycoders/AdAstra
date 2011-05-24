/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

import adastra.engine.Game;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Main Launcher for the CLI
 * 
 * @author webpigeon
 */
public class CliMain implements Runnable, Iterable<Module> {
    private Map<String, Module> modules;
    private GameModel model;
    
    public static void main(String[] args) {
        CliMain cli = new CliMain();
        cli.loadModule("core", new CoreTools());
        cli.loadModule("asset", new AssetTools());
        cli.loadModule("sector", new SectorTools());
        Thread t = new Thread(cli);
        t.start();
    }
    
    public CliMain(){
        this.modules = new HashMap<String, Module>();
        Game theGame = new Game();
        theGame.generateMap(10);
        this.model = new GameModel(theGame);
    }
    
    public void loadModule(String prefix, Module module){
        modules.put(prefix, module);
        module.init(this);
    }
    
    @Override
    public void run(){
        System.out.println("AdAstra CLI v0.1");
        System.out.println("");
        
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("AdAstra: ");
            String[] inputArray = input.nextLine().split(" ");
            Module mod = modules.get(inputArray[0]);
            if(mod == null){
                System.out.println("ERROR: invalid module "+inputArray[0]);
                continue;
            }
            
            mod.invoke(inputArray);
        }
    }
    
    public GameModel getModel(){
        return model;
    }
    
    public void printLn(String line){
        System.out.println(line);
    }
    
    public void quit(){
        printLn("Quit called!");
        System.exit(0);
    }

    @Override
    public Iterator<Module> iterator() {
        return modules.values().iterator();
    }
 
}
