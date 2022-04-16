package game;

import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Wrench extends WeaponItem  {

    private int price = 200;

    public Wrench() {
        super("Wrench", '%', 50, "Wrench Attack!", 80);
    }

    public int getPrice(){return this.price;}
}
