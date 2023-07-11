package u2015;
import java.io.*;
import java.util.*;

public class paint2 {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner (new File ("paint.in"));
		PrintWriter out = new PrintWriter("paint.out");
		
		int a = sc.nextInt(),
	            b = sc.nextInt(),
	            c = sc.nextInt(),
	            d = sc.nextInt();
	        
	    int[] arr = new int[101];
	    for (int i = a; i < b; i++) {
	    	arr[i] = 1;
	    }
	    for (int i = c; i < d; i++) {
	        arr[i] = 1;
		}
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            sum += arr[i];
        }

        out.println(sum);
        out.close();
	}
}
