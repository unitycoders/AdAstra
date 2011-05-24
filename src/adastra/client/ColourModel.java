/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package adastra.client;

import java.awt.Color;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author jwalto
 */
public class ColourModel implements ComboBoxModel {
    private static String[] names = new String[]{
        "Blue",
        "Sky Blue",
        "Aqua",
        "Cyan",
        "Green",
        "Yellow",
        "Orange",
        "Red",
        "Rose",
        "Purple",
        "White",
        "Silver",
        "Gold"
    };
    private static Color[] colours = new Color[]{
        //TODO I used HSV values, the need to be RGB
        new Color(48,100,99), //Blue
        new Color(200,56,97), //Sky Blue
        new Color(182,56,95), //Aqua
        new Color(172,56,97), //Cyan
        new Color(116,71,78), //Green
        new Color(61,100,100), //Yellow
        new Color(48,100,99), //Orange
        new Color(0,100,99), //Red
        new Color(0,31,99), //Rose
        new Color(255,65,99), //purple
        new Color(0,0,100), //white
        new Color(0,0,85), //Silver
        new Color(59,100,60), //Orange
    };
    private String selected;


    public ColourModel(){
        selected = null;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selected = (String)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return ColourModel.names.length;
    }

    @Override
    public Object getElementAt(int index) {
        return ColourModel.names[index];
    }

    public static String getName(int id){
        return ColourModel.names[id];
    }

    public static Color getColour(int id){
        return ColourModel.colours[id];
    }

    public static Color getColour(String name){
        for(int i=0; i<ColourModel.names.length; i++){
            if(ColourModel.names[i].equals(name)){
                return getColour(i);
            }
        }
        return Color.WHITE;
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

}
