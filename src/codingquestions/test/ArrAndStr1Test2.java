package codingquestions.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import codingquestions.arraysandstrings.ArrAndStr1;

@RunWith(Parameterized.class)
public class ArrAndStr1Test2 {
	String input_str;
	String output_str;
	private ArrAndStr1 arrandstr;
	
	@Before
	public void initialize() {
		arrandstr = new ArrAndStr1();
	}
	
	public ArrAndStr1Test2(String input, String expected_output) {
		this.input_str = input;
		this.output_str = expected_output;
	}
	
	@Parameterized.Parameters
	public static Collection passAndTestArrStr() {
		return Arrays.asList(new Object[][] {
			{"abc","String has unique characters"},
			{"hajsdkahsd","String does not have unique characters"},
			{"sriram","String does not have unique characters"},
			{"jaichu","String has unique characters"},
			{"sumanth","String has unique characters"},
			{"todo","String does not have unique characters"},
			{"test","String does not have unique characters"}
		});
	}
	
	@Test
	public void testProperValues() {
		assertEquals(output_str, arrandstr.findStringHasUnique(input_str));
	}
}