package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class FindingIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a={3,2,11,4,6,7};
		int[] b={1,2,8,4,9,7};
		
		List<Integer> listA = new ArrayList<Integer>();
		List<Integer> listB = new ArrayList<Integer>();
		
		for (Integer integer : a) 
			listA.add(integer);
		
		for (Integer integer : b) 	
		    listB.add(integer);
		
		System.out.println("Matching numbers are: ");
		for (Integer integer : listA) {
			if(listB.contains(integer))
				System.out.println(integer);
		}

	}

}
