package MacquireBank;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("jjaisudha");
		list.add("jjsriram");
		list.add("kkramani");
		list.stream().filter(s->s.startsWith("jj")).forEach(System.out::println);
	}
}
