package game.ground.fountains;

import game.magical_Items.magic_water.HealthWater;

public class HealthFountain extends Fountain{

    public HealthFountain(){
        super('H', new HealthWater());
    }


}
