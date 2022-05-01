package game.enemy;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actors.Status;

import game.reset.Resettable;

public abstract class Enemy extends Actor implements Resettable {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.ENEMY);
    }

    public Actor startFollowFromExit(GameMap map){
        if(this.hasCapability(Status.ENGAGED)){
            Location here = map.locationOf(this);
            for(Exit exit : here.getExits()){
                if(exit.getDestination().containsAnActor()){
                    Actor attacker = exit.getDestination().getActor();
                    if(attacker.hasCapability(Status.HOSTILE_TO_ENEMY)){
                        return attacker;
                    }
                }
            }
        }

        return null;
    }


    @Override
    public void resetInstance() {
        this.hurt(getMaxHp());
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
