package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;

import java.util.Random;

public class Toad extends Actor {

    public Toad() {
        super("Toad", 'T', 999999999);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        actions.add(new DoNothingAction());
        return actions;
    }

    public String speakWithToad(){
        String retVal;

        //World.player

        String[] dialogue = {"You might need a wrench to smash Koopa's hard shells.",
                "You better get back to finding the Power Stars.",
                "The Princess is depending on you! You are our only hope.",
                "Being imprisoned in these walls can drive a fungus crazy :("
        };
        Random r = new Random();
        int n;
        //check player status and items
        //TODO: if player is holing a wrench
        if(true){
            n = getRandomWithExclusion(r, 0, 3,0);
        }
        //TODO:if player has super star active
        else if(true){
            n = getRandomWithExclusion(r, 0, 3,1);
        }
        else{
            n = r.nextInt(4);
        }

        retVal = dialogue[n];

        return retVal;
    }

    public int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

}


