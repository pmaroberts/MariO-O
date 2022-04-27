package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.magical_Items.PowerStar;

public class ConsumePowerStar extends ConsumeAction{
    PowerStar powerStar;

    public ConsumePowerStar(PowerStar powerStar){
        super();
        this.powerStar = powerStar;
    }

    @Override
    public String execute(Actor actor, GameMap map ){
        actor.removeItemFromInventory(this.powerStar);
        this.powerStar.healPlayer(actor);
        actor.addCapability(Status.POWERSTAR);
        this.powerStar.instantKill();
        this.powerStar.removeActionPowerStar(powerStar.getPowerStarConsume());
        map.locationOf(actor).removeItem(powerStar);
        return menuDescription(actor);

    }

    /**
     * creates a string about the actors action
     * @param actor The actor performing the action.
     * @return a string that describes the consumption that can be printed to the user
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + this.powerStar.toString();
    }
}

