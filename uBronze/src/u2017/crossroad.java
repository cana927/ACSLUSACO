//package u2017;
import java.io.*;
import java.util.*;

public class crossroad {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader("crossroad.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new PrintWriter ("crossroad.out")));
		
		int n = Integer.parseInt(in.readLine());
		int [] cow = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int moved = 0;
		
		for (int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int cownum = Integer.parseInt(st.nextToken());
			int side = Integer.parseInt(st.nextToken());
			if (cow[cownum-1] == -1) {
				cow[cownum-1] = side;
			}
			else {
				if (cow[cownum-1] != side) {
					moved ++;
					cow[cownum-1] = side;
				}
			}
		}
		out.println (moved);
		out.close();
		in.close();
	}
}
