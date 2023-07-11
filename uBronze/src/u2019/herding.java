//package u2019;
import java.io.*;
import java.util.*;

public class herding {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner (new File("herding.in"));
		PrintWriter out = new PrintWriter("herding.out");
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int min = 0;
		int max = 0;
		
		int one = Math.min(a, Math.min(b, c));
		int three = Math.max(a, Math.max(b, c));
		int two =0;
		if (a != one && a != three) {
			two = a;
		}
		if (b != one && b != three) {
			two = b;
		}
		if (c != one && c != three) {
			two = c;
		}
		
		if (two - one == 2 || three - two == 2) {
			min = 1;
		}else if (three-one ==2) {
			min = 0;
		}else {
			min = 2;
		}
		
		if (three-one == 2) {
			max = 0;
		}else {
		max = Math.max(three-two, two - one) - 1;
		}
		out.println (min);
		out.println (max);
		out.close();
	}
}
