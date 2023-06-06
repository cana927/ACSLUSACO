package u2015;
import java.io.*;
import java.util.*;

public class paint {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("paint.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter(new FileWriter("paint.out")));
		
		StringTokenizer line = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(line.nextToken());
		int b = Integer.parseInt(line.nextToken());
		
		line = new StringTokenizer(in.readLine());
		int c = Integer.parseInt(line.nextToken());
		int d = Integer.parseInt(line.nextToken());
		
		/*int[] fence = new int[101];
		for(int i = a; i<b; i++) {
			fence [i] = 1;
		}
		for (int i = c; i<d; i++) {
			fence[i] = 1;
		}
		
		int count = 0;
		for(int i = 0; i<fence.length; i++) {
			count += fence[i]; 
		}
		
		out.println(count);*/
		
		int intersection = Math.min(b, d) - Math.max(a,c);
		
		if (intersection<0) intersection = 0;
		
		out.println((b-a)+(d-c)-intersection);
		
		in.close();
		out.close();
	}
}
