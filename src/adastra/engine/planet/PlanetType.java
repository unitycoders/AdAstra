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

    public PlanetType(int rows, int cols, int r, int g, int b) {
        this.rows = rows;
        this.cols = cols;
        this.colour = new Color(r, g, b);
    }

    public int getPlots() {
        return rows * cols;
    }

    public boolean canBuild(int row, int col) {
        return true; //TODO fix, here for debug
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
