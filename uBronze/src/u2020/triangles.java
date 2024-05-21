//package u2020;

import java.util.*;
import java.io.*;

public class triangles {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter out = new PrintWriter("triangles.out");

    // read in the first input line and store it in an int variable 'n'
    int n = Integer.valueOf(in.readLine());

    // create 2 integer arrays called 'x' and 'y' and set them to a size of 'n'
    int[] x = new int[n];
    int[] y = new int[n];
    // create a for loop that iterates n times
    for (int i = 0; i < n; i++) {
      // create a StringTokenizer object that reads in the next input line
      StringTokenizer st = new StringTokenizer(in.readLine());
      // take the first token and store it in the 'x' array at index 'i'
      x[i] = Integer.parseInt(st.nextToken());
      // take the second token and store it in the 'y' array at index 'i'
      y[i] = Integer.parseInt(st.nextToken());

    }

    int max = 0;
    // create a for loop that iterates n times; use variable i
    for (int i = 0; i < n; i++) {
      // create a for loop that iterates n times; use variable j
      for (int j = 0; j < n; j++) {
        // create a for loop that iterates n times; use variable k
        for (int k = 0; k < n; k++) {
          if (y[i] == y[j] && x[i] == x[k]) {
            // create an int variable called 'area' and set it equal to the absolute value
            // of the difference between the x values * the difference between the y values
            int area = Math.abs((x[j] - x[i]) * (y[k] - y[i]));
            // compare the current 'max' with the calculated 'area' value and store the
            // bigger value into 'max'
            max = Math.max(max, area);

          }
        }
      }
    }

    out.println(max);
    in.close();
    out.close();

  }

}