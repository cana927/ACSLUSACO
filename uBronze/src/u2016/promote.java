package u2016;
import java.io.*;
import java.util.*;

public class promote {
	public static void main (String[]args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("promote.in"));
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int diffbron = -1*(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		st = new StringTokenizer (in.readLine());
		int diffsilv = -1*(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		st = new StringTokenizer (in.readLine());
		int diffgold = -1*(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		st = new StringTokenizer (in.readLine());
		int diffplat = -1*(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
		
		int moveplat = 0;
		int movegold = 0;
		int movesilv = 0;
		
		
		moveplat = diffplat;
		movegold = diffgold + diffplat;
		movesilv = movegold + diffsilv;
		
		
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter ("promote.out")));
		out.println (moveplat);
		out.println (movegold);
		out.println (movesilv);
		out.close();
	}
}
