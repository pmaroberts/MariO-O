package game.magical_Items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Buyer;

public interface PurchasableItem {

    /**
     * general purchase method to allow purchaseAction to call general execute
     * @param buyer Buyer purchasing the item
     * @param map GameMap the buyer is on
     * @return string menuDescription
     */
    String purchase(Buyer buyer, GameMap map);

    /**
     * price getter (all purchasable items will have price)
     * @return int price amount
     */
    int getPrice();

}