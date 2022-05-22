package game.actors.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.SpeakAction;
import game.actors.Speakable;
import game.actors.Status;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;

import javax.swing.*;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
/**
 * Koopa Class
 * @author Peter Roberts
 * @author Sara Hopkins
 * @version Assignment 3
 */
public class PiranhaPlant extends Enemy implements Speakable {

    private static final int RESET_HP_INCREASE = 50;
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority, behaviour

    /**
     * array of strings that Piranha Plant can speak
     */
    private final String[] dialogue = {"Slsstssthshs~! (Never gonna say goodbye~)",
            "Ohmnom nom nom nom."
    };

    /**
     * Age of Piranha, used to allow the plant to speak every second turn
     */
    private int age;


    public PiranhaPlant(){
        super("Piranha Plant",'Y',1); // Should be 150 as per assignment 3
        this.behaviours.put(1, new AttackBehaviour());
        this.registerResetInstance();
        this.age = 0;
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

        this.age++;
        // Handle the reset please
        if(this.hasCapability(Status.RESET)){
            this.increaseMaxHp(RESET_HP_INCREASE);
            this.heal(99999);
            this.removeCapability(Status.RESET);
            return new DoNothingAction();
        }

        if(this.age % 2 == 0){
            return new SpeakAction(this);
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

    /**
     * method to pick random prompt for Piranha Plant to speak each turn
     * @param actor default actor, included in interface for speak with Toad
     * @return the string spoken
     */
    @Override
    public String speak(Actor actor) {
        Random r = new Random();
        return dialogue[r.nextInt(2)];
    }

}
