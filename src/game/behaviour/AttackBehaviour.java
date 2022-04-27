package game.behaviour;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.actors.Status;


public class AttackBehaviour implements Behaviour {


    // TODO: develop and use it to attack the player automatically.
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()){
            Location destination = exit.getDestination();
            // Check if there is an actor at exit.
            if(destination.containsAnActor()){
                Actor target = destination.getActor();
                // Check if the actor at the exit is hostile to enemy (i.e. a player)
                if(target.hasCapability(Status.HOSTILE_TO_ENEMY)){
                    return new AttackAction(target, exit.getName());
                }

            }
        }
        return null;



    }
}
