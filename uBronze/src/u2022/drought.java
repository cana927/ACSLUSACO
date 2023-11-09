//package u2022;
import java.util.*;

public class drought {
	public static void main(String[] args) {

	    Scanner in = new Scanner(System.in);
	    int T = in.nextInt();
	    while(T-- > 0) {

	      int n = in.nextInt() + 2;
	      long[] arr = new long[n];

	      for(int i = 1; i < n-1; i++) {
	        arr[i] = in.nextLong();
	      }

	      long cornUsed = 0, diff = 0;
	      boolean works = true;

	      for(int i = 2; i < n-1; i++) {

	        if(arr[i-1] < arr[i]) {
	          diff = arr[i] - arr[i-1];
	          arr[i] -= diff;
	          arr[i+1] -= diff;

	          if(arr[i+1] < 0) {
	            works = false;
	          }

	          cornUsed += diff*2;
	        }
	        else if(arr[i-1] > arr[i]) {
	          diff = arr[i-1] - arr[i];
	          cornUsed += diff*(i-1);

	          works = (i%2 == 1);
	        }

	        if(!works) {
	          break;
	        }
	        
	      }

	      if(works) {
	        System.out.println(cornUsed);
	      }
	      else {
	        System.out.println(-1);
	      }
	      
	    }
	    
	  }
}
