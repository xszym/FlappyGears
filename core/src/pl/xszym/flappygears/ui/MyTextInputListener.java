package pl.xszym.flappygears.ui;

import com.badlogic.gdx.Input.TextInputListener;

public class MyTextInputListener implements TextInputListener {

	private String teamAndName;
	
	@Override
	public void input(String text) {
		// TODO Auto-generated method stub
		teamAndName = text;
		System.err.println(text);
		System.err.println(teamAndName);
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}

	public String getTeamAndName() {
		return teamAndName;
	}

}
