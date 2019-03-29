package commbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Rare1 {// implements Comparator<Integer>{
    public static int nthMostRare(int[] elements, int n) {
    	HashMap<Integer, Integer> rareMap = new HashMap<Integer, Integer>();
    	for(int i=0;i<elements.length; i++) {
    		rareMap.put(elements[i], 0);
    	}
    	for (Map.Entry rareEntry : rareMap.entrySet()) {
	    	for(int i=0;i<elements.length; i++) {
	    		int cnt = 0;
	    		if((Integer)rareEntry.getKey() == elements[i]) {
	    			cnt = (Integer)rareEntry.getValue();
	    			rareEntry.setValue(++cnt);
	    		} 
	    	}
    	}
    	int result = 0;
    	for (Map.Entry rareEntry : rareMap.entrySet()) {
    		if(Integer.parseInt(rareEntry.getValue().toString()) == n) {
    			result = Integer.parseInt(rareEntry.getKey().toString());
    		}
    	}

    	return result;
    }

    public static void main(String[] args) {
        int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
    	//int x = nthMostRare(new int[] { 1, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 2, 2, 2, 2 }, 2);
        System.out.println(x);
    }
}