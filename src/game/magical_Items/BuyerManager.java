package game.magical_Items;

import game.actors.Buyer;
import org.w3c.dom.html.HTMLAreaElement;

import java.util.ArrayList;
import java.util.HashMap;

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
