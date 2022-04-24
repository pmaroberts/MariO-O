package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

public class Toad extends Actor {

    Toad() {
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
        return actions;
    }
}


