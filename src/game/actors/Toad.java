package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actions.SpeakWithToadAction;
import game.weapon.Wrench;

import java.util.Random;

public class Toad extends Actor {

    Wrench wrench = new Wrench();

    public Toad() {
        super("Toad", 'T', 999999999);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new DoNothingAction());

        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new SpeakWithToadAction(otherActor));
        }
        return actions;
    }


}


