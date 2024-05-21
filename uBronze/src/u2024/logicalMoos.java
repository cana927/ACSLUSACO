//package u2024;

import java.util.*;
import java.io.*;

public class logicalMoos {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    //create two int variables N and Q and set the next two tokens into those variables
    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    //read in the next input line and split it by a space and store into a String[] called input
    String [] input = in.readLine().split(" ");
    //create a String array called 'phrase' and set its length to input.length+2
    String[] phrase = new String[input.length+2];
    //create a for loop that iterates through all of 'input' elements and stores it into 'phrase'
    for (int i = 0; i<input.length; i++) {
      phrase[i] = input[i];
    }
    phrase[phrase.length-2] = "or";
    phrase[phrase.length-1] = "false";

    //min stores the location of the last true in the first 'true' interval
    //max stores the location of the first true in the last 'true' interval
    //create an int variable called min and set it to Integer.MAX_VALUE
    //create an int variable called max and set it to 0
    int min = Integer.MAX_VALUE;
    int max = 0;

    //if start[l] == 1 and end[r] == 1, then phrase can be 'true'
    //create an int array called start and end; set both of their lengths to N
    int [] start = new int [N];
    int [] end = new int [N];

    //lastFalse stores the last location of 'false' in any interval
    //intervalStart stores the start of an interval
    //create an int variable called lastFalse and set it to -1
    //create an int variable called intervalStart and set it to 0
    int lastFalse = -1;
    int intervalStart = 0;

    //loop over all elements in 'phrase', and we will go until we reach the last "or" to denote the end of the phrase
    //create a for loop that iterates from 0 to N+1 (exclusive)
    for (int i = 0; i<N+1; i++){

      //check if lastFalse is -1 and that we are still within the bounds of phrase (use N to check for bounds)
      if(lastFalse == -1 && i < N) {
        //set start[i] = 1
        start[i] = 1;
      }
      //check if phrase at index i is equal to false
      if(phrase[i].equals("false")) {
        //update the lastFalse variable to match the current index
        lastFalse = i;
      }
      if(phrase[i].equals("or")) {
        //check if the lastFalse variable is equal to -1
        if (lastFalse == -1) {
          min = Math.min(i-1, min);
          max = Math.max(intervalStart,max);
        }
        //update end array
        for(int j = Math.max(intervalStart, lastFalse); j < i; j++) {
          end[j] = 1;
        }
        lastFalse = -1;
        intervalStart = i+1;
      }
      
    }

    //create a for loop that iterates from 0 to Q (exclusive)
    for(int i = 0; i < Q; i++) {

      //reset the StringTokenizer st to read in the next input line
      st = new StringTokenizer(in.readLine());
      //create int variables called 'l' and 'r' and set them to the next two tokens - 1
      int l = Integer.parseInt(st.nextToken()) - 1;
      int r = Integer.parseInt(st.nextToken()) - 1;
      //create a String variable called 'goal' and set it to the next token
      String goal = st.nextToken();

      //case #1: goal is true
      if(goal.equals("true") && (start[l] == 1 && end[r] == 1 || l > min || r < max)) {
        System.out.print("Y");
      }
      //case #2: goal false
      //check if goal is false and that l <= min and r >= max
      else if(goal.equals("false") && l <= min && r >= max) {
        System.out.print("Y");
      }
      else {
        System.out.print("N");
      }
      
    }
    
  }


}