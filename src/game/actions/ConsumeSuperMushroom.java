package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.SuperMushroom;

public class ConsumeSuperMushroom extends ConsumeAction{
    SuperMushroom superMushroom;

    public ConsumeSuperMushroom(SuperMushroom superMushroom){
        super(superMushroom);
        this.superMushroom = superMushroom;
    }

    @Override
    public String execute(Actor actor, GameMap map ){
        actor.removeItemFromInventory(this.superMushroom);
        this.superMushroom.increaseHPSuperMushroom(actor);
        this.superMushroom.updatePlayerDisplayCharacter(actor);
        this.superMushroom.removeActionSuperMushroom(superMushroom.getSuperMushroomConsume());
        return menuDescription(actor);

        }
    }

