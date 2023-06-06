package u2015;
import java.util.*;
import java.io.*;

public class billboard {
	public static void main(String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		int [][] visiblespace = new int [2000][2000];
		
		for (int i = 0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			//System.out.println("Points: (" + x1 + ", " + y1 + ")   (" + x1 + ", " + y2 + ")");
			
			x1 += 1000;
			y1 += 1000;
			x2 += 1000;
			y2 += 1000;
			
			if (i<2) {
				for (int row = y1; row < y2; row ++) {
					for (int col = x1; col<x2; col++) {
						visiblespace[row][col] = 1;
					}
				}
			}
			else if (i==2) {
				for (int row = y1; row < y2; row ++) {
					for (int col = x1; col<x2; col++) {
						visiblespace[row][col] = 0;
					}
				}
			}
		}
		
		/*for (int i=0; i<2000; i++) {
			for (int j = 0; j<2000; j++) {
				if (visiblespace[i][j] == 1) {
					out.print("x ");
				}
				else {
					out.print ("  ");
				}
			}
			out.println(); 
		}
		*/
		int sum = 0;
		for (int i=0; i<2000; i++) {
			for (int j = 0; j<2000; j++) {
				sum += visiblespace[i][j];
			}
		}
		
		out.println(sum);
		in.close();
		out.close();
	}
}
