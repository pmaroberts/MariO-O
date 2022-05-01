package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Buyer;
import game.actors.Status;
import game.magical_Items.PurchasableItem;

public class Wrench extends WeaponItem implements PurchasableItem {

    public static final int PRICE = 200;

    /**
     * constructor for wrench weaponItem
     * sets it to be portable
     */
    public Wrench() {
        super("Wrench", '%', 50, "Wrench Attack!", 80);
        this.togglePortability();
    }

    /**
     * public getter for private class price int
     * @return private class instance attribute integer wrench purchase price
     */
    public int getPrice(){return Wrench.PRICE;}

    /**
     * wrench purchase method calls
     * @param buyer Buyer purchasing the item
     * @param map GameMap the buyer is on
     * @return player balance and/or purchase success statement
     */
    @Override
    public String purchase(Buyer buyer, GameMap map) {
        if (buyer.getWalletBalance()> PRICE){
            buyer.addItemToInventoryBuyer(this);
            buyer.editBalance(-PRICE);
            buyer.addCapability(Status.WRENCH);
            return "Successfully purchased Wrench! Remaining Balance: " + buyer.getWalletBalance();
        }
        return "insufficient Balance :(";
    }


}
