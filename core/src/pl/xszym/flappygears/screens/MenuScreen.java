package pl.xszym.flappygears.screens;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.IClickCallback;
import pl.xszym.flappygears.ui.ReplayButton;

public class MenuScreen extends AbstractScreen {


	public MenuScreen(FlappeGears game) {
		super(game);
		init();
	}

	@Override
	protected void init() {
		
		stage.addActor(FlappeGears.bg);
		
		initTouched();
	}



	private void initTouched() {
		ReplayButton replayButton = new ReplayButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));
				
			}
		});
		stage.addActor(replayButton);
	}

	@Override
	public void render(float delta) {

		super.render(delta);
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
		
	}

}
