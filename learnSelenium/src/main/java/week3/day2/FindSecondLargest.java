// https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week3/day1/Assignments/FindSecondLargest.java

package week3.day2;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
 
		// Here is the input
		int[] data = {3,2,11,4,6,7,2,3,3,6,7};
		Set<Integer> set = new TreeSet<Integer>();
		for(int i =0; i< data.length; i++) {
			set.add(data[i]);
		}
		//System.out.println(set);
		
		List<Integer> list = new ArrayList<Integer>(set);
		
		System.out.println("Second largest number is: " +list.get(list.size()-2));
		
		



	}
	

}
