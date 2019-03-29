package oracle.simulator;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
	public static void main(String args[]) {
		List<String> site = new ArrayList<String>();
		site.add("ootooooooo");
		site.add("oooooooToo");
		site.add("rrrooooToo");
		site.add("rrrroooooo");
		site.add("rrrrrtoooo");
		List<String> input = new ArrayList<String>();
		input.add("a4");
		input.add("r");
		input.add("a4");
		input.add("l");
		input.add("a2");
		input.add("a4");
		input.add("l");
		input.add("q");
		int cost = 0;
		int fuel = 0;
		for(int i=0; i<site.size(); i++) {
			for(int j=0; j<input.size(); j++) {
				if(input.get(j).toString().startsWith("a")) {
					//advance
				} else if(input.get(j).toString().startsWith("r")) {
					//turn right
				} else if(input.get(j).toString().startsWith("l")) {
					//turn left
				}
			}
		}
	}
}