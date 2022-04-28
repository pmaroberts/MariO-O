package game.magical_Items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actors.Status;

public class PowerStar extends ConsumableItem {
    public static final int PRICE = 600;
    private int turns;

    /**
     * constructor for PowerStar item, initialises turns (age counter) to zero
     *
     * @param portable a boolean variable to indicate whether the item can be moved/ carried
     */
    public PowerStar(boolean portable) {
        super("PowerStar", '*', portable);
        turns = 0;
    }

    /**
     * getter for private class price attribute
     *
     * @return the static price attribute, references class instance not created object instance.
     */
    public int getPrice() {
        return PowerStar.PRICE;
    }

    /**
     * getter for turns counter, private 'age; attribute for PowerStar item
     *
     * @return an integer indicating item age
     */
    public int getTurns() {
        return this.turns;
    }

    /**
     * this is responsible for increasing the player HP by 200
     *
     * @param actor the player who has used the powerStar
     */
    public void healPlayer(Actor actor) {
        actor.heal(200);
    }

    /**
     * overridden tick method from item class. added a counter, turns attribute, which will track the amount of
     * time (turns) that have passed since the initialisation of the particular instance
     *
     * @param location the location at which the item is (on the floor)
     */
    @Override
    public void tick(Location location) {
        this.turns++;
        if (this.turns == 10) {
            location.removeItem(this);
        }
    }

    /**
     * overriding second tick method in item abstract class. this one tracks the passing of time of a carried
     * item (one in the actor's inventory). once it
     *
     * @param location the location that the actor is at
     * @param actor    The actor carrying this Item.
     */
    @Override
    public void tick(Location location, Actor actor) {
        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.hasCapability(Status.POWERSTAR)) {
                this.turns++;
                if (this.turns == 10) {
                    actor.removeItemFromInventory(actor.getInventory().get(i));
                    actor.removeCapability(Status.POWERSTAR);
                    removeInstantKill();
                }
            }
        }
    }

    /**
     * instant kill method implements that a base hit from the user with no weapon while powerStar is active
     * will instantly kill any enemy because the damage is such an arbitrary high number.
     */
    public void instantKill() {
        IntrinsicWeapon instaKill = new IntrinsicWeapon(999999, "POWERSTAR_INSTAKILL");
    }

    /**
     * this simply resets the users base attack skill to what was previously before powerStar booster initiated
     */
    public void removeInstantKill() {
        IntrinsicWeapon instaKill = new IntrinsicWeapon(5, "punch");
    }

    /**
     * updates player status enum with capability selected
     *
     * @param status chosen status, multipurpose method as any status can be updated
     */
    public void updateStatus(Status status) {
        this.addCapability(status);
    }

    public void removeActionPowerStar(Action action){
        this.removeAction(action);
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        actor.removeItemFromInventory(this);
        this.healPlayer(actor);
        actor.addCapability(Status.POWERSTAR);
        this.instantKill();
        this.removeActionPowerStar(this.getConsumeAction());
        map.locationOf(actor).removeItem(this);
    }

}
