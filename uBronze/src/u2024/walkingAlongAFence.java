package u2024;

import java.io.*;
import java.util.*;

public class walkingAlongAFence {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		Point [] points = new Point[P];
		for (int i = 0; i<P; i++) { 
			st = new StringTokenizer (in.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			if (i == 0) {
				points[i] = new Point (X, Y, 0);
			}
			else {
				points[i] = new Point (X, Y, points[i-1].dis + Math.abs(points[i-1].x - X + points[i-1].y - Y));
			}
		}
		
		for (int i = 0; i<N;i ++) {
			st = new StringTokenizer (in.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int p1 = 0;
			int p2 = 0;
			
			for (int r = 0; r<P; r++) {
				if (points[r].x == x1 && points[r].y == y1) {
					p1 = r;
				}
				if (points[r].x == x2 && points[r].y == y2) {
					p2 = r;
				}
			}
			
			int d1 = points[p2].dis - points[p1].dis;
			int d2 = points[P-1].dis-points[p1].dis + points[p2].dis;
			int d3 = points[p1].dis - points[p2].dis;
			int d4 = points[P-1].dis-points[p2].dis + points[p1].dis;
			
			System.out.println (d1+ " " +  d2 + " " + d3 + " " + d4);
		}
	}
	public static class Point {
		int x;
		int y;
		int dis;
		public Point (int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}
