import java.util.*;
import java.io.*;

public class _2223allstar3 {

	static class KWIC {
		
		public String before;
		public String word;
		public String after;
		public int order;
		
		public KWIC(String before, String word, String after, int order) {
			this.before = before;
			this.word = word;
			this.after = after;
			this.order = order;
		}
		
		public String toString() {
			return this.before + " " + this.word + " " + this.after;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++) {
			
			String[] wordsToIndex = in.readLine().split(" ");
			List<String> ignore = Arrays.asList(in.readLine().split(" "));
			StringTokenizer st = new StringTokenizer(in.readLine());
			int[] range = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			ArrayList<KWIC> table = new ArrayList<KWIC>();
			
			for(int j = 0; j < wordsToIndex.length; j++) {
				
				String curr = wordsToIndex[j];
				boolean puncExists = false;
				Map<String, Integer> wordOrder = new HashMap<String, Integer>();
				
				if(!Character.isLetter(curr.charAt(curr.length()-1))) {
					curr = curr.substring(0, curr.length()-1);
					puncExists = true;
				}
				
				wordOrder.put(curr.toLowerCase(), 0);
				
				if(!ignore.contains(curr.toLowerCase())) {
					
					String before = "";
					String after = "";
					
					for(int k = j-1; k >= j-3 && k >= 0; k--) {
						String wordBefore = wordsToIndex[k];
						if(!Character.isLetter(wordBefore.charAt(wordBefore.length()-1)) || ignore.contains(wordBefore.toLowerCase())) {
							break;
						}
						before = wordBefore + " " + before;
					}
					before = before.trim();
					
					for(int k = j+1; k <= j+3 && k < wordsToIndex.length; k++) {
						
						String wordAfter = wordsToIndex[k];
						if(!Character.isLetter(wordAfter.charAt(wordAfter.length()-1))) {
							
							if(ignore.contains(wordAfter.substring(0, wordAfter.length()-1).toLowerCase())) {
								break;
							}
							wordAfter = wordAfter.substring(0, wordAfter.length()-1);
							after = after + " " + wordAfter;
							break;
							
						}
						
						if(ignore.contains(wordAfter.toLowerCase()) ||  puncExists) {
							break;
						}
						after = after + " " + wordAfter;
						
					}
					after = after.trim();
					
					table.add(new KWIC(before, curr, after, wordOrder.get(curr.toLowerCase())));
					wordOrder.replace(curr.toLowerCase(), wordOrder.get(curr.toLowerCase())+1);
					
				}
				
			}
			
			Collections.sort(table, new Comparator() {
				public int compare(Object o1, Object o2) {
					String s1 = ((KWIC)o1).word.toLowerCase();
					String s2 = ((KWIC)o2).word.toLowerCase();
					
					int wordCompare = s1.compareTo(s2);
					if(wordCompare != 0) {
						return wordCompare;
					}
					
					Integer i1 = ((KWIC)o1).order;
					Integer i2 = ((KWIC)o2).order;
					
					return i1.compareTo(i2);
					
				}
			});
			
			int longestBefore = 0;
			int longestWord = 0;
			int longestAfter = 0;
			
			for(int j = 0; j < table.size(); j++) {
				longestBefore = Math.max(longestBefore, table.get(j).before.length());
				longestWord = Math.max(longestWord, table.get(j).word.length());
				longestAfter = Math.max(longestAfter, table.get(j).after.length());
			}
			
			int min = Integer.MAX_VALUE;
			int ind = 0;
			for(int j = range[1]-1; j >= range[0]-1; j--) {
				int dashes = (longestBefore-table.get(j).before.length()) + (longestAfter-table.get(j).after.length()) 
						+ (longestWord-table.get(j).word.length());
				if(dashes <= min) {
					min = dashes;
					ind = j;
				}
			}
			
			int beforeDashes = (longestBefore - table.get(ind).before.length());
			for(int j = 0; j < beforeDashes; j++) {
				table.get(ind).before = "-" + table.get(ind).before;
			}
			
			int afterDashes = (longestAfter - table.get(ind).after.length());
			for(int j = 0; j < afterDashes; j++) {
				table.get(ind).after += "-";
			}
			
			table.get(ind).word = "<" + String.format("%-" + longestWord + "s", table.get(ind).word).replace(' ', '-') + ">";
			
			System.out.println(table.get(ind));
			
		}

	}

}
/*
KWIC is an acronym for Key Word In Context, the most common format for concordance lines which is used for indexing in context.
for in the
7 15
The quick, brown fox jumped over the lazy dogs.
the
1 6
HackerRank is the best platform to do ACSL programs for the Finals competition.
for the
1 10
How are you? I am fine. It is nice to be in Florida. Writing Python programs is easier by the pool!
to in by the
5 15
Lions and Tigers and Bears, Oh My! is from the Wizard of Oz. Where is it found?
and from the it
1 10

The best Dr. Seuss book was The Cat in the Hat and the second best was Green Eggs and Ham. They are both Easy Readers! Have you read them?
the and
2 12
Four score and seven years ago our fathers brought forth on this continent a new nation, conceived in liberty and dedicated to the proposition that all men are created equal. Was this Abraham Lincoln or Benjamin Franklin?
and the in to or
5 20
Jessica Fletcher was played by Angela Lansbury in Murder, She Wrote. However, Angela Lansbury also had a cameo appearance in Mary Poppins Returns. If only Julie Andrews was in it too!
by if a in
14 23
Everyone loves a classic novel, but where to start? From Jane Austen to Charles Dickens, Toni Morrison to Fyodor Dostoevsky, the fiction canon is so vast you can easily get lost in it.
a to the but in
5 25
We hold these truths to be selfevident, that all men are created equal, that they are endowed by their Creator with certain unalienable Rights, that among these are Life, Liberty and the pursuit of Happiness.
to are that the and
3 23
C. S. Lewis wrote a timeless tale capturing the hearts of children everywhere with its fantastical world through the wardrobe, full of fauns, dwarves and anthropomorphised animals. Whether you were Peter, Edmund, Susan or Lucy, we all wanted to put on a fur coat and go on a snowladen adventure with Mr Tumnus. Where is Narnia, really?
a with the of to on and
20 40
Alexander and the Terrible, Horrible, No Good, Very Bad Day starts with I went to bed with gum in my mouth and now there is gum in my hair, and when I got out of bed this morning, I stepped on the skateboard and I dropped my sweater in the sink while the water was running. I could tell it was going to be a terrible, horrible, no good, very bad day.
and the in a on with
24 31
Friends, Romans, countrymen, lend me your ears. I have come to bury Caesar, not to praise him. The evil that men do lives after them; The good is oft interrÃ¨d with their bones.
to with
5 25
Ben Franklin said these: Love your Enemies, for they tell you your Faults; He that falls in love with himself will have no rivals; There never was a good war or a bad peace; Look before, or you will find yourself behind; Do not throw stones at your neighbors, if your own windows are glass; Well done is better than well said.
for in with at if or
10 40
He also wrote these: Dost thou love life? Then do not squander Time; for that is the Stuff Life is made of; Glass, China, and Reputation, are easily cracked, and never well mended; What is more valuable than Gold? Diamonds. Than Diamonds? Virtue; Haste makes Waste; Wish not so much to live long as to live well.
for the of and to
19 22
*/
