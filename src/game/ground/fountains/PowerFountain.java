package game.ground.fountains;

import game.magical_Items.magic_water.PowerWater;

public class PowerFountain extends Fountain{

    public PowerFountain(){
        super('P', new PowerWater());
    }
}
