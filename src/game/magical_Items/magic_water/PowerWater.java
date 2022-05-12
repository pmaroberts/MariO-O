package game.magical_Items.magic_water;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class PowerWater extends Water{

    public PowerWater(){
        super("PowerWater", 'P');
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        int prev_damage = actor.getWeapon().damage();
        new IntrinsicWeapon(prev_damage+15, "punches");
    }
}
