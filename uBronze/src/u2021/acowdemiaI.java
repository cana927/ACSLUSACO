//package u2021;

import java.util.*;
import java.io.*;
public class acowdemiaI {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create a StringTokenizer object to read in the next input line
    StringTokenizer st = new StringTokenizer(in.readLine());

    //create an int variable called 'n' and store the next token in it
    int n = Integer.parseInt(st.nextToken());
    //create an int variable called 'l' and store the next token in it
    int l = Integer.parseInt(st.nextToken());

    //create an Integer array called papers and create it with a size of 'n'
    Integer [] papers = new Integer [n];

    //reset the StringTOkenizer object to read in the next input line
    st = new StringTokenizer(in.readLine());  

    //create a for loop that interates 'n' times
    for (int i = 0; i < n; i++) {
      //read in the next token and store it in the ith index of the papers array
      papers[i] = Integer.parseInt(st.nextToken());
    }

    //sort our array in reverse order (largest value to smallest value)
    Arrays.sort(papers, Comparator.reverseOrder());

    //create an in variable called 'h' and set it equal to a call to 'hIndex'
    int h = hIndex(papers);

    //create an if statement that checks if 'h' is not equal to 'n'
    if (h != n) {
      //create a for loop that starts at 'h' and checks j >= 0 and if j > h-l
      //the loop will decrement by 1 as long as the above condition is true
      for (int j = h; j>=0 && j > h-l; j--) {
        //increment the value at papers[j] by 1
          papers[j] +=1;
      }
    }

    //sort the papers array in reverse order again, just in case any new values are out of place
    Arrays.sort(papers, Comparator.reverseOrder());

    //print out another call to hIndex
    System.out.println(hIndex(papers));
    
  }

  //create a public static method header called 'hIndex' that takes in an Integer array called 'papers' and returns an int
  public static int hIndex (Integer [] papers) {

    //create an int variable called 'h' and set it equal to the length of 'papers'
    int h = papers.length;

    //create a while loop that checks if h > 0 and that papers[h-1] < h
    
    while(h>0 && papers[h-1] < h){
      //decrement h by 1
      h--;
    }
    return h;
  }
  
  
}