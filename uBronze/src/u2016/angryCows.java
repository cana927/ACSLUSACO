package u2016;
import java.io.*;
import java.util.*;

public class angryCows {
	public static void main (String [] args) throws IOException   {
		BufferedReader in = new BufferedReader(new FileReader("angry.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter ("angry.out")));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		
		int [] cows = new int [n];
		for (int i =0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			cows[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cows);
		
		int max = 0;
		
		for (int i =0; i<n; i++) {
			int backnum = 1;
			int back = i;
			while (back>0) {
				int goback = back-1;
				while (goback>0 && cows[goback]>= cows[back] - backnum) {
					goback--;
				}
				
				if (goback < back -1) {
					backnum++;
					back = goback+1;
				}
				else {
					break;
				}
			}
			int backcows = i-back;
			
			int frontnum = 1;
			int front = i;
			while (front<n-1) {
				int gofront = front+1;
				while (gofront<n-1 && cows[gofront]<= cows[front] + frontnum) {
					gofront++;
				}
				
				if (gofront > front+1) {
					frontnum++;
					front = gofront-1;
				}
				else {
					break;
				}
			}
			int frontcows = front-i;
			out.println (backcows + " " + frontcows);
			
			if (frontcows + backcows +1> max) {
				max = frontcows + backcows + 1;
			}
		}
		out.println (max);
		in.close();
		out.close();
	}
}