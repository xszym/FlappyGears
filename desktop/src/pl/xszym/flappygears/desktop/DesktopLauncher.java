package pl.xszym.flappygears.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import pl.xszym.flappygears.FlappeGears;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = FlappeGears.TITLE;
		config.width = FlappeGears.WIDTH;
		config.height = FlappeGears.HEIGHT;
		config.resizable = false;
		new LwjglApplication(new FlappeGears(), config);
	}
}
