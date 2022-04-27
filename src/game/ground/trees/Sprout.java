package game.ground.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Goomba;
import game.Utils;

public class Sprout extends Tree {

    private final double GOOMBA_ODDS = 0.0; // Should be 0.1 as per Assignment 1.
    private final int GROW_UP_AGE = 10;


    public Sprout() {
        super('+'); // '+' is the display character for Sprouts
    }

    @Override
    public void tick(Location location){
        super.incrementAge();
        this.spawnGoomba(location);
        this.growUp(location);

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
}
