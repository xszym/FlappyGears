package pl.xszym.flappygears.entities;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;

public class WallGear extends Image {
	public final static int WALLGEAR_WIDHT = 50;
	public final static int WALLGEAR_HEIGHT = 50;

	private Rectangle boundsGear;

	public WallGear(float x, float y) {
		super(FlappeGears.WALL_GEAR_PNG_TEKSTURA);

		this.setOrigin(WALLGEAR_WIDHT / 2, WALLGEAR_HEIGHT / 2);
		this.setSize(WALLGEAR_WIDHT, WALLGEAR_HEIGHT);

		boundsGear = new Rectangle(this.getX(), this.getY(), WALLGEAR_WIDHT, WALLGEAR_HEIGHT);

		this.setPosition(x, y);
		this.setDebug(FlappeGears.setDebug);

	}

	public void reposition(float x, float y) {

		this.setPosition(x, y);
		boundsGear.setPosition(this.getX(), this.getY());

	}

	public boolean collides(Rectangle player) {
		return player.overlaps(boundsGear);
	}
}
