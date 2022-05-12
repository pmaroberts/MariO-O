package game.ground.fountains;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.FillAction;
import game.actors.Buyer;
import game.actors.Status;
import game.magical_Items.BuyerManager;
import game.magical_Items.magic_water.Water;

public abstract class Fountain extends Ground {
    private final Water water;

    public Fountain(char dispchar, Water water){
        super(dispchar);
        this.water = water;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (actor.hasCapability(Status.FLOOR_BANNED)) {
            actions.add(new ConsumeAction(this.water));
        }
        int check = BuyerManager.getInstance().buyers().indexOf(actor);
        if (check != -1) {
            Buyer buyer = BuyerManager.getInstance().buyers().get(check);
            actions.add(new FillAction(buyer.getBottle(), this.water));
        }
        return actions;
    }


}
