/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.engine;

import java.awt.Point;

/**
 * An ability something a player can do
 * 
 * 
 * @author jwalto
 */
public interface Ability {

    public String getName();

    public String getCommand();

    public Event fireEvent(Asset source, Point target);

 //         =,    (\_/)    ,=
 //          /`-'--(")--'-'\
 //     jgs /     (___)     \
 //        /.-.-./ " " \.-.-.\



}
