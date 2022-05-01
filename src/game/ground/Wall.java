package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.actions.JumpAction;
import game.actors.Status;

public class Wall extends Ground implements JumpOnAble{

	private static final double JUMP_ODDS = 0.8;
	private static final int FALL_DAMAGE = 20;

	public Wall() {
		super('#');
		this.addInstance();
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.POWERSTAR);
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	public int jump() {
		if(Utils.probReturn(JUMP_ODDS)){
			return 0;
		}
		return FALL_DAMAGE;
	}


	@Override
	public ActionList allowableActions(Actor actor, Location location, String direction){
		ActionList actions =  new ActionList();
		if(!location.containsAnActor() && !actor.hasCapability(Status.POWERSTAR)){
			actions.add(new JumpAction(location, direction));
		}
		return actions;
	}

	@Override
	public void tick(Location location) {
		this.destroyedByPowerStar(location);
	}
}
