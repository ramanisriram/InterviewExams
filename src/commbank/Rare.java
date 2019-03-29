package commbank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Rare {
	public static int nthMostRare(int[] elements, int n) {
		Map<Integer, Long> rareMap = Arrays.stream(elements).boxed()
				.collect(groupingBy(Function.identity(), counting()))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
		List<Long> rareOc = rareMap.entrySet().stream()
				.map(Map.Entry::getValue).distinct()
				.collect(Collectors.toList());
		Optional<Map.Entry<Integer, Long>> rareResult = rareMap.entrySet()
				.stream()
				.filter(e -> e.getValue().intValue() == rareOc.get(n - 1)).findFirst();
		int finalResp = rareResult.get().getKey();
		return finalResp;
	}

	public static void main(String[] args) {
		int x = nthMostRare(new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 }, 2);
		System.out.println(x);
	}
}