package testdome;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TrainComposition {
	LinkedList train = new LinkedList();
    public void attachWagonFromLeft(int wagonId) {
        if(train.size() == 0) {
        	train.add(new Integer(wagonId));
        } else {
        	train.addFirst(new Integer(wagonId));
        }
    }

    public void attachWagonFromRight(int wagonId) {
    	if(train.size() == 0) {
        	train.add(new Integer(wagonId));
        } else {
        	train.addLast(new Integer(wagonId));
        }
    }

    public int detachWagonFromLeft() {
    	int item = (int) train.getFirst();
        train.removeFirst();
        return item;
    }

    public int detachWagonFromRight() {
    	int item = (int) train.getLast();
    	train.removeLast();
    	return item;
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        //System.out.println(tree.detachWagonFromRight()); // 7 
        //System.out.println(tree.detachWagonFromLeft()); // 13
        for(int i=0; i<tree.train.size(); i++) {
        	System.out.println(tree.train.get(i));
        }
    }
}