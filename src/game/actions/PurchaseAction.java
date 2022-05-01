package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Buyer;
import game.magical_Items.PurchasableItem;

public class PurchaseAction extends Action {

    private final PurchasableItem purchasableItem;
    private final Buyer buyer;
    /**
     * Consume item action constructor
     */
   public PurchaseAction(PurchasableItem item, Buyer buyer) {
        this.purchasableItem = item;
        this.buyer = buyer;
    }

    /**
     * overriding the execute method from the Action class as ut us n=necessary for any extension of an abstract class
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a staement either indicating success or failure of purchase.
     * @see Action class - for execute method
     */
    @Override
    public String execute(Actor actor, GameMap map) {

        return purchasableItem.purchase(this.buyer,map);
    }

    /**
     * overriding method menu description which is responsible for creating a string about the actors action
     * @param actor The actor performing the action.
     * @return a string about the action preformed.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + purchasableItem + " ($" + purchasableItem.getPrice() + ")";
    }
}

