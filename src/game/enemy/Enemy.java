package game.enemy;

import edu.monash.fit2099.engine.actors.Actor;
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
