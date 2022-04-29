package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.PurchaseAction;
import game.magical_Items.PowerStar;
import game.magical_Items.SuperMushroom;
import game.weapon.Wrench;

public class Toad extends Actor {

    public Toad() {
        super("Toad", '0', 999999999);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        Location here = map.locationOf(this);
        for(Exit exit : here.getExits()){
            if(exit.getDestination().containsAnActor()){
                Actor buyer = exit.getDestination().getActor();
                actions.add(new PurchaseAction(new SuperMushroom(true)));
                actions.add(new PurchaseAction(new PowerStar(true)));
                actions.add(new PurchaseAction(new Wrench()));


            }
        }
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new DoNothingAction());
        return actions;
    }
}


