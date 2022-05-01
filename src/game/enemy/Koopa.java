package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.AttackAction;
import game.actions.DestroyShell;
import game.actors.Status;
import game.behaviour.Behaviour;
import game.behaviour.FollowBehaviour;
import game.behaviour.WanderBehaviour;
import game.magical_Items.SuperMushroom;

import java.util.HashMap;
import java.util.Map;



public class Koopa extends Enemy {

    private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority, behaviour


    public Koopa() {
        super("Koopa", 'K', 100); // hp should be 100
        //this.behaviours.put(10, new WanderBehaviour());
        //this.behaviours.put(1, new AttackBehaviour());
        this.addCapability(Status.VALID_CORPSE);
        this.addItemToInventory(new SuperMushroom(true));
    }

    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            if(this.hasCapability(Status.VALID_CORPSE)){
                actions.add(new AttackAction(this,direction));
            }
            else if(otherActor.hasCapability(Status.WRENCH)){
                actions.add(new DestroyShell(this,direction));
            }
        }
        return actions;
    }


    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        if(this.hasCapability(Status.RESET)){
            map.removeActor(this);
            return new DoNothingAction();
        }

        if(!this.isConscious()){
            this.becomeDormant();
        }
        // Allows Koopa to follow whatever attacks it
        Actor attacker = this.startFollowFromExit(map);
        if(attacker != null && this.hasCapability(Status.VALID_CORPSE)){
            try{
                this.behaviours.put(2, new FollowBehaviour(attacker));
            }
            catch(Exception ignored){}
        }
        for(Behaviour Behaviour : behaviours.values()) {
            Action action = Behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        return new DoNothingAction();
    }

    public void becomeDormant(){
        this.setDisplayChar('D');
        this.behaviours.clear(); // Removes all behaviours
        this.removeCapability(Status.VALID_CORPSE);
        this.addCapability(Status.DORMANT);
    }

    @Override
    protected IntrinsicWeapon getIntrinsicWeapon(){
        // We can use intrinsic weapon here because it automatically has a 50% hit rate.
        return new IntrinsicWeapon(30, "punch"); //
    }
}
