package game.magical_Items.magic_water;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.ConsumableItem;


public abstract class Water extends ConsumableItem {

    public Water(String name, char dispchar){
        super( name, dispchar,false);

    }

    @Override
    public void toExecute(Actor actor, GameMap map){

    }

}
