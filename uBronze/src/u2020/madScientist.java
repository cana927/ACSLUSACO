//package u2020;


import java.util.*;
import java.io.*;

public class madScientist {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new FileReader("breedflip.in"));
    PrintWriter out = new PrintWriter("breedflip.out");

    //read in the first line of input and store into an int variable 'n'
    int n = Integer.valueOf(in.readLine());
    //read in the second line of input and store into a char array 'a'
    //HINT: you can use .toCharArray() on a String to get a char array from it
    char [] a = in.readLine().toCharArray();
    //repeat the steps above and store into a char array 'b'
    char[] b = in.readLine().toCharArray();
    int ans = 0;

    while(!new String(a).equals(new String(b))) {

      //increment 'ans' by 1
      ans++;
      //create an int variable called 'lhs' and set it to 0
      int lhs = 0;
      //create a while loop that checks if a[lhs] is equal to b[lhs]
      while(a[lhs] == b[lhs]){
        lhs++;
      }
      //create an int variable called 'rhs' and set  it to n-1
      int rhs = n - 1;
      //create a while loop that checks if a[rhs] is equal to b[rhs], and decrement rhs by 1
      while (a[rhs] == b[rhs]) {
        rhs--;
      }

      //create a for loop that iterates from lhs to rhs (inclusive)
      for(int i = lhs; i <= rhs; i++){
        //check if a[i] is equal to 'G', if so set a[i] to 'H'
        if(a[i] == 'G') {
          a[i] = 'H';
        }//create the else statement that changes a[i] to 'G'
        else {
          a[i] = 'G';
        }
      }
      
      
    }

    out.println(ans);
    in.close();
    out.close();
    
  }

  
}