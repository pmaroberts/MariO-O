package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.items.PickUpItemAction;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.actions.ConsumeAction;
import game.magical_Items.Coin;
import game.magical_Items.PurchasableItem;
import game.magical_Items.SuperMushroom;
import game.weapon.Wrench;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements Buyer{

	private final Menu menu = new Menu();
	private int wallet = 0;

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		SuperMushroom superMushroom = new SuperMushroom(true);
		for (Item item : this.getInventory()){
			if (item.getAllowableActions().contains(new PickUpItemAction(item))){

			}
			//okay so i want to check if the item is in the inventory of the player
			//and if it is, i want to add the consume action, but i also want to add the
			//capability to say that the item is in the inventory

			//if the item in the inventory has been picked up, then it should be added to the capability list


		}

		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();


		// return/print the console menu
		display.println("BALANCE: " + this.getWalletBalance());
		display.println("HP: " + this.printHp());
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}


	public int getWalletBalance(){return this.wallet;}

	public void addMoney(Coin coin){
		this.wallet = this.wallet + coin.getValue();
	}

	public void editBalance(int amount){
		this.wallet = this.wallet + amount;
	}

	@Override
	public void addItemToInventoryBuyer(Item item) {
		this.addItemToInventory(item);
	}

	@Override
	public void addCapability(Enum<?> capability) {
		super.addCapability(capability);
	}
}
