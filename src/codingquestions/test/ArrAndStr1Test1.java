package codingquestions.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import codingquestions.arraysandstrings.ArrAndStr1;

class ArrAndStr1Test1 {
	//check null input
	//check for numbers also
	//test combo of nos and characters
	//how about special characters ?
	
	ArrAndStr1 obj = null;
	
	@BeforeClass
	void initializeObj() {
		obj = new ArrAndStr1();
	}
	
	@Test
	void checkNullInput() {
		assertTrue("Null not allowed".equals(obj.findStringHasUnique(null)));
	}
	

}