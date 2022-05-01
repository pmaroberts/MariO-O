package game.actors;

import edu.monash.fit2099.engine.items.Item;
import game.magical_Items.Coin;

public interface Buyer {

    int getWalletBalance();

    void addMoney(Coin coin);

    void editBalance(int amount);

    void addItemToInventoryBuyer(Item item);

    void addCapability(Enum<?> capability);
}
