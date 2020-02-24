package DataStructureDemo;

import java.util.*;

public class BinaryQueries {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		String ip1 = s.nextLine(); // Reading input from STDIN
		int arrIdx = 0, test = 0;
		String[] c = ip1.split(" ");
		arrIdx = Integer.parseInt(c[0]);
		test = Integer.parseInt(c[1]);
		System.out.println("arraIdx= " + arrIdx + "  test= " + test);

		String arrStr = s.nextLine(); // Reading input from STDIN
		String[] arr = arrStr.split(" ");
		System.out.println("arra= ");
		for (String s1 : arr) {
			System.out.print(s1 + ",");
		}

		for (int i = 0; i <= test; i++) {
			String test1 = s.nextLine(); // Reading input from STDIN
			System.out.println(i + "test= " + test1); // Writing output to STDOUT
		}
	}
}
