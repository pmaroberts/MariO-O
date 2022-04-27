package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Player;

public class Coin extends Item {
    private final int value;

    /**
     * coin item constructor
     *
     * @param value    the coin instance value (integer)
     * @param portable a boolean variable that describes if the coin is portable.
     *                 enemy's if they drop coins when killed will need to have a portable coin in inventory
     *                 for main player, coin will not be portable
     */
    Coin(int value, boolean portable) {
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
     * @param gameMap the gameMap that the coin is found on
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
}
