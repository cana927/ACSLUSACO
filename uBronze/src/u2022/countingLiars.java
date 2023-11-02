//package u2022;

import java.util.*;
import java.io.*;

public class countingLiars {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //read in the first line and store it into an int variable called n
    int n = Integer.parseInt(in.readLine());
    //create an array of Cow objects
    Cow[] infos = new Cow[n];
    //create a for-loop that iterates from 0 to n
    for (int i = 0; i < n; i++) {
      //create a StringTokenzier object and initialize it with the next input line
      StringTokenizer st = new StringTokenizer(in.readLine());
      //create a char variable called direction and read in the next token and store it here
      char direction = st.nextToken().charAt(0);
      //create an int variable called reference and store the next token in it
      int reference = Integer.valueOf(st.nextToken());

      //create a Cow object and store it in the infos array at the current index using the two variables above
      infos[i] = new Cow(direction, reference);
    }

    int answer = n;

    //create a for-each loop that iterates through every value in the infos array
    for (Cow info : infos) {
      //create a variable called x and set it equal to info.reference
      int x = info.reference;
      //create an int variable called liars and set it equal to 0
      int liars = 0;

      //create another for-each that iterates over the infos array
      for (Cow info2 : infos) {
        //create an if statement that checks if the info2.direction is equal to 'G' and if x is less than info2.reference
        if(info2.direction == 'G' && x < info2.reference){
          liars++;
        }
        else if(info2.direction == 'L' && x > info2.reference) { //check if info2.direction is 'L' and if x is greater than info2.reference
          liars++;
        }  
      }
      //setting answer to the smaller value between answer and liars
      answer = Math.min(answer, liars);
      
    }
    System.out.println(answer);
  }

  public static class Cow {
    public final char direction;
    public final int reference;

    public Cow(char direction, int reference) {
      this.direction = direction;
      this.reference = reference;
    }
  }
  
}