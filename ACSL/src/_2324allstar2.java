import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'playCards' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER players
     *  2. STRING_ARRAY cards
     */

    public static String playCards(int players, List<String> cards) {
        ArrayList <Player> p = new ArrayList <Player>();
        for (int i = 0; i<players; i++) {
            p.add(new Player (i+1, cards.get(i)));
        }
        
        String finalanswer = "";
        Boolean done = false;
        int firstplayer = 0;
        
        while (!done) {
            for (Player player: p) {
                System.out.println (player.number);
                player.print();
                System.out.println();
            }
            
            int value = 0;
            
            //find first num
            int r = 0;
            for (int i = 0; i< p.get(firstplayer).list.size(); i++) {
                if (p.get(firstplayer).list.get(i) >= 100*value) {
                    value = p.get(firstplayer).list.get(i);
                    r = i;
                    
                }
            }
            p.get(firstplayer).list.remove(r);
            
            if (p.get(firstplayer).isDone()) {
                finalanswer += p.get(firstplayer).number + " ";
                p.remove(firstplayer);
                if (p.size() == 1) {
                    finalanswer += p.get(0).number;
                    return finalanswer;
                }
                firstplayer--;
            }
            
            //next players play
            int place = firstplayer ++;
            if (place >= p.size()) {
                place = 0;
            }
            int lastplayed = firstplayer;
            
            while (place != lastplayed) {
                System.out.println (place + " " + value);
                
                for (int i = 0; i< p.get(place).list.size(); i++) {
                    if (p.get(place).list.get(i) > value && p.get(place).list.get(i)/value <13) {
                        value = p.get(place).list.get(i);
                        p.get(place).list.remove(i);
                        
                        if (p.get(place).isDone()) {
                            finalanswer += p.get(place).number + " ";
                            p.remove(place);
                            if (p.size() == 1) {
                                finalanswer += p.get(0).number;
                                return finalanswer;
                            }
                            place--;
                        }
                          
                        lastplayed = place;
                        i = p.get(place).list.size();
                    }
                }
                
                place ++;
                if (place >= p.size()) {
                    place = 0;
                }
            }
            firstplayer = lastplayed; 
            System.out.println ("First = " + lastplayed);
        }
        return "";
    }
    
}

class Player {
    int number;
    ArrayList <Integer> list;
    
    public Player (int n, String cards) {
        number = n;
        list = new ArrayList<Integer>();
        
        // 0 1 2 3 4 5 6 7 8 9 0 1 2
        // 3 4 5 6 7 8 9 T J Q K A 2
        int [] nums = new int [13];
        StringTokenizer st = new StringTokenizer(cards);
        while (st.hasMoreTokens()) {
            String card = st.nextToken();
            if (card.charAt(0) == 'T') {
                nums[7]++;
            }
            else if (card.charAt(0) == 'J') {
                nums[8]++;
            }
            else if (card.charAt(0) == 'Q') {
                nums[9]++;
            }
            else if (card.charAt(0) == 'K') {
                nums[10]++;
            }
            else if (card.charAt(0) == 'A') {
                nums[11]++;
            }
            else if (card.charAt(0) == '2') {
                nums[12]++;
            }
            else {
                nums [card.charAt(0)-'3'] ++;
            }
        }
        
        for (int i = 0; i<13; i++) {
            if (nums[i] == 1) {
                list.add(i+1);
            }
            if (nums[i] == 2) {
                list.add((i+1)*100);
            }
            if (nums[i] == 3) {
                list.add((i+1)*10000);
            }
            if (nums[i] == 4) {
                list.add((i+1)*1000000);
            }
        }
        Collections.sort (list);
    }
    
    public Boolean isDone () {
        return (list.size() == 0);
    }
    
    public void print () {
        for (int i : list) {
            System.out.print (i + " " );
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int players = Integer.parseInt(bufferedReader.readLine().trim());

        int cardsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> cards = IntStream.range(0, cardsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        String result = Result.playCards(players, cards);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
