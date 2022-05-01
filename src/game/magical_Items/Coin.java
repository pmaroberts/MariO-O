package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Buyer;
import game.actors.Status;
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
    public void tick(Location location){
        if(this.hasCapability(Status.RESET)){
            location.removeItem(this);
        }

    }

    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }


}
