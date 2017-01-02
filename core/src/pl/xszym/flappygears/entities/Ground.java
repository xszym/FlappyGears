package pl.xszym.flappygears.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.screens.PlayScreen;


public class Ground extends Image {

	public final static int GROUND_WIDHT = FlappeGears.WIDTH;
	public final static int GROUND_HEIGHT = 54;

	private final static int STARTING_X = 0;
	private final static int STARTING_Y = PlayScreen.PLAYER_UP;

	private Rectangle boundsGround;

	public Ground() {
		super(new Texture("spikes.png"));

		this.setOrigin(GROUND_WIDHT / 2, GROUND_HEIGHT / 2);
		this.setSize(GROUND_WIDHT, GROUND_HEIGHT);

		boundsGround = new Rectangle(this.getX(), this.getY(), GROUND_WIDHT, GROUND_HEIGHT);

		this.setPosition(STARTING_X, -STARTING_Y);
		this.setDebug(FlappeGears.setDebug);

	}

	public void update() {
		boundsGround.setPosition(this.getX(), this.getY());
	}

	public void setPosition2(Player player) {

		if (player.getVelocity().y > 0) {

			float y = player.getY();
			
			if (this.getY() < y - STARTING_Y) {

				this.setPosition(0, y - STARTING_Y);

			}

		}

	}

	public Rectangle getBoundsGround() {
		return boundsGround;
	}

	public boolean collides(Rectangle player) {
		return player.overlaps(boundsGround);

	}

}
