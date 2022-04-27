package game.reset;

import com.sun.source.tree.Tree;
import game.actors.Player;
import game.enemy.Enemy;
import game.magical_Items.Coin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A global Singleton manager that does soft-reset on the instances.
 * TODO: you may modify (add or remove) methods in this class if you think they are not necessary.
 * HINT: refer to Bootcamp Week 5 about static factory method.
 * A3: Think about how will you improve this implementation in the future assessment.
 * What could be the drawbacks of this implementation?
 */
public class ResetManager {
    /**
     * A list of resettable instances (any classes that implements Resettable,
     * such as Player implements Resettable will be stored in here)
     */
    private List<Resettable> resettableList;

    /**
     * A singleton reset manager instance
     */
    private static ResetManager instance;

    /**
     * Get the singleton instance of reset manager
     * @return ResetManager singleton instance
     */
    public static ResetManager getInstance(){
        if(instance == null){
            instance = new ResetManager();
        }
        return instance;
    }

    /**
     * Constructor
     */
    private ResetManager(){
        resettableList = new ArrayList<>();
    }

    /**
     * Reset the game by traversing through all the list
     * By doing this way, it will avoid using `instanceof` all over the place.
     */
    public void run(){
        for (int i = 0; i< resettableList.size(); i ++){
            if(resettableList.get(i) instanceof Tree){
                Random r = new Random();
                if(r.nextBoolean()){
                    //get location of the tree and if true set that location to dirt
                 //resettableList.get(i)
                }
            }
            else if(resettableList.get(i) instanceof Enemy){
                //kill enemy here
                //resettableList.get(i).
            }
            else if(resettableList.get(i) instanceof Player){
                //reset player status and HP
            }
            else if(resettableList.get(i) instanceof Coin){
                //remove coin from ground
            }

        }
    }

    /**
     * Add the Resettable instance to the list
     * FIXME: it does nothing, you need to implement it :)
     */
    public void appendResetInstance(Resettable reset){
    }


    /**
     * Remove a Resettable instance from the list
     * @param resettable resettable object
     * FIXME: it does nothing, you need to implement it :)
     */
    public void cleanUp(Resettable resettable){
    }
}
