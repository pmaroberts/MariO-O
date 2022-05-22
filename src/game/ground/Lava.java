package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

public class Lava extends Ground {

    private static final int DAMAGE = 15;
    public Lava(){
        super('L');
    }

    @Override
    public void tick(Location location){
        hurtActor(location);
    }

    @Override
    public boolean canActorEnter(Actor actor){
        return !actor.hasCapability(Status.LAVA_BANNED);
    }

    // Hurts the actor and then removes it if the actor is dead.
    public void hurtActor(Location location){
        Actor actor = location.getActor();
        if(actor != null){
            actor.hurt(DAMAGE);
            if(!actor.isConscious()){
                location.map().removeActor(actor);
            }
        }
    }

}
