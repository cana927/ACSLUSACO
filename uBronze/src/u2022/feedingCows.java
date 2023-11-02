//package u2022;
import java.util.*;
import java.io.*;

public class feedingCows {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //read in the first line and parse it as an integer and store it into a variable called 'T'
    //Hint: in.readLine()
    int T = Integer.parseInt(in.readLine());
    //create a for loop that iterates a total of T number of times
    for(int t = 0;t < T; t++){

      //create a StringTOkenizer object and initialize it by reading in the next line
      StringTokenizer st = new StringTokenizer(in.readLine());
      //create an int variable 'N' and 'K' and store the next two tokens in them
      int N = Integer.valueOf(st.nextToken());
      int K = Integer.valueOf(st.nextToken());
      //Hint: st.nextToken() <-- reads in the next available token

      //create a char[] called 'cows' and store the next line into it
      //by using the .toCharArray() on the string
      char[] cows = in.readLine().toCharArray();
      char[] answer = new char[N];
      Arrays.fill(answer, '.');

      //set value to be unreachable at first
      //create int variables called lastG and lastH that will hold the value -K-1
      int lastG = -K-1;
      int lastH = -K-1;
      int count = 0;

      //create a for loop that iterates N total times
      for(int i = 0; i < N; i++) {

        //check if Guernsey is NOT within reach of food
        //Conditions: is the current cow a Guernsey? and is i-lastG > K?
        if(cows[i] == 'G' && (i-lastG > K)){
          //setting lastG while being bound by the length
          lastG = Math.min(i+K, N-1);
          if(answer[lastG] != '.') {
            lastG--;
          }
          answer[lastG] = 'G';
          count++;
        }
        else if(cows[i] == 'H' && (i-lastH > K)) {
          lastH = Math.min(i+K, N-1);
          if(answer[lastH] != '.') {
            lastH--;
          }
          answer[lastH] = 'H';
          count++;
        }
        
      }

      //print count
      System.out.println(count);
      //print out our answer[] in the format as shown in the example output
      System.out.println(String.valueOf(answer));
    }
    
  }
}

