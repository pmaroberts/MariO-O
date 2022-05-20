package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpeakAction;

import java.util.Random;

public class Peach extends Actor implements Speakable{

    private final String[] dialogue = {"You might need a wrench to smash Koopa's hard shells.",
            "You better get back to finding the Power Stars.",
            "The Princess is depending on you! You are our only hope.",
            "Being imprisoned in these walls can drive a fungus crazy :("
    };

    private boolean count = false;

    public Peach(){
        super("Peach", 'P', 600000);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(this.count){
            this.count = false;
            return new SpeakAction(this);
        }
        else{
            this.count = true;
            return new DoNothingAction();
        }
    }

    @Override
    public String speak(Actor actor) {
        Random r = new Random();
        return dialogue[r.nextInt(3)];
    }
}
