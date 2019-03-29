package testdome;

public class Palindrome {
    public static boolean isPalindrome(String word) {
        String anoWord = "";
        for(int i=word.length()-1; i>=0; i--) {
        	anoWord += word.charAt(i);
        }
        System.out.println("anoWord:" + anoWord);
        return word.equalsIgnoreCase(anoWord);
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}