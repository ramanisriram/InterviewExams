package atlassian.prep;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private String name;
	private int id;
	private String parentorchild;
	private List<Node> children = new ArrayList<Node>();
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getParentorchild() {
		return parentorchild;
	}
	public void setParentorchild(String parentorchild) {
		this.parentorchild = parentorchild;
	}
	
}