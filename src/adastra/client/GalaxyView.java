/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Ability;
import adastra.engine.Asset;
import adastra.engine.Galaxy;
import adastra.engine.Sector;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author jwalto
 */
public class GalaxyView extends ScrollableComponent implements SelectionListener {
    private GameController controller;
    private SectorSprite[] sprites;
    private Galaxy galaxy;
    private GameModel model;

    /**
     * Build a new sector view
     *
     * TODO write some kind of listener to dynamiclly update the sprite list
     * @param controller the game controller to monitor
     */
    public GalaxyView(GameController controller, GameModel model){
        super(600,600,800,600);
        sprites = new SectorSprite[0];
        controller.addListener(this);
        this.controller = controller;

        this.model = model;
        if(model.getGame() != null){
            this.galaxy = model.getGame().getMap();
        }
    }

    public void updateGalaxy(){
        if(model.getGame() == null){
            return;
        }

        if(galaxy == model.getGame().getMap()){
            return;
        }
        galaxy = model.getGame().getMap();

        if(galaxy == null){
            sprites = new SectorSprite[0];
            return;
        }

        sprites = new SectorSprite[galaxy.sectorCount()];
        int count=0;

        for(Sector sector : galaxy){
           sprites[count] = SectorSprite.build(sector);
           count++;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        updateGalaxy();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void paintChildren(Graphics g){
        if(sprites == null){
            return; //no sprites here!
        }

        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(getXOffset(), getYOffset());

        for(SectorSprite sprite : sprites){
            sprite.paint(g);
        }

        g2.translate(getXOffset()*-1, getYOffset()*-1);
    }

    @Override
    protected void paintBorder(Graphics g) {
        super.paintBorder(g);

        g.setColor(Color.red);
        g.drawRect(getXOffset()-600, getYOffset()-600, 1200, 1200);
    }



    @Override
    public void sectorSelected(Sector sector) {
    }

    @Override
    public void assetSelected(Asset asset) {
    }

    @Override
    public void abilitySelected(Ability ability) {
    }

}
