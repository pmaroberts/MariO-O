package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpeakAction;

import java.util.Random;

/**
 * Peach Actor
 * @author Peter Roberts, Sara Hopkins
 * @version Assignment 3
 */
public class Peach extends Actor implements Speakable{
    /**
     * array of string speak prompts for peach
     */
    private final String[] dialogue = {"Dear Mario, I'll be waiting for you...",
            "Never gonna give you up!",
            "Release me, or I will kick you!"
    };

    /**
     * boolean to count every second turn to speak
     */
    private boolean count = false;

    /**
     * Constructor for Peach Actor
     */
    public Peach(){
        super("Peach", 'P', 600000);
    }

    /**
     * Peach play turn
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action peach takes
     */
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

    /**
     * method to pick random prompt for Bowser to speak each turn
     * @param actor default actor, included in interface for speak with Toad
     * @return the string spoken
     */
    @Override
    public String speak(Actor actor) {
        Random r = new Random();
        return dialogue[r.nextInt(3)];
    }

}
