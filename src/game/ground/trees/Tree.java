package game.ground.trees;

import edu.monash.fit2099.engine.positions.Ground;
import game.reset.Resettable;

abstract class Tree extends Ground implements Resettable {

    /**
     * Constructor.
     *
     */
    public Tree() {
        super('+');
        this.registerInstance();
    }

    @Override
    public void registerInstance() {
        Resettable.super.registerInstance();
    }
}
