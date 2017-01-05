package pl.xszym.flappygears.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class SaveScoresToFile {
	

	public void save(TreeMap<String, Integer> treeMap) {
		{
			Map<String, Integer> hashmap = treeMap;

			try {
				FileOutputStream fos = new FileOutputStream("list.ser");

				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(hashmap);
				oos.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public LinkedHashMap<String, Integer> load() {
		
		
		try {
			
			FileInputStream fis = new FileInputStream("list.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			TreeMap<String, Integer> anotherList = (TreeMap<String, Integer>) ois.readObject();
			ois.close();
			
			LinkedHashMap<String, Integer> anotherList2 = new LinkedHashMap<String, Integer>(anotherList);
			
			return anotherList2;
		} catch (Exception e) {
			
		}
		
		return null;
		
	}
}
