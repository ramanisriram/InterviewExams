package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1 {
	public static void main(String args[]) {
		List inner1 = new ArrayList();
		inner1.add(1);
		inner1.add(2);
		List inner2 = new ArrayList();
		inner2.add(3);
		inner2.add(4);
		List inner3 = new ArrayList();
		inner3.add(-1);
		inner3.add(1);
		List outer = new ArrayList();
		outer.add(inner1);
		outer.add(inner2);
		outer.add(inner3);

		closestDesti(3, outer, 2);
	}

	static List<List<Integer>> closestDesti(int numDestination, List<List<Integer>> allLocation, int numDeliveries) {
		List<Integer> values = null;
		Map<Integer, List<Integer>> map = new HashMap();
		int tmpvalue = 0;
		List<Integer> anoList = new ArrayList();
		for (List outer : allLocation) {
			int sqvalue = (int) Math.round((Math.pow(Integer.valueOf(outer.get(0).toString()), 2)
					+ (Math.pow(Integer.valueOf(outer.get(1).toString()), 2))));
			values = new ArrayList();
			values.add(Integer.valueOf(outer.get(0).toString()));
			values.add(Integer.valueOf(outer.get(1).toString()));
			anoList.add(sqvalue);
			map.put(sqvalue, values);
		}
		
		List<Integer> anoListSub = new ArrayList();
		List<List<Integer>> finishedList = new ArrayList();
		
		Collections.sort(anoList);
		
		anoListSub = anoList.subList(0, numDeliveries);
		
		
		for(int k=0;k<numDeliveries;k++) {
			finishedList.add(map.get(anoListSub.get(k)));
		}
		
		System.out.println("finishedList:"+finishedList);

		return finishedList;
	}
}