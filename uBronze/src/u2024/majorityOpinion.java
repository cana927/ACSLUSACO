//package u2024;

import java.util.*;
import java.io.*;

public class majorityOpinion {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //read in the first line of input and set it equal to an int variable 't'
    int t = Integer.parseInt(in.readLine());

    //create a while loop that iterates while t-- is greater than 0
    while(t-- > 0) {

      //create an int variable 'n' and set it equal to the next integer in the input
      int n = Integer.parseInt(in.readLine());
      //create a StringTokenizer object and call it 'st' and read in the next input line
      StringTokenizer st = new StringTokenizer (in.readLine());
      //create an int array 'h' and set it to a size of 'n'
      int[] h = new int[n];
      //create a for loop that iterates n times
      for(int i = 0; i < n; i++){
        //store each of the next tokens into the array 'h'
        h[i] = Integer.parseInt(st.nextToken());
        
      }

      //create a boolean array called 'good' and set it to a size of n+1
      boolean[] good = new boolean[n+1];
      for(int i = 0;i + 1 < n; i++) {
        //create an if statement that checks if the hay at index i is equal to the hay at index i+1
        if (h[i] == h[i+1]) {
          //set the boolean value of 'good' at index h[i] to true
          good[h[i]] = true;
        }
        //create an if statment that checks if i+2 < n and that the hay type of index i is equal to index i+2
        if( i+2 < n && h[i] == h[i+2]){
          //set the boolean value of 'good' at index h[i] to true
          good[h[i]] = true;
        }
        
      }

      //create a boolean variable 'printed' and set it to false
      boolean printed = false;
      //create a for loop that iterates from 1 to n (inclusive)
      for (int i = 1; i<=n; i++) {
        //check if the boolean value of 'good' at index i is true
        if(good[i] == true){
          //check if 'printed' is true
          if(printed == true){
            System.out.print(" ");
          }
          printed = true;
          System.out.print(i);
          
        }
      }

      if(!printed) System.out.print(-1);
      System.out.println();
      
    }
    
  }

  
}