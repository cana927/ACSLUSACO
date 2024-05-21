import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'play2248' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING boardValues as parameter.
     */

    public static String play2248(String boardValues) {
        int [][] board = new int [8][5];
        StringTokenizer st = new StringTokenizer (boardValues);
        
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // System.out.println ("OG board");
        // for (int i=0; i<8; i++) {
        //     for (int j = 0; j<5; j++) {
        //         System.out.print (board[i][j] + " ");
        //     }
        //     System.out.println ();
        // }
        
        //find start
        String start = findStart(board);
        st = new StringTokenizer (start);
        
        //find path and delete path
        board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 0;
        int [][] foundpath = findpath (board, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        // System.out.println ("Found path");
        // for (int i=0; i<8; i++) {
        //     for (int j = 0; j<5; j++) {
        //         System.out.print (foundpath[i][j] + " ");
        //     }
        //     System.out.println ();
        // }
        
        //delete all too small
        int biggestval = findbiggestvalue (foundpath);
        
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<5; j++) {
                if (foundpath[i][j] <= Math.pow(2, biggestval-8)) {
                    foundpath[i][j] = 0;
                }
            }
        }
        
        //shift board down
        int [][] downboard = movedown (foundpath);
        // System.out.println ("Down board");
        // for (int i=0; i<8; i++) {
        //     for (int j = 0; j<5; j++) {
        //         System.out.print (downboard[i][j] + " ");
        //     }
        //     System.out.println ();
        // }
        
        //fill board
        int [][] finalboard = fillboard (downboard, biggestval);
        
        // System.out.println ("Final board");
        // for (int i=0; i<8; i++) {
        //     for (int j = 0; j<5; j++) {
        //         System.out.print (finalboard[i][j] + " ");
        //     }
        //     System.out.println ();
        // }
        
        String answer = "";
        
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<5; j++) {
                answer += finalboard[i][j] + " ";
            }
        }
        
        return answer.substring(0, answer.length()-1);
    }
    
    public static String findStart (int [][] board) {
        for (int i = 0; i< 8; i++) {
            for (int j = 0; j<5; j++) {
                int val = board[i][j];
                
                //check right
                if (j!=4 && board[i][j+1] == val) {
                    return "" + i + " " + j + " " + i + " " + (j+1);
                }
                
                //check bottom left
                if (j!=0 && i!= 7 && board[i+1][j-1] == val) {
                    return "" + i + " " + j + " " + (i+1) + " " + (j-1);
                }
                
                //check bottom
                if (i!=7 && board[i+1][j] == val) {
                    return "" + i + " " + j + " " + (i+1) + " " + j;
                }
                
                //check bottom right
                if (j!=4 && i!= 7 && board[i+1][j+1] == val) {
                    return "" + i + " " + j + " " + (i+1) + " " + (j+1);
                }
            }
        }
        return "";
    }
    
    static int sum;
    
    public static int [][] findpath (int [][] board, int i, int j) {
        int val = board[i][j];
        sum += val; 
        //if found: clear previous and replace square with new value; return findpath

        //check left
        if (j!=0 && (board[i][j-1] == val || board[i][j-1] == val*2)) {
            board [i][j] = 0;
            return findpath (board, i, j-1);
        }
            
        //check right
        else if (j!=4 && (board[i][j+1] == val || board[i][j+1] == val*2)) {
            board [i][j] = 0;
            return findpath (board, i, j+1);
        }
            
        //check bottom left
        else if (j!=0 && i!= 7 && (board[i+1][j-1] == val || board[i+1][j-1] == val*2)) {
            board [i][j] = 0;
            return findpath (board, i+1, j-1);
        }
            
        //check bottom
        else if (i!= 7 && (board[i+1][j] == val || board[i+1][j] == val*2)) {
            board [i][j] = 0;
            return findpath (board, i+1, j);
        }
            
        //check bottom right
        else if (j!=4 && i!= 7 && (board[i+1][j+1] == val || board[i+1][j+1] == val*2)) {
            board [i][j] = 0;
            return findpath (board, i+1, j+1);
        }
            
        //if not found: return board
        else {
            int powval = 0;
            while (sum > Math.pow(2,powval)) {
                powval ++;
            }
            board[i][j] = (int) Math.pow(2, powval);
            return board;
        }
    }
    
    public static int findbiggestvalue (int [][] board){
        int val = 0;
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<5; j++) {
                while (board [i][j] > Math.pow(2, val)) {
                    val ++;
                }
            }
        }
        return val;
    }
    
    public static int [][] movedown (int [][] board) {
        for (int i = 7; i>0; i--) {
            for (int j = 0; j<5; j++) {
                if (board[i][j] ==0) {
                    int height = i;
                    while (height > 0 && board[height][j] == 0) {
                        height --;
                    }
                    board[i][j] = board[height][j];
                    board [height][j] = 0;
                }
            }
        }
        return board;
    }
    
    public static int [][] fillboard (int [][] board, int biggestval) {
        int curr = (int)(Math.pow (2, biggestval));
        
        for (int i = 0; i<8; i++) {
            for (int j = 0; j<5; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = curr;
                    curr /= 2;
                    if (curr <= (int)(Math.pow (2, biggestval-8))) {
                        curr = (int)(Math.pow (2, biggestval));
                    }
                }
            }
        }
        
        return board;
    }

}

public class _2324intc4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String boardValues = bufferedReader.readLine();

        String result = Result.play2248(boardValues);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
