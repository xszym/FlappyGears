package pl.xszym.flappygears.screens;

import java.util.Random;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.GameLabel;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.ReplayButton;

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
		
		int i = new Random().nextInt();
		
		scoreService.addPlayerToScoreTable("Player " + i, 5883 , scoreService.getPoints());	
		initReplayButton();
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
		ReplayButton replayButton = new ReplayButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));
			}
		});
		stage.addActor(replayButton);
	}
	
	private void initGameOverScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("Your points: " + scoreService.getPoints());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH/2 - 80,FlappeGears.HEIGHT/2 - 150);
		stage.addActor(gameOverScoreLabel);
	}
	
	private void initGameOverBestScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("High score: " + scoreService.getBestScore());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH/2 - 80,FlappeGears.HEIGHT/2 + 50 - 150);
		stage.addActor(gameOverScoreLabel);	
	}
	
}
