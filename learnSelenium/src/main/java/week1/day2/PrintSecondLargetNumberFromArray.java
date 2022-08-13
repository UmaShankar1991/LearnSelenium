package week1.day2;

import java.util.Arrays;

public class PrintSecondLargetNumberFromArray {
	public static void main(String[] args) {
		int[] numbers = {1,4,2,3,6};
		Arrays.sort(numbers);
		System.out.println("Second highest number is: "+numbers[numbers.length-2]);
		
	}

}
