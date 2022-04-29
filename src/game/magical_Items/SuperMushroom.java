package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;

public class SuperMushroom extends ConsumableItem implements PurchasableItem {

    private static final int SUPER_MUSHROOM_HP_BONUS = 50; //add 50 max HP everytime superMushroom consumed
    private static final int PRICE = 400; //$400 to purchase from Toad

    /**
     * constructor
     * @param portable whether or not the item is able to be carried by player
     */
    public SuperMushroom(boolean portable){
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


    public void addSuperMushroomAction(Action action) {
        this.addAction(action);
    }

    /**
     * getter for private price attribute
     * @return static price attribute
     */
    public int getPrice(){return SuperMushroom.PRICE;}

    public void removeActionSuperMushroom(Action action){
        this.removeAction(action);
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        actor.removeItemFromInventory(this);
        this.increaseHPSuperMushroom(actor);
        this.updatePlayerDisplayCharacter(actor);
        this.removeActionSuperMushroom(this.getConsumeAction());
        map.locationOf(actor).removeItem(this);
    }

    @Override
    public String purchase(Actor actor, GameMap map) {
        if (actor.getWalletBalance()> PRICE){
            actor.addItemToInventory(this);
            actor.editBalance(-PRICE);
            return "Successfully purchased SuperMushroom! Remaining Balance: " + actor.getWalletBalance();
        }
        return "insufficient Balance :(";
    }


}
