//package u2021;

import java.util.*;
import java.io.*;

public class acowdemiaIII {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create a StringTokenizer object that reads in the next input line
    StringTokenizer st = new StringTokenizer(in.readLine());

    //create an int variable n and m that store the next two tokens in them
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    //create a char 2D array called 'pasture' that is initialized to n+2 rows and fully omit the columns
    char[][] pasture = new char[n+2][];

    //initialize pasture[0] to a new char array of size m+2
    pasture[0] = new char[m+2];

    //use Arrays.fill to fill the first row of pasture with '.'
    Arrays.fill(pasture[0], '.');

    //set pasture[n+1] to be equal to pasture[0]
    pasture[n+1] = pasture[0];

    //create a for loop that iterates from 1 to n (inclusive) 
    for (int i = 1; i<=n; i++) {
      pasture[i] = ('.' + in.readLine() + '.').toCharArray();
    }

    int answer = 0;
    //create a nested for loop that iterates from 1 to n (inclusive) for the outer loop and 1 to m (inclusive) for the inner loop)
    for(int i = 1;i <= n;i ++){
      for(int j = 1;j <= m;j ++){
        //create an if statement that checks if the current character in the pasture is 'G'
        //in the same if statement, add in a condition that also checks if the left and right side of the 'G' are 'C' characters
        //in the same if statement, add in a condition that also checks if the top and bottom side of the 'G' are 'C' characters
        if(pasture[i][j] == 'G' && ((pasture[i][j-1] == 'C' && pasture[i][j+1] == 'C') || 
                                    (pasture[i+1][j] == 'C' && pasture[i-1][j] == 'C'))){
          //if the above conditions are met, change the current character in pasture to a '.'
          pasture[i][j] = '.';
          //increment the answer by 1
          answer++;
        }
      }
    }

    //create another nested for loop like the one above
    for(int i =1; i <= n;i++){
      for(int j = 1; j <= m; j++){
        //create an if statement that checks if the current character in the pasture is 'C'
        if (pasture[i][j] == 'C'){
          //create an if statement that checks if the bottom left diagonal of the current character is 'C'
          if(pasture[i+1][j-1] == 'C'){
            //check if the left of the current character is 'G'
            if (pasture [i][j-1] == 'G') {
              //turn the 'G' into a '.''
              pasture[i][j-1] = '.';
              //increment the answer by 1
              answer++;
            }
            else if(pasture[i+1][j] == 'G') {
              //turn the 'G' into a '.' and increment answer by 1
              pasture[i+1][j] = '.';
              answer++;
            }
          }
          //create an if statement that checks if the bottom right diagonal of the current character is 'C'
          if(pasture[i+1][j+1] == 'C'){
            //check if the right side of the current character is 'G'
            if (pasture [i][j+1] == 'G') {
              //turn the 'G' into a '.' and increment answer by 1
              pasture[i][j+1] = '.';
              answer++;
            }//create an else if that checks if the character right below is a 'G'
            else if(pasture[i+1][j] == 'G'){
              //turn the 'G' into a '.' and increment answer by 1
              pasture[i+1][j] = '.'; answer++;
            }
          }
          
        }
      }
    }

    System.out.println(answer);
    
  }

}