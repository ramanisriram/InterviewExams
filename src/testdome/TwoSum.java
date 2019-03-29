package testdome;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
    	int[] dumList = list;
    	int[] finalRet = new int[2];
    	for(int i=0;i<list.length; i++) {
    		for(int j=0; j<dumList.length; j++) {
    			if(list[i] + list[j] == sum) {
    				finalRet[0] = i;
    				finalRet[1] = j;
    				break;
    			}
    		}
    		if(finalRet.length != 0) {
    			break;
    		}
    	}
        return finalRet;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 9, 4, 6, 7, 3}, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}