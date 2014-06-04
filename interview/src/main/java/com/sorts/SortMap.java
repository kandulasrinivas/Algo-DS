package com.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//This class does sorting of the hashmap based on values
public class SortMap {

	public static void main(String[] args) {
		List<String> foodItemsList = new ArrayList<String>();
		foodItemsList.add("rice");
		foodItemsList.add("bread");
		foodItemsList.add("rice");
		foodItemsList.add("egg");
		foodItemsList.add("egg");
		foodItemsList.add("cake");
		foodItemsList.add("cake");
		foodItemsList.add("cake");
		foodItemsList.add("cake");
		Map<String, Integer> itemsCount = new HashMap<String, Integer>();
		for (String item : foodItemsList) {
			if (itemsCount.get(item) != null) {
				Integer count = itemsCount.get(item);
				itemsCount.put(item, ++count);
			} else {
				itemsCount.put(item, 1);
			}

		}
		Set<Map.Entry<String, Integer>> mp = itemsCount.entrySet();
		List<Map.Entry<String, Integer>> ll = new ArrayList<Map.Entry<String, Integer>>(
				mp);
		Collections.sort(ll, new SortMap.ValueComparator());
		System.out.println(ll);
	}

	static class ValueComparator implements
			Comparator<Map.Entry<String, Integer>> {

		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o1.getValue().compareTo(o2.getValue());
		}

	}

}
