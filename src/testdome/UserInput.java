package testdome;

public class UserInput {
    
    public static class TextInput {
    	public String valString = "";
    	public int chars = 0;
    	public void add(char c) {
    		valString += String.valueOf(c);
    		++chars;
    	}
    	public String getValue() {
    		return valString;
    	}
    }

    public static class NumericInput extends TextInput {
    	
    	public void add(char c) {
    		super.add(c);
    		String numRegex   = ".*[0-9].*";
    		String alphaRegex = ".*[a-zA-Z].*";
    		String tempChar = String.valueOf(c);
    		if(super.valString.matches(alphaRegex)) {
    			super.valString = super.valString.replace(tempChar, "");
    		}
    	}
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}