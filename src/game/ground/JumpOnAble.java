package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.items.Coin;

public interface JumpOnAble {
    /**
     * Method that runs when Grounds are jumped on.
     * @return 0 if jump is successful, fall damage if jump fails.
     */
    int didJumpSucceed();

    /**
     * Method for destroying JumpOnAble ground when actor walks through it with a PowerStar
     * @param location location of the actor
     */
    default void destroyedByPowerStar(Location location){
        Actor actor = location.getActor();
        if(actor != null && actor.hasCapability(Status.POWERSTAR)){
            location.setGround(new Dirt());
            location.addItem(new Coin(5,true));
        }
    }

    /**
     * Method for adding instances of Ground objects that implement JumpOnAble interface (to avoid casting)
     */
    default void addInstance(){
        JumpOnAbleGroundManager.getInstance().appendJumpOnAbleGround(this);
    }

}
