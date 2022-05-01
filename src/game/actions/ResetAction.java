package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.Resettable;

public class ResetAction extends Action{
    ResetManager reset;

    public ResetAction() {
        this.reset = ResetManager.getInstance();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        reset.run();
        return "Reset complete!";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Reset the map (you can only do this once!)";
    }

    @Override
    public String hotkey(){return "r";};


}
