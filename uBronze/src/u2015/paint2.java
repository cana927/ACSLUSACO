package u2015;
import java.io.*;
import java.util.*;

public class paint2 {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("paint.in"));
		PrintWriter out = new PrintWriter ("paint.out");
		
		String line = in.readLine();
		out.println("Hello worlds!");
		out.close();
	}
}
