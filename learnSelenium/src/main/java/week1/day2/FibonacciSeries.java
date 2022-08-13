package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int count = 11;
		int temp =0;
		int first =0;
		int second =1;
		System.out.println("Fibonacci series for first 11 numbers is: ");
		for(int i=0; i<count; i++) 
		{
			System.out.println(first);
			temp = first+second;
			first = second;
			second = temp;			
		}
			
		
		

	}

}
