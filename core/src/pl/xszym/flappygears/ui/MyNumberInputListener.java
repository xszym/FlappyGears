package pl.xszym.flappygears.ui;

import java.util.StringTokenizer;

import com.badlogic.gdx.Input.TextInputListener;

public class MyNumberInputListener implements TextInputListener {

	private int number;
	

	public void input(String text) {
		// TODO Auto-generated method stub
		
		number = Integer.parseInt(text);
		
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}

	public int getTeamAndName() {
		return number;
	}


}
