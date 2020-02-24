package LinkedList_DS;

public class RotateLinkedList {
	private Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node rotateList(Node head, int k) {
			if (k == 0) return head; 
	        Node current  = head; 
	        int count = 1; 
	        while (count < k && current !=  null) 
	        { 
	            current = current.getNext(); 
	            count++; 
	        } 
	        if (current == null) 
	            return head; 
	        Node kthNode = current; 
	        while (current.getNext() != null) 
	            current = current.getNext(); 
	        current.setNext(head); 
	        head = kthNode.getNext(); 
	        kthNode.setNext(null); 
	        return head;
		}
  
}
