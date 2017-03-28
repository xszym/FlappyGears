package pl.xszym.flappygears.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.service.WinService;
import pl.xszym.flappygears.ui.GameLabel;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyTextButton;
import pl.xszym.flappygears.ui.MyTextInputListener;

public class GameOverScreen extends AbstractScreen {

	private GameLabel gameOverScoreLabel;
	private GameLabel gameOverWinLabel;
	private MyTextInputListener myTextInputListener;
	private Boolean inNameInput;
	private String name;
	private WinService winService;

	public GameOverScreen(FlappeGears game) {
		super(game);
	}

	@Override
	protected void init() {
		stage.addActor(FlappeGears.bg);

		initGameOverBestScoreLabel();
		initGameOverScoreLabel();

		initSpiceGearsLogo();
		initMenuButton();

		initReplayButton();
		initSaveScoreButton();

		initWinService();

	}

	@Override
	public void render(float delta) {
		super.render(delta);

		if (name != null) {
			scoreService.addPlayerToScoreTable(name, 5883, scoreService.getPoints());
			name = null;
			game.setScreen(new MenuScreen(game));
		}

		drawStage();
	}

	private void drawStage() {
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void initReplayButton() {
		MyTextButton replayButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));
			}
		}, "Replay", FlappeGears.WIDTH / 2 + 30, 150);
		stage.addActor(replayButton);
	}

	private void initSaveScoreButton() {
		MyTextButton replayButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {

				myTextInputListener = new MyTextInputListener();

				Gdx.input.getTextInput(new TextInputListener() {

					@Override
					public void input(String text) {
						name = text;
						inNameInput = true;
					}

					@Override
					public void canceled() {
						inNameInput = false;
					}
				}, "Name", "", "Team numer + Name");

			}
		}, "Save \n Score", FlappeGears.WIDTH / 2 - 120, 150);
		stage.addActor(replayButton);
	}

	private void initGameOverScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("Your score: " + scoreService.getPoints());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH / 2 - 200, FlappeGears.HEIGHT / 2 - 20 - 150);
		stage.addActor(gameOverScoreLabel);
	}

	private void initGameOverBestScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("High score: " + scoreService.getBestScore());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH / 2 - 200, FlappeGears.HEIGHT / 2 + 30 - 150);
		stage.addActor(gameOverScoreLabel);
	}

	private void initSpiceGearsLogo() {
		Image logo = new Image(FlappeGears.LOGO_PNG_TEKSTURA);
		logo.setPosition(FlappeGears.WIDTH - 150, FlappeGears.HEIGHT - 150);
		stage.addActor(logo);

	}

	private void initMenuButton() {

		MyTextButton menuButton = new MyTextButton(new IClickCallback() {

			@Override
			public void onClick() {
				game.setScreen(new MenuScreen(game));
			}
		}, "Menu", FlappeGears.WIDTH - 280, FlappeGears.HEIGHT - 150);
		stage.addActor(menuButton);

	}

	private void initWinService() {
		winService = new WinService();
		if (winService.chackWin(scoreService.getPoints())) {
			initGameOverWinLabel();
		} else {

		}
	}

	private void initGameOverWinLabel() {
		gameOverWinLabel = new GameLabel();
		gameOverWinLabel.setText("You won " + winService.getWinThink());
		gameOverWinLabel.setPosition(FlappeGears.WIDTH / 2 - 200, FlappeGears.HEIGHT / 2 + 0);
		stage.addActor(gameOverWinLabel);
	}

}
