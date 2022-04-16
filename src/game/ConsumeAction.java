package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;


// i want this class to have an execute method that removes item from ground/ or inventory (if else if-else loop to check)
// i want the item class to create an action instance (addSampleAction) and then add it to this.allowable actions
// i reckon best way to do would be having a item.type

public class ConsumeAction extends Action {
    private final Item item;

    ConsumeAction(Item item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map ) {
        actor.removeItemFromInventory(item);

        ActionList magicalItems = new ActionList();

       // magicalItems.add(this.item); APPARENTLY CANNOT ADD ITEMS TO ACTION LIST????????


        if (item.toString().equals("SuperMushroom")){
            SuperMushroom superMushroom = new SuperMushroom(true);
            superMushroom.increaseHPSuperMushroom(actor);
            superMushroom.updatePlayerDisplayCharacter(actor);
            return menuDescription(actor);
        }
        else if(item.toString().equals("PowerStar")){
            PowerStar powerStar = new PowerStar(true);
            powerStar.healPlayer(actor);
            //powerStar.
            return "";
        }
        else {
            return "";
        }
        }


    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + item ;
    }
}

