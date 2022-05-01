package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Buyer;
import game.actors.Player;

public class Coin extends ConsumableItem {
    private final int value;

    /**
     * coin item constructor
     *
     * @param value    the coin instance value (integer)
     * @param portable a boolean variable that describes if the coin is portable.
     *                 enemy's if they drop coins when killed will need to have a portable coin in inventory
     *                 for main player, coin will not be portable
     */
    public Coin(int value, boolean portable) {
        super("Coin $" + value, '$', portable);
        this.value = value;
        //this.addAction(new ConsumeAction(this));
    }

    /**
     * a getter for private value attribute of coin
     * @return integer coin value
     */
    public int getValue() {
        return this.value;
    }


    /**
     * a method to pick up the coin and remove it from the map
     * @param player the player whose balance will be affected by coin pickup
     * @return the menu description of the pickup action
     */
    public void removeCoin(Player player) {
        player.editBalance(this.getValue());
        }

    /**
     * adds coin action to coin item allowable actions
     * @param action the action to add to list of allowable actions
     */
    public void addCoinAction(Action action) {
        this.addAction(action);
    }

    public void removeActionCoin(Action action){
        this.removeAction(action);
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        int check = BuyerManager.getInstance().buyers().indexOf(actor);
        if (check!= -1){
            Buyer buyer = BuyerManager.getInstance().buyers().get(check);
            buyer.editBalance(this.value);
        }
        actor.removeItemFromInventory(this);
        this.removeActionCoin(this.getConsumeAction());
        map.locationOf(actor).removeItem(this);
    }
}
