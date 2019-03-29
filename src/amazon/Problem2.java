package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Problem2 {
	
	static CopyOnWriteArrayList<Integer> valInt = new CopyOnWriteArrayList();
	public static void main(String args[]) {
		
		List<List<Integer>> forwardList = new ArrayList();
		List<List<Integer>> reverseList = new ArrayList();
		
		
		List<Integer> myFList = new ArrayList();
		List<Integer> myRList = new ArrayList();
		//int arr1[] = { 1000,2000,3000 };
		//int arr2[] = { 1000,2000,3000,4000 };
		int x = 7000;
		
		
		List<Integer> test1 = new ArrayList();
		test1.add(1);
		test1.add(1000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(2);
		test1.add(3000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(3);
		test1.add(5000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(4);
		test1.add(8000);
		forwardList.add(test1);
		
		//--------------------------------
		
		test1 = new ArrayList();
		test1.add(1);
		test1.add(3000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(2);
		test1.add(5000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(3);
		test1.add(7000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(4);
		test1.add(8000);
		reverseList.add(test1);
		
		/*List<Integer> test1 = new ArrayList();
		test1.add(1);
		test1.add(2000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(2);
		test1.add(3000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(3);
		test1.add(5000);
		forwardList.add(test1);
		
		test1 = new ArrayList();
		test1.add(4);
		test1.add(8000);
		forwardList.add(test1);
		
		//--------------------------------
		
		test1 = new ArrayList();
		test1.add(1);
		test1.add(4000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(2);
		test1.add(5000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(3);
		test1.add(6000);
		reverseList.add(test1);
		
		test1 = new ArrayList();
		test1.add(4);
		test1.add(7000);
		reverseList.add(test1);*/
		
		Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
		Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
		
		for(int i=0;i<forwardList.size();i++) {
			map1.put(forwardList.get(i).get(0), forwardList.get(i).get(1));
		}
		
		for(int i=0;i<reverseList.size();i++) {
			map2.put(reverseList.get(i).get(0), reverseList.get(i).get(1));
		}
		
		
		BiConsumer<? super Integer, ? super Integer> action1 = (intKey, intVal) -> {
			myFList.add(intVal);
		};
		map1.forEach(action1);
		
		Object[] arr1 = myFList.toArray();
		
		BiConsumer<? super Integer, ? super Integer> action2 = (intKey, intVal) -> {
			myRList.add(intVal);
		};
		map2.forEach(action2);
		
		Object[] arr2 = myRList.toArray();
		
		List<String> val = findPairs(arr1, arr2, arr1.length, arr2.length, x);
		if(val.size() == 0) {
			Collections.sort(valInt);
			x = valInt.get(valInt.size()-1);
			val = findPairs(arr1, arr2, arr1.length, arr2.length, x);
		}
		
		List<List<Integer>> result = new ArrayList();
		
		Consumer<? super String> action3 = (strVal) -> {
			//System.out.println("strVal:"+strVal);
			BiConsumer<? super Integer, ? super Integer> action4 = (intKey1, intVal1) -> {
				if(intVal1.toString().equals(strVal.split(" ")[0])) {
					//System.out.println("Key is:"+intKey1);
					List<Integer> inside = new ArrayList();
					inside.add(intKey1);
					inside.add(intVal1);
					result.add(inside);
				}
			};
			BiConsumer<? super Integer, ? super Integer> action5 = (intKey2, intVal2) -> {
				if(intVal2.toString().equals(strVal.split(" ")[1])) {
					//System.out.println("Key2 is:"+intKey2);
					List<Integer> inside = new ArrayList();
					inside.add(intKey2);
					inside.add(intVal2);
					result.add(inside);
				}
			};
			map1.forEach(action4);
			map2.forEach(action5);
		};
		val.forEach(action3);
		
		System.out.println(result);
	}

	static List findPairs(Object arr1[], Object arr2[], int n, int m, int x) {
		List<String> val = new ArrayList();
		boolean equa = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((int)arr1[i] + (int)arr2[j] == x) {
					equa = true;
					//System.out.println(arr1[i] + " " + arr2[j]);
					val.add(arr1[i] + " " + arr2[j]);
				} else {
					valInt.add((int)arr1[i] + (int)arr2[j]);
				}
			}
		}
		
		
		
		if(!equa) {
			//System.out.println("valInt:size():" + valInt.size());
			for(Integer y : valInt) {
				if(y > x) {
					valInt.remove(y);
				}
			}
		}
		
		return val;
	}
}