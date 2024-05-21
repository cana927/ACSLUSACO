import java.util.*;

public class _2223jrc4 {
	public static String arrowForMostTargets(int size, String targets) {
        int [][] board = new int [size][size];
        int max = 0;
        String output = "";
        
        StringTokenizer st = new StringTokenizer (targets);
        while (st.hasMoreElements()) {
            String tar = st.nextToken();
            board[tar.charAt(0)-'0'][tar.charAt(1)-'0'] = 1;
        }
        Character [] listoflets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        
        for (int i = 0; i<size; i++) {
            for (int r = 0; r<size; r++) {
                if (r == 0 || i ==0 || r == size-1 || i == size-1) {
                    for (Character ch : listoflets) {
                        int nums = hit (board, i,r,ch);
                        if (nums > max) {
                            output = "" + i + r + Character.toString(ch);
                        }
                    }
                }
            }
        }
        return output;
    }
    public static int hit (int [][] board, int r, int c, Character direction) {
        if (direction == 'A') {
            int max = 0;
            
        }
        else if (direction == 'B') {
            
        }
        else if (direction == 'C') {
            
        }
        else if (direction == 'D') {
            
        }
        else if (direction == 'E') {
            
        }
        else if (direction == 'F') {
            
        }
        else if (direction == 'G') {
            
        }
        else {
            
        }
    }
}
