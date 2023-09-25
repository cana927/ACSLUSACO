package u2019;

import java.io.*;
import java.util.*;

public class lineup {
	public static void main (String [] args) throws IOException {
		Scanner sc = new Scanner (new File("lineup.in"));
		PrintWriter out = new PrintWriter("lineup.out");
		
		Cow john = new Cow();
        john.name = "John";

        Cow julia = new Cow();
        julia.name = "Julia";

        Cow ethan = new Cow();
        ethan.name = "Ethan";

        ethan.successors.add(john);
        john.successors.add(julia);
        ethan.successors.add(julia);
        julia.successors.add(ethan);

        dfs(ethan);
		
		
		out.println ();
		out.close();
	}
	static class Cow {
        String name;
        
        boolean seen = false;
        ArrayList<Cow> successors = new ArrayList<Cow>();
    }

    static void dfs(Cow c) {
        if (c.seen == true) {
            return;
        }

        for (int i = 0; i < c.successors.size(); i++) {
            Cow child = c.successors.get(i);

            // Do something with the node!!
            System.out.println(c.name + " is following to " + child.name);


            dfs(child);
        }
    }
}

