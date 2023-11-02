//package u2016;
import java.io.*;
import java.util.*;

public class squarePasture {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("square.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("square.out")));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine());
		x1 = Math.min(x1, Integer.parseInt(st.nextToken()));
		y1 = Math.min(y1, Integer.parseInt(st.nextToken()));
		x2 = Math.max (x2, Integer.parseInt(st.nextToken()));
		y2 = Math.max(y2, Integer.parseInt(st.nextToken()));
		
		out.print (Math.max((x2-x1),(y2-y1)) * Math.max((x2-x1),(y2-y1)));
		in.close();
		out.close();
	}
}
