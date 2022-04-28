package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Utils;
import game.weapon.Wrench;

public class DestroyShell extends Action {

    protected Actor target;
    protected String direction;


    public DestroyShell(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if(Utils.probReturn(actor.getWeapon().chanceToHit())){
            ActionList dropActions = new ActionList();
            // drop all items
            for (Item item : target.getInventory())
                dropActions.add(item.getDropAction(actor));
            for (Action drop : dropActions)
                drop.execute(target, map);
            // remove actor
            map.removeActor(target);
            return "Shell is destroyed";
        }
        else{
            return actor + "misses";
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks shell at " + direction + " with wrench";
    }
}
