package game.ground;

import edu.monash.fit2099.engine.positions.Location;

public class PipesManager {

    private static PipesManager instance;

    private static Location warpTo;

    public static PipesManager getInstance(){
        if (instance == null) {
            instance = new PipesManager();
        }
        return instance;
    }

    public Location getWarpTo(){
        return PipesManager.warpTo;
    }

    public void setWarpTo(Location location){
        PipesManager.warpTo = location;
    }

}
