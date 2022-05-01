package game.ground.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;
import game.enemy.Goomba;
import game.Utils;
import game.ground.Dirt;

public class Sprout extends Tree {

    private static final double GOOMBA_ODDS = 0.1; // Should be 0.1 as per Assignment 1.
    private static final int GROW_UP_AGE = 10;
    private static final double JUMP_ODDS = 0.9;
    private static final int FALL_DAMAGE = 10;


    public Sprout() {
        super('+'); // '+' is the display character for Sprouts
    }

    @Override
    public void tick(Location location){
        if(this.hasCapability(Status.RESET)){
            location.setGround(new Dirt());
        }
        super.incrementAge();
        this.spawnGoomba(location);
        this.growUp(location);
        this.destroyedByPowerStar(location);

    }

    public void spawnGoomba(Location location){
        if(Utils.probReturn(GOOMBA_ODDS) && !location.containsAnActor()){
            location.addActor(new Goomba());
        }
    }

    public void growUp(Location location){
        if(super.age == GROW_UP_AGE){
            location.setGround(new Sapling());
        }
    }

    public int jump() {
        if(Utils.probReturn(JUMP_ODDS)){
            return 0;
        }
        return FALL_DAMAGE;
    }
}
