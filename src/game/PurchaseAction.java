package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;

public class PurchaseAction extends Action {





/*
    if (item.toString().equals("SuperMushroom")){
        SuperMushroom superMushroom = new SuperMushroom(true);
        Coin coin = new Coin(player);
        coin.checkBalance(superMushroom.getPrice());
    } */

    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + item ;
    }
}
