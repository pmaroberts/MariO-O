package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Buyer;
import game.actors.Player;
import game.reset.Resettable;

public class Coin extends ConsumableItem implements Resettable {
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
        this.registerInstance();
    }

    /**
     * a getter for private value attribute of coin
     * @return integer coin value
     */
    public int getValue() {
        return this.value;
    }


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

    @Override
    public void resetInstance() {
        //create disposable character to 'pick up coins' then delete disposable character?
        Player disposable = new Player("disposable", 'd', 2);
        //removeCoin(disposable,)


        //get current map and removes this coin
        //GameMap map = ;
        //map.locationOf(this).removeItem(this);
        //this allowed ??????^^^^
    }


}
