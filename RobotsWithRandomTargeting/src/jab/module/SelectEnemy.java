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
		double maxDistance = 0;
		BotInfo selected = null;
		while (iterator.hasNext()) {
			BotInfo botInfo = iterator.next();
			if ((!botInfo.teammate) && maxDistance < botInfo.distance) {
				selected = botInfo;
				maxDistance = botInfo.distance;
			}
		}
		bot.enemy = selected;
	}

}
