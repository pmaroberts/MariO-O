package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import java.util.HashMap;
import java.util.Map;


// ************************************************************************************
// At the moment this is just a placeholder for testing, it will be implemented soon :)
// ************************************************************************************
public class Koopa extends Actor {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    public Koopa() {
        super("Koopa", 'K', 50);
        this.behaviours.put(10, new WanderBehaviour());
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for(Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }
}
