package game.magical_Items;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;

public abstract class ConsumableItem extends Item {
    ConsumeAction consumeAction;

    public ConsumableItem(String name, char displayChar, boolean portable){
        super(name, displayChar, portable);
        consumeAction = new ConsumeAction(this);
        this.addAction(consumeAction);
    }

    public void toExecute(Actor actor, GameMap map){}

    public ConsumeAction getConsumeAction(){
        return consumeAction;
    }
}
