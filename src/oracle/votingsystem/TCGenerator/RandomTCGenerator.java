package oracle.votingsystem.TCGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import oracle.votingsystem.VoteCounterMain;

public class RandomTCGenerator {
	public static void main(String args[]) {
		Random r = new Random();
		int noOfVotes = 100;
		int maxNoOfPref = 20;
		String inputCandidates = "ABCDEFGHIJKLMNOPQRST";
		List testCaseData = new ArrayList();
		String dummyData = null;
		for(int j=0; j<noOfVotes; j++) {
			
		    int leftLimit = 97; // letter 'a'
		    int rightLimit = 116; // letter 't'
		    int targetStringLength = 10;
		    Random random = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int i = 0; i < targetStringLength; i++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    char[] chars = buffer.toString().toUpperCase().toCharArray();
			
			Set<Character> charSet = new LinkedHashSet<Character>();
			for (char c : chars) {
			    charSet.add(c);
			}
	
			StringBuilder sb = new StringBuilder();
			for (Character character : charSet) {
			    sb.append(character);
			}
			System.out.print("String is :"+sb.toString());
			testCaseData.add(sb.toString());
			System.out.print("\n");
		}
		
		VoteCounterMain.performVoting(testCaseData);
	}
}