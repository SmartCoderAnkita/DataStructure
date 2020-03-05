package LinkedList_DS;

import java.util.Stack;

/*Can we reverse a linked list in less than O(n)?
It doesn’t look possible to reverse a simple singly linked list. A simple singly linked list can only be reversed in O(n) time using recursive and iterative methods.*/
public class LinkedListReverse {
	private static Node head;
	static LinkedList1 list1 = new LinkedList1();

	private void getStart() {
		try {
			System.out.println("Initial head started at = " + head.getData());
			head = reverse(head);
			// Time Complexity: O(n)
			// Space Complexity: O(1)
			list1.traversal(head);
			head = reverseUtil(head, null);
			list1.traversal(head);
			head = Reverse(head);
			list1.traversal(head);
			head = reverse(head, 2);
			list1.traversal(head);
			head = Reverse(head, 2);
			list1.traversal(head);
			head = reverseBySizeBy2(head);
			list1.traversal(head);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Recursively Reversing a linked list (A simple implementation) */
	Node Reverse(Node head) {
		if (head == null) {
			return head;
		}

		if (head.getNext() == null) {
			return head;
		}

		Node newHeadNode = reverse(head.getNext());

		// change references for middle chain
		head.getNext().setNext(head);
		head.setNext(null);

		return newHeadNode;
	}

	/* Function to reverse the linked list */
	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	/*
	 * A simple and tail recursive function to reverse a linked list. prev is passed
	 * as NULL initially.
	 */
	Node reverseUtil(Node curr, Node prev) {
		/* If last node mark it head */
		if (curr.getNext() == null) {
			head = curr;
			curr.setNext(prev);
			return head;
		}
		Node next1 = curr.getNext();
		curr.setNext(prev);
		reverseUtil(next1, curr);
		return head;
	}

	/* Reverse a Linked List in groups of given size */
	Node reverse(Node head, int k) {
		Node current = head;
		Node next = null;
		Node prev = null;

		int count = 0;

		while (count < k && current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count++;
		}

		if (next != null)
			head.setNext(reverse(next, k));

		return prev;
	}

	Node Reverse(Node head, int k) {
		// Create a stack of Node*
		Stack<Node> mystack = new Stack<Node>();
		Node current = head;
		Node prev = null;

		while (current != null) {

			// Terminate the loop whichever comes first
			// either current == NULL or count >= k
			int count = 0;
			while (current != null && count < k) {
				mystack.push(current);
				current = current.getNext();
				count++;
			}

			// Now pop the elements of stack one by one
			while (mystack.size() > 0) {

				// If final list has not been started yet.
				if (prev == null) {
					prev = mystack.peek();
					head = prev;
					mystack.pop();
				} else {
					prev.setNext(mystack.peek());
					prev = prev.getNext();
					mystack.pop();
				}
			}
		}

		// Next of last element will point to NULL.
		prev.setNext(null);
		return head;
	}

	/*
	 * Reverse a Linked List according to its Size Given a linked list with n nodes,
	 * reverse it in the following way :
	 * 
	 * If n is even, reverse it in group of n/2 nodes. If n is odd, keep the middle
	 * node as it is, reverse first n/2 elements and reverse last n/2 elements.
	 * Input : 1 2 3 4 5 6 (n is even) 
	 * Output : 3 2 1 6 5 4 
	 * Input : 1 2 3 4 5 6 7 (n * is odd) 
	 * Output : 3 2 1 4 7 6 5
	 */
	// Function to reverse the linked list according to its size
	Node reverseSizeBy2Util(Node head, int k, boolean skipMiddle) {
		if (head == null)
			return null;

		int count = 0;
		Node curr = head;
		Node prev = null;
		Node next = null;

		// Reverse current block of list.
		while (curr != null && count < k) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;
			count++;
		}

		// If size is even, reverse next block too.
		if (!skipMiddle)
			head.setNext(reverseSizeBy2Util(next, k, false));

		else {

			// if size is odd, skip next element
			// and reverse the block after that.
			head.setNext(next);
			if (next != null)
				next.setNext(reverseSizeBy2Util(next.getNext(), k, true));
		}
		return prev;
	}

	Node reverseBySizeBy2(Node head) {
		// Get the size of list.
		int n = list1.listLength(head);

		// If the size is even, no need to skip middle Node.
		if (n % 2 == 0)
			return reverseSizeBy2Util(head, n / 2, false);

		// If size is odd, middle Node has
		// to be skipped.
		else
			return reverseSizeBy2Util(head, n / 2, true);
	}

	public static void main(String[] args) {
		LinkedListReverse list = new LinkedListReverse();
		head = list1.createList(head);
		System.out.println("Initial List");
		list1.traversal(head);
		list.getStart();
	}

}
