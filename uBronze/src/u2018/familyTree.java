package u2018;

import java.io.*;
import java.util.*;

public class familyTree {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader (new FileReader ("family.in"));
		PrintWriter out = new PrintWriter (new BufferedWriter (new FileWriter ("family.out")));
		
		StringTokenizer st = new StringTokenizer (in.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		ArrayList <Person> people = new ArrayList <Person> ();
		ArrayList <String> names = new ArrayList <String> ();
		Person a = new Person (st.nextToken());
		Person b = new Person (st.nextToken());
		
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer (in.readLine());
			String name1 = st.nextToken();
			String name2 = st.nextToken();
			
			if (name1 == a.name && name2 == b.name) {
				out.println (name1 + " is the mother of " + name2);
			}
			else if (name1 == b.name && name2 == a.name) {
				out.println (name2 + " is the mother of " + name1);
			}
			else if (name1 == a.name){
				Person p = new Person (name2);
				p.mom = a;
				a.daughter.add(p);
			}
			else if (name2 == a.name){
				Person p = new Person (name1);
				p.mom = a;
				a.daughter.add(p);
			}
			else if (name1 == b.name){
				Person p = new Person (name2);
				a.mom = p;
				p.daughter.add(a);
			}
			else if (name2 == b.name){
				Person p = new Person (name1);
				a.mom = p;
				p.daughter.add(a);
			}
			else if (names.contains(name1) && names.contains(name2)) {
				int place1 = names.indexOf(name1);
				int place2 = names.indexOf(name2);
				
				people.get(place1).daughter.add(people.get(place2));
				people.get(place2).mom = people.get(place1);
			}
			else if (names.contains(name1)) {
				int place = names.indexOf(name1);
				Person p = new Person (name2);
				
				people.get(place).daughter.add(p);
				p.mom = people.get(place);
				
				people.add(p);
				names.add(name2);
			}
			else if (names.contains(name2)) {
				int place = names.indexOf(name2);
				Person p = new Person (name1);
				
				people.get(place).mom = p;
				p.daughter.add(people.get(place));
				
				people.add(p);
				names.add(name2);
			}
			else {
				Person p1 = new Person (name1);
				Person p2 = new Person (name2);
				p1.daughter.add(p2);
				p2.mom = p1;
				
				people.add(p1);
				names.add(name1);
				people.add(p2);
				names.add(name2);
			}
		}
		
		
		
	}
	public static class Person  {
		Person mom;
		ArrayList <Person> daughter;
		String name;
		
		public Person (String name) {
			this.name = name;
		}
	}
}
