package u2016;
import java.io.*;
import java.util.*;

public class square {
	public static void main (String []args)throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("square.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer (in.readLine());
		int tx1 = Integer.parseInt(st.nextToken());
		int ty1 = Integer.parseInt(st.nextToken());
		int tx2 = Integer.parseInt(st.nextToken());
		int ty2 = Integer.parseInt(st.nextToken());
		
		int fx1 = Math.min(x1,  tx1);
		int fy1 = Math.min(y1,  ty1);
		int fx2 = Math.max(x2,  tx2);
		int fy2 = Math.max(y2,  ty2);
		
		int side = Math.max((fx2 - fx1),(fy2 - fy1));
		
		out.println (side*side);
		in.close();
		out.close();
		
	}
}
