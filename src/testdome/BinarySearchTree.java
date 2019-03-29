class Node {
	public int value;
	public Node left, right;

	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
}

public class BinarySearchTree {
	public static boolean contains(Node root, int value) {
		Node tempNode = null;
		boolean leftVal = false;
		// first check the root node itself
		if (root != null && root.value == value)
			leftVal = true;

		// check left node
		if (!leftVal) {
			if (root.left != null) {
				leftVal = contains(root.left, value);
			} else {
				tempNode = root;
			}
			if (tempNode != null && tempNode.value == value)
				leftVal = true;
		}
		// Check right node
		if (!leftVal) {
			if (root.right != null) {
				leftVal = contains(root.right, value);
			} else {
				tempNode = root.right;
			}
			if (tempNode != null && tempNode.value == value)
				leftVal = true;
		}

		return leftVal;
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null, null);
		Node n3 = new Node(3, null, null);
		Node n2 = new Node(2, n1, n3);
		Node n4 = new Node(4, null, null);
		Node n6 = new Node(6, null, null);
		Node n5 = new Node(5, n4, n6);
		Node n7 = new Node(7, n2, n5);

		System.out.println(contains(n7, 2));
	}
}