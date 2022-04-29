package game.actors;

import game.magical_Items.Coin;

public interface Buyer {

    int getWalletBalance();

    void addMoney(Coin coin);

    void editBalance(int amount);
}
