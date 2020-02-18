import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestRunner {
	public static void main(String[] args) {
		TestSuite suite = new TestSuite(AllTests.class);
		TestResult result = new TestResult();
		suite.run(result);
		System.out.println("Number of test cases = " + result.runCount());
	}
}