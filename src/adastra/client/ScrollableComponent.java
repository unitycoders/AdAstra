/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author jwalto
 */
public class ScrollableComponent extends JComponent {
    private Rectangle viewpoint;

    public ScrollableComponent(int x, int y, int width, int height){
        super();
        viewpoint = new Rectangle(x,y,width,height);
    }

    public int getXOffset(){
        return viewpoint.x;
    }

    public int getYOffset(){
        return viewpoint.y;
    }

    public int getXBound(){
        return 1200;
    }

    public int getYBound(){
        return 1200;
    }

    public void moveView(int x, int y) {
        viewpoint.x += x;
        viewpoint.y += y;

        checkBounds();
        repaint();
    }

    public void moveView(Point p, int x, int y){
        int nx = p.x - viewpoint.x;
        int ny = p.y - viewpoint.y;

        viewpoint.x = x-viewpoint.x-nx;
        viewpoint.y = y-viewpoint.y-ny;

        checkBounds();
        repaint();
    }

    private void checkBounds(){
        int sectorWidth = getXBound()/2 + 40;
        int sectorHeight = getYBound()/2 + 40;

        if (viewpoint.x < -sectorWidth + viewpoint.width){
            viewpoint.x = -sectorWidth + viewpoint.width;
        } else if (viewpoint.x > sectorWidth){
            viewpoint.x = sectorWidth;
        }
        if (viewpoint.y < -sectorHeight + viewpoint.height){
            viewpoint.y = -sectorHeight + viewpoint.height;
        } else if (viewpoint.y > sectorHeight){
            viewpoint.y = sectorHeight;
        }
    }

    public Point getStart(Point p){
        return new Point(p.x-viewpoint.x,p.y-viewpoint.y);
    }

}
