package pl.xszym.flappygears.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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
		
		if(points > getBestScore())
		{
			prefs.putInteger(GAME_BESTSCORE, points);
			prefs.flush();
		} else {
			
		}
	}
	
	
	
	public void addPlayerToScoreTable(String name, int team, int score) {
		FlappeGears.BESTPLAYERS.put(name, score);
		TreeMap<String, Integer> sortedMap = sortMapByValue(FlappeGears.BESTPLAYERS);
		//System.err.println(sortedMap);
	}

	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys.
		// The comparator is used to sort the TreeMap by keys.
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		
		
		String aggFileName = "agg-"+String.valueOf("06.txt");
		FileWriter fstream = new FileWriter(aggFileName);
		BufferedWriter out = new BufferedWriter(fstream);

		for (TreeMap<String, Integer> result : sortMap.entrySet()) {
		     System.out.println("Key = " + result.getKey() + ", Value = " + result.getValue()); //this statement prints out my keys and values
		     out.write(result.getKey() + "\t" + result.getValue());
		     System.out.println("Done");
		     out.flush();   // Flush the buffer and write all changes to the disk
		 }

		out.close();    // Close the file
		return result;
	}

}
