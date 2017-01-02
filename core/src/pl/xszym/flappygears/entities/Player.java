package pl.xszym.flappygears.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;

public class Player extends Image {

	private final static int WIDHT = 90;
	private final static int HEIGHT = 90;
	
	public Vector3 getVelocity() {
		return velocity;
	}

	private final static int STARTING_X = FlappeGears.WIDTH / 2 - WIDHT / 2;
	private final static int STARTING_Y = 50;
	
	private static final int GRAVITY = -10;
	private int WIND = 0;
	private Vector3 position;
	private Vector3 velocity;
	
	public boolean maxRight;

	public boolean maxLeft;
	
	private Rectangle boundsPlayer;
	
	public Player(){
		super(new Texture("player.png"));
		
		this.setOrigin(WIDHT / 2, HEIGHT / 2);
		this.setSize(WIDHT, HEIGHT);
	
		boundsPlayer = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight() - 30);
		
		this.setDebug(FlappeGears.setDebug);
		initVectors();
	}

	public Vector3 getPosition() {
		return position;
	}

	private void initVectors() {
		position = new Vector3(STARTING_X, STARTING_Y, 0);
		velocity = new Vector3(0, 0, 0);
		
	}
	
	public void updatePlayer(float delta) {
		
		this.setPosition(position.x, position.y);
		velocity.add(WIND, GRAVITY, 0);
		velocity.scl(delta);
		position.add(velocity.x, velocity.y, 50);
		if (position.y < 0) {
			position.y = 0;
		} 
		
		if (position.x < 0){
			position.x = 0;
			maxLeft = true;
		} else {
			maxLeft = false;
		}
		if (position.x > FlappeGears.WIDTH - WIDHT){
			position.x = FlappeGears.WIDTH - WIDHT;
			maxRight = true;
		} else {
			maxRight = false;
		}
		velocity.scl(1 / delta);
		
		boundsPlayer.setPosition(position.x, position.y);
	}
	
	public void fly(int x, int y) {
		velocity.x = x;
		velocity.y = y;

	}
	
	public Rectangle getBoundsPlayer(){
		return boundsPlayer;
	}

}
	

