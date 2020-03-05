package LinkedList_DS;

public class NthNodeFromEnding {
	/* Function to get the nth node from the last of a linked list */
	void printNthFromLast(Node head, int n) {
		int len = 0;
		Node temp = head;

		// 1) count the number of nodes in Linked List
		while (temp != null) {
			temp = temp.getNext();
			len++;
		}

		// check if value of n is not more than length of
		// the linked list
		if (len < n)
			return;

		temp = head;

		// 2) get the (len-n+1)th node from the beginning
		for (int i = 1; i < len - n + 1; i++)
			temp = temp.getNext();

		System.out.println(temp.getData());
	}

	/* Function to get the nth node from end of list */
	void printNthFromLast2(Node head, int n) {
		Node main_ptr = head;
		Node ref_ptr = head;

		int count = 0;
		if (head != null) {
			while (count < n) {
				if (ref_ptr == null) {
					System.out.println(n + " is greater than the no " + " of nodes in the list");
					return;
				}
				ref_ptr = ref_ptr.getNext();
				count++;
			}
			while (ref_ptr != null) {
				main_ptr = main_ptr.getNext();
				ref_ptr = ref_ptr.getNext();
			}
			System.out.println("Node no. " + n + " from last is " + main_ptr.getData());
		}
	}
}
