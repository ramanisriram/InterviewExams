package codingquestions.arraysandstrings;

//Q:Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures ?
public class ArrAndStr1 {
	public String findStringHasUnique(String input) {
		if(input == null) {
			return "Null inputs are not allowed";
		}
		int firstIndex = 0;
		int lastIndex = 0;
		boolean alldone = true;
		for(int i=0; i<input.length(); i++) {
			firstIndex = input.indexOf(input.charAt(i));
			lastIndex = input.lastIndexOf(input.charAt(i));
			if(firstIndex != lastIndex) {
				alldone = false;
				return "String does not have unique characters";
			}
		}
		if(alldone) {
			return "String has unique characters";
		}
		
		return null;
	}
}