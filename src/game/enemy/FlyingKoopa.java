package game.enemy;

import game.actors.Status;

public class FlyingKoopa extends Koopa{

    public FlyingKoopa(){
        super("Flying Koopa", 'F', 1);
        this.addCapability(Status.FLY);
    }

}
