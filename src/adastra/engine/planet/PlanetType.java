/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adastra.engine.planet;

/**
 *
 * @author jwalto
 */
public class PlanetType {

    private int rows;
    private int cols;

    public PlanetType(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
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
}
