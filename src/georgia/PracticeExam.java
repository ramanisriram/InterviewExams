package georgia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeExam<S> {
	
	int x = 5;
	public static void main(String args[]) {
		int x = 6;
		x = ~x;
		System.out.println(x);
		
		x = x >> 1;
		System.out.println(x);
		
		int gh = -1;
		System.out.println("gh:");
		System.out.println(gh >>> 0);
		
		PracticeExam b = new PracticeExam();
		System.out.println(b.x);
		
		String b1 = "green";
		String b2 = "maroon";
		System.out.println(b1.compareTo(b2));
		
		
		System.out.println(
		Stream.of("maroon","green","blue").max((s1, s2) -> s1.compareTo(s2))
				.filter(s -> s.endsWith("n")).orElse("yellow"));
		
		//Date time
		YearMonth ym1 = YearMonth.of(2015, Month.SEPTEMBER);
		YearMonth ym2 = YearMonth.of(2016, Month.FEBRUARY);
		
		System.out.println(ym1.until(ym2, ChronoUnit.MONTHS));
		System.out.println(ym1.minus(Period.ofMonths(4)).getMonthValue());
		
		//doThis();
		
		Class c = b.getClass();
		try {
			System.out.println(c.getMethod("getNumber", null).toString());
			System.out.println(c.getDeclaredMethod("setNumber", null).toString());
		} catch (NoSuchMethodException | SecurityException e) {}
		
		/*try {
			BufferedReader a = new BufferedReader(new FileReader("input.dat"));
			FileReader cv = new FileReader("input.dat");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Supplier<String> i = () -> "Car";
		Consumer<String> cx = y -> System.out.print(y.toLowerCase());
		Consumer<String> dx = y -> System.out.print(y.toUpperCase());
		cx.andThen(dx).accept(i.get());
		System.out.println();
		
		
		String first = "first";
		String second = new String("first");
		"first".concat(second);
		System.out.println(first.equals(second));
		System.out.println(first == second);
		System.out.println(first.equals("firstSecond"));
		System.out.println(second == "first");
		
		int xhe = 1000000000;
		System.out.println(xhe);
		
		Stream.of("1red","2red","3red").findFirst().map(String::toLowerCase).ifPresent(System.out::println);
		Stream.of("1red","2red","3red").anyMatch(s -> {System.out.println(s); return s.startsWith("1");});
		
		IntStream.range(1,2).mapToObj(k -> k + "red").forEach(System.out::println);
		
		populate(ArrayList::new, "Read", "Blue", "Green");
		//Stream.of('0','1').forEach(output::write);
		Locale local = new Locale("USA");
		System.out.println("asda:"+local.getCountry());
		
		int j = 0;
		int ac[] = {2,4};
		do for(int q : ac)
			System.out.println(q + " ");
		while (j++ < 1);
		
		
		System.out.println("doint");
		System.out.println(Year.isLeap(2016));
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		int days = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
		System.out.println(days > 365);
		
		cal.set(2016, 1, 1);
		days = cal.getMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(days == 29);
		
		String[] arr = {"Jai", "su"};
		
		String ab = Stream.of(arr).collect(Collectors.joining(""));
		System.out.println(ab);
		
		String[] arr1 = {"Jai","sssssuuuu"};
		Stream<String> str= Arrays.stream(arr1);
		System.out.println(str.map(s->s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.joining()));
	}
	
	private static void populate(Supplier<List> cons, String... colors) {
		List l = cons.get();
		for(int i=0; i<colors.length;i++) {
			l.add(colors[i]);
		}
		System.out.println(l);
	}

	public static void main() {
		System.out.println("hello");
	}
	
	public Integer getNumber() {
		return 2;
	}
	
	public void setNumber(Integer n) {
		
	}
	
	public static void doThis() {
		System.out.println("chceck");
		throw new NullPointerException();
	}
	
	
}