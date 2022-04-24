package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.actors.Status;

public class SuperMushroom extends Item {

    private static final int SUPER_MUSHROOM_HP_BONUS = 50; //add 50 max HP everytime superMushroom consumed
    private static final int PRICE = 400; //$400 to purchase from Toad

    /**
     * constructor
     * @param portable whether or not the item is able to be carried by player
     */
    public SuperMushroom(boolean portable){ //idk about this, how to tell if traded or picked up?
        super("SuperMushroom", '^', portable);
    }

    /**
     * responsible for permanently increasing the maxHP by 50 for the actor
     * and sets the players HP to the max HP
     * @param actor the actor who consumed the mushroom
     */
    public void increaseHPSuperMushroom(Actor actor){

        actor.increaseMaxHp(SUPER_MUSHROOM_HP_BONUS);
        actor.heal(99999); //arbitrarily large number since heal caps at maxHP
    }

    /**
     * this method is responsible for changing the display character for Mario from m to M
     * @param actor the actor who consumed the super mushroom
     */
    public void updatePlayerDisplayCharacter(Actor actor) {
        actor.addCapability(Status.TALL); //updating enum
    }

    /**
     * this adds the consume action to the action list of allowable actions if the SuperMushroom is in the players inventory
     * @param actor the actor who consumes the mushroom
     */
    public void addSuperMushroomConsumeAction(Actor actor){
        if (actor.getInventory().toString().equals("SuperMushroom")){
            this.addAction(new ConsumeAction(this));
        }
    }

    public void addSuperMushroomAction(Action action) {
        this.addAction(action);
    }

    /**
     * getter for private price attribute
     * @return static price attribute
     */
    public int getPrice(){return SuperMushroom.PRICE;}

    /**
     * Add the item to the actor's inventory.
     *
     * @see Action#execute(Actor, GameMap)
     * @param superMushroom the instance of the superMushroom picked up
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a suitable description to display in the UI
     */
    public String pickupSuperMushroom(SuperMushroom superMushroom, Actor actor, GameMap map){
        PickUpItemAction pickUpItemAction = new PickUpItemAction(superMushroom);//adds the item to the class
        return pickUpItemAction.execute(actor, map); //return statement to be shown to user
    }

}
