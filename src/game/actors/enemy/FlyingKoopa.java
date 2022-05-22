package game.actors.enemy;

import game.actors.Status;

/**
 * Flying Koopa Class
 * @author Peter Roberts
 * @author Sara Hopkins
 * @version Assignment 3
 */
public class FlyingKoopa extends Koopa {
    /**
     * array of strings that FlyingKoopa can speak
     */
    private final String[] dialogue = {"Never gonna make you cry!",
            "Koopi koopi koopii~!",
            "Pam pam pam!"
    };

    private final int bound = 3;

    /**
     * Constructor
     */
    public FlyingKoopa(){
        super("Flying Koopa", 'F', 1);
        this.addCapability(Status.FLY);
    }

}
