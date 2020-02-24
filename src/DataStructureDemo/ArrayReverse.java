package DataStructureDemo;

import java.util.Scanner;
import java.util.stream.IntStream;

public class ArrayReverse {

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
	        int size = s.nextInt();                 // Reading input from STDIN
	        int arr[] = new int[size];
	        for(int i=0;i<size;i++){
	            arr[i] = s.nextInt();
	        }
	    long[] res= IntStream.range(0, size).mapToLong(i -> arr[size-1-i]).toArray();
	    for (long object : res) {
	    	 System.out.println(object);
		}
	   
	}
	
}
