package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class PowerStar extends Item {
    public static final int price = 600;
    private int turns;

    /**
     * this is the constructor for powerStar item, it will be instantiated as a weapon item, therefore will have access to all
     * item and weaponItem methods. When created will be made as a Weapon and when the player collects or purchases the powerStar,
     * then it will be added to inventory for 10 turns. I.e., the player will have instant kill for 10 turns
     * the damage is set as an arbitrarily high number to ensure that any implemented enemy will be killed by the player while
     * the powerStar booster is active
     */
    PowerStar(boolean portable){
        super("PowerStarInstantKill", '*', portable);
        turns = 0;
    }

    /**
     * this is responsible for increasing the player HP by 200
     * @param actor the player who has used the powerStar
     */
    public void healPlayer(Actor actor){
        actor.heal(200);
    }

    @Override
    public void tick(Location location, GameMap map, Actor actor){
        turns++;
        if(turns == 10){
            map.locationOf(actor).removeItem(this); // shouldnt need to be an actor.
        }else if (turns <= 10){
            return "PowerStar ( " + (10 - turns) + " turns left )";
        }
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        actor.addItemToInventory(item);
        return menuDescription(actor);
    }

    public WeaponItem addInstantKill(Actor actor){
        WeaponItem weaponItem = new WeaponItem('PowerStarInstantKill', '~', 999999, "PowerStar InstantKill", 100);
        actor.addItemToInventory(weaponItem);
        return weaponItem;
    }

    public void removeInstantKill(Actor actor, WeaponItem weaponItem){
        actor.removeItemFromInventory(weaponItem);
    }

}



/*
Power Star * cannot stay in the game forever. It will fade away and be removed from the game within 10 turns
(regardless it is on the ground or in the actor's inventory). Anyone that consumes a Power Star will be healed by 200 hit points and will become invincible.
The invincible effect replaces fading duration (aka, fading turn's ticker stops). Here, the invincible effect lasts for 10 turns.

Higher Grounds. The actor does not need to jump to higher level ground (can walk normally).
If the actor steps on high ground, it will automatically destroy (convert) ground to Dirt.

Convert to coin. For every destroyed ground, it drops a Coin ($5).

Immunity. All enemy attacks become useless (0 damage).

Attacking enemies. When active, a successful attack will instantly kill enemies.
 */