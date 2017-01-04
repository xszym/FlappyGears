package pl.xszym.flappygears.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameLabel extends Label{
	
	public GameLabel(){
		super("", prepareLabelStyle());
		init();
	}

	private void init() {
		this.setX(70);
		this.setY(650);
	}

	private static LabelStyle prepareLabelStyle() {
		LabelStyle labelStyle = new LabelStyle();
		
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/HARNGTON.TTF"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 40;
		parameter.borderColor = Color.BLACK;
		parameter.borderWidth = 3;
		BitmapFont koreanFont = generator.generateFont(parameter);
		parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;
		
		labelStyle.font = koreanFont;
		
		generator.dispose();
		return labelStyle;
	}
}
