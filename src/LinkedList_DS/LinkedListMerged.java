package LinkedList_DS;

public class LinkedListMerged {

	public Node sortedMerge(Node headA, Node headB) {
		Node dummyNode = new Node(0);
		Node tail = dummyNode;
		while (true) {
			if (headA == null) {
				tail.setNext(headB);
				break;
			}
			if (headB == null) {
				tail.setNext(headA);
				break;
			}
			if (headA.getData() <= headB.getData()) {
				tail.setNext(headA);
				headA = headA.getNext();
			} else {
				tail.setNext(headB);
				headB = headB.getNext();
			}
			tail = tail.getNext();
		}
		return dummyNode.getNext();
	}

	// Create new linked list from two given linked list with greater element at each node
	/*
	 * Input: list1 = 5->2->3->8 list2 = 1->7->4->5 Output: New list = 5->7->4->8
	 * 
	 * Input: list1 = 2->8->9->3 list2 = 5->3->6->4 Output: New list = 5->8->9->4
	 */
	static Node newList(Node root1, Node root2)  
	{  
	    Node ptr1 = root1, ptr2 = root2, ptr;  
	    Node root = null, temp;  
	  
	    while (ptr1 != null) {  
	        temp = new Node();  
	        temp.setNext(null);  
	  
	        // Compare for greater node  
	        if (ptr1.getData() < ptr2.getData())  
	            temp.setData(ptr2.getData());  
	        else
	            temp.setData(ptr1.getData()); 
	  
	        if (root == null)  
	            root = temp;  
	        else {  
	            ptr = root;  
	            while (ptr.getNext() != null)  
	                ptr = ptr.getNext();  
	  
	            ptr.setNext(temp);  
	        }  
	        ptr1 = ptr1.getNext();  
	        ptr2 = ptr2.getNext();  
	    }  
	    return root;  
	}  
}
