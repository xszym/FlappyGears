package pl.xszym.flappygears.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.xszym.flappygears.FlappeGears;



public class RightButton extends Button {
	public RightButton(final IClickCallback callback){
		super(new ButtonStyle());
		
		init(callback);
	}

	private void init(final IClickCallback callback) {
		
		
		this.setWidth(FlappeGears.WIDTH/2);
		this.setHeight(FlappeGears.HEIGHT + 300);
		this.setX(0);
		this.setDebug(true);
		
		this.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				
				callback.onClick();
				
				return super.touchDown(event, x, y, pointer, button);
			}
		});
}
}
