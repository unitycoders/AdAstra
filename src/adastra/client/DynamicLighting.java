package adastra.client;

import java.awt.*;
import adastra.engine.Location;

/**
 * Created by Perry Monschau.
 * Date: 16-May-2011
 * Time: 12:02:52
 */
public class DynamicLighting {
    int colormin;
    int colormax;

    public DynamicLighting(int colormin, int colormax) {
        this.colormin = colormin;
        this.colormax = colormax;
    }


    //used with dynamic light rendering
    public double getShade(Location[] locs, Polygon p, int z) {

        double shade = 0;
        double test;

        //find brightest shade (light source with closest angle to face)
        if (z >= 0) {
            for (Location loc : locs) {
                test = lightcalc(loc, p, z);
                if (test > shade) {
                    shade = test;
                }
            }
        } else {
            shade = Math.PI;
        }
        return shade;
    }
                   //polygon color, lightsource locations, polygon, z side
    public Color getColor(Color c, Location[] locs, Polygon p, int z) {
        double shade = getShade(locs, p, z);

        return colorcalc(c, shade);
    }

    //no longer used
    /*public Circle[] getOvalLocs(Location[] locs, Circle r, double scale){
        Circle[] ra = new Circle[locs.length];
        for (int i=0; i < locs.length; i++){
            Location loc = locs[i];
            double ang = Math.atan2(loc.y - r.getLoc().y,loc.x - r.getLoc().x);
            int x = (int)(Math.cos(ang)*(scale/4)+r.getLoc().x+scale/3);
            int y = (int)(Math.sin(ang)*(scale/4)+r.getLoc().y+scale/3);
            ra[i] = new Circle();
            ra[i].setLoc(new Location(x,y));
        }
        return ra;
    }*/

    private Color colorcalc(Color c, double shade) {
        double mul = colormin + shade * (colormax - colormin) / (Math.PI);
        mul /= 255;
        return new Color((int) (c.getRed() * mul), (int) (c.getGreen() * mul), (int) (c.getBlue() * mul), c.getAlpha());
    }

    //used with dynamic light rendering
    private double lightcalc(Location loc, Polygon p, int z) {

        double[] hp = getHp(p.xpoints, p.ypoints, z);
        double[] cp = getCp(p.xpoints, p.ypoints);



        double angls = Math.atan2(loc.getY() - cp[1], loc.getX() - cp[0]);
        double anghp = Math.atan2(hp[1] - cp[1], hp[0] - cp[0]);

            double angfin = Math.abs(angls - anghp);

            //if angle is greater than half circle, get shorter angle
            if (angfin > Math.PI) {
                angfin = Math.PI * 2 - angfin;
            }

            return Math.PI - angfin; //angfin ranges from 0 to PI
    }

    private double[] getHp(int[] xp, int[] yp, int z) {
        double[] dxp = new double[xp.length];
        double[] dyp = new double[yp.length];

        for (int i = 0; i < xp.length; i++) {
            dxp[i] = xp[i];
            dyp[i] = yp[i];
        }
        return getHp(dxp, dyp, z);
    }

    private double[] getCp(int[] xp, int[] yp) {
        double[] dxp = new double[xp.length];
        double[] dyp = new double[yp.length];

        for (int i = 0; i < xp.length; i++) {
            dxp[i] = xp[i];
            dyp[i] = yp[i];
        }
        return getCp(dxp, dyp);
    }

    private double[] getHp(double[] xp, double[] yp, int z) {
        return new double[]{(xp[z] + xp[(z + 1) % xp.length]) / 2.0, (yp[z] + yp[(z + 1) % xp.length]) / 2.0};
    }


    private double[] getCp(double[] xp, double[] yp) {
        double[] cp = new double[2];
        cp[0] = sum(xp) / (double) xp.length;
        cp[1] = sum(yp) / (double) yp.length;
        return cp;
    }

    private double sum(double[] ds) {
        double sum = 0;
        for (double d : ds) {
            sum += d;
        }
        return sum;
    }

}