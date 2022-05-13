package game.magical_Items;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;

public class Fire extends Item {
    private int turns;
    /***
     * Constructor.
     */
    public Fire() {
        super("Fire", 'v', false);
        this.turns = 0;
    }

    /**
     * tick method tracks passage of time for fire on the ground
     * will be removed if on ground for 3 turns
     * if not expired, check for an actor and deal 20 damage
     * @param location the location of the fire
     */
    @Override
    public void tick(Location location) {
        this.turns++;
        if (this.turns == 3) {
            location.removeItem(this);
        }
        else if(location.containsAnActor()){
            location.getActor().hurt(20);
        }

    }


}
