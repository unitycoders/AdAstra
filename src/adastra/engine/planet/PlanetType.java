/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

import java.awt.Color;

/**
 *
 * @author jwalto
 */
public class PlanetType {
    private Color colour;
    private int rows;
    private int cols;
    private boolean build[][];

    public PlanetType(int r, int g, int b){
        System.out.println("Here");
        build = new boolean[10][10];


        for(int row=0; row<10; row++){
            build[row] = new boolean[10];
            for(int col=0; col<10; col++){
                build[row][col] = ((row+col) % 2 == 0);
            }
        }


        this.rows = 10;
        this.cols = 10;
        this.colour = new Color(r,g,b);
    }

    public PlanetType(boolean[][] slots, int r, int g, int b){
        this.build = slots;
        this.colour = new Color(r,g,b);
    }

    @Deprecated
    public PlanetType(int rows, int cols, int r, int g, int b) {
        this.rows = 10;
        this.cols = 10;
        this.colour = new Color(r, g, b);
    }

    public int getPlots() {
        return 100;
    }

    public boolean canBuild(int row, int col) {
        return build[row][col]; //TODO build guard
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
    
    public Color getColour(){
        return colour;
    }
}
