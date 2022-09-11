package week6.day1;

import java.util.HashSet;
import java.util.Set;

public class hackerrank {

	    /*
	     * Complete the 'numDuplicates' function below.
	     *
	     * The function is expected to return an INTEGER.
	     * The function accepts following parameters:
	     *  1. STRING_ARRAY name
	     *  2. INTEGER_ARRAY price
	     *  3. INTEGER_ARRAY weight
	     */

	    public static void main(String[] args) {
	        String[] name = {"ball","bat","lamp","brick","pump"};
	        int[] price = {2,2,1,3,2};
	        int[] weight = {1,2,1,1,3};
	        
	        Set<String> joinset = new HashSet<String>();
	        
	        for(int i=0; i<name.length; i++) {
	        	joinset.add(name[i]+price[i]+weight[i]);
	        	
				}
	        System.out.println(joinset);
	        
	        System.out.println(name.length - joinset.size());
	        }
	        
	        		
	    	
	        
	    }

