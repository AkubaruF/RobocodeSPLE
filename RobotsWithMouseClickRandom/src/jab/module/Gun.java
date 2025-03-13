package jab.module;

import robocode.Bullet;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Gun
 * 
 * @author jab
 */
public class Gun extends Part {

	public Module bot;

	public Gun(Module bot) {
		this.bot = bot;
	}

	public void fire() {
		if (bot.bulletPower > 0 && bot.getGunHeat() == 0) {
			Bullet b = bot.setFireBullet(bot.bulletPower);
			bot.registerBullet(b);
		}
	}

	public void listenInput(InputEvent e) {
		if (e instanceof MouseEvent) {
			if (e.getID() == MouseEvent.MOUSE_PRESSED)
				bot.bulletPower = (Math.random() < 0.5) ? 1 : 3;
			else if (e.getID() == MouseEvent.MOUSE_RELEASED)
				bot.bulletPower = 0;
		}
	}

}
