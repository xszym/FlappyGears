package pl.xszym.flappygears.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.xszym.flappygears.FlappeGears;
import pl.xszym.flappygears.entities.Player;

public class LeftButton extends Button {
	public LeftButton(final IClickCallback callback) {
		super(new ButtonStyle());

		init(callback);
	}

	Player player = new Player();

	private void init(final IClickCallback callback) {
		this.setWidth(FlappeGears.WIDTH / 2);
		this.setHeight(FlappeGears.HEIGHT + 300);
		this.setX(FlappeGears.WIDTH / 2);
		// this.setY(player.getPosition().y + PlayScreen.PLAYER_UP);
		this.setDebug(true);
		this.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

				callback.onClick();

				return super.touchDown(event, x, y, pointer, button);
			}
		});

	}
}
