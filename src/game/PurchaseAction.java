package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class PurchaseAction extends Action {

    private final Item item;
    private final Player player;

    /**
     * constructor for purchase action, trading action class extended from Action abstract class
     * @param item the assigned item instance the player wants to purchase
     * @param player the player who is purchasing items from toad
     */
    PurchaseAction(Item item, Player player){
        this.item = item;
        this.player = player;
    }

    /**
     * overriding the execute method from the Action class as ut us n=necessary for any extension of an abstract class
     * checks what item instance has been assigned throught the .toString method
     * i.e., comparing item string names.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a staement either indicating success or failure of purchase.
     * @see Action class - for execute method
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        if (item.toString().equals("SuperMushroom")){
            SuperMushroom superMushroom = new SuperMushroom(true);
            if(player.getWalletBalance() >= superMushroom.getPrice()){
                player.editBalance(-superMushroom.getPrice());
                return superMushroom.toString() + " successfully purchased! Money remaining: $" + player.getWalletBalance();
            }
            else{
                return "Not Enough Money In Wallet For Purchase!";
            }
        }
        else if(item.toString().equals("PowerStar")){
            PowerStar powerStar = new PowerStar(true);
            if(player.getWalletBalance() >= powerStar.getPrice()){
                player.editBalance(-powerStar.getPrice());
                return powerStar.toString() + " successfully purchased! Money remaining: $" + player.getWalletBalance();
            }
            else{
                return "Not Enough Money In Wallet For Purchase!";
            }


        }
        else if(item.toString().equals("Wrench")){
            Wrench wrench = new Wrench();
            if(player.getWalletBalance() >= wrench.getPrice()){
                player.editBalance(-wrench.getPrice());
                return wrench.toString() + " successfully purchased! Money remaining: $" + player.getWalletBalance();
            }
            else{
                return "Not Enough Money In Wallet For Purchase!";
            }
        }
        return "error item not entered correct- debugging statement, check purchase class, line :52";
    }


    /**
     * overriding method menu description which is responsible for creating a string about the actors action
     * @param actor The actor performing the action.
     * @return a string about the action preformed.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + item ;
    }
}
