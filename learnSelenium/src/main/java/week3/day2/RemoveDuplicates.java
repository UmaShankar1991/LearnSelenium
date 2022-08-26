package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {		
		
		String input = "Paypal";
		//char[] inputCharArray = input.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		Set<Character> duplicateSet = new HashSet<Character>();
		 
		for(int i=0; i<input.length(); i++) {
			if(!charSet.add(input.toLowerCase().charAt(i)))
				duplicateSet.add(input.toLowerCase().charAt(i));
		}
		
		for (Character character : duplicateSet) {
			charSet.remove(character);
		}
		
		System.out.println("Unique characters are: "+charSet);
		
	}

}