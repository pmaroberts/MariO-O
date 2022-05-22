package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class UnlockCuffs extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        map.removeActor(actor);
        return "Congratulations! You have saved Princess Peach from Bowser. They can now live happily ever after!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Unlock Princess Peach's handcuffs";
    }
}
