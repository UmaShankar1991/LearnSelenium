// https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week3/day1/Assignments/PrintUniqueCharacter.java

package week3.day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Problem
		 * 
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * 
		 * Input:  babu
		 * Output: a u 
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		char[] inputChar = inputString.toLowerCase().toCharArray();
		//System.out.println(inputChar[0]);
		Set<Character> set = new HashSet<Character>();
		Set<Character> repeatingSet = new HashSet<Character>();
		
		for (char c : inputChar) {
				if(!set.add(c)) {
					set.remove(c);
					repeatingSet.add(c);
				}			    	
		}
		for (Character character : repeatingSet) {
			set.remove(character);
		}
   
	System.out.println("Unique characters in set are: "+ set);

	}

}
