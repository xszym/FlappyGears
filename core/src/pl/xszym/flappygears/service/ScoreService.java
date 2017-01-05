package pl.xszym.flappygears.service;

import java.util.ArrayList;
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
	private int bestScore;
	private Preferences prefs;

	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
	}

	public void addPoint() {
		getPoints();
		points++;
		savePoints();
	}

	public void resetGameScore() {
		points = 0;
		savePoints();
	}

	public int getPoints() {
		points = prefs.getInteger(GAME_SCORE);
		return points;
	}

	public int getBestScore() {
		bestScore = prefs.getInteger(GAME_BESTSCORE);
		return bestScore;
	}

	public void savePoints() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	public void chackBestScore() {

		savePoints();

		if (points > getBestScore()) {
			prefs.putInteger(GAME_BESTSCORE, points);
			prefs.flush();
		} else {

		}
	}

	public void addPlayerToScoreTable(String name, int team, int score) {
		
		
		FlappeGears.BESTPLAYERS.put(name, score);
		
//		int lastPlace = 9;
//		if (FlappeGears.BESTPLAYERS.size() > lastPlace) {
//			Integer value = (new ArrayList<Integer>(FlappeGears.BESTPLAYERS.values())).get(lastPlace);
//			if (score > value) {
//
//				FlappeGears.BESTPLAYERS.put(name, score);
//				FlappeGears.BESTPLAYERS.values().remove(lastPlace + 1);
//			}
//		} else { }
		
		TreeMap<String, Integer> sortedMap = sortMapByValue(FlappeGears.BESTPLAYERS);
		SaveScoresToFile saveScoresToFile = new SaveScoresToFile();
		saveScoresToFile.save(sortedMap);
		System.err.println(saveScoresToFile.load());

	}

	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}

}
