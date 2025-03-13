package jab.module;

import java.util.Iterator;
import jab.module.BotInfo;

/**
 * Select enemy
 * 
 * @author jabier.martinez
 */
public class SelectEnemy extends Part {

	public Module bot;

	public SelectEnemy(Module bot) {
		this.bot = bot;
	}

	public void select() {
		Iterator<BotInfo> iterator = bot.botsInfo.values().iterator();
		double minSpeed = Double.MAX_VALUE;
		BotInfo selected = null;
		while (iterator.hasNext()) {
			BotInfo botInfo = iterator.next();
			if ((!botInfo.teammate) && minSpeed < botInfo.velocity) {
				selected = botInfo;
				minSpeed = botInfo.velocity;
			}
		}
		bot.enemy = selected;
	}

}
