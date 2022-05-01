package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.Resettable;

public class ResetAction extends Action implements Resettable {
    ResetManager reset;

    public ResetAction(ResetManager reset) {
        this.reset = reset;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        reset.run();
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return null;
    }

    @Override
    public void resetInstance() {

    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
