package commbank;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class Rare2 {
   public static  List<Map.Entry<Integer, Long>> nthMostRare(int[] elements, int n) {      
   	Map<Integer, Long> sortedMap =
               Arrays.stream(elements).boxed()
                     .collect(groupingBy(Function.identity(), counting())).entrySet().stream()
                     .sorted(Map.Entry.comparingByValue())
                     .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (k, v) -> k, LinkedHashMap::new));
       List<Long> occurrences =
               sortedMap.entrySet().stream()
                        .map(Map.Entry::getValue)
                        .distinct().collect(Collectors.toList());
       return sortedMap.entrySet().stream()
               .filter(e -> e.getValue().intValue() == occurrences.get(n-1)).collect(Collectors.toList());
     }

   public static void main(String[] args) {
       int[] x = { 5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5 };
       nthMostRare(x, 2).stream().map(Map.Entry::getKey).forEach(System.out::println);
   }
}