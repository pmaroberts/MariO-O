package game.magical_Items.magic_water;

import edu.monash.fit2099.engine.items.Item;

import java.util.Stack;

public class Bottle extends Item {

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
}
