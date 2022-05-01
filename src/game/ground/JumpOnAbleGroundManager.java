package game.ground;

import java.util.ArrayList;

public class JumpOnAbleGroundManager {
    private ArrayList<JumpOnAble> jumpOnAbles;

    private static JumpOnAbleGroundManager instance;

    private JumpOnAbleGroundManager() {jumpOnAbles = new ArrayList<>();}

    public static JumpOnAbleGroundManager getInstance(){
        if (instance == null) {
            instance = new JumpOnAbleGroundManager();
        }
        return instance;
    }

    public void appendJumpOnAbleGround(JumpOnAble ground){this.jumpOnAbles.add(ground);}

    public ArrayList<JumpOnAble> getJumpOnAbles(){
        return new ArrayList<>(this.jumpOnAbles);
    }
}
