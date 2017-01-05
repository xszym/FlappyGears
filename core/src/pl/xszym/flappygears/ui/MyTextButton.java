package pl.xszym.flappygears.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.xszym.flappygears.FlappeGears;

public class MyTextButton extends TextButton {
	
	private int x;
	private int y;
	
	public MyTextButton(final IClickCallback callback, String name, int x, int y)
	{
		super(name ,prepareResetButtonStyles());

		this.x = x;
		this.y = y;
		
		init(callback);
		
	}

	private void init(final IClickCallback callback)
	{

		this.setWidth(100);
		this.setHeight(100);
		this.setX(x);
		this.setY(y);
		//this.setDebug(true);

		this.addListener(new ClickListener()
		{
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
			{

				callback.onClick();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}
	
	private static TextButtonStyle prepareResetButtonStyles(){
		TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("ui-red.atlas"));
		Skin skin = new Skin(atlas);
		TextButtonStyle buttonstyle = new TextButtonStyle();
		buttonstyle.font = FlappeGears.labelStyle20.font;
		buttonstyle.fontColor = FlappeGears.labelStyle20.fontColor;
		buttonstyle.up = skin.getDrawable("button_02");
		buttonstyle.down = skin.getDrawable("button_03");
		return buttonstyle;
	}

}
