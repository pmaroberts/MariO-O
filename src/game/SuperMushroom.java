package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

public class SuperMushroom extends Item {

    private static final int SUPER_MUSHROOM_HP_BONUS = 50; //add 50 max HP everytime superMushroom consumed
    private static final int PRICE = 400;


    SuperMushroom(boolean portable){ //idk about this, how to tell if traded or picked up?
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
    public void updatePlayerDisplayCharacter(Actor actor){
        actor.addCapability(Status.TALL); //updating enum
        //actor.setDisplayChar(Character.toUpperCase(getDisplayChar())); // setDisplayChar hasn't yet been extended into actor
    }

    public void addSuperMushroomAction(Action action){
        this.addAction(action);
    }

    public int getPrice(){return SuperMushroom.PRICE;}


    /**
     * this method is to be used by Koopa enemy class when shell is broken and this method will be
     * responsible for adding the item to the map display
     * @param map the current map being used from gameMap class, generated in application class
     * @param koopaXCoordinate the x coordinate integer of where koopa "dies"
     * @param koopaYCoordinate the y coordinate integer of where koopa "dies"
     */
    public void addSuperMushroomDrop(GameMap map, int koopaXCoordinate, int koopaYCoordinate){
        Location location = new Location(map, koopaXCoordinate, koopaYCoordinate);
        location.addItem(new SuperMushroom(false));
    }



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
