package MacquireBank;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	public static void main(String args[]) {
		List<String> inputValues = new ArrayList();
		inputValues.add("keyhbmeknckfavrpqyyfjxjjmivtsftikovkcdcwefctqrqjryhtlcvstm");
		inputValues.add("aab");
		inputValues.add("abb");
		inputValues.add("abab");
		inputValues.add("abaaaba");
		minimalOperations(inputValues);
		
	}
	public static List<Integer> minimalOperations(List<String> words) {
		
		List<Integer> returnValues = new ArrayList();

		for(String input : words) {
			int output = 0;
			for (int i = 0; i < input.length();) {
				if (input.charAt(i) == input.charAt(i + 1)) {
					output = 1;
					break;
				} else {
					if (i + 1 == input.length() - 1) {
						break;
					} else {
						i++;
					}
				}
			}
			returnValues.add(output);
			System.out.println(output);
		}
		return returnValues;
	}
}