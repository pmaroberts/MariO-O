package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.ground.JumpOnAble;
import game.ground.JumpOnAbleGroundManager;

public class JumpAction extends Action {

    protected Location jumpToLocation;
    protected String direction;
    protected JumpOnAble jumpToGround;

    public JumpAction(Location jumpToLocation, String direction) {
        this.direction = direction;
        this.jumpToLocation = jumpToLocation;
        int check = JumpOnAbleGroundManager.getInstance().getJumpOnAbles().indexOf(jumpToLocation.getGround());
        if(check != -1){
            this.jumpToGround = JumpOnAbleGroundManager.getInstance().getJumpOnAbles().get(check);
        }

    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int jumpResult = jumpToGround.jump();
        if(jumpResult == 0 || actor.hasCapability(Status.TALL)){
            map.moveActor(actor, this.jumpToLocation);
            return "Jumped successfully to " + this.jumpToGround.getClass().getSimpleName() + "(" + this.jumpToLocation.x() + ", " + this.jumpToLocation.y() + ")";
        }
        actor.hurt(jumpResult);
        return "Jump failed. HP has been decreased by " + jumpResult;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " jumps on " + this.jumpToGround.getClass().getSimpleName() + " to the " + direction;
    }
}
