package pl.xszym.flappygears.screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.service.ScoreService;
import pl.xszym.flappygears.ui.GameLabel;

public class GameOverScreen extends AbstractScreen {

	private GameLabel gameOverScoreLabel;
	private ScoreService scoreService;
	
	public GameOverScreen(FlappeGears game) {
		super(game);
		
	}

	@Override
	protected void init() {
		
		scoreService = new ScoreService();
		
		initGameOverScoreLabel();
		int i = new Random().nextInt();
		scoreService.addPlayerToScoreTable("Player " + i, 5883 , scoreService.getPoints());
		
	}
	

	


	@Override
	public void render(float delta) {
		
		super.render(delta);
		
		initTouched();
		
		drawStage();
		
	}
	
	private void drawStage() {
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
		
	}

	private void initTouched() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new MenuScreen(game));
		}
	}
	
	private void initGameOverScoreLabel() {
		gameOverScoreLabel = new GameLabel();
		gameOverScoreLabel.setText("Your points: " + scoreService.getPoints());
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH/2 - 40,FlappeGears.HEIGHT/2);
		stage.addActor(gameOverScoreLabel);
	}
}
