package CompareInterface;

import java.util.Arrays;
import java.util.Comparator;

public class SampleTest implements Comparator<Integer> {
	static Integer[] valArr = { 2, 10, 1 };

	public static void main(String args[]) {
		Arrays.sort(valArr, new SampleTest());

		for (Integer valArrTemp : valArr) {
			System.out.println("last:" + valArrTemp);
		}
	}
	
	
	public static void doTestsing() {
		Arrays.sort(valArr, new SampleTest());

		for (Integer valArrTemp : valArr) {
			System.out.println("last:" + valArrTemp);
		}
	}

	@Override
	//If this compare method returns +1 then the 2nd argument is considered as small.
	//So its placed first.
	//When this method returns -1, then the 1st argument is considered as small.
	public int compare(Integer a1, Integer a2) {
		System.out.println("Compare");
		System.out.println("a1:" + a1);
		System.out.println("a2:" + a2);
		System.out.println("Result:" + a2.compareTo(a1));
		System.out.println("------------------------");
		return a2.compareTo(a1);
	}

}
