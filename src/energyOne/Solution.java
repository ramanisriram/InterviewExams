package energyOne;

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		try {
			Solution inst = new Solution();
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
					items[j] = Integer
							.parseInt(arrElements.get(i).split(" ")[j]);
				}

				int visitedIt = 0;
				for (int k = 0; k < items.length;) {
					if (items[k] == 0) {
						if (items[k + nm[1]] == 0) {
							visitedIt = k;
							k = k + nm[1];
						} else {
							if(items[k + 1] == 0) {
								visitedIt = k;
								k = k + 1;
								continue;
							} else {
								if(k!= 0 && items[k - 1] == 0 && (k - 1 != visitedIt)) {
									visitedIt = k;
									k = k - 1;
									continue;
								} else {
									System.out.println("NO");
									break;
								}
							}
						}
					} else {
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
