package game.enemy;


import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.Utils;
import game.actions.AttackAction;
import game.actors.Status;
import game.behaviour.AttackBehaviour;
import game.behaviour.Behaviour;
import game.behaviour.FollowBehaviour;
import game.behaviour.WanderBehaviour;
import game.actions.AttackAction;

import java.util.HashMap;
import java.util.Map;
/**
 * A little fungus guy.
 */
public class Goomba extends Enemy {
	private final Map<Integer, Behaviour> behaviours = new HashMap<>(); // priority,
	private static final double SUICIDE_ODDS = 0.1; // Should be 0.1 as per assignment 1

	/**
	 * Constructor.
	 */
	public Goomba() {
		super("Goomba", 'g', 50);
		this.behaviours.put(10, new WanderBehaviour());
		this.behaviours.put(1, new AttackBehaviour());
	}

	/**
	 * At the moment, we only make it can be attacked by Player.
	 * You can do something else with this method.
	 * @param otherActor the Actor that might perform an action.
	 * @param direction  String representing the direction of the other Actor
	 * @param map        current GameMap
	 * @return list of actions
	 * @see Status#HOSTILE_TO_ENEMY
	 */
	@Override
	public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
		ActionList actions = new ActionList();
		// it can be attacked only by the HOSTILE opponent, and this action will not attack the HOSTILE enemy back.
		if(otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this,direction));
		}
		return actions;
	}

	/**
	 * Figure out what to do next.
	 * @see Actor#playTurn(ActionList, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

		if(this.hasCapability(Status.RESET)){
			map.removeActor(this);
			return new DoNothingAction();
		}

		Actor attacker = this.startFollowFromExit(map);
		if(attacker != null){
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
		this.maybeSuicide(map);
		return new DoNothingAction();
	}

	@Override
	protected IntrinsicWeapon getIntrinsicWeapon(){
		// We can use intrinsic weapon here because it automatically has a 50% hit rate.
		return new IntrinsicWeapon(10, "kick"); //
	}

	public void maybeSuicide(GameMap map){
		if(Utils.probReturn(SUICIDE_ODDS)){
			map.removeActor(this);
		}
	}




}
