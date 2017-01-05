package pl.xszym.flappygears.screens;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.ui.GameLabel;
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

		initScoreTable();

	}

	private void initScoreTable() {

		LinkedHashMap<String, Integer> hMap = FlappeGears.BESTPLAYERS;
		List<String> name = new ArrayList<String>(hMap.keySet());
		List<Integer> score = new ArrayList<Integer>(hMap.values());

		int pozX = 50;
		int pozY = FlappeGears.HEIGHT - 300;
		
		if (FlappeGears.BESTPLAYERS.size() > 10) {
			for (int i = 0; i < 10; i++) {
				GameLabel gameLabel = new GameLabel();
				int i1 = i + 1;
				gameLabel.setText(i1 + ".  " + name.get(i) + "  " + score.get(i));
				gameLabel.setPosition(pozX , pozY - (i * 40));
				stage.addActor(gameLabel);

				System.err.println(score.get(i));
				System.err.println(name.get(i));
			}
		} else {
			for (int i = 0; i < FlappeGears.BESTPLAYERS.size(); i++) {
				GameLabel gameLabel = new GameLabel();
				int i1 = i + 1;
				gameLabel.setText(i1 + ".  " + name.get(i) + "  " + score.get(i));
				gameLabel.setPosition(pozX , pozY - (i * 50));
				stage.addActor(gameLabel);

				System.err.println(score.get(i));
				System.err.println(name.get(i));
			}
		}

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
