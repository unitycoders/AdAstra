/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.oldclient;

import java.awt.BorderLayout;

/**
 *
 * @author jwalto
 */
public class GameView extends AdAstraPanel {
    private GameController ctrl;
    private AssetProperties assetProps;

    public GameView(GameController ctrl){
        this.ctrl = ctrl;
        this.assetProps = new AssetProperties();

        this.setLayout(new BorderLayout());
        this.add(new GalaxyComponent(), BorderLayout.CENTER);
    }

    @Override
    public String getName() {
        return "Game screen";
    }

    @Override
    public void notifySelected() {
        
    }

}
