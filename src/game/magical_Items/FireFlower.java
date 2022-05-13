package game.magical_Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

public class FireFlower extends ConsumableItem{

    private int turns;
    /**
     * consumable item constructor adds consume action to item
     */
    public FireFlower() {
        super("FireFlower", 'f', false);
        this.turns = 0;
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        actor.addCapability(Status.FIRE_ATTACK);
        this.removeAction(this.getConsumeAction());
        actor.addItemToInventory(this);
    }

    @Override
    public void tick(Location location, Actor actor) {
        this.turns++;
        if (this.turns == 20) {
            actor.removeItemFromInventory(this);
            actor.removeCapability(Status.FIRE_ATTACK);
        }
    }

    public int getTurns(){
        return this.turns;
    }
}
