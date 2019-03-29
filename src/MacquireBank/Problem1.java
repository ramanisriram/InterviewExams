package MacquireBank;

import java.io.UnsupportedEncodingException;

//O(n+m) where n and m are length of strings
public class Problem1 {

	public static void main(String args[]) {
		
		String j = "ウ"; 
		//j = "熊";
		try {
			System.out.println(j.getBytes("SJIS").length);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 String s1 = "abc"; 
	        String s2 = "stuvwx"; 
	        System.out.println(merge(s1, s2)); 
	}

	public static String merge(String s1, String s2) 
    { 
        StringBuilder finalString = new StringBuilder(); 
  
         /*append character to final string from the two strings  */
        int i = 0, j = 0; 
        while (i < s1.length() && j < s2.length()) { 
          //  alternatively
            finalString.append(s1.charAt(i++)); 
            finalString.append(s2.charAt(j++)); 
        }

	/*
	 * check if both the strings are traversed and if not then append remainder of
	 * that string to the final string
	 */
	if(i!=s1.length())

	{
		finalString.append(s1.substring(i));
	}if(j!=s2.length())
	{
		finalString.append(s2.substring(j));
	}return finalString.toString();
}}
