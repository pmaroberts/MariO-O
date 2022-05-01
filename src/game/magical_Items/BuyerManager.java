package game.magical_Items;

import game.actors.Buyer;
import java.util.ArrayList;

public class BuyerManager {
    private ArrayList<Buyer> buyers;

    private static BuyerManager instance;

    private BuyerManager() {
        buyers = new ArrayList<>();
    }

    public static BuyerManager getInstance() {
        if (instance == null) {
            instance = new BuyerManager();
        }
        return instance;
    }

    public void appendBuyer(Buyer buyer) {
        this.buyers.add(buyer);
    }

    public ArrayList<Buyer> buyers() {
        return new ArrayList<Buyer>(this.buyers);
    }
}
