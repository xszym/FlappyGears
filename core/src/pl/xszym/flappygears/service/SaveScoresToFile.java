package pl.xszym.flappygears.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
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

	public TreeMap<String, Integer> load() {
		try {
			
			FileInputStream fis = new FileInputStream("list.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			TreeMap<String, Integer> anotherList = (TreeMap<String, Integer>) ois.readObject();

			ois.close();

			System.out.println(anotherList);
			return anotherList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
