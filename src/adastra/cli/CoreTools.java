/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

/**
 * Provides basic console tools
 * 
 * @author webpigeon
 */
public class CoreTools extends Module {
    private CliMain main;

    @Override
    public void init(CliMain main) {
        this.main = main;
    }

    @Override
    public void invoke(String[] args) {
        if(args.length == 1){
            main.printLn("Core Tools v0.1, help for commands");
            return;
        }
        
        if(args[1].equals("help")){
            showHelp();
            return;
        }
        
        if(args[1].equals("list")){
            listModules();
            return;
        }
        
        if(args[1].equals("quit")){
            main.quit();
            return;
        }
    }
    
    private void showHelp(){
        main.printLn("list: lists all modules");
        main.printLn("quit: exits the console");
    }
    
    private void listModules(){
        for(Module mod : main){
            main.printLn(mod.toString());
        }
    }
    
    @Override
    public String toString(){
        return "Core toolkit: core console commands";
    }
    
}
