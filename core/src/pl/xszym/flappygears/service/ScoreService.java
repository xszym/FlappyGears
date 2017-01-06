package pl.xszym.flappygears.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
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
	private SaveScoresToPrefs saveScoresToFile;
	private TreeMap<String, Integer> sortedScoresMap;

	public ScoreService() {
		init();
	}

	private void init() {
		prefs = Gdx.app.getPreferences(GAME_PREFS);
		saveScoresToFile = new SaveScoresToPrefs();
		sortedScoresMap = sortMapByValue(FlappeGears.BESTPLAYERS);
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
		List<Integer> point = new ArrayList<Integer>(sortedScoresMap.values());
		bestScore = point.get(0);
		return bestScore;
	}

	public void savePoints() {
		prefs.putInteger(GAME_SCORE, points);
		prefs.flush();
	}

	public void addPlayerToScoreTable(String name, int team, int score) {
		FlappeGears.BESTPLAYERS.put(name, score);
		sortAndSaveMap();
	}

	public void sortAndSaveMap() {
		sortedScoresMap = sortMapByValue(FlappeGears.BESTPLAYERS);
		saveScoresToFile.save(sortedScoresMap);
	}

	public static TreeMap<String, Integer> sortMapByValue(LinkedHashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}

	public TreeMap<String, Integer> getSortedMap() {
		return sortedScoresMap;
	}

}
