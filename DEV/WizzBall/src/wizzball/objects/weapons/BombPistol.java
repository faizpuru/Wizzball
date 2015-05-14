/**
 * TUT _ Tampere
 * TIE-21106_Software_Engineering_Methodology
 * Group 6
 */
package wizzball.objects.weapons;

import wizzball.game.Wizzball;
import wizzball.objects.basics.BasicObject;
import wizzball.objects.enemies.BasicEnemy;

/**
 * 
 *
 */
public class BombPistol extends BasicWeapon {

	/**
	 * @param p
	 * @param xpos
	 * @param ypos
	 * @param height
	 * @param width
	 * @param down
	 */

	public float sizeBullet = 0;

	public BombPistol(Wizzball p, float xpos, float ypos, float height, float width, boolean down) {
		super(p, xpos, ypos, height, width, down);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.weapons.BasicWeapon#activateWeapon()
	 */
	@Override
	public void activateWeapon() {
		sizeBullet = parent.sp1.radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.weapons.BasicWeapon#weaponAnimation()
	 */
	@Override
	public void weaponAnimation() {

		if (isShooting()) {
			if (sizeBullet >= 40) {
				sizeBullet = 0;
				return;
			}
			parent.pushMatrix();
			parent.pushStyle();
			parent.translate(parent.width / 2, parent.ypos);
			parent.fill(0, 0, 0, 0);
			parent.stroke(200, 20, 20);
			parent.ellipse(0, 0, sizeBullet, sizeBullet);
			sizeBullet += 2;
			parent.popStyle();
			parent.popMatrix();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.weapons.BasicWeapon#isShooting()
	 */
	@Override
	public boolean isShooting() {
		return sizeBullet != 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.weapons.BasicWeapon#weaponEffect()
	 */
	@Override
	protected void weaponEffect() {

		for (BasicObject o : parent.lvl.objects) {
			if (o instanceof BasicEnemy) {
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.basics.BasicObject#loadImage()
	 */
	@Override
	public void loadImage() {
		image = parent.lasergun;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see wizzball.objects.weapons.BasicWeapon#getTimeBetweenTwoShoot()
	 */
	@Override
	protected int getTimeBetweenTwoShoot() {
		return 1500;
	}

}