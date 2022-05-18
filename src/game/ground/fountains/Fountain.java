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
    private int count;
    private int timer = 0;
    private boolean empty = false;

    public Fountain(char dispchar, Water water){
        super(dispchar);
        this.water = water;
        this.count = 10;
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (this.count>0){
            if (location.containsAnActor()){
                if(!this.empty){
                    if (actor.hasCapability(Status.FLOOR_BANNED)) {
                        actions.add(new ConsumeAction(this.water));
                    }
                }

                int check = BuyerManager.getInstance().buyers().indexOf(actor);
                if (check != -1) {
                    Buyer buyer = BuyerManager.getInstance().buyers().get(check);
                    if(!this.empty){
                        actions.add(new FillAction(buyer.getBottle(), this.water, this));
                    }

                }
            }
        }
        return actions;
    }

    @Override
    public void tick(Location location) {
        if (count == 0){
            this.empty = true;
        }
        if (this.empty){
            if (timer == 5){
                timer = 0;
                this.empty = false;
            }
            else{
                this.refillFountain();
            }
        }
    }

    public int getCount() {
        return this.count;
    }

    public void fillBottleFromFountain(){
        this.count = this.count - 5; //takes 3 water to fill a bottle
    }

    public void refillFountain(){

        if((count + 3) > 10) {
            count = 10;
        }
        else{
            count = count + 2;
        }
        timer++;
    }
}


