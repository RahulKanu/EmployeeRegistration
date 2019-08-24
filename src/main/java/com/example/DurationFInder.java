package com.example;

import java.util.ArrayList;
import java.util.List;

public class DurationFInder {
	
	public static String calculateMax(List<String> durations) {
		if(durations.size()==0) {
			return "";
		}
		int maxDuration = 0;
		int counter = 0;
		int countDays;
		int index = 0;
		for(String str: durations) {
			char[] chara = str.toCharArray();
			countDays = chara[0] * 365 + chara[2] * 30 + chara[4];
			System.out.println(countDays);

			counter++;
			if(countDays > maxDuration ) {
				maxDuration = countDays;
				index = counter;
			}
		}
		System.out.println("Max"+maxDuration +"\n"  + durations.get(index-1));
		return durations.get(index-1);
	}
	public static void main(String...arg) {
		List<String> durations = new ArrayList<>();
		durations.add("1Y1M1D");
		durations.add("1Y0M1D");
		durations.add("0Y0M1D");
		DurationFInder.calculateMax(durations);
		
	}
	

}
