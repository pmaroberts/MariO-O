package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class PowerStar extends Item {
    public static final int PRICE = 600;
    private int turns;

    /**
     * constructor for PowerStar item, initialises turns (age counter) to zero
     * @param portable a boolean variable to indicate whether the item can be moved/ carried
     */
    PowerStar(boolean portable) {
        super("PowerStarInstantKill", '*', portable);
        turns = 0;
    }

    /**
     * getter for private class price attribute
     * @return the static price attribute, references class instance not created object instance.
     */
    public int getPrice() {
        return PowerStar.PRICE;
    }

    /**
     * getter for turns counter, private 'age; attribute for PowerStar item
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
     * @param location the location that the actor is at
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location location, Actor actor) {
        for (int i = 0; i < actor.getInventory().size(); i++) {
            if (actor.getInventory().get(i).toString().equals("PowerStar")) {
                this.turns++;
                if (this.turns == 10) {
                    actor.removeItemFromInventory(actor.getInventory().get(i));
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
     * @param actor the actor whose intrinsic weapon damage was increased
     */
    public void removeInstantKill(Actor actor) {
        IntrinsicWeapon instaKill = new IntrinsicWeapon(5, "punch");
    }

    /**
     * responsible for adding action to the action list in powerStar item attribute
     * @param action the action to be added
     */
    public void addPowerStarAction(Action action) {
        this.addAction(action);
    }

    /**
     * updates player status enum with capability selected
     * @param status chosen status, multipurpose method as any status can be updated
     */
    public void updateStatus(Status status) {
        this.addCapability(status);
    }


    //this method doesn't check for consumption bc it doesn't matter, the timer counts on the ground and in
    //inventory too

    //defo check this method bc not sure if it should be put in tick method!!!

    /**
     *
     * @param actor the actor who has an active powerstar booster
     */
    public void checkPowerStar(Actor actor) {
        if (this.turns == 10) {
            updateStatus(Status.HOSTILE_TO_ENEMY);
            removeInstantKill(actor);
        }
    }


    /**
     * this method is responsible for adding the consume action to the item actionList of allowable actions.
     * only consume action is needed in class as Toad actor should handle purchase action list?
     * @param actor the actor that is in proximity and prompted to consume item
     */
    public void addPowerStarAction(Actor actor) {
        if (actor.getInventory().toString().equals("PowerStar")) {
            this.addAction(new ConsumeAction(this));
        }
    }

}
