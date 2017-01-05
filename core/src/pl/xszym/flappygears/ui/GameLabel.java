package pl.xszym.flappygears.ui;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import pl.xszym.flappygears.FlappeGears;

public class GameLabel extends Label{
	
	public GameLabel(){
		super("", prepareLabelStyle());
		init();
	}

	private void init() {
		this.setX(70);
		this.setY(650);
	}

	private static LabelStyle prepareLabelStyle() {
		
		return FlappeGears.labelStyle40;
	}
}
