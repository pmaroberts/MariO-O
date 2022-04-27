package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;
import game.magical_Items.PowerStar;

public class ConsumePowerStar extends ConsumeAction{
    PowerStar powerStar;

        public ConsumePowerStar(PowerStar powerStar){
            super(powerStar);
            this.powerStar = powerStar;
        }

        @Override
        public String execute(Actor actor, GameMap map ){
            actor.removeItemFromInventory(this.powerStar);
            this.powerStar.healPlayer(actor);
            this.powerStar.updateStatus(Status.POWERSTAR);
            this.powerStar.removeActionPowerStar(powerStar.getPowerStarConsume());
            return menuDescription(actor);

        }
    }

