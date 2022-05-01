package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actors.Status;

import java.util.Random;

public class SpeakWithToadAction extends Action {

    private Actor otherActor;

    public SpeakWithToadAction(Actor otherActor) {
        this.otherActor = otherActor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        String retVal;

        String[] dialogue = {"You might need a wrench to smash Koopa's hard shells.",
                "You better get back to finding the Power Stars.",
                "The Princess is depending on you! You are our only hope.",
                "Being imprisoned in these walls can drive a fungus crazy :("
        };

        Random r = new Random();
        int n;
        if(actor.hasCapability(Status.WRENCH)){
            n = getRandomWithExclusion(r, 0, 3,0);
        }
        else if(actor.hasCapability(Status.POWERSTAR)){
            n = getRandomWithExclusion(r, 0, 3,1);
        }
        else{
            n = r.nextInt(4);
        }

        retVal = dialogue[n];

        return "Toad: " + retVal;
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Speak with toad";
    }


    /**
     * @param rnd Random object
     * @param start minimum possible value inclusive
     * @param end highest possible value inclusive
     * @param exclude number/s to exclude
     * @return random integer
     */
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
