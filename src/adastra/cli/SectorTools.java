/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.cli;

import adastra.engine.Asset;
import adastra.engine.Galaxy;
import adastra.engine.Sector;

/**
 *
 * @author webpigeon
 */
public class SectorTools extends Module {
    private CliMain main;
    private GameModel model;
    
    public SectorTools(){
        
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
            if(args.length != 3){
                main.printLn("usage: sector select [id]");
                return;
            }
            
            select(Integer.parseInt(args[2]));
            return;
        }
        
        if(args[1].equals("count")){
            count();
            return;
        }
        
        if(args[1].equals("list")){
            list();
            return;
        }
        
        throw new RuntimeException("invalid command!");
    }
    
    private void status(){
        Sector sec = model.getSector();
        if(sec == null){
            main.printLn("No sector selected");
            return;
        }
       main.printLn("sector details for: "+sec);
       main.printLn("size: ("+sec.getHeight()+ "," + sec.getWidth()+")");
    }
    
    private void count(){
        Galaxy gal = model.getGalaxy();
        main.printLn("There are "+gal.sectorCount()+" sectors");
    }
    
    private void order(){
        main.printLn("not implemented.");
    }
    
    private void select(int id){        
        if(model.selectSector(id)){
            main.printLn("selected sector "+id);
        }else{
            main.printLn("error selecting sector");
        }
    }
    
    private void list(){
        Galaxy gal = model.getGalaxy();
        
        for(Sector s : gal){
            main.printLn("n: "+s.toString());
        }
    }
    
    @Override
    public String toString(){
        return "Sector toolkit: select and examine sectors";
    }
    
}
