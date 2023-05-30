import java.io.*;
import java.util.*;

public class weirdAlgorithm {
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long n = Long.parseLong(br.readLine());
		
		while (n != 1) {
			System.out.print (n + " ");
			if (n%2 == 0) {
				n /= 2;
			}
			else {
				n = n*3 +1;
			}
		}
		System.out.print(1);
	}
}
