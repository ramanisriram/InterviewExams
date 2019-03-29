package testdome;

import java.util.Arrays;
import java.util.Comparator;

public class SortedSearch implements Comparator<Integer> {
	
	private static int lessThanVar = 0;
	private static int count = 0;
    public static int countNumbers(int[] sortedArray, int lessThan) {
    	lessThanVar = lessThan;
    	
    	Integer[] sortArr = new Integer[sortedArray.length];
    	for(int i=0; i< sortedArray.length; i++) {
    		sortArr[i] = sortedArray[i];
    	}
        Arrays.sort(sortArr, new SortedSearch());
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        //System.out.println(SortedSearch.countNumbers(new int[] { 1, 2 }, 2));
    }

	@Override
	public int compare(Integer a1, Integer a2) {
		if(a2 < lessThanVar) {
			++count;
		}
		return a1.compareTo(a2);
	}
}