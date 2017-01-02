package pl.xszym.flappygears.service;

import java.util.Hashtable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class ScoreService {

	public final static String GAME_PREFS = "com.xszym.gamespicegears.prefs";
	public final static String GAME_SCORE = "com.xszym.gamespicegears.prefs.score";
	public final static String GAME_BESTSCORE = "com.xszym.gamespicegears.prefs.bestscore";

	private int points;
	private Array<ScorePlayerService> scorePlayers;
	private Preferences prefs;

	Hashtable<String, String> hashTable = new Hashtable<String, String>();

	Json json = new Json();

	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		// scorePlayers = new Array<ScorePlayerService>();
		// hashTable.put("test", json.toJson(scorePlayers));

	}

	public void addPlayerToScoreTable(String name, int team, int score) {
//		scorePlayers.add(new ScorePlayerService(name, team, score));
//		System.out.println(scorePlayers.get(0).getName());
//		System.out.println(scorePlayers.get(0).getScore());
//		System.out.println(hashTable.get(0));
	}

	public void addPoints(int pointsToAdd) {
		points += pointsToAdd;
	}

	public void addPoint() {
		points++;
	}

	public void resetGameScore() {
		points = 0;
		saveCurrentGamestate();

	}

	public int getPoints() {
		points = prefs.getInteger(GAME_SCORE);
		return points;
	}

	public void saveCurrentGamestate() {
		prefs.putInteger(GAME_SCORE, points);
		String serializedInts = Gdx.app.getPreferences(GAME_PREFS).getString(GAME_BESTSCORE);
		ScorePlayerService deserializedInts = json.fromJson(ScorePlayerService.class, serializedInts);
		prefs.put(hashTable);
		prefs.flush();
	}

}
