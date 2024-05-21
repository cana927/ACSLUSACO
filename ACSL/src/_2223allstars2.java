
public class _2223allstars2 {
	static int [] nums = new int [200];
    
    public static String sumsNotCommon(String intervals1, String intervals2, String intervals3) {
        boolean isThree = true;
        if (intervals3.equals("null")){
            isThree = false;
        }
        String output = "";
        
        getNums (intervals1);
        getNums (intervals2);
        if (isThree) {
            getNums(intervals3);
        }
        
        int total = 0;
        for (int i =0; i<200; i++) {
            if (nums[i]==1) {
                total += i-100;
            }
        }
        output += total;
        
        if (isThree) {
            total = 0;
            for (int i =0; i<200; i++) {
                if (nums[i]==2) {
                    total += i-100;
                }
            }
            output += " " + total;
        }
        return output;
    }
    
    public static void getNums (String interval) {
        String [] i = interval.split(" ");
        
        for (String ints : i ) {
            int beg = -1;
            int end = -1;
            int comma = -1;
            for (int r = 0; r<ints.length(); r++) {
                if (ints.charAt(r) == ',') {
                    comma = r;
                }
            }
            
            if (ints.charAt(0) == '[') {
                beg = Integer.parseInt(ints.substring(1,comma));
            }
            else {
                beg = Integer.parseInt(ints.substring(1,comma))+1;
            }
            
            if (ints.charAt(ints.length()-1) == ']') {
                end = Integer.parseInt(ints.substring(comma+1,ints.length()-1));
            }
            else {
                end = Integer.parseInt(ints.substring(comma+1,ints.length()-1)) -1;
            }
            
            for (int r = beg; r<=end; r++) {
                nums[r+100] ++;
            }
        }
    }
}
