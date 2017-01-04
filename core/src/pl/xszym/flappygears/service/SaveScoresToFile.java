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

	public void save() {
		{
			Map<String, String> hashmap = new HashMap<String, String>();
			hashmap.put("key1", "value1");
			hashmap.put("key2", "value2");
			hashmap.put("key3", "value3");
			hashmap.put("key4", "value4");

			FileOutputStream fos;
			try {
				fos = new FileOutputStream("list.ser");

				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(hashmap);
				oos.close();

				FileInputStream fis = new FileInputStream("list.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				TreeMap<String, Integer> anotherList = (TreeMap<String, Integer>) ois.readObject();

				ois.close();

				System.out.println(anotherList);

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

	public void load() {

	}
}
