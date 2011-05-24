/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

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
    }

    @Override
    public String getName() {
        return "Game screen";
    }

    @Override
    public void notifySelected() {
        
    }

}
