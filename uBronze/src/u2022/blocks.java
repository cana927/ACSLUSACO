//package u2022;

import java.util.*;
import java.io.*;
public class blocks {

  //create a static integer variable N and just declare it
  static int N;
  //create a static String array called 'cubes' and set it equal to a size of 4
  static String[] cubes = new String[4];
  //create a static String array called 'words' and set it equal to a size of 10
  static String[] words = new String[10];
  //create a static ArrayList of Strings called 'possibleWords' and set it to an empty ArrayList
  static ArrayList<String> possibleWords = new ArrayList <String> ();
  
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //read in the first input line and set N equal to it
    N = Integer.valueOf(in.readLine());
    //create a for-loop that iterates from 0 to 4
    for(int i = 0; i < 4; i++){
      //populate the cubes array by reading in the next input lines
      cubes[i] = in.readLine();
    }

    //call the generateWords method and pass in "" and new boolean[4]
    generateWords("", new boolean[4]);

    //process our queries
    //create a for loop that iterates from 0 to N
    for(int i = 0; i < N; i++){
      //set words[i] equal to the next input line being read
      words[i] = in.readLine();
      //create a boolean variable called 'possible' and set it to false
      boolean possible = false;

      //create a for-each loop that iterates through our 'possibleWords' ArrayList
      for (String s : possibleWords) {
        //create an if statement that checks if the current word we are iterating through is equal to words[i]
        if(s.equals(words[i])) {
          //set possible to true and break
          possible = true;
          break;
          
        }
        
      }
      if(possible) {
        System.out.println("YES");
      }
      else {
        System.out.println("NO");
      }
    }
          
  }

  //recursively generate all possible words
  //create a public static void method called 'generateWords' and set it to have parameters of String 'currentWord' and boolean array called 'cubesUsed'
  public static void generateWords (String currentWord, boolean [] cubesUsed) {
    //add the currentWord into the 'possibleWords' ArrayList
    possibleWords.add(currentWord);
    //pick the next cube
    //create a for-loop that iterates from 0 to 4
    for (int i = 0; i < 4; i++) {
      //check if cubesUsed at index i has not been used
      //create an if statement that checks if !cubesUsed[i]
      if(!cubesUsed[i]) {
        //pick which letter to use
        //set cubesUsed[i] to true
        cubesUsed[i] = true;
        //create a for loop that iterates from 0 to 6
        for (int j = 0; j < 6; j++) {
          generateWords(currentWord+cubes[i].charAt(j), cubesUsed);
        }
        //set cubesUsed[i] to false
        cubesUsed [i] = false;
      }
    }
    
  }
  
}
