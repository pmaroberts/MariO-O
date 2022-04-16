package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;

public class Coin extends Item {
    private int value;

    Coin(int value, boolean portable){
        super("Coin $"+ value, '$', portable);
        this.value = value;
    }


    public boolean checkBalance(int price, Player player){
        if (player.wallet => price) {
            return true;
        }
        else{
            return false;
        }
    }


    public String removeCoin(Coin coin, Actor actor, GameMap gameMap){
        PickUpItemAction pickUpItemAction = new PickUpItemAction(coin);
        return pickUpItemAction.execute(actor, gameMap);
    }
}
