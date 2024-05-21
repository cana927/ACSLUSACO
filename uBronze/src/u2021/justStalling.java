//package u2021;
import java.util.*;
import java.io.*;

public class justStalling {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //read in the first line of input and store into an int variable called 'n'
    int n = Integer.parseInt(in.readLine());
    //create an Integer array called 'cows' with size 'n'
    Integer [] cows = new Integer[n];
    //create a StringTokenizer object called 'st' and read in the next input line
    StringTokenizer st = new StringTokenizer (in.readLine());
    //create a for loop that runs 'n' times
    for(int i = 0; i < n; i++){
      //store the next token into the 'cows' array at index 'i'
      cows[i] = Integer.parseInt(st.nextToken());
    }
    
    //set the StringTokenizer object to read in the next input line
    st = new StringTokenizer(in.readLine());

    //create an Integer array called 'stalls'' with size 'n'
    Integer [] stalls = new Integer[n];

    //create a for loop that runs 'n' times
    for(int i = 0; i < n; i++){
      //store the next token into the 'stalls' array at index 'i'
      stalls[i] = Integer.parseInt(st.nextToken());
    }

    //sort the 'stalls' array in ascending order
    Arrays.sort(stalls);

    //create a long variable called 'ans' and set it to 1
    long ans = 1;

    //create a for loop that runs n times
    for(int i = 0; i < n; i++){
      //create a long variable called 'howManyFit' and set it to 0
      long howManyFit = 0;
      //create a for each loop that iterates through each element of the 'cows' array
      for(int cow : cows) {
        //check if the current cow is less than or equal to the current stall height
        if (cow <= stalls[i]) {
          //if it is, increment 'howManyFit' by 1
          howManyFit ++;
        } 
      }

      //subtract 'i' from 'howManyFit'
      howManyFit -= i;
      //multiply 'howManyFit' by 'ans' and store it into 'ans'
      ans *= howManyFit;
      
    }

    System.out.println(ans);
    
  }

}