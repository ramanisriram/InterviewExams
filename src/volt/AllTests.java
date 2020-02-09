package volt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import volt.RomanNumbers;

public class AllTests {
	
	@Test
    public void testBoundaryCase1() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("Invalid Input", testObj.convertIntegerToRoman(-1));
    }
	
	@Test
	public void testBoundaryCase2() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("Invalid Input", testObj.convertIntegerToRoman(3001));
    }
	
	@Test
	public void testBoundaryCase3() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("Invalid Input", testObj.convertIntegerToRoman(0));
    }
	
	@Test
	public void testProperValue() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("X",testObj.convertIntegerToRoman(1000));
    }
	
	@Test
	public void userTest1() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("XVLLLLOMMMM",testObj.convertIntegerToRoman(1990));
    }
	
	@Test
	public void userTest2() {
        RomanNumbers testObj = new RomanNumbers();
        assertEquals("MMMM",testObj.convertIntegerToRoman(40));
    }
	
}
