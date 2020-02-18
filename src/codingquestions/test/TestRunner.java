package codingquestions.test;

import org.junit.runner.notification.Failure;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestRunner {
	public static void main(String args[]) {
		TestSuite suites = new TestSuite(ArrAndStr1Test1.class, ArrAndStr1Test2.class);
		TestResult result = new TestResult();
		suites.run(result);
		System.out.println("Number of test cases = " + result.runCount() + ":" +  result.errorCount() + ":");
		
	}
}