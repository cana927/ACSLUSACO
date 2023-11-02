//package u2022;

import java.util.*;
import java.io.*;
public class photoshoot {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //read in the first line and store into an int variable called N; parse as neccessary
    int N = Integer.parseInt(in.readLine());
    //read in the second line as a string and call .toCharArray and store in a char[] called cows
    char[] cows = in.readLine().toCharArray();

    //create a boolean variable called found and set it equal to false
    boolean found = false; //if we have seen no HG or GH pairs so far
    
    //create a boolean variable called last and set it equal to false;
    boolean last = false; //whether the last pair is HG (true if so; false if GH) 
    
    //create an int variable called splits and set it equal to 0
    int splits = 0; //number of switches/reversals
    
    //loop over all pairs using a for loop that increments by 2 up to N
    for(int i = 0; i < N; i += 2) {

      //ignore HH and GG pairs by checking if the current cow and the next cow over are equal
      //create an if statement checking the above conditions
      if (cows[i] == cows[i+1]) {
        continue;
      }

      boolean type = cows[i] == 'H'; //corresponds to the same rule as listed in 'last'

      //create an if statement checking if !found
      if(!found) {
        //no split/reversal so far
        //set found = true
        found = true;
        //set last = type
        last = type;
      }
      else {
        //create an if-statement that checks if type is not equal to last
        if (type != last) {
          splits++;
        }
        //set last equal to type
        last = type;
      }
      
    }

    //create an int variable called ans and set it equal to splits
    int ans = splits;
    
    //create an if-statement checking if last is equal to false
    if (last == false) {
      ans++;
    }  

    System.out.println(ans);
    
  }
}