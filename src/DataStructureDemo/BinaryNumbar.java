/*You are given a set of binary elements. You have to eliminate the binary numbers that contain 11 as a substring. The resultant sequence will be 1, 10, 100, 101, 1000, and so on.

You are required to generate the code to determine the  value of the new sequence.

Input format

First line:  denoting the number of test cases
Next  lines: A single integer 
Output format

Print  lines representing the code to display the  value.

Constraints



SAMPLE INPUT 
2
3
9
SAMPLE OUTPUT 
100
10001*/

package DataStructureDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryNumbar {

	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(System.in);
			int size = s.nextInt(); // Reading input from STDIN
			int[] arr = new int[size];
			for (int i = 0; i < size; i++) {
				arr[i] = s.nextInt();
			}
			ArrayList<String> list = new ArrayList<>();
			String bin = "";
			int count = 1, i = 1;
			for (int j = 0; j < size; j++) {
				count = list.size()==0?1:list.size()+1;
				if(list.size() >= arr[j]) {
					//System.out.println("exist "+list.get(arr[j]-1));
					bin = list.get(arr[j]-1);
				}else {
				
				while (arr[j] >= count) {
					if (!Integer.toBinaryString(i).contains("11")) {
						bin = Integer.toBinaryString(i);
						list.add(bin);
//						System.out.println(i+"->  "+count+"  "+bin);
						count++;
					}
					i++;
				} //System.out.println("new "+bin);
				}System.out.println(bin);
//				System.out.println(bin);
			}
//			System.out.println("Size Array "+ list.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
