package game.magical_Items.magic_water;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.magical_Items.ConsumableItem;

import java.util.Iterator;
import java.util.Stack;

public class Bottle extends ConsumableItem {

    private Stack<Water> stack;

    public Bottle(){
        super("Bottle", 'B', false);
        stack = new Stack<>();
    }

    public void addToBottle(Water water){
        this.stack.push(water);
    }

    public Water removeFromBottle(){
        return this.stack.pop();
    }

    @Override
    public void toExecute(Actor actor, GameMap map){
        Water water = removeFromBottle();
        water.toExecute(actor, map);
    }

    @Override
    public String toString() {
        Iterator<Water> iterator = stack.iterator();
        String str = "[ ";
        int count = 0;
        while(iterator.hasNext()){
            Water water = iterator.next();
            if (count == 0){
                str += water.toString();
                count += 1;
            }
            else{
                str += ", ";
                str += water.toString();
            }
        }
        str += " ]";
        return "Bottle " + str;
    }


}
