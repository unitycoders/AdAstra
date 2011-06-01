package adastra.oldclient;

/**
 * Created by IntelliJ IDEA.
 * User: mroonea
 * Date: 19-May-2011
 * Time: 07:42:23
 * To change this template use File | Settings | File Templates.
 */
public class KeyPressOptions extends Option{

    /*
        The space above will be used to declare all of the different key presses
        To make it easy to navigate make sure it is all in alphabetical order
    */

    public int DOWN_KEY;
    public int MENU;
    public int TOGGLE;
    public int UP_KEY;


    public KeyPressOptions(){
        super();
    }

    public KeyPressOptions(String file){
        super(file);
    }

    public boolean setValues(String file) {

        //TODO - requires a file format, and all of the available keyPresses such as toggle, menuKey, Options key etc.

        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void setDefaultValues() {

        //TODO - requires all of the available keypresses such as above. Requires default keys to be set in DefaultKeyOptions

        this.DOWN_KEY = DefaultKeyOptions.DOWN_KEY;
        this.MENU = DefaultKeyOptions.MENU;
        this.TOGGLE = DefaultKeyOptions.TOGGLE;
        this.UP_KEY = DefaultKeyOptions.UP_KEY;

    }
}
