import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atlassian.prep.Node;
import atlassian.prep.ParentChild;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	ParentChild obj = null;
	protected String value1;

	protected void setUp() {
		System.out.println("in setup");
		value1 = "init";
		obj = new ParentChild();
	}

	@Test
	public void testAdd() {
		Node result = obj.createparentchildtree("page1", "child", 0);
		assertTrue(result.getName().equals("page1"));
		countTestCases();
		System.out.println(getName());
	}
	
	@After
	protected void teadDown() {
		value1 = "end";
		obj = null;
	}
	
	
}
