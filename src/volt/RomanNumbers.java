package volt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class RomanNumbers {

	private Map<Integer, Integer> hitCount = new HashMap<Integer, Integer>();
	private Map<Integer, String> romanNos = new TreeMap<Integer, String>(Collections.reverseOrder());
	private StringBuilder finalResult = new StringBuilder();

	private int performCalc(int key, int input) {
		int quotient = 0;
		int reminder = 0;
		if (input >= key) {
			// divide the input by the key 1990/1000
			quotient = input / key;
			reminder = input % key;
			quotient = quotient + hitCount.get(key);
			hitCount.put(key, quotient);
			String temp = romanNos.get(key);
			String romanNumber = IntStream.range(0,quotient).mapToObj(i -> temp).collect(Collectors.joining(""));
			finalResult.append(romanNumber);
			performCalc(key, reminder);
		} else {
			//40<=1000, so go to the next item
			reminder = input;
		}
		return reminder;
	}

	public String convertIntegerToRoman(int input) {
		
		if(input > 3000 || input <= 0) {
			return "Invalid Input";
		} else {
			//int input = 1990;
		
			romanNos.put(1000, "X");
			romanNos.put(500, "V");
			romanNos.put(100, "L");
			romanNos.put(50, "O");
			romanNos.put(10, "M");
			romanNos.put(5, "S");
			romanNos.put(1, "1");
			
	
			// put values into map
			hitCount.put(1000, 0);
			hitCount.put(500, 0);
			hitCount.put(100, 0);
			hitCount.put(50, 0);
			hitCount.put(10, 0);
			hitCount.put(5, 0);
			hitCount.put(1, 0);
			Set<Integer> romanNoskey = romanNos.keySet();
			Iterator<Integer> it = romanNoskey.iterator();
			int key = 0;
	
			while (it.hasNext()) {
				key = it.next();
				input = performCalc(key, input);
			}
			//System.out.println("finalResult:"+finalResult.toString());
			return finalResult.toString();
		}
	}
}