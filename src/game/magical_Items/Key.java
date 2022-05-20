package game.magical_Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

public class Key extends Item {

    public Key(){
        super("Key", '%',true);
    }


    // Actor is buffed with the Keyholder status simply for holding the Key
    @Override
    public void tick(Location currentLocation, Actor actor){
        actor.addCapability(Status.KEYHOLDER);
    }


    // Key cannot be dropped by Player once picked up (because why would you)
    @Override
    public DropItemAction getDropAction(Actor actor){
        if(!actor.hasCapability(Status.HOSTILE_TO_ENEMY)){
            return new DropItemAction(this);
        }
        return null;
    }


}
