package adastra.oldclient;

/**
 * Created by IntelliJ IDEA.
 * User: mroonea
 * Date: 19-May-2011
 * Time: 07:31:56
 * To change this template use File | Settings | File Templates.
 */
public abstract class Option {

    //If the default constructor is used then the default values are used
    public Option(){
        this.setDefaultValues();
    }

    //If the filename constructor is used, it reads the file and if it fails th default values are used
    public Option(String file){
        if(!this.setValues(file)){
            this.setDefaultValues();
        }
    }

    //If the file being passed does not exist then false is returned, at this point using the default may be useful
    public abstract boolean setValues(String file);
    public abstract void setDefaultValues();


}
