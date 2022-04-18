package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem  {

    public static final int PRICE = 200;

    public Wrench() {
        super("Wrench", '%', 50, "Wrench Attack!", 80);
    }

    public int getPrice(){return Wrench.PRICE;}

    public void addWrenchAction(Action action){
        this.addAction(action);
    }
}
