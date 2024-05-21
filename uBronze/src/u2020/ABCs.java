//package u2020;

import java.util.*;
import java.io.*;

public class ABCs {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //Create a StringTokenizer object called 'st' and read in the next input line
    StringTokenizer st = new StringTokenizer(in.readLine());
    //create an int array called 'nums' and set it to size of 7
    int [] nums = new int [7];
    
    //create a for loop that iterates 7 times
    for (int i = 0; i < 7; i++) {
      //store the next token into the 'nums' array at index i
      nums[i] = Integer.parseInt(st.nextToken());
      
    }

    //sort the nums array in ascending order
    Arrays.sort(nums);

    //create an int variable 'a' and store the first element of 'nums' in it
    int a = nums[0];
    //create an int variable 'b' and store the second element of 'nums' in it
    int b = nums[1];
    //create an int variable 'c' and store the last element of 'nums' in it and subtract 'a' and 'b' from it
    int c = nums[6] - a -b;

    System.out.println(a + " " + b + " " + c);
    
    
  }

  
}