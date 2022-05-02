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

/**
 * Class for Toad
 * @author Sara Hopkins
 * @version Assignment 2
 */
public class Toad extends Actor {

    /**
     * toad constructor
     */
    public Toad() {
        super("Toad", '0', 999999999);
    }

    /**
     * toad play turn method, executed each round
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return doNothingAction
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }

    /**
     * allowable actions of Toad, adding purchase actions if player is in range
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return allowableActionList
     */
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


