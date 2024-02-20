//package u2023;

import java.util.*;
import java.io.*;

public class farmerJohnActuallyFarms {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create an int variable called 'test' and store the next input line in it
    int test = Integer.parseInt(in.readLine());
    //create a while loop that runs as long as the test variable is greater than 0 (decrement as well so that it isnt infinite)
    test: while(test-- > 0){
      //create an in variable called 'N' and store the next input line in it
      int N = Integer.parseInt(in.readLine());
      //create an int array called 'H' and store the method call to readArray() in it
      int [] H = readArray(in,N);
      //repeat the same process above but for int[] A
      int[] A = readArray(in, N);
      //repeat the same process above but for int[] T
      int[] T = readArray(in, N);

      //We are going to be sorting the plants from lowest T value to greatest
      //lower T value means bigger plant height
      //create a long 2D array called 'data' and set it to row size N and column size 2
      long[][] data = new long[N][2];
      //create a for loop that runs N times
      for(int i = 0; i < N; i++){
        //create a long array called 'temp' and set it to an array where the first value is H[i] and second is A[i]
        long[] temp = {H[i], A[i]};
        //store temp into data[T[i]]
        data[T[i]] = temp;
      }

      //create a long variable called 'days' and set it to 0
      long days = 0;
      //create a for loop that runs N-1 times
      for(int  i = 0; i < N-1; i++){
        //we are trying to check if plant 1 is taller than plant 2
        //create two long variables called 'H1' and 'H2' and set them to the ith and i+1th row of data and the 0th column, respectively
        long H1 = data[i][0];
        long H2 = data[i+1][0];
        //create two long variables called 'A1' and 'A2' and set them to the ith and i+1th row of data and the 1st column, respectively
        long A1 = data[i][1];
        long A2 = data[i+1][1];
        //H1 is the height of the plant that needs to be taller than H2
        //if the growth rate of H1 is smaller than H2, then it will never outgrow H2 (assuming H1 < H2)
        //create an if statement that check if H1 <= H2
        if (H1 <= H2) {
          //create another if statement that checks if A1 <= A2
          if (A1<=A2) {
            //print out -1
            System.out.println(-1);
            continue test;
          }
          //update days by getting the max value between days and the formula (H2-H1)/(A1-A2) + 1
          days = Math.max(days, (H2-H1)/(A1-A2) + 1);
          
        }
      }

      //grow all the plants by the number of days we calculated above
      //create a for loop that runs N times
      for(int i = 0; i < N; i++) {
        //apply the formula Height of plant = H[i] + A[i] * days
        data[i][0] += data[i][1] * days;
      }

      //check if the plant i is taller than plant i+1 for all values of i
      //create a for loop that runs N-1 times

      for(int i = 0; i < N - 1; i++) {
        //check if the current height of the plant in the data 2D array at index i is less than or equal to the plant at index i+1
        if (data[i][0] <= data[i+1][0]) {
          //print out -1
          System.out.println (-1);
          //force the 'test' loop to go to the next iteration
          continue test;
        }
        
      }

      System.out.println(days);
      
    }
    
  }

  public static int[] readArray(BufferedReader in, int n) throws IOException {
    StringTokenizer st = new StringTokenizer(in.readLine());
    int[] ret = new int[n];
    for(int i = 0; i < n; i++) {
      ret[i] = Integer.parseInt(st.nextToken());
    }
    return ret;
  }
  
}