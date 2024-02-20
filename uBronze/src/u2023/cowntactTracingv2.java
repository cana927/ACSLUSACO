//package u2023;
import java.io.*;
import java.util.*;

public class cowntactTracingv2 {
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    String cows = in.readLine();

    //if original input has no infected cows, we will simply return 0
    if(cows.indexOf("1") == -1) {
      System.out.println(0);
      System.exit(0);
    }

    //create an Arraylist to store the segment/interval sizes
    ArrayList<Integer> segments = new ArrayList<>();
    int interval = 0;
    for(int i = 0; i < n; i++) {
      if(cows.charAt(i) == '1') {
        interval++;
      }
      else {
        if(interval > 0) {
          segments.add(interval);
          interval = 0;
        }
      }
    }
    if(interval > 0) segments.add(interval);

    //number of segments/intervals
    int L = segments.size();

    //to account for the edge case where the ends of the bit string can be 1, we will create boolean variables leftZero and right Zero
    boolean leftZero = cows.charAt(0) == '0';
    boolean rightZero = cows.charAt(n-1) == '0';
    //use formula: maxDays = length of segment - 1 (this is for when 1 is at the ends)
    int maxDays = Math.min(segments.get(0), segments.get(L-1)) - 1;
    //use formula: maxDays = (length of segment - 1) / 2
    if(leftZero) {
      maxDays = Math.min(maxDays, (segments.get(0)-1)/2);
    }
    if(rightZero) {
      maxDays = Math.min(maxDays, (segments.get(L-1)-1)/2);
    }

    //we have already accounted for the segments at each end with their potential edge cases, so now we just need to check all the segments in between
    for(int i = 1; i < L-1; i++) {
      maxDays = Math.min(maxDays, (segments.get(i)-1)/2);
    }

    int ans = 0;
    for(int i = 0; i < L; i++) {
      //using formula: min # of cows to start with = length of segment / spread
      ans += segments.get(i) / (2*maxDays+1);
      //account for edge case with even number of infected cows
      if(segments.get(i) % (2*maxDays+1) != 0) {
        ans += 1;
      }
    }

    System.out.println(ans);
    
  }

}
