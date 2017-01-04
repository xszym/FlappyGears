package pl.xszym.flappygears;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import pl.xszym.flappygears.screens.MenuScreen;

public class FlappeGears extends Game {

	public static final int WIDTH = 540;
	public static final int HEIGHT = 960;
	public static final String TITLE = "Flappy Steampunk FRC";
	public static final boolean setDebug = false;

	SpriteBatch batch;
	Texture img;

	private boolean paused;

	public static Texture WALL_GEAR_PNG_TEKSTURA;
	public static Texture TUBE_PNG_TEKSTURA;
	public static ArrayList<Integer> numberOfGame;
	public static HashMap<String, Integer> BESTPLAYERS;
	public static Image bg;
	public static LabelStyle labelStyle;
	public static FreeTypeFontGenerator generator;
	public static FreeTypeFontParameter parameter;

	@Override
	public void create() {
		WALL_GEAR_PNG_TEKSTURA = new Texture("wallgear.png");
		TUBE_PNG_TEKSTURA = new Texture("gears.png");
		BESTPLAYERS = new HashMap<String, Integer>();
		numberOfGame = new ArrayList<Integer>();

		initLabelStyle();
		
		initBG();

		this.setScreen(new MenuScreen(this));
	}

	private void initLabelStyle() {
		labelStyle = new LabelStyle();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/HARNGTON.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		BitmapFont steamPunkFont = generator.generateFont(parameter);
		parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
		labelStyle.font = steamPunkFont;
		generator.dispose();		
	}

	public void initBG() {
		bg = new Image(new Texture("bg.jpg"));
		FlappeGears.bg.setX(0);
		FlappeGears.bg.setY(0);
		FlappeGears.bg.setHeight(FlappeGears.HEIGHT);
		FlappeGears.bg.setWidth(FlappeGears.WIDTH);

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
