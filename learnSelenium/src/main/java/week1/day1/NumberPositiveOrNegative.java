package week1.day1;

import java.util.Scanner;

public class NumberPositiveOrNegative {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter valid number: ");
		int input = sc.nextInt();
		System.out.println("Given input is: "+ input);
		
		if(input > 0) 
			System.out.println("Given number is positive");
		else
			System.out.println("Given number is negative");
		
	}

}
