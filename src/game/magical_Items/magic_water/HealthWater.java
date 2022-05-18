package game.magical_Items.magic_water;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class HealthWater extends Water{

    public HealthWater(){
        super("HealthWater", 'H');

    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        actor.heal(50);
    }

}
