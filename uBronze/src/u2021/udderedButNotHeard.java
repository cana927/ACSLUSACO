//package u2021;

import java.util.*;
import java.io.*;

public class udderedButNotHeard {
  public static void main(String[] args) throws IOException  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create a char array called 'alphabet' that stores the first input line converted into a char array
    char[] alphabet = in.readLine().toCharArray();
    //create a char array called 'word' that stores the next input line converted into a char array
    char[] word = in.readLine().toCharArray();

    //create an in variable called 'ans' and set it to 1
    int ans = 1;
    //create two int variables called 'i' and 'k' and set them to 0
    int i = 0;
    int k = 0;

    //create a while loop that runs while i is less than the length of 'word'
    while (i<word.length) {

      //create a boolean variable called 'works' and set it to false
      boolean works = false;

      //create a for loop that iterates from 'k' to 26 (use variable j for the for loop)
      for(int j = k; j < 26; j++){
        //check if the letter from 'word' at index i is equal to the letter from 'alphabet' at index j
       if (word[i] == alphabet[j])  {
         //set k to be equal to j+1
         k = j + 1;
         //set works to true
         works = true;
         break;
       }
      }

      //check if !works
      if (!works) {
        //set k to 0 and increment ans by 1
        k=0;
        ans++;
      }
      else {
        //increment i by 1
        i++;
        
      }
      
    }

    //print ans
    System.out.println(ans);
    
  }

  
}