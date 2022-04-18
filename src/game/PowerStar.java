package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class PowerStar extends Item {
    public static final int price = 600;
    private int turns;

    /**
     * when the player collects or purchases the powerStar,then it will be added to inventory for 10 turns.
     * I.e., the player will have instant kill for 10 turns, the damage is set as an arbitrarily high number to ensure
     * that any implemented enemy will be killed by the player while the powerStar booster is active
     */
    PowerStar(boolean portable){
        super("PowerStarInstantKill", '*', portable);
        turns = 0;
    }

    public int getPrice(){return PowerStar.price;}

    public int getTurns(){return this.turns;}

    /**
     * this is responsible for increasing the player HP by 200
     * @param actor the player who has used the powerStar
     */
    public void healPlayer(Actor actor){
        actor.heal(200);
    }

    @Override
    public void tick(Location location){
        this.turns++;
        if(this.turns == 10){
            location.removeItem(this);
        }
    }

    public void tick(Location location, Actor actor){
        for (int i = 0; i < actor.getInventory().size(); i++){
            if(actor.getInventory().get(i).toString().equals("PowerStar")){
                this.turns++;
                if(this.turns == 10){
                    actor.removeItemFromInventory(actor.getInventory().get(i));
                }
            }
        }
    }

    public String pickUp(PowerStar powerStar, Actor actor, GameMap gameMap) {
        PickUpItemAction pickUpItemAction = new PickUpItemAction(powerStar);
        return pickUpItemAction.execute(actor, gameMap);
    }


    public void instantKill(){
        IntrinsicWeapon instaKill = new IntrinsicWeapon(999999, "POWERSTAR_INSTAKILL");
    }
    

    public void removeInstantKill(Actor actor){
        IntrinsicWeapon instaKill = new IntrinsicWeapon(5, "punch");
    }

    public void addPowerStarAction(Action action){
        this.addAction(action);
    }

    public void updateStatus(Actor actor, Status status){
        actor.addCapability(status);
    }


    //this method doesn't check for consumption bc it doesn't matter, the timer counts on the ground and in
    //inventory too
    public void checkPowerStar(Actor actor){
        if (this.turns == 10){
            updateStatus(actor, Status.HOSTILE_TO_ENEMY);
            removeInstantKill(actor);
        }
    }


}



/*

Higher Grounds. The actor does not need to jump to higher level ground (can walk normally).
If the actor steps on high ground, it will automatically destroy (convert) ground to Dirt.

Convert to coin. For every destroyed ground, it drops a Coin ($5).

Immunity. All enemy attacks become useless (0 damage).

Attacking enemies. When active, a successful attack will instantly kill enemies.
 */