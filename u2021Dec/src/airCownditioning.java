import java.io.*;
import java.util.*;

public class airCownditioning {
	public static void main (String [] args) {
		Scanner sc  = new Scanner (System.in);
		
		int N = sc.nextInt();
		
		int[] a = new int[N];
		int [] b = new int [N];
		
		for (int i=0;i<N;i++) {
			a[i] = sc.nextInt();
		}
		for (int i=0;i<N; i++) {
			b[i] = sc.nextInt();
		}
	}
}
