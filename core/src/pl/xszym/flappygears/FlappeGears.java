package pl.xszym.flappygears;

import java.util.HashMap;
import java.util.TreeSet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pl.xszym.flappygears.screens.MenuScreen;

public class FlappeGears extends Game {

	public static final int WIDTH = 540;
	public static final int HEIGHT = 960;
	public static final String TITLE = "Flappy Steampunk FRC";
	public static final boolean setDebug = true;

	SpriteBatch batch;
	Texture img;

	private boolean paused;

	public static Texture WALL_GEAR_PNG_TEKSTURA;
	public static Texture TUBE_PNG_TEKSTURA;
	public static HashMap BESTPLAYERS; 

	@Override
	public void create() {
		this.setScreen(new MenuScreen(this));
		WALL_GEAR_PNG_TEKSTURA = new Texture("wallgear.png");
		TUBE_PNG_TEKSTURA = new Texture("gears.png");
		BESTPLAYERS = new HashMap<String, Integer>();
	}

	//
	// getters and setters
	//
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

}
