package testdome;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    	
    	Set namesAnoSet = new HashSet();
    	for(int i=0; i<names1.length; i++) {
    		namesAnoSet.add(names1[i]);
    	}
    	for(int j=0; j<names2.length; j++) {
    		namesAnoSet.add(names2[j]);
    	}
    	
    	Object[] namesObj = namesAnoSet.toArray();
    	String[] names3 = new String[namesObj.length];
    	for(int i=0;i<namesObj.length; i++) {
    		names3[i] = (String) namesObj[i];
    	}
    	return names3;
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}