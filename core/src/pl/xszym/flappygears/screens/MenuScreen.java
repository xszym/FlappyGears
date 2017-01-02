package pl.xszym.flappygears.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import pl.xszym.flappygears.FlappeGears;


public class MenuScreen extends AbstractScreen {

	private Texture bg;

	public MenuScreen(FlappeGears game) {
		super(game);
		init();
	}

	@Override
	protected void init() {
		bg = new Texture("bg.jpg");

	}

	private void initTouched() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new PlayScreen(game));

		}

	}

	@Override
	public void render(float delta) {

		super.render(delta);
		initTouched();
		spriteBatch.begin();
		spriteBatch.draw(bg, 0, 0, FlappeGears.WIDTH, FlappeGears.HEIGHT);
		spriteBatch.end();

	}


}
