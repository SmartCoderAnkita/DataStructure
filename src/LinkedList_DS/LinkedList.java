package LinkedList_DS;

public class LinkedList {
	private Node head;

	private void getStart() {
		try {
			// 1.
			createList(head);
			traversal(head);
			// 2.
			insertAtBegining(0);
			traversal(head);
			// 3.
			insertAtEnding(4);
			traversal(head);
			// 4.
			insertAtPosition(6, 5);// (position,value)
			traversal(head);
			// 5.
			deleteAtPosition(5, 33);// (position,value)
			traversal(head);
			// 6.
			deleteValue(3);
			traversal(head);
			// 7.
			System.out.println("Logic 1 | List length using Recursive method = " + listLength());
			System.out.println("Logic 2 | List length = " + listLength(head));
			// 8.
			int value = 2;
			System.out.println("Logic 1 | Searched element " + value + " is present = " + searchElement(value));
			System.out.println("Logic 2 | Searched element " + value + " is present using Recursion = "
					+ searchElement(head, value));
			// 9.
			int index = 6;
			System.out.println("Nth index element where index is " + index + " and value = " + NthIndexElement(index));
			// 10.
			System.out.println("Logic 1 | Middle element of list is " + midleElementOfList());
			System.out.println("Logic 2 | Middle element of list is " + midleElementOfList());
			// 11.
			System.out.println(
					"Logic 1 | Searched element " + value + " is present = " + countOfGivenElement(value) + " times");
			System.out.println("Logic 2 | Searched element " + value + " is present = "
					+ countOfGivenElement(head, value) + " times");
			// 110.
			deleteList();
			System.out.println("List Deleted " + (listLength() == 0 ? "YES" : "NO"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int countOfGivenElement(Node temp, int value) {
		if (temp == null)
			return 0;
		if (temp.getData() == value)
			return 1 + countOfGivenElement(temp.getNext(), value);
		
			return countOfGivenElement(temp.getNext(), value);
	}

	private int countOfGivenElement(int value) {
		int round = 0;
		Node temp = head;
		while (temp != null) {
			if (value == temp.getData())
				round++;
			temp = temp.getNext();
		}
		return round;
	}

	private String midleElementOfList() {
		int l = listLength(), round = 0;
		Node temp = head;
		if (l == 0)
			return "List Not Present";
		while (temp != null && round != l / 2) {
			temp = temp.getNext();
			++round;
		}

		return String.valueOf(temp.getData() + " at index " + round);
	}

	private String midleElementOfList2() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if (head != null) {
			while (fast_ptr != null && fast_ptr.getNext() != null) {
				fast_ptr = fast_ptr.getNext().getNext();
				slow_ptr = slow_ptr.getNext();
			}
			return String.valueOf(slow_ptr.getData());
		} else
			return "List Not Present";
	}

	private String NthIndexElement(int i) {
		Node temp = head;
		int index = 0;
		while (temp != null && index != i) {
			temp = temp.getNext();
			++index;
		}
		if (temp == null)
			return "No data found.";
		else
			return temp.getData() + "";
	}

	private boolean searchElement(Node node, int value) {
		if (node == null)
			return false;

		if (node.getData() == value)
			return true;
		return searchElement(node.getNext(), value);
	}

	private boolean searchElement(int element) {
		Node n = head;
		while (n != null && n.getData() != element) {
			n = n.getNext();
		}
		return (n.getData() == element) ? true : false;
	}

	private void deleteList() {
		head = null;
	}

	private void deleteAtPosition(int position, int key) {
		Node n = head, n_prv = null;
		int postionCount = 0;
		if (n == null)
			return;
		while (n != null && key != n.getData() && postionCount != position) {
			n_prv = n;
			n = n.getNext();
			++postionCount;
		}
		if (n_prv == null)
			return;

		n_prv.setNext(n.getNext());
		System.out.println("Delete key " + key + " At Position " + position + " head=" + head.getData());
	}

	private void deleteValue(int i) {
		System.out.println("Delete all keys " + i + " head=" + head.getData());
		Node n = head, n_prv = null;
		if (n != null && n.getData() == i) {
			head = n.getNext(); // Changed head
			return;
		}
		while (n != null) {
			while (n != null && n.getData() != i) {
				n_prv = n;
				n = n.getNext();
			}
			if (n == null)
				return;
			n_prv.setNext(n.getNext());
			n = n_prv.getNext();
		}
	}

	private int listLength(Node head2) {
		int count = 0;
		Node temp = head2;
		while (temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	private int listLength() {
		return getRecursiveCount(head);
	}

	private int getRecursiveCount(Node node) {
		if (node == null)
			return 0;

		return 1 + getRecursiveCount(node.getNext());
	}

	private void insertAtPosition(int i, int key) {
		System.out.println("Add value " + key + " At Position " + i + " head = " + head.getData());
		Node n = head, n_prv = null;
		int l = 1;
		while (n != null && l != i) {
			n_prv = n;
			n = n.getNext();
			++l;
		}
		Node newNode = new Node(key);
		n_prv.setNext(newNode);
		newNode.setNext(n);
	}

	private void insertAtEnding(int i) {
		Node n = head;
		while (n.getNext() != null) {
			n = n.getNext();
		}
		Node newNode = new Node(i);
		n.setNext(newNode);
		System.out.println("Add at Ending head=" + head.getData());
	}

	private void insertAtBegining(int num) {
		Node new_node = new Node(num);
		new_node.setNext(head);
		head = new_node;
		System.out.println("Add at Bigining head=" + head.getData());
	}

	private void traversal(Node node) {
		Node n = node;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
		System.out.println();
	}

	private void createList(Node node2) {
		head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(33);
		Node n4 = new Node(3);
		head.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		System.out.println("Start head=" + head.getData());
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		list.getStart();
	}
}
