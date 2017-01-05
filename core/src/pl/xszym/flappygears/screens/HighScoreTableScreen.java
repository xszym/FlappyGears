package pl.xszym.flappygears.screens;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyTextButton;

public class HighScoreTableScreen extends AbstractScreen {

	public HighScoreTableScreen(FlappeGears game) {
		super(game);

	}

	@Override
	protected void init() {

		stage.addActor(FlappeGears.bg);

		initMenuButton();

	}

	private void initMenuButton() {

		MyTextButton menuButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new MenuScreen(game));
			}
		}, "Menu", FlappeGears.WIDTH - 150, FlappeGears.HEIGHT - 150);
		stage.addActor(menuButton);

	}

	@Override
	public void render(float delta) {
		super.render(delta);

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();

	}

	@Override
	public void dispose() {

		super.dispose();

		stage.dispose();
	}

}
