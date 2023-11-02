//package u2022;

import java.util.*;
import java.io.*;
public class alchemy {
  public static void main(String[] args) throws IOException{

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //read in the first line and store into an integer variable called 'n'
    int n = Integer.valueOf(in.readLine());

    StringTokenizer st = new StringTokenizer(in.readLine());
    int[] have = new int[n];

    //populate the metals that we have using a for loop
    for(int i = 0; i < n; i++) {
      have[i] = Integer.parseInt(st.nextToken());
    }

    int ans = 0;
    int[][] recipes = new int[n][];
    //read in the next line and store the integer value in a variable called 'k'
    int k = Integer.valueOf(in.readLine());

    //populate the recipes 2D Array
    while(k-- > 0) {
      //re-assign the StringTokenizer object to the next current line
      st = new StringTokenizer(in.readLine());
      int gain = Integer.parseInt(st.nextToken())-1;

      recipes[gain] = new int[Integer.parseInt(st.nextToken())];

      //populate the recipe with their respective ingredients
      //create a for-loop that iterates from 0 to recipes[gain].length
      for(int i = 0; i < recipes[gain].length; i++) {
        //set recipes[gain][i] to the next token in the current line
        recipes[gain][i] = Integer.valueOf(st.nextToken())-1;
      }

    }

    while(canMake(recipes, have, n-1)) {
      ans++;
    }
    
    System.out.println(ans);
    
  }

  public static boolean canMake(int[][] recipes, int[] have, int want) {

    //already have 1 or more of metal N
    if(have[want] > 0) {
      have[want]--;
      return true;
    }

    //no recipe exists for our metal N
    if(recipes[want] == null) {
      return false;
    }

    for(int ingredient: recipes[want]) {
      if(!canMake(recipes, have, ingredient)) {
        return false;
      }
    }

    return true;
    
  }
  
}