package game.actors.enemy;

import game.actors.Status;

/**
 * Class for the Flying Koopa
 */
public class FlyingKoopa extends Koopa {

    /**
     * Constructor
     */
    public FlyingKoopa(){
        super("Flying Koopa", 'F', 1);
        this.addCapability(Status.FLY);
    }

}
