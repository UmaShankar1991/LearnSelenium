// https://github.com/TestLeafPages/SeleniumAssignments/blob/master/week3/day1/Assignments/PrintDuplicateNumbers.java

package week3.day2;

import java.util.Set;
import java.util.TreeSet;

public class PrintDuplicateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {4,3,6,8,29,1,2,4,7,8};
		Set<Integer> uniqueSet = new TreeSet<Integer>();
		Set<Integer> duplicateSet = new TreeSet<Integer>();
		
		for (Integer integer : data) {
			if(!uniqueSet.add(integer))
				duplicateSet.add(integer);
		}

        System.out.println("Duplicate Numbers are: "+ duplicateSet);
	}

}
