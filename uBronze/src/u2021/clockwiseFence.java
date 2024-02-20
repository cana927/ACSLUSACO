//package u2021;

import java.util.*;
import java.io.*;

public class clockwiseFence {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create an int variable n and store the first input line in it
    int n = Integer.valueOf(in.readLine());
    //create a for loop that iterates n times
    for(int i = 0; i < n; i++) {
      //create a String variable called 'str' and store the next input line in it
      String str = in.readLine();
      //create two int variables called 'cw' and 'ccw' and set them to 0
      int cw = 0;
      int ccw = 0;
      //create a String variable called 'sub' and set it to an empty string
      String sub = "";
      //create a for loop that iterates through the length-1 of the above String str variable
      for(int j = 0;j < str.length()-1;j ++){
        //set the value of 'sub' to the current pair of characters in 'str' bounded by j
        sub = str.substring(j, j+2);
        //check if sub is equal to NE, SW, ES, or WN
        //if so, increment 'cw' by 1
        if (sub.equals("NE") || sub.equals("SW") || sub.equals("ES") || sub.equals("WN")) {
          cw++;
        }
        //check if sub is equal to NW, SE, EN, or WS
        //if so, increment 'ccw' by 1
        if (sub.equals("NW") || sub.equals("SE") || sub.equals("EN") || sub.equals("WS")) {
          ccw++;
        }

        //set 'sub' to the substring of 'str' bounded from str.length()-3 to the end
        sub = str.substring(str.length()-3);
        //do the same if statement checks as above for both CW and CCW
        if (sub.equals("NE") || sub.equals("SW") || sub.equals("ES") || sub.equals("WN")) {
          cw++;
        }
        if (sub.equals("NW") || sub.equals("SE") || sub.equals("EN") || sub.equals("WS")) {
          ccw++;
        }
        
      }

      //check if cw is greater than ccw
      //if so, print out CW
      if (cw > ccw) {
        System.out.println ("CW");
      }else{
        System.out.println ("CCW");
      }
      
    }
    
  }

  
}