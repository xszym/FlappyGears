package pl.xszym.flappygears.screens;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.MyTextButton;

public class MenuScreen extends AbstractScreen {


	public MenuScreen(FlappeGears game) {
		super(game);
		init();
	}

	@Override
	protected void init() {
		
		stage.addActor(FlappeGears.bg);
		
		initHighScoreButton();
		
		initPlayButton();
	}


	

	@Override
	public void render(float delta) {

		super.render(delta);
		
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
		}, "High \n Scores", FlappeGears.WIDTH - 150, FlappeGears.HEIGHT - 150);
		stage.addActor(highScoreButton);
		
	}
	
	
	private void initPlayButton() {
		MyTextButton playButton = new MyTextButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));
				
			}
		}, "Play", FlappeGears.WIDTH / 2 - 50, 150);
		stage.addActor(playButton);
	}


}
