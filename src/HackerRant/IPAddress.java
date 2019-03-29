package HackerRant;

import java.util.Scanner;

public class IPAddress {
	public static void main(String args[]) {
		Scanner inpSc = new Scanner(System.in);
		String inputIPadd = inpSc.next();
		String validFormat = ".*[0-9].*";
		String[] cops = inputIPadd.split("\\.");
		
		boolean allGood = true;
		if(inputIPadd.endsWith(".") || inputIPadd.startsWith(".")) {
			allGood = false;
		} else if(cops.length != 4) {
			allGood = false;
		} else {
			for(int i=0; i<cops.length; i++) {
				if(Integer.parseInt(cops[i]) > 255 || Integer.parseInt(cops[i]) < 0) {
					allGood = false;
					break;
				} else if(!cops[i].matches(validFormat)) {
					allGood = false;
					break;
				}
			}
		}
		System.out.println(allGood);
		inpSc.close();
	}
}