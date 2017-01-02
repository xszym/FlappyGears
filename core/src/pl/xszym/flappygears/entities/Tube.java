package pl.xszym.flappygears.entities;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;

public class Tube extends Image {
	public final static int TUBE_WIDHT = 200;
	public final static int TUBE_HEIGHT = 142;



	private static final int FLUCTUATION = FlappeGears.WIDTH - TUBE_WIDHT;
	private static final int GEARS_GAP = 100;
	private static final int LOWEST_OPENING = 00;

	private Random rand;

	private Rectangle boundsGear;

	public Tube(float y) {
		super(FlappeGears.TUBE_PNG_TEKSTURA);

		this.setOrigin(TUBE_WIDHT / 2, TUBE_HEIGHT / 2);
		this.setSize(TUBE_WIDHT, TUBE_HEIGHT);
		rand = new Random();

		this.setPosition(rand.nextInt(FLUCTUATION), y);

		boundsGear = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());

		this.setDebug(FlappeGears.setDebug);
	}

	public void reposition(float y) {

		this.setPosition(rand.nextInt(FLUCTUATION), y);
		boundsGear.setPosition(this.getX(), this.getY());

	}

	public boolean collides(Rectangle player) {
		return player.overlaps(boundsGear);
	}

}
