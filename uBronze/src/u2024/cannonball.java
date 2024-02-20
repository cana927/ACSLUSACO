//package u2024;

import java.util.*;
import java.io.*;

public class cannonball {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    //create two int variables 'N' and 'S' and store the next two tokens in them
    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    //create an int 2D array 'data' and set it to N rows and 2 columns
    int[][] data = new int[N][2];

    //create a for loop tha runs N times
    for(int i = 0; i < N; i++){
      //reset the StringTokenizer object to read in the next input line
      st = new StringTokenizer (in.readLine());
      //set the first and second token in the StringTokenizer object to the current row in the data array
      data[i][0] = Integer.parseInt(st.nextToken());
      data[i][1] = Integer.parseInt(st.nextToken());
    }

    //create an int variable called 'power' and set it to 1
    int power = 1;
    //create an int variable called 'direction' and set it to 1
    //1 means going to the right; -1 means going to the left
    int direction = 1;

    //create an int array called 'brokenTargets' and set its size to N
    int[] brokenTargets = new int[N];

    int time = 0;

    //create a while loop that runs while S is within 1 to N inclusive
    while(S >= 1 && S <= N && time <= 3*N) {
      time += 1;
      //create an int variable called v and set it to the v-value of the current number within the number line (use S as a reference point of where we are currently at in the number line)
      int v = data[S-1][1];
      //case 1: Jump Pad
      //check if the current number from the data 2D array within the number line is equal to 0
      if (data[S-1][0] == 0) {
        //increment 'power' by v
        power += v;
        //multiply the current direction value by -1
        direction *= -1;
        
      }
      else { //case 2: Target
        //check if our power is >= v
        if (power >= v) {
          //set brokenTargets at index S-1 to 1
          brokenTargets[S-1] = 1;
        }
      }

      //update S by adding the product of direction and power
      S += (direction*power);
      
    }

    int sum = 0;
    for(int i = 0; i < brokenTargets.length; i++) {
      sum +=  brokenTargets[i];
    }
    System.out.println(sum);
    
  }

  
}