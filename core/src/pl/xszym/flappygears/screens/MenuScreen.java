package pl.xszym.flappygears.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyTextButton;
import pl.xszym.flappygears.ui.MyTextInputListener;

public class MenuScreen extends AbstractScreen {

	private MyTextInputListener myTextInputListener;
	private String implementedPassoword = null;
	private String pass = "spice1410";

	public MenuScreen(FlappeGears game) {
		super(game);
		init();
	}

	@Override
	protected void init() {

		stage.addActor(FlappeGears.bg);

		initSpiceGearsLogo();

		initHighScoreButton();

		initOptionButton();

		initPlayButton();
	}

	@Override
	public void render(float delta) {

		super.render(delta);

		chackPassword();

		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();

	}

	private void initHighScoreButton() {

		MyTextButton highScoreButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new HighScoreTableScreen(game));
			}
		}, "High \n Scores", FlappeGears.WIDTH / 2 - 120, 150);
		stage.addActor(highScoreButton);

	}

	private void initPlayButton() {
		MyTextButton playButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));

			}
		}, "Play", FlappeGears.WIDTH / 2 + 30, 150);
		stage.addActor(playButton);
	}

	private void initOptionButton() {

		MyTextButton optionButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {

				myTextInputListener = new MyTextInputListener();

				Gdx.input.getTextInput(new TextInputListener() {

					@Override
					public void input(String text) {

						implementedPassoword = text;

					}

					@Override
					public void canceled() {

					}
				}, "Password", "", "password");

			}
		}, "Options", FlappeGears.WIDTH - 280, FlappeGears.HEIGHT - 150);
		stage.addActor(optionButton);

	}

	private void initSpiceGearsLogo() {
		Image logo = new Image(FlappeGears.LOGO_PNG_TEKSTURA);
		logo.setPosition(FlappeGears.WIDTH - 150, FlappeGears.HEIGHT - 150);
		stage.addActor(logo);

	}

	private void chackPassword() {
		if (pass.equals(implementedPassoword)) {
			game.setScreen(new OptionScreen(game));
		}
	}

}
