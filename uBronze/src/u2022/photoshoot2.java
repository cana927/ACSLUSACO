//package u2022;
import java.io.*;
import java.util.*;

public class photoshoot2 {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //read in input N and store in an integer variable
    int n = Integer.valueOf(in.readLine());
    //create a StringTokenizer object called stA and set it to read the next input line
    StringTokenizer stA = new StringTokenizer(in.readLine());
    //create a StringTokenzer object called stB and set it to read the next input line
    StringTokenizer stB = new StringTokenizer(in.readLine());

    //create two integer arrays called a and b respectively, and set them to be of size n
    int [] a = new int[n];
    int [] b = new int[n];

    //create a forloop that iterates from 0 to n and populates the a and b arrays
    for (int i = 0; i<n; i++){
      //populate the integer array 'a' using the StringTokenizer object above
      a[i] = Integer.parseInt(stA.nextToken());
      //populate the integer array 'b' using the StringTokenizer object above
      b[i] = Integer.valueOf(stB.nextToken());
    }

    //we want to greedily move cows in order of list B
    //we also want to keep track of where we are in list A
    int answer = 0; //keeps track of # of modifications
    boolean[] moved = new boolean[n+1]; // keeps track of which cows have already been moved
    int k = 0; //keep track of where we are at in list A

    //create a for loop that iterates from 0 to n
    for(int i = 0; i < n; i++){
      //create a while loop that will skip over cows that are already moved
      //the condition in the while loop will be: moved[a[k]]
      while(moved[a[k]]) {
        k++;
      }

      //we want to move cow b[i] intoi place (if it is not already there)
      //create an if statement that checks if b[i] is equal to a[k]
      if (b[i] == a[k]) { //cow b[i] is already in place
        k++;
      }
      else { //we need to move this cow
        //increment answer by 1
        answer ++;
        //set the value of moved[b[i]] to true
        moved[b[i]] = true; //mark it as moved instead of actually moving it
      }
      
    }
    System.out.println(answer);
  }
}