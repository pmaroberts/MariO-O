package game.actors;

import edu.monash.fit2099.engine.items.Item;
import game.magical_Items.BuyerManager;

public interface Buyer {

    int getWalletBalance();

    void editBalance(int amount);

    void addItemToInventoryBuyer(Item item);

    void addCapability(Enum<?> capability);

    default void addInstance(){
        BuyerManager.getInstance().appendBuyer(this);
    }
}
