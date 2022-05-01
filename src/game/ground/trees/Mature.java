package game.ground.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Koopa;
import game.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import game.actors.Status;
import game.ground.Dirt;


public class Mature extends Tree {

    private static final double KOOPA_ODDS = 0.15;
    private static final double SUICIDE_ODDS = 0.2;
    private static final double JUMP_ODDS = 0.7;
    private static final int FALL_DAMAGE = 30;

    public Mature() {
        super('T'); // 'T' is the display character for Matures
    }

    @Override
    public void tick(Location location){
        super.incrementAge();
        this.spawnKoopa(location);
        this.spawnSprout(location);
        this.suicide(location);
        this.destroyedByPowerStar(location);
    }

    public void spawnKoopa(Location location){
        if(Utils.probReturn(KOOPA_ODDS) && !location.containsAnActor()){
            location.addActor(new Koopa());
        }
    }

    public void suicide(Location location){
        if(Utils.probReturn(SUICIDE_ODDS)){
            location.setGround(new Dirt());
        }
    }

    public void spawnSprout(Location location){
        Random rand = new Random();
        List<Exit> exits = location.getExits();
        List<Exit> dirtExits = new ArrayList<>();

        if(super.age%5 == 0){
            for(Exit exit : exits){
                if(exit.getDestination().getGround().hasCapability(Status.FERTILE)){
                    dirtExits.add(exit);
                }
            }
            if(!dirtExits.isEmpty())
            {
                Exit chosenExit = dirtExits.get(rand.nextInt(dirtExits.size()));
                chosenExit.getDestination().setGround(new Sprout());
            }

        }
    }

    // Returns 0 if jump is successful, fall damage if jump fails.

    @Override
    public int jump() {
        if(Utils.probReturn(JUMP_ODDS)){
            return 0;
        }
        return FALL_DAMAGE;
    }


}
