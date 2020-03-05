package LinkedList_DS;

public class LinkedListSwapNodes {

	/* Function to swap Nodes x and y in linked list by changing links */
	public void swapNodes(Node head,int x, int y) {
		if (x == y)
			return;

		Node prevX = null, currX = head;
		while (currX != null && currX.getData() != x) {
			prevX = currX;
			currX = currX.getNext();
		}

		Node prevY = null, currY = head;
		while (currY != null && currY.getData() != y) {
			prevY = currY;
			currY = currY.getNext();
		}

		if (currX == null || currY == null)
			return;

		if (prevX != null)
			prevX.setNext(currY);
		else
			head = currY;

		if (prevY != null)
			prevY.setNext(currX);
		else
			head = currX;

		// Swap next pointers
		Node temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
	}

	/* Function for swapping kth nodes from both ends of 
    linked list */
 public void swapKth(Node head,int k) 
 { 
     // Count nodes in linked list 
	 int n = 0; 
     Node s = head; 
     while (s != null) 
     { 
         n++; 
         s = s.getNext(); 
     } 

     // Check if k is valid 
     if (n < k) 
         return; 

     // If x (kth node from start) and y(kth node from end) 
     // are same 
     if (2*k - 1 == n) 
         return; 

     // Find the kth node from beginning of linked list. 
     // We also find previous of kth node because we need 
     // to update next pointer of the previous. 
     Node x = head; 
     Node x_prev = null; 
     for (int i = 1; i < k; i++) 
     { 
         x_prev = x; 
         x = x.getNext(); 
     } 

     // Similarly, find the kth node from end and its  
     // previous. kth node from end is (n-k+1)th node 
     // from beginning 
     Node y = head; 
     Node y_prev = null; 
     for (int i = 1; i < n - k + 1; i++) 
     { 
         y_prev = y; 
         y = y.getNext(); 
     } 

     // If x_prev exists, then new next of it will be y. 
     // Consider the case when y->next is x, in this case, 
     // x_prev and y are same. So the statement  
     // "x_prev->next = y" creates a self loop. This self 
     // loop will be broken when we change y->next. 
     if (x_prev != null) 
         x_prev.setNext(y); 

     // Same thing applies to y_prev 
     if (y_prev != null) 
         y_prev.setNext(x); 

     // Swap next pointers of x and y. These statements 
     // also break self loop if x->next is y or y->next 
     // is x 
     Node temp = x.getNext(); 
     x.setNext(y.getNext()); 
     y.setNext(temp); 

     // Change head pointers when k is 1 or n 
     if (k == 1) 
         head = y; 

     if (k == n) 
         head = x; 
 } 
}
