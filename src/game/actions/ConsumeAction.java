package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public abstract class ConsumeAction extends Action {
    /**
     * Consume item action constructor
     */
    public ConsumeAction() {
    }

    /**
     * overriding action class execute method. updates and calls methods according to which item type is fed through

     */
    @Override
    public String execute(Actor actor, GameMap map ) {
            return "";
    }

    /**
     * creates a string about the actors action
     * @param actor The actor performing the action.
     * @return a string that describes the consumption that can be printed to the user
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes "  ;
    }
}

