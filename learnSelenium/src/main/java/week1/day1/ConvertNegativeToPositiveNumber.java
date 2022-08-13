package week1.day1;

import java.util.Scanner;


public class ConvertNegativeToPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input: ");
		int input = sc.nextInt();
		System.out.println("Given input is: " + input);
		if(input  < 0)
			System.out.println("Positive of a given input is: "+ input*-1);
		else
			System.out.println("Given input is already positive");

	}

}
