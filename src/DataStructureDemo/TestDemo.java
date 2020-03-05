package DataStructureDemo;

import LinkedList_DS.*;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] l = new Object[10];
		l[0] = "String";
		l[1] = 12;
		System.out.println(l[0]);
		System.out.println(l[1]);
		
		Node head = null;
		try {
		LinkedList1 list1 = new LinkedList1();
		head = list1.createList(head);
		list1.traversal(head);
		System.out.println(list1.getRecursiveCount(head));
		list1.deleteValue(head,3);
		list1.deleteAtPosition(head,2,33);
		list1.traversal(head);
		
		//Swipe Node
		LinkedListSwapNodes swap = new LinkedListSwapNodes();
		swap.swapNodes(head,33,37);
		list1.traversal(head);
		
		//Merge Sort List
		LinkedListMerged list = new LinkedListMerged();
		LinkedList1 list11 = new LinkedList1();
		LinkedList1 list22 = new LinkedList1();
		Node list1_head = null, list2_head = null;
		list1_head = list11.createList(list1_head);
		list2_head = list22.createList(list2_head);
		System.out.println("Initial List");
		list11.traversal(list1_head);
		list22.traversal(list2_head);
		head = list.sortedMerge(list1_head, list2_head);
		System.out.println("Merged List");
		list1.traversal(head);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
