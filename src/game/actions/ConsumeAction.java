package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
//import game.magical_Items.Coin;
import game.magical_Items.PowerStar;





public abstract class ConsumeAction extends Action {
    private final Item item;


    /**
     * Consume item action constructor
     * @param item the chosen item instance to be consumed
     */
    public ConsumeAction(Item item) {
        this.item = item;
    }

    /**
     * overriding action class execute method. updates and calls methods according to which item type is fed through
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return menu description string. actor consumes .....item
     */
    @Override
    public String execute(Actor actor, GameMap map ) {
        actor.removeItemFromInventory(item);

        if(item.toString().equals("PowerStar")){
            PowerStar powerStar = new PowerStar(true);
            powerStar.healPlayer(actor);
            powerStar.updateStatus(Status.POWERSTAR);
            //more powerStar methods here if neccessary?
            // i think other capabilities will be in other classes tho, enemy, trees?
            return menuDescription(actor);
        }
        //else if (item.toString().equals("Coin")){
        //    Coin coin = new Coin();
        //}
        else {
            return "";
        }
    }

    /**
     * creates a string about the actors action
     * @param actor The actor performing the action.
     * @return a string that describes the consumption that can be printed to the user
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item ;
    }
}

