package oracle.votingsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Validator {
//this method has to be re used. currently this is not used any where.
	static List validateInput1(Map orginalInput, ArrayList<String> userInput) {
		List finalMap = new ArrayList();
		LinkedHashSet finalInputList = null;
		for (String in : userInput) {
			int count = 0;
			char[] a = in.toCharArray();
			finalInputList = new LinkedHashSet();
			for (char c : a) {
				if (!orginalInput.containsKey(Character.toString(c))) {
					finalInputList.add(orginalInput.get(Character.toString(c)));
				}
			}
			finalMap.add(finalInputList);

		}

		return finalMap;
	}

	static Map validateInput(List<String> inputList) {
		Map finalCandidateMap = new HashMap();
		List<String> validatedinputList = new ArrayList<String>();
		for (String in : inputList) {
			char[] inputVal = in.toCharArray();
			boolean isStringFine = true;
			for (char c : inputVal) {
				boolean itemInCandList = true;
				for (Map.Entry<String, String> entry : VoteCounterMain.candidateList.entrySet()) {
					// Condition that checks
					// Add candidates to the map which has vote
					// candidite not in the first position then dont add to the map.
					if (entry.getKey().equals(Character.toString(c))) {
						if (!finalCandidateMap.containsKey(Character.toString(c))) {
							finalCandidateMap.put(entry.getKey(), entry.getValue());
						}
						itemInCandList = true;
						break;
					} else {
						itemInCandList = false;
					}
				}
				if (!itemInCandList) {
					isStringFine = false;
					break;
				} else {
					isStringFine = true;
				}
			}
			if (isStringFine) {
				validatedinputList.add(in);
			}
		}
		VoteCounterMain.userInputList = (ArrayList<String>) validatedinputList;
		return finalCandidateMap;
	}

	public static boolean discardforinvalidinput(String input) {
		// Create a Set to insert characters
		Set<Character> set = new HashSet<>();

		// get all characters form String
		char[] characters = input.toCharArray();

		for (Character c : characters) {
			if (!set.add(c)) {
				return false;
			}
		}
		return true;
	}
}
