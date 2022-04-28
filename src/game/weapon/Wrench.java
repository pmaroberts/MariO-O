package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actors.Status;

public class Wrench extends WeaponItem  {

    public static final int PRICE = 200;

    /**
     * constructor for wrench weaponItem
     */
    public Wrench() {
        super("Wrench", '%', 50, "Wrench Attack!", 80);
        this.togglePortability();
    }

    /**
     * public getter for private class price int
     * @return private class instance attribute integer wrench purchase price
     */
    public int getPrice(){return Wrench.PRICE;}


    @Override
    public void tick(Location currentLocation, Actor actor) {
        actor.addCapability(Status.WRENCH);
    }



}
