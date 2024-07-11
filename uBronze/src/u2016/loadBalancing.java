package u2016;

import java.util.*;
import java.io.*;
public class loadBalancing {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter out = new PrintWriter("balancing.out");
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[] xvals = new int[N];
		int[] yvals = new int[N];
		Set<Integer> vfences = new HashSet<>();
		Set<Integer> hfences = new HashSet<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			xvals[i] = Integer.parseInt(st.nextToken());
			yvals[i] = Integer.parseInt(st.nextToken());
			vfences.add(xvals[i]+1);
			hfences.add(yvals[i]+1);
		}
		
		int min = N;
		for(int v : vfences) {
			for(int h : hfences) {
				
				int topLeft = 0;
				int topRight = 0;
				int bottomLeft = 0;
				int bottomRight = 0;
				
				for(int i = 0; i < N; i++) {
					if(xvals[i] < v && yvals[i] > h) {
						topLeft++;
					}
					else if(xvals[i] > v && yvals[i] > h) {
						topRight++;
					}
					else if(xvals[i] < v && yvals[i] < h) {
						bottomLeft++;
					}
					else if(xvals[i] > v && yvals[i] < h) {
						bottomRight++;
					}
				}
				
				int curr = Collections.max(Arrays.asList(topLeft, topRight, bottomLeft, bottomRight));
				min = Math.min(min, curr);
				
			}
		}
		
		out.println(min);
		in.close();
		out.close();

	}

}