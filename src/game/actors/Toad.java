package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.actions.SpeakWithToadAction;
import game.magical_Items.PowerStar;
import game.magical_Items.SuperMushroom;
import game.weapon.Wrench;

public class Toad extends Actor {
private final Buyer buyer;

    public Toad(Buyer buyer) {
        super("Toad", '0', 999999999);
        this.buyer = buyer;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new DoNothingAction());
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){

            actions.add(new PurchaseAction(new SuperMushroom(true), this.buyer));
            actions.add(new PurchaseAction(new PowerStar(true), this.buyer));
            actions.add(new PurchaseAction(new Wrench(), this.buyer));
            actions.add(new SpeakWithToadAction(otherActor));
        }
        return actions;
    }
}


