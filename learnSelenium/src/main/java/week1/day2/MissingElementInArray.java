package week1.day2;

import java.util.Arrays;

public class MissingElementInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {12,10,19};
		int arrLength = arr.length;
		Arrays.sort(arr);

		int j = arr[0];
		for(int i=0; i<arrLength; i++)
			System.out.print(arr[i]);
		System.out.println();		
		for(int i=0; i<arrLength; i++)
		{
			if(j != arr[i]) {
				System.out.println(j);
				i= i-1; //decrement i by 1 if the current j is not equal to array element
			}
			if(j<arr[arr.length-1]) //Stop incrementing j when the loop reaches last element in array
				j++;	
		}
				
	}

}
