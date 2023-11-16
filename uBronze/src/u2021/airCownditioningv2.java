package u2021;
import java.util.*;
import java.io.*;

public class airCownditioningv2 {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    //create an int variable called 'n' and read in the first line of input and store it there
    int n = Integer.parseInt(in.readLine());
    //create an int variable called 'ans' and set it to 0
    int ans = 0;
    //create an int array called 'a' and set it to a size of n
    int[] a = new int[n];

    //create a StringTOkenizer object called 'st' and set it to read the next input line
    StringTokenizer st = new StringTokenizer(in.readLine());

    //create a for loop that starts at 0 and iterates n times
    for(int i = 0; i < n; i++){
      //set a[i] to the next token using the StringTokenizer object (parse as necessary)
      a[i] = Integer.parseInt(st.nextToken());
    }

    //re-initialize the StringTokenizer object to read the next input line
    st = new StringTokenizer(in.readLine());
 
    //create a for loop that starts at 0 and iterates n times
    for(int i = 0;i < n;i ++){
      //set a[i] equal its current value - the next token
      a[i] = a[i] - Integer.parseInt(st.nextToken());
    }

    //set 'ans' to the absolute value of the first value inside the array 'a'
    ans = Math.abs(a[0]);

    //create a for loop that starts at 0 and iterates to n-1
    for(int i = 0; i < n-1; i++) {
      //add the absolute value of the difference of a[i] and a[i+1] to 'ans'
      ans += Math.abs(a[i] - a[i+1]);
      
    }

    //add the absolute value of the last value in the array 'a' into 'ans'
    ans += Math.abs(a[n-1]);

    //divide ans by 2 and update its value
    ans = ans/2;

    System.out.println(ans);
    
  }
}