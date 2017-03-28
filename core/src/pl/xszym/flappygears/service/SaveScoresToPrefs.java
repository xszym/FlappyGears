package pl.xszym.flappygears.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;

public class SaveScoresToPrefs  {
	
	public final static String GAME_HIGHSCORES = "com.xszym.gamespicegears.prefs.highscores";
	private Preferences prefs;
	
	public SaveScoresToPrefs() {
		prefs = Gdx.app.getPreferences(ScoreService.GAME_PREFS);
		
	}

	public void save(TreeMap<String, Integer> treeMap) {
		{
			Map<String, Integer> hashmap = treeMap;
			
			String hashMapString = hashmap.toString();
			FileHandle file = Gdx.files.local("scores.txt");
			file.writeString(hashMapString, false);


			prefs.putString(GAME_HIGHSCORES, hashMapString);
			prefs.flush();
		}
	}

	public LinkedHashMap<String, Integer> load() {
		
		try {
			
			String text = prefs.getString(GAME_HIGHSCORES);
			text = text.replaceAll("\\{", "");
			text = text.replaceAll("\\}", "");
			text = text.replaceAll(" ", "");
			
			TreeMap<String, Integer> mapFromString = new TreeMap<String, Integer>();

			String[] pairs = text.split(",");
			for (int i=0; i < pairs.length;i++) {
			    String pair = pairs[i];
			    String[] keyValue = pair.split("=");
			    mapFromString.put(keyValue[0], Integer.valueOf(keyValue[1]));
			}
			
			TreeMap<String, Integer> anotherList = (TreeMap<String, Integer>) mapFromString;
			
			LinkedHashMap<String, Integer> anotherList2 = new LinkedHashMap<String, Integer>(anotherList);
			
//			FileInputStream fis = new FileInputStream("list.ser");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			TreeMap<String, Integer> anotherList = (TreeMap<String, Integer>) ois.readObject();
//			ois.close();
//			LinkedHashMap<String, Integer> anotherList2 = new LinkedHashMap<String, Integer>(anotherList);
			
			
			return anotherList2;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	


	
}
