package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.magic_water.Bottle;
import game.magical_Items.magic_water.Water;

public class FillAction extends Action {

    private final Bottle bottle;
    private final Water water;
    public FillAction(Bottle bottle, Water water){
        this.bottle = bottle;
        this.water = water;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.bottle.addToBottle(this.water);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " refill " + this.water.toString();
    }
}
