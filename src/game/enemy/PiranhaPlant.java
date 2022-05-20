package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actors.Status;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;

import java.util.Map;
import java.util.TreeMap;

public class PiranhaPlant extends Enemy{

    private static final int RESET_HP_INCREASE = 50;
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour



    public PiranhaPlant(){
        super("PiranhaPlant",'Y',1); // Should be 150 as per assignment 3
        this.behaviours.put(1, new AttackBehaviour());
        this.registerResetInstance();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this,direction));
        }

        return actions;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle the reset please

        if(this.hasCapability(Status.RESET)){
            this.increaseMaxHp(RESET_HP_INCREASE);
            this.heal(99999);
            this.removeCapability(Status.RESET);
            return new DoNothingAction();
        }

        for(Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "chomps"); // Should be 90 as per assignment 3
    }

}
