package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.PurchaseAction;
import game.actions.SpeakWithToadAction;
import game.magical_Items.BuyerManager;
import game.magical_Items.PowerStar;
import game.magical_Items.SuperMushroom;
import game.weapon.Wrench;

public class Toad extends Actor {

    public Toad() {
        super("Toad", '0', 999999999);
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
            int check = BuyerManager.getInstance().buyers().indexOf(otherActor);
            if (check!= -1){
                Buyer buyer = BuyerManager.getInstance().buyers().get(check);
                actions.add(new PurchaseAction(new SuperMushroom(true), buyer));
                actions.add(new PurchaseAction(new PowerStar(true), buyer));
                actions.add(new PurchaseAction(new Wrench(), buyer));
                actions.add(new SpeakWithToadAction(otherActor));
            }
        }
        return actions;
    }
}


