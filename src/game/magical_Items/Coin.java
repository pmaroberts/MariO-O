package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Player;
import game.reset.Resettable;

public class Coin extends Item implements Resettable {
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
        this.registerInstance();
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
    public String removeCoin(Player player, GameMap gameMap) {
        PickUpItemAction pickUpItemAction = new PickUpItemAction(this);
        player.editBalance(this.getValue());
        return pickUpItemAction.execute(player, gameMap);
        }

    /**
     * adds coin action to coin item allowable actions
     * @param action the action to add to list of allowable actions
     */
    public void addCoinAction(Action action) {
        this.addAction(action);
    }

    @Override
    public void resetInstance() {
        //create disposable character to 'pick up coins' then delete disposable character?
        Player disposable = new Player("disposeable", 'd', 2);
        //removeCoin(disposable,)


        //get current map and removes this coin
        //GameMap map = ;
        //map.locationOf(this).removeItem(this);
        //this allowed ??????^^^^
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
