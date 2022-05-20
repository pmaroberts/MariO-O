package game.actors.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.SpeakAction;
import game.actors.Speakable;

import java.util.Random;

/**
 * Action for consuming items
 * @author Sara Hopkins, Peter Roberts
 * @version Assignment 3
 */

public class Bowser extends Enemy implements Speakable {

    //string array of speak string options
    private final String[] dialogue = {"What was that sound? Oh, just a fire.",
            "Princess Peach! You are formally invited... to the creation of my new kingdom!",
            "Never gonna let you down!",
            "Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!"
    };

    //bool used for counting every second turn for speak action
    private boolean count = false;

    /**
     * Constructor for Bowser
     */
    public Bowser() {
        super("Bowser", 'B', 500);
    }

    /**
     * The Bowser's playturn method, overwritten from actor
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the action for Bowser to take
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if(this.count){ //place all bowser play turn stuff inside this if else
            //this if is responsible for Bowser speaking every second turn
            this.count = false; //update bool
            return new SpeakAction(this); //speak
        }
        else{
            this.count = true; //update bool
            return new DoNothingAction();
        }
    }

    /**
     * method to pick random prompt for Bowser to speak each turn
     * @param actor default actor, included in interface for speakwithToad
     * @return the string spoken
     */
    @Override
    public String speak(Actor actor) {
        Random r = new Random();
        return dialogue[r.nextInt(4)];
    }

}
