package game.ground.trees;

import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.magical_Items.Coin;


public class Sapling extends Tree {

    private static final double COIN_ODDS = 0.1;
    private static final int COIN_VALUE = 20;
    private static final int GROW_UP_AGE = 10;
    private static final double JUMP_ODDS = 0.8;
    private static final int FALL_DAMAGE = 20;

    public Sapling() {
        super('t'); // 't' is the display character for Saplings
    }

    @Override
    public void tick(Location location){
        super.incrementAge();
        this.dropCoin(location);
        this.growUp(location);
        this.destroyedByPowerStar(location);
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

    public int jump() {
        if(Utils.probReturn(JUMP_ODDS)){
            return 0;
        }
        return FALL_DAMAGE;
    }

}
