//package u2024;
import java.util.*;
import java.io.*;

public class walkingFence {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    //Create two integer variables N and P and assign the next two tokens into those variables
    int N = Integer.parseInt(st.nextToken());
    int P = Integer.parseInt(st.nextToken());

    //create an integer 2D array called 'posts' with P rows and 2 columns
    int [][] posts = new int[P][2];
    //create an integer 2D array called 'cows' with N rows and 4 columns
    int [][] cows = new int [N][4];
 
    //create a for loop that iterates P times
    for(int i = 0; i < P; i++){
      //set the 'st' StringTokenizer object to the next input line
      st = new StringTokenizer(in.readLine());
      //set the first and second tokens of the input line to the first and second elements of the 'posts' array at the current row i
      posts[i][0] = Integer.parseInt(st.nextToken());
      posts[i][1] = Integer.parseInt(st.nextToken());
    } 

    //create a for loop that iterates N times
    for (int i = 0; i < N; i++) {
      //set the 'st' StringTokenizer object to the next input line
      st = new StringTokenizer(in.readLine());
      //set the next 4 tokens into the current row i of the cows 2D array
      cows[i][0] = Integer.parseInt(st.nextToken());
      cows[i][1] = Integer.parseInt(st.nextToken());
      cows[i][2] = Integer.parseInt(st.nextToken());
      cows[i][3] = Integer.parseInt(st.nextToken());
    }

    //create an integer 2D array called 'grid' and set it to a 1001x1001 2D array
    int[][] grid = new int[1001][1001];
    //create an int variable called 'time' and set it to 0
    int time = 0;

    //create a for loop that iterates P times
    for(int i = 0; i < P; i++) {

      int[] curr = posts[i];
      int[] next = posts[(i+1)%P];
      //Case #1: curr x coord < next x coord
      //create an if statement that checks if the current x coord is less than the next x coord
      if (curr[0] < next[0]) {
        //create a for loop that iterates from the current x coord to the next x coord (exclusive)
        for (int r = curr[0]; r<next[0]; r++) {
          grid[r][curr[1]] = time;
          time += 1;
        }
      }

      //Case #2: curr x coord > next x coord
      //create an if statement that checks if the current x coord is greater than the next x coord
      if(curr[0] > next[0]){
        //create a for loop that iterates from the current x coord to the next x coord (exclusive AND should be decrementing since curr x > next x)
        for(int r = curr[0]; r > next[0]; r--) {
          //update the grid at the current (r,curr[1]) position with time and then update time
          grid[r][curr[1]] = time;
          time += 1;
        }
      }

      //Case #3: curr y coord < next y coord
      //create an if statement that checks if the curr y coord is less than the next y coord
      if (curr[1] < next[1]) {
        //create a for loop that iterates from the curr y coord to the next y coord(exclusive)
        for(int j = curr[1]; j < next[1]; j++){
          //update the grid at the current (curr[0],j) position with time and then update time
          grid[curr[0]][j] = time;
          time += 1;
        }
      }

      //Case #4: curr y coord >  next y coord
      //create an if statement that checks if the curr y coord is greater than the next y coord
      if (curr[1] > next[1]) {
        //create a for loop that iterates from the curr y coord to the next y coord (exclusive AND should be decrementing since curr y > next y)
        for (int j = curr[1]; j>next[1]; j-- ) {
          //update the grid at the current (curr[0],j) position with time and then update time
          grid[curr[0]][j] = time;
          time += 1;
        }
      }
      
    }

    for(int[] cow: cows) {
      int t1 = grid[cow[0]][cow[1]];
      int t2 = grid[cow[2]][cow[3]];
      System.out.println(Math.min(((t1-t2)%time+time)%time,((t2-t1)%time+time)%time));
    }
    
  }

}