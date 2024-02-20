//package u2021;
import java.util.*;
import java.io.*;

public class walkingHome {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //read in the first line of input and store in int variable T
    int T = Integer.parseInt(in.readLine());

    //loop through each test case
    while(T-- > 0) {

      //create a StringTOkenizer object and initilize with the next input line
      StringTokenizer st = new StringTokenizer(in.readLine());

      //store the next two tokens into int variable n and k using the StringTokenizer object
      int n = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());

      //create a char 2D array called 'g' of row size n and omit the column size

      char[][] g = new char[n][];
      //create a loop that iterates n times
      
      for(int i = 0; i  < n; i++){
        //read in the next input line and call .toCharArray() on that line and store into g[i]
        g[i] = in.readLine().toCharArray();
      }

      int result = 0;

      //create a loop that checks if k >= 1
      if(k >= 1) {
        //create two boolean variables called 'urcorner' and 'dlcorner' and set to true
        boolean urcorner = true;
        boolean dlcorner = true;
        //create a loop that iterates n times
        for (int i = 0; i < n; i++) {
          if(g[0][i] == 'H' || g[i][n-1] == 'H') urcorner = false;
          //create an if statement that checks if g[i][0] == 'H' or g[n-1][i] == 'H'
          if (g[i][0] == 'H' || g[n-1][i] == 'H') {
            dlcorner = false;
          }
        }
        result += urcorner ? 1 : 0;
        result += dlcorner ? 1 : 0;
      }
      //create an if statement that checks if k >= 2
      if (k >= 2) {
        for(int j = 1; j < n-1; j++) {
          boolean valid = true;
          for(int i = 0; i < n; i++) {
            if(g[i][j] == 'H') valid = false;
            if(i < j && g[0][i] == 'H') valid = false;
            if(i > j && g[n-1][i] == 'H') valid = false;
          }
          result += valid ? 1 : 0;
        }

        //create a loop using i as the variable that loops from 1 to n-1
        for(int i = 1; i < n-1; i++) {
          //create a boolean variable called valid and set to true
          boolean valid = true;
          //create a loop using j as the variable that loop from 0 to n
          for (int j = 0; j < n; j++) {
            //create an if statement that checks if g[i][j] == 'H'
            if (g[i][j] == 'H') valid = false;
            //create an if statement that checks if j < i and g[j][0] == 'H'  m
            if (j < i && g[j][0] == 'H') valid = false;
            //create an if statement that checks if j > i and g[j][n-1] == 'H'
            if(j > i&& g[j][n-1] == 'H'){
              valid = false;
            }
          }
          //add 1 to result if valid is true and 0 otherwise
          result += valid ? 1 : 0;
        }
        
      }
      //create an if statement that checks if k >= 3
      if(k >= 3) {
        //create a nested for loop with the outer loop using i going from 1 to n-1
        //and the inner loop using j going from 1 to n-1
        for(int i = 1; i < n-1; i++){
          for(int j = 1; j < n-1; j++){
            //RDRD
            //create a boolean variable called valid and set it equal to g[i][j] == '.'
            boolean valid = g[i][j] == '.';
            //create a loop using a as a variable that loops from 0 to n
            for (int a = 0; a<n; a++) {
              if(a <= i && g[a][j] == 'H') valid = false;
              if(a >= i && g[a][n-1] == 'H') valid = false;
              if(a <= j && g[0][a] == 'H') valid = false;
              if(a >= j && g[i][a] == 'H') valid = false;
            }
            result += valid ? 1 : 0;
            //reset valid to be equal to g[i][j] == '.'
            valid = g[i][j] == '.';
            //DRDR
            //create a loop using a as a variable that loops from 0 to n
            for(int a = 0; a < n; a++){
              if(a <= i && g[a][0] == 'H') valid = false;
              if(a >= i && g[a][j] == 'H') valid = false;
              if(a <= j && g[i][a] == 'H') valid = false;
              if(a >= j && g[n-1][a] == 'H') valid = false;
            }
            result += valid ? 1 : 0;
          }
        }  
      }
      System.out.println(result);
    }
    
  }
}