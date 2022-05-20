package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Speakable;
import game.actors.Status;

import java.util.Random;

/**
 * Action for speaking with the Toad
 * @author Tim Moniaga
 * @version Assignment 2
 */
public class SpeakAction extends Action {
    private Speakable speakable;
    private Actor actor;


    public SpeakAction(Speakable speakable) {
        this.speakable = speakable;
    }
    public SpeakAction(Speakable speakable, Actor actor) {
        this.speakable = speakable;
        this.actor = actor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return this.speakable.speak(this.actor);
    }


    @Override
    public String menuDescription(Actor actor) {
        return "Speak with Toad"; //technically a cheat here but the only actor that the action will come up for is Toad
    }




}
