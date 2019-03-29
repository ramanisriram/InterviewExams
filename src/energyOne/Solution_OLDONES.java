package energyOne;

import java.util.*;

public class Solution_OLDONES {
	public static void main(String[] args) {
		try {
			Solution_OLDONES inst = new Solution_OLDONES();
			Scanner input = new Scanner(System.in);
			List<String> lines = new ArrayList<String>();
			String lineNew;
			while (input.hasNextLine()) {
				lineNew = input.nextLine();
				if (lineNew.isEmpty()) {
					break;
				}
				lines.add(lineNew);
			}
			inst.parseInput(lines);
			inst.performMovement();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void performMovement() {
		for (int i = 0; i < noTc; i++) {
			try {
				int[] nm = null;

				nm = new int[2];
				nm[0] = Integer.parseInt(lenJump.get(i).split(" ")[0]);
				nm[1] = Integer.parseInt(lenJump.get(i).split(" ")[1]);

				int[] items = null;
				int listCnt = 0;

				listCnt = arrElements.get(i).split(" ").length;
				items = new int[listCnt];

				for (int j = 0; j < listCnt; j++) {
					items[j] = Integer.parseInt(arrElements.get(i).split(" ")[j]);
				}

				boolean backwardCheck = false;
				boolean forwardCheck = false;
				int numJump = 999;
				for (int k = 0; k < items.length;) {
					if (items[k] == 0) {
						if (k == (items.length - 1)) {
							System.out.println("YES");
							break;
						}
						if (items[k + nm[1]] == 0 && numJump != k) {
							forwardCheck = false;
							backwardCheck = false;
							numJump = k;
							k = k + nm[1];
							continue;
						} else {
							// System.out.println("Check k:" + k);
							if (!forwardCheck && items[k + 1] == 0) {
								backwardCheck = true;
								forwardCheck = false;// so that the next item can proceed forward and not backward
								k = k + 1;
								continue;
							} else {
								forwardCheck = true;// done with forward check for this item. so set it true
							}
							if (!backwardCheck && k != 0 && items[k - 1] == 0) {
								k = k - 1;
								backwardCheck = false;// so that the next item can do a back ward check
								forwardCheck = true;// need not go forward, for the previous item need not read the
													// forward item
								continue;
							} else {
								backwardCheck = true;
							}
						}
					} else {
						if (backwardCheck && forwardCheck) {
							System.out.println("NO");
							break;
						} else {
							k = k + 1;
						}
					}
					if ((backwardCheck && forwardCheck) || !(backwardCheck && forwardCheck)) {
						System.out.println("NO");
						break;
					}
				}
			} catch (ArrayIndexOutOfBoundsException er) {
				System.out.println("YES");
			}
		}
	}

	List<String> lenJump = null;
	List<String> arrElements = null;
	int noTc = 0;

	public void parseInput(List<String> inpLines) throws Exception {
		noTc = Integer.parseInt(inpLines.get(0));
		lenJump = new ArrayList<String>();
		arrElements = new ArrayList<String>();
		for (int i = 1; i < inpLines.size(); i++) {
			if (i % 2 == 0)
				arrElements.add(inpLines.get(i));
			else
				lenJump.add(inpLines.get(i));
		}
	}
}
