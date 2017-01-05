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
		
		initTouched();
	}



	private void initTouched() {
		MyTextButton replayButton = new MyTextButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				game.setScreen(new PlayScreen(game));
				
			}
		}, "Play", FlappeGears.WIDTH / 2 - 50, 150);
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
