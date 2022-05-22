package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.ground.PipesManager;

public class WarpAction extends Action {


    @Override
    public String execute(Actor actor, GameMap map) {

        Location oldLocation = map.locationOf(actor);

        // Try to kill the PiranhaPlant at the pipe if it is there.
        if(PipesManager.getInstance().getWarpTo().containsAnActor()){
            map.removeActor(PipesManager.getInstance().getWarpTo().getActor());
        }

        map.moveActor(actor,PipesManager.getInstance().getWarpTo());
        PipesManager.getInstance().setWarpTo(oldLocation);
        return actor.toString() + "teleported successfully";

    }

    @Override
    public String menuDescription(Actor actor) {
        return "Teleport through WarpPipe";
    }
}
