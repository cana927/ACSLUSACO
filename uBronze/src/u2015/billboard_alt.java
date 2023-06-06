package u2015;
import java.util.*;
import java.io.*;


public class billboard_alt {
	public static void main (String [] args)throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		Rect a, b, t;
		StringTokenizer st;
		
		st = new StringTokenizer (in.readLine());
		 a = new Rect (Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		 
		 st = new StringTokenizer (in.readLine());
		 b = new Rect (Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		 
		 st = new StringTokenizer (in.readLine());
		 t = new Rect (Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		 
		 out.println (a.area() + b.area() - intersect(a,t) - intersect (t, b));
		 
		 in.close();
		 out.close(); 
	}
	
	
	public static int intersect (Rect a, Rect b) {
		int xOverlap = Math.min(a.x2, b.x2)- Math.max(a.x1, b.x1);
		if (xOverlap<0) {
			xOverlap= 0;
		}
		int yOverlap = Math.min(a.y2, b.y2)- Math.max(a.y1, b.y1);
		if (yOverlap<0) {
			yOverlap= 0;
		}
		return xOverlap * yOverlap; 
	}
}

class Rect {
	int x1, y1, x2, y2;
	
	Rect(int x1, int y1, int x2, int y2) {
		this.x1=x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2= y2;
		
	}
	
	int area () {
		return (x2-x1)*(y2-y1);
	}
}