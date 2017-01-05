package pl.xszym.flappygears.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.GameLabel;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyTextInputListener;
import pl.xszym.flappygears.ui.MyTextButton;

public class GameOverScreen extends AbstractScreen {

	private GameLabel gameOverScoreLabel;

	private Image bg;

	public GameOverScreen(FlappeGears game) {
		super(game);
	}

	@Override
	protected void init() {

		stage.addActor(FlappeGears.bg);

		initGameOverBestScoreLabel();
		initGameOverScoreLabel();

		initReplayButton();
		initSaveScoreButton();
	}

	@Override
	public void render(float delta) {
		super.render(delta);

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

				MyTextInputListener myTextInputListener = new MyTextInputListener();

				Gdx.input.getTextInput(myTextInputListener, "Name", "", "Team numer + Name");
				
				if (myTextInputListener.getTeamAndName() == null){
					
				}	else {
					scoreService.addPlayerToScoreTable(myTextInputListener.getTeamAndName(), 5883,
							scoreService.getPoints());
				}
				
				

			}
		}, "Save \n Score", FlappeGears.WIDTH / 2 - 120, 150);
		stage.addActor(replayButton);
	}

	private void initGameOverScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("Your score: " + scoreService.getPoints());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH / 2 - 80, FlappeGears.HEIGHT / 2 - 150);
		stage.addActor(gameOverScoreLabel);
	}

	private void initGameOverBestScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("High score: " + scoreService.getBestScore());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH / 2 - 80, FlappeGears.HEIGHT / 2 + 50 - 150);
		stage.addActor(gameOverScoreLabel);
	}

}
