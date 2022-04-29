package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.PurchasableItem;

public class PurchaseAction extends Action {

    PurchasableItem purchasableItem;
    /**
     * Consume item action constructor
     */
   public PurchaseAction(PurchasableItem item) {
        this.purchasableItem = item;
    }

    /**
     * overriding the execute method from the Action class as ut us n=necessary for any extension of an abstract class
     * checks what item instance has been assigned throught the .toString method
     * i.e., comparing item string names.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a staement either indicating success or failure of purchase.
     * @see Action class - for execute method
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        return purchasableItem.purchase(actor,map);
    }

    /**
     * overriding method menu description which is responsible for creating a string about the actors action
     * @param actor The actor performing the action.
     * @return a string about the action preformed.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasableItem ;
    }
}

