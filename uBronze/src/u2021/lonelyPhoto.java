//package u2021;
import java.io.*;
import java.util.*;

class lonelyPhoto {
	  public static void main(String[] args) throws IOException {

	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    //create an int variable called 'n' and set the first input line to it
	    int n = Integer.valueOf(in.readLine());
	    //create a char array called cows and set the next input line to it
	    //HINT: use .toCharArray() on the input line that you read
	    char[] cows = in.readLine().toCharArray();

	    //create a long variable called 'ans' and set it to 0
	    long ans = 0;
	    
	    //create a for loop that iterates through our cows array
	    for (int i = 0; i < n; i++) {

	      //create a long variable called 'lhs' and set it to 0
	      long lhs = 0;

	      //create an if statement that checks if i >0 and that cows[i-1] !=  cows[i]
	      
	      if(i > 0 && cows[i-1] != cows[i]){
	        //increment lhs by 1
	        lhs++;
	        for(int k = i-2; k >= 0 && cows[k] == cows[i-1]; k--) lhs++;
	      }
	  
	      //create a long variable called 'rhs' and set it to 0
	      long rhs = 0;

	      //create an if statement that checks if i+1 < n and that cows[i] != cows[i+1]
	      if(i + 1 < n && cows[i] != cows[i+1]) {
	        //increment rhs by 1
	        rhs++;
	        //create a for loop that starts at i+2 and iterates through the cows array as long as
	        //k < n and cows[k] == cows[i+1]

	        for (int k = i + 2; k < n && cows[k] == cows[i+1]; k++) {
	          //increment rhs by 1
	          rhs ++;
	        } 
	      }
	      ans += lhs * rhs + Math.max(lhs-1,0) + Math.max(rhs-1, 0);
	    }
	    
	    System.out.println(ans);
	    
	  }
	}