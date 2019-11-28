package com.dumbDataGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Shifter {
	
	private List<String> allChars;
	private List<String> allNumbers;

	
	public Shifter() {
		this.allChars = getAllChars();
		this.allNumbers = getAllNumbers();
		this.allChars.forEach(System.out::print);
		this.allNumbers.forEach(System.out::print);
	}
	
	public List<List<String>> getShiftedLists(List<List<String>> lists, List<Boolean> selected) {
		List<List<String>> finalList = new ArrayList<>();
		List<List<String>> inputLists;
		
		
		if (selected.get(2)) inputLists = lists;
		else {
			inputLists = lists.subList(1, lists.size());
			finalList.add(lists.get(0));
		}
		
		
		for (List<String> list : inputLists) {
			List<String> singleList = new ArrayList<>();
			for (String i : list) {
				StringBuilder sb = new StringBuilder();
				for (String e : i.split("")) {
					if (allChars.contains(e)) {
						if (selected.get(0)) appendElement(allChars, sb, e);
					    else sb.append(e);
					} else if (allNumbers.contains(e)) {
						if (selected.get(1)) appendElement(allNumbers, sb, e);
						else sb.append(e);
					} else {
						sb.append(e);
					}
				}
				singleList.add(sb.toString());
			}
			finalList.add(singleList);
		}
		return finalList;
	}
	
	private void appendElement(List<String> alls, StringBuilder sb, String e) {
		int index = alls.indexOf(e);
		if (index + 1 >= alls.size()) 
			sb.append(alls.get(0));
		else
			sb.append(alls.get(index+1));
	}

	private List<String> getAllChars() {
		List<String> allChars = new ArrayList<>();
		for (int i=65; i<91; i++) allChars.add(Character.toString((char)i));
		for (int i=97; i<123; i++) allChars.add(Character.toString((char)i));
		return allChars;
	}
	
	private List<String> getAllNumbers() {
		List<String> allNumbers = new ArrayList<>();
		for (int i=48; i<58; i++) allNumbers.add(Character.toString((char)i));
		return allNumbers;
	}
 	
	
}
