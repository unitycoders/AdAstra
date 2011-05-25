/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import adastra.engine.Asset;

/**
 *
 * @author jwalto
 */
public class SpriteFactory {

    public static Sprite buildSprite(Asset asset){
        if(asset.getType() == Asset.TYPE_PLANET){
            return new PlanetSprite(asset);
        }

       if(asset.getType() == Asset.TYPE_VESSEL){
           return new AssetSprite(asset);
       }

        System.err.println("Unknown type ID "+asset.getType());
        return null;
    }

}
