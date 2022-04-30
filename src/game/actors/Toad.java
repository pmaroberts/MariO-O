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
    private final Buyer buyer;


    public Toad(Buyer buyer) {
        super("Toad", '0', 999999999);
        this.buyer = buyer;
    }
// get copy of list of actors, then check if the actor has hostiletoenemy status
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        Location here = map.locationOf(this);
        for(Exit exit : here.getExits()){
            if(exit.getDestination().containsAnActor()){
                Actor actor = exit.getDestination().getActor();
                if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    new PurchaseAction(new SuperMushroom(true), this.buyer);
                    actions.add(new PurchaseAction(new PowerStar(true), this.buyer));
                    actions.add(new PurchaseAction(new Wrench(), this.buyer));
                }


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


