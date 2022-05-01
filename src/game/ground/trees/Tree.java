package game.ground.trees;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Utils;
import game.actions.JumpAction;
import game.actors.Status;
import game.ground.JumpOnAble;
import game.ground.JumpOnAbleGroundManager;
import game.reset.Resettable;



public abstract class Tree extends Ground implements JumpOnAble, Resettable {

    private final double RESET_ODDS = 0.5;


    protected int age;
    public Tree(char displayChar) {
        super(displayChar);
        this.age = 0;
        this.addInstance();//All trees can be jumped on
        this.registerInstance();
    }

    public void incrementAge(){
        this.age++;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.POWERSTAR);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions =  new ActionList();
        if(!location.containsAnActor() && !actor.hasCapability(Status.POWERSTAR)){
            actions.add(new JumpAction(location, direction));
        }
        return actions;
    }

    @Override
    public void resetInstance(){
        if(Utils.probReturn(RESET_ODDS))
        {
            this.addCapability(Status.RESET);

        }
    }

}
