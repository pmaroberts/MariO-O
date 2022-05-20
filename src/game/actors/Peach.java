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

    private final String[] dialogue = {"Dear Mario, I'll be waiting for you...",
            "Never gonna give you up!",
            "Release me, or I will kick you!"
    };

    private boolean count = false;

    public Peach(){
        super("Peach", 'P', 600000);
        this.addCapability(Status.POWERSTAR); // to allow peach to not be attacked
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
