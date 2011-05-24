/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

import adastra.engine.Asset;
import adastra.engine.Game;
import adastra.engine.Sector;

/**
 *
 * @author webpigeon
 */
public class AssetTools extends Module {
    private CliMain main;
    private GameModel model;
    
    public AssetTools(){
        
    }

    @Override
    public void init(CliMain main) {
        this.main = main;
        this.model = main.getModel();
    }

    @Override
    public void invoke(String[] args) {
        if(args.length == 1){
            return;
        }
        
        if(args[1].equals("status")){
            status();
            return;
        }
        
        if(args[1].equals("order")){
            order();
            return;
        }
        
        if(args[1].equals("select")){
            if(args.length != 4){
                main.printLn("usage: asset select x y");
                return;
            }
            
            select(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
            return;
        }
        
        if(args[1].equals("list")){
            list();
            return;
        }
        
        throw new RuntimeException("invalid command!");
    }
    
    private void status(){
        Asset a = model.getAsset();
        if(a != null)
            main.printLn("Selected: "+a);
        else
            main.printLn("No asset selected.");
    }
    
    private void order(){
        main.printLn("not implemented.");
    }
    
    private void select(int x, int y){
        if(model.selectAsset(x, y)){
            main.printLn("selected asset");
        }else{
            main.printLn("error selecting asset");
        }
    }
    
    private void list(){
        Sector sec = model.getSector();
        if(sec == null){
            main.printLn("No sector selected.");
            return;
        }
        
        for(Asset a : sec){
            main.printLn(a.getLocation()+": "+a.toString());
        }
    }
    
    @Override
    public String toString(){
        return "Asset toolkit: select and issue orders to assets";
    }
    
}
