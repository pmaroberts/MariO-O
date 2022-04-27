package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.SuperMushroom;

public class ConsumeSuperMushroom extends ConsumeAction{
    SuperMushroom superMushroom;

    public ConsumeSuperMushroom(SuperMushroom superMushroom){
        super();
        this.superMushroom = superMushroom;

    }

    @Override
    public String execute(Actor actor, GameMap map ){
        actor.removeItemFromInventory(this.superMushroom);
        this.superMushroom.increaseHPSuperMushroom(actor);
        this.superMushroom.updatePlayerDisplayCharacter(actor);
        this.superMushroom.removeActionSuperMushroom(superMushroom.getSuperMushroomConsume());
        map.locationOf(actor).removeItem(superMushroom);
        return menuDescription(actor);

    }

    /**
     * creates a string about the actors action
     * @param actor The actor performing the action.
     * @return a string that describes the consumption that can be printed to the user
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + this.superMushroom.toString();
    }


}

