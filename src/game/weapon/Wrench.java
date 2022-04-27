package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem  {

    public static final int PRICE = 200;

    /**
     * constructor for wrench weaponItem
     */
    public Wrench() {
        super("Wrench", '%', 50, "Wrench Attack!", 80);
    }

    /**
     * public getter for private class price int
     * @return private class instance attribute integer wrench purchase price
     */
    public int getPrice(){return Wrench.PRICE;}

    /**
     * adds an action to the list of allowable items
     * @param action chosen action
     */
    public void addWrenchAction(Action action){
        this.addAction(action);
    }
}
