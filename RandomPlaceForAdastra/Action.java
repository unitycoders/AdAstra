package RandomPlaceForAdastra;

/**
 * Created by IntelliJ IDEA.
 * User: mroonea
 * Date: 19-May-2011
 * Time: 07:21:59
 * To change this template use File | Settings | File Templates.
 */
public class Action {
    public boolean toggle;
    public boolean menu;
    public int verticleKeyMove;
    public int horizontalKeyMove;
    //More to be added, any action which is graphical or part of a composite combination should be in here.

    public Action(){
        this.setDefaultActionValues();
    }

    public void setDefaultActionValues(){
        this.toggle = DefaultActionValues.toggle;
        this.menu = DefaultActionValues.menu;
        this.verticleKeyMove = DefaultActionValues.verticalMovement;
        this.horizontalKeyMove = DefaultActionValues.verticalMovement;
    }
}
