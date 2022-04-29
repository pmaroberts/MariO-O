package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.magical_Items.PurchasableItem;

public class Wrench extends WeaponItem implements PurchasableItem {

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

    @Override
    public String purchase(Actor actor, GameMap map) {
        if (actor.getWalletBalance()> PRICE){
            actor.addItemToInventory(this);
            actor.editBalance(-PRICE);
            return "Successfully purchased Wrench! Remaining Balance: " + actor.getWalletBalance();
        }
        return "insufficient Balance :(";
    }
}
