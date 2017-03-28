package pl.xszym.flappygears.service;

import java.util.Comparator;
import java.util.LinkedHashMap;

import pl.xszym.flappygears.FlappeGears;

class ValueComparator implements Comparator<String>{

	LinkedHashMap<String, Integer> map = FlappeGears.BESTPLAYERS;
 
	public ValueComparator(LinkedHashMap<String, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(String s1, String s2) {
		if(map.get(s1) >= map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}


}