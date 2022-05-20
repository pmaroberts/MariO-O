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

public class Bowser extends Enemy implements Speakable {

    private final String[] dialogue = {"What was that sound? Oh, just a fire.",
            "Princess Peach! You are formally invited... to the creation of my new kingdom!",
            "Never gonna let you down!",
            "Wrrrrrrrrrrrrrrrryyyyyyyyyyyyyy!!!!"
    };

    private boolean count = false;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Bowser(String name, char displayChar, int hitPoints) {
        super("Bowser", 'B', 500);
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
        return dialogue[r.nextInt(4)];
    }

}
