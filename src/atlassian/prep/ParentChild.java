package atlassian.prep;
import java.util.function.Consumer;

public class ParentChild {

	public Node createparentchildtree(String name, String parentchild, int i) {
		Node node = new Node();
		node.setName(name);
		node.setParentorchild(parentchild);
		node.setId(++i);
		return node;
	}
	
	public static void main(String args[]) {
		String input = "PP15C1C2C3C4C5PP22C1"
	}

	public void displayResult(Node node) {
		
		Consumer<Node> printcons = p -> {
			System.out.println(p.getName());
			Consumer<Node> printcons1 = q -> {
				System.out.println(q.getName());
			};
			if(p.getChildren().size() != 0) {
				p.getChildren().stream().forEach(printcons1);
			}
		};
		node.getChildren().stream().forEach(printcons);

	}
}