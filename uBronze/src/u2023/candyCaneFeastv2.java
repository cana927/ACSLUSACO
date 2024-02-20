//package u2023;

import java.util.*;
import java.io.*;

public class candyCaneFeastv2 {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // create a StringTokenizer object that reads in the next input line
    StringTokenizer st = new StringTokenizer(in.readLine());
    // create an int variable called 'n' and read in the next token from the
    // StringTokenizer object
    int n = Integer.parseInt(st.nextToken());
    // create an int variable called 'm' and read in the next token from the
    // StringTokenizer object
    int m = Integer.parseInt(st.nextToken());
    // create a long array called 'cows' with length 'n'
    long[] cows = new long[n];
    // reset the StringTokenizer object to read in the next input line
    st = new StringTokenizer(in.readLine());
    // create a for loop that runs n times
    for (int i = 0; i < n; i++) {
      // read in the next token from the StringTokenizer object and store it in the
      // ith index of the cows array
      cows[i] = Long.parseLong(st.nextToken());
    }

    // reset the StringTokenizer object to read in the next input line
    st = new StringTokenizer(in.readLine());

    // create a while loop that runs m times
    while (m-- > 0) {
      // create a long variable called 'curr' and set it to the next token from the
      // StringTokenizer object
      long curr = Long.parseLong(st.nextToken());
      // create an long variable called 'taken' and set it to 0
      long taken = 0;
      // create a for loop that starts at 0 and checks if i < n and taken < curr
      for (int i = 0; i < n && taken < curr; i++) {
        // create a long variable called 'inc' and set it equal to the minimum between
        // curr and cows[i] and then subtract 'taken' from that value
        long inc = Math.min(curr, cows[i]) - taken;
        // create an if statement that checks if inc > 0
        if (inc > 0) {
          // add inc to cows[i]
          cows[i] += inc;
          // add inc to taken
          taken += inc;
        }
      }

    }

    // create a for loop that runs n times
    for (int i = 0; i < n; i++) {
      // print out the ith index of the cows array
      System.out.println(cows[i]);
    }

  }

}
