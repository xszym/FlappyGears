package pl.xszym.flappygears.screens;

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
		gameOverScoreLabel = new GameLabel();
		scoreService = new ScoreService();
		
		gameOverScoreLabel.setPosition(FlappeGears.WIDTH/2, FlappeGears.HEIGHT/2);
		gameOverScoreLabel.setText("Your points: " + scoreService.getPoints());
		stage.addActor(gameOverScoreLabel);
		
		scoreService.addPlayerToScoreTable("Test",5883, scoreService.getPoints());
	}
	
	private void initTouched() {
		if (Gdx.input.isTouched()) {
			game.setScreen(new MenuScreen(game));

		}

	}
	
	@Override
	public void render(float delta) {
		
		super.render(delta);
		
		initTouched();
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

}
