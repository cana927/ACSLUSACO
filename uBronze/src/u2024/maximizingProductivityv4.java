//package u2024;


import java.util.*;
import java.io.*;

public class maximizingProductivityv4 {
  public static void main(String[] args) throws IOException {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create an int variable called "MAX_TIME" and set it to 1000001
    int MAX_TIME = 1000001;

    //read in the next input line, split it by a space, and store into a String[] called "input"
    String[] input = in.readLine().split(" ");
    //create two int variables called "N" and "Q" and set them to the first and second elements of the input array (parse as necessary)
    int N = Integer.parseInt(input[0]);
    int Q = Integer.parseInt(input[1]);

    //read in the next two input lines, split them by a space, and store them into String arrays called "cInput" and "tInput", respectively
    String[] cInput = in.readLine().split(" ");
    String[] tInput = in.readLine().split(" ");

    //create two int arrays called "C" and "T" and set them to a size of N
    int[] C = new int[N];
    int[] T = new int[N];
    //use a for loop to iterate through the C and T arrays and set each element to the corresponding element in the cInput and tInput arrays (parse as necessary)
    for (int i = 0; i < N; i++) {
      C[i] = Integer.parseInt(cInput[i]);
      T[i] = Integer.parseInt(tInput[i]);
    }

    //Create the visit array and increase visit[t] by 1 for each barn that can be visited if we
    //wake up at time t, but not if we wake up at time t+1

    //create an int array called "visit" and set it to a size of MAX_TIME
    int [] visit = new int [MAX_TIME];

    //create a for loop that iterates N times
    for(int i = 0; i < N; i++){
      //create an int variable called "leeway" and set it to C[i] - T[i] - 1
      int leeway = C[i] - T[i] - 1;
      //check if leeway is a non-negative number
      if (leeway >= 0) {
        visit[leeway] += 1;
      }
    }
    
    //create a for loop that starts at MAX_TIME-2 and iterates down to 0
    for (int i = MAX_TIME-2; i >= 0; i--) {
      //set visit[i] to the sum of visit[i] + visit[i+1]
      visit[i] = visit[i] + visit[i+1];
    }

    /*
      example:
      visit = [0,0,1,2,1,0,1]
      becomes:
      visit = [5,5,5,4,2,1,1]
    */

    //create a for loop that iterates Q times
    for(int i = 0; i < Q; i++) {
      //read in the next input line, split it by a space, and store it into the "input" array
      input = in.readLine().split(" ");
      //create two int variables "V" and "S" and set them to the first and second elements of the input array (parse as necessary)
      int V = Integer.parseInt(input[0]);
      int S = Integer.parseInt(input[1]);
      //check if V <= visit[S], if so, print "YES", otherwise print "NO"
      if(V <= visit[S]){
        System.out.println("YES");
      }else{
         System.out.println("NO");
      }
    }
    
  }

  
}