package week1.day2;

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count =0;
		for(int i =2; i<=n-1; i++) {
			if(n%i == 0)
				count++;
		}
		
		if(count ==0) 
			System.out.println("Given number is prime");
		else
			System.out.println("Given number is not prime");

	}

}
