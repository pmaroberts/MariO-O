package game.ground.fountains;

import game.magical_Items.magic_water.PowerWater;

/**
 * Child Class for PowerFountain Ground Type
 * @author Sara Hopkins
 * @version Assignment 3
 */
public class PowerFountain extends Fountain{

    /**
     * constructor for PowerFountain
     */
    public PowerFountain(){
        super('P', new PowerWater());
    }
}
