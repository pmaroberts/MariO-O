package game.magical_Items;

import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Buyer;

public interface PurchasableItem {


    String purchase(Buyer buyer, GameMap map);

    int getPrice();

}