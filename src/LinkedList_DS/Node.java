package LinkedList_DS;

public class Node {
	private int data;
	private Node next;

	Node(int d) {
		data = d;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
