package pl.xszym.flappygears.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class SaveScoresToFile  {
	

	public void save(TreeMap<String, Integer> treeMap) {
		{
			Map<String, Integer> hashmap = treeMap;

			try {
				
				String hashMapString = hashmap.toString();
				System.err.println(hashMapString);
				FileHandle file = Gdx.files.local("scores.txt");
				file.writeString(hashMapString, false);

//				FileOutputStream fos = new FileOutputStream("list.ser");
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
//				oos.writeObject(hashmap);
//				oos.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public LinkedHashMap<String, Integer> load() {
		
		try {
			FileHandle file = Gdx.files.internal("scores.txt");
			String text = file.readString();
			text = text.replaceAll("\\{", "");
			text = text.replaceAll("\\}", "");
			
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
			
			System.err.println("load " + anotherList2);
			
			return anotherList2;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	


	
}
