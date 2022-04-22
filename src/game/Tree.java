package game;

import edu.monash.fit2099.engine.positions.Ground;

public abstract class Tree extends Ground {

    protected int age;

    public Tree(char displayChar) {
        super(displayChar);
        this.age = 0;
    }

    public void incrementAge(){
        this.age++;
    }


}
