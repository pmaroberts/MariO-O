package game.magical_Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
public interface PurchasableItem {


    String purchase(Actor actor, GameMap map);

}