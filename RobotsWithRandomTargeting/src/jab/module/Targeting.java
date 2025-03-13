package jab.module;

import java.util.Random;
import robocode.util.Utils;
import jab.module.Module;
import jab.module.Targeting;

/**
 * Targeting
 * 
 * @author jabier.martinez
 */
public class Targeting extends Part {

	public Module bot;

	public Targeting(Module bot) {
		this.bot = bot;
	}

	public void target() {
		if (bot.enemy != null) {
			Random rand = new Random();

			double myX = bot.getX();
			double myY = bot.getY();
			double enemyX = bot.enemy.x;
			double enemyY = bot.enemy.y;

			double randRadiusX = ((2 * rand.nextDouble()) - 1) * 18;
			double randRadiusY = ((2 * rand.nextDouble()) - 1) * 18;

			double theta = Utils
					.normalAbsoluteAngle(Math.atan2(enemyX - myX + randRadiusX, enemyY - myY + randRadiusY));
			bot.setTurnGunRightRadians(Utils.normalRelativeAngle(theta - bot.getGunHeadingRadians()));
		}
	}

}
