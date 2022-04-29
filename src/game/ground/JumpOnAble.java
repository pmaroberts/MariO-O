package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.magical_Items.Coin;

public interface JumpOnAble {
    int jump();
    default void destroyedByPowerStar(Location location){
        Actor actor = location.getActor();
        if(actor != null && actor.hasCapability(Status.POWERSTAR)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5,true));
        }
    }
}
