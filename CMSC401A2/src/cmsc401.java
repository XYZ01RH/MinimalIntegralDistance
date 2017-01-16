//import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author riley hanson
 *
 */
public class cmsc401 {
	private static Scanner in;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
		int size;
		int[] a;
		//int min;
		
		System.out.println("Enter the number of terms");
		size = in.nextInt();
		if(size == 0) {
			System.err.println("Invalid input size.");
			System.exit(0);
		}
		a = new int[size];
		
		for(int i = 0; i < size; i++) {
			a[i] = in.nextInt();
		}
		
		int first = 0;
		int last = a.length - 1;
		quickSort(a, first, last);
		//System.out.println(Arrays.toString(a));
		minIntDist(a, size);
		in.close();
		
	}
	
	private static void quickSort(int[] a, int first, int last) {
		if( a == null || a.length < 2 || first >= last ) {
			return;
		}
		int mid = first + (last - first) / 2;
		int p = a[mid];
		
		int i = first, j = last;
		while( i <= j ) {
			while( a[i] < p ) {
				i++;
			}
			while( a[j] > p ) {
				j--;
			}
			if( i <= j ) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		if( first < j ) {
			quickSort(a, first, j);
		}
		if( last > i ) {
			quickSort(a, i, last);
		}
	}


	private static void minIntDist(int[] a, int n) {
		if( a == null || n <= 1) {
			return;
		} else {
			int minDist = a[n-1];
			int x = minDist;
			int o1 = a[0];
			int o2 = a[n-1];
			int j;
			for(int i = 0; i < n - 1; i++) {
				j = i + 1;
				x = Math.abs(a[j] - a[i]);
				//System.out.println(x);
				if(x < minDist) {
					minDist = x;
					o1 = a[j];
					o2 = a[i];
				}
			} System.out.println(o1 + " " + o2);
		} 
	}
	
}
