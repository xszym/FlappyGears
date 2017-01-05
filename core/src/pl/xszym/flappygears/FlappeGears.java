package pl.xszym.flappygears;

import java.util.LinkedHashMap;

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
import pl.xszym.flappygears.service.SaveScoresToFile;

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
	public static LinkedHashMap<String, Integer> BESTPLAYERS;
	public static Image bg;
	public static LabelStyle labelStyle40;
	public static LabelStyle labelStyle20;
	public static FreeTypeFontGenerator generator;
	public static FreeTypeFontParameter parameter;

	@Override
	public void create() {

		initTexture();
		initScoreToFile();
		initLabelStyle20();
		initLabelStyle40();
		initBG();

		this.setScreen(new MenuScreen(this));
	}

	private void initScoreToFile() {
		SaveScoresToFile saveScoresToFile = new SaveScoresToFile();

		if (saveScoresToFile.load() == null) {
			BESTPLAYERS = new LinkedHashMap<String, Integer>();
			BESTPLAYERS.put("Pierwszy gracz", 0);
		} else {
			BESTPLAYERS = saveScoresToFile.load();
		}
	}

	private void initTexture() {
		WALL_GEAR_PNG_TEKSTURA = new Texture("wallgear.png");
		TUBE_PNG_TEKSTURA = new Texture("gears.png");
	}

	private void initLabelStyle40() {
		labelStyle40 = new LabelStyle();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/HARNGTON.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		BitmapFont steamPunkFont = generator.generateFont(parameter);
		parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
		labelStyle40.font = steamPunkFont;
		generator.dispose();
	}
	private void initLabelStyle20() {
		labelStyle20 = new LabelStyle();
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/HARNGTON.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 20;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 1;
		BitmapFont steamPunkFont = generator.generateFont(parameter);
		parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
		labelStyle20.font = steamPunkFont;
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
