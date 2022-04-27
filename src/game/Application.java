package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.actors.Toad;
import game.enemy.Goomba;
import game.ground.Dirt;
import game.ground.Floor;
import game.ground.Wall;
import game.magical_Items.PowerStar;
import game.magical_Items.SuperMushroom;
import game.ground.trees.Sprout;

import java.util.Random;

/**
 * The main class for the Mario World game.
 *
 */
public class Application {

	public static void main(String[] args) {

			World world = new World(new Display());

			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Sprout());

			List<String> map = Arrays.asList(
				"..........................................##..........+.........................",
				"............+............+..................#...................................",
				"............................................#...................................",
				".............................................##......................+..........",
				"...............................................#................................",
				"................................................#...............................",
				".................+................................#.............................",
				".................................................##.............................",
				"................................................##..............................",
				".........+..............................+#____####.................+............",
				".......................................+#_____###++.............................",
				".......................................+#______###..............................",
				"........................................+#_____###..............................",
				"........................+........................##.............+...............",
				"...................................................#............................",
				"....................................................#...........................",
				"...................+.................................#..........................",
				"......................................................#.........................",
				".......................................................##.......................");

			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			Actor mario = new Player("Player", 'm', 100);
			world.addPlayer(mario, gameMap.at(42, 10));

			Actor toad = new Toad();
			//world.addPlayer(toad, gameMap.at(42, 9)); //44 9

			Random rand = new Random();
			SuperMushroom superMushroom = new SuperMushroom(true);
			//gameMap.at(rand.nextInt(39), rand.nextInt(19)).addItem(superMushroom);
			gameMap.at(42, 9).addItem(superMushroom);

			PowerStar powerStar = new PowerStar(true);
			gameMap.at(rand.nextInt(39), rand.nextInt(19)).addItem(powerStar);
			gameMap.at(42, 10).addItem(powerStar);

			// FIXME: the Goomba should be generated from the Tree
			gameMap.at(35, 10).addActor(new Goomba());

			world.run();

	}
}
