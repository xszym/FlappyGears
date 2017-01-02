package pl.xszym.flappygears.service;

public class ScorePlayerService {
	private String name;
	private int team;
	private int score;
	
	public ScorePlayerService(String name, int team, int score) {
		this.name = name;
		this.team = team;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getTeam() {
		return team;
	}

	public int getScore() {
		return score;
	}
	
}
