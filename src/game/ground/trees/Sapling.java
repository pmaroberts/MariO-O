package game.ground.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.Tree;
import game.Utils;

public class Sapling extends Tree {

    private final double COIN_ODDS = 0.1;
    private final int COIN_VALUE = 20;
    private final int GROW_UP_AGE = 10;

    public Sapling() {
        super('t'); // 't' is the display character for Saplings
    }

    @Override
    public void tick(Location location){
        super.incrementAge();
        this.dropCoin(location);
        this.growUp(location);
    }

    public void dropCoin(Location location){
        if(Utils.probReturn(COIN_ODDS)){
            location.addItem(new Coin(COIN_VALUE,true));
        }
    }

    public void growUp(Location location){
        if(super.age == GROW_UP_AGE){
            location.setGround(new Mature());
        }
    }


}
