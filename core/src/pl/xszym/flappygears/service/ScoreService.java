package pl.xszym.flappygears.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import pl.xszym.flappygears.FlappeGears;

public class ScoreService {

	public final static String GAME_PREFS = "com.xszym.gamespicegears.prefs";
	public final static String GAME_SCORE = "com.xszym.gamespicegears.prefs.score";
	public final static String GAME_BESTSCORE = "com.xszym.gamespicegears.prefs.bestscore";

	private int points;
	private Preferences prefs;
	
	
	
	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		
		
	}

	public void addPlayerToScoreTable(String name, int team, int score) {
		System.err.println(FlappeGears.BESTPLAYERS.size());
		FlappeGears.BESTPLAYERS.put(name, score);
		System.err.println(FlappeGears.BESTPLAYERS);
		
		TreeMap<String, Integer> sortedMap = sortMapByValue(FlappeGears.BESTPLAYERS);  
		System.out.println(sortedMap);
	}
 
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map);
		//TreeMap is a map sorted by its keys. 
		//The comparator is used to sort the TreeMap by keys. 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
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
		prefs.flush();
	}

}
