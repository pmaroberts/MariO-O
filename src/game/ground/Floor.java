package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.actors.Status;

/**
 * A class that represents the floor inside a building.
 */
public class Floor extends Ground {
	public Floor() {
		super('_');
	}

	@Override
	public boolean canActorEnter(Actor actor){
		return !actor.hasCapability(Status.ENEMY);
	}
}

