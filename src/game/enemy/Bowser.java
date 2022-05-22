package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actors.Status;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;
import game.behaviour.FollowBehaviour;
import game.magical_Items.Key;

import java.util.Map;
import java.util.TreeMap;

public class Bowser extends Enemy{

    /**
     * Behaviours treemap
     */
    private final Map<Integer, Behaviour> behaviours = new TreeMap<>(); // priority,

    /**
     * Allows the Bowser to return home on reset
     */
    private final Location home;

    public Bowser(Location home){
        super("Bowser",'B',1); // Should be 500 as per assignment 3
        this.home = home;
        this.addItemToInventory(new Key());
        this.addCapability(Status.FIRE_ATTACK);
        this.behaviours.put(1, new AttackBehaviour());
    }


    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            behaviours.put(2,new FollowBehaviour(otherActor));
            actions.add(new AttackAction(this,direction));
        }
        return actions;
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // Go home and heal if reset has been run
        if(this.hasCapability(Status.RESET)){
            map.moveActor(this,home);
            this.heal(99999);
            this.behaviours.clear();
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
        return new IntrinsicWeapon(1, "punches");
    } // Should be 80 as per assignment 3

}
