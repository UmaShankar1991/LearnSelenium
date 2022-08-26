// https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week3/day1/Assignments/MissingNumber.java

package week3.day2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class MissingNumber {

	public static void main(String[] args) {
		/*
		 * Problem 
		 * 
		 * There will be running number between 1 to 10
		 * One of the unique number will be missing
		 * Find the missing number
		 * 
		 * 
		 */
		
		
		Set<Integer> set = new TreeSet<Integer>();
		Collections.addAll(set, 1,2,5,3,7,9,4,6,20);
		//Method 1
		List<Integer> list = new ArrayList<Integer>(set);
		System.out.println("Missing numbers are: ");
		for(int i=list.get(0); i<list.get(list.size()-1); i++) {
			if(!list.contains(i)) {
				System.out.println(i);
			}
		}

		
	}
	

}
