package game.ground;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.JumpActorAction;
import game.actions.WarpAction;
import game.actors.Status;
import game.enemy.PiranhaPlant;
import game.reset.Resettable;

// Needs to implement resettable.
// NO destroyed by powerstar in tick, it cannot be destroyed by powerstar.
public class WarpPipe extends Ground implements JumpOnAble, Resettable {

    private int age = 0;

    public WarpPipe(){
        super('C');
        this.addJumpInstance();
        this.registerResetInstance();
    }

    @Override
    public void tick(Location location){
        this.age++;
        spawnPiranhaPlant(location);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions =  new ActionList();

        // Jumping
        if(!location.containsAnActor() && !replaceCanActorEnter(actor)){
            actions.add(new JumpActorAction(location, direction));
        }

        // Teleporting
        if(location.getActor() == actor && actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            actions.add(new WarpAction());
        }

        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor){
        return replaceCanActorEnter(actor);
    }

    @Override
    public int didJumpSucceed() {
        return 0;
    }

    public void spawnPiranhaPlant(Location location){
        if((this.age == 1 || this.hasCapability(Status.RESET))  && !location.containsAnActor()){
            location.addActor(new PiranhaPlant());
            this.removeCapability(Status.RESET);
        }
    }

    @Override
    public void resetInstance() {
        this.addCapability(Status.RESET);
    }
}
