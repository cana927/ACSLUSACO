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
     * Complete the 'wordSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING rows_cols
     *  2. STRING gridLetters
     *  3. STRING words
     */

    public static String wordSearch(String rows_cols, String gridLetters, String words) {
        StringTokenizer st = new StringTokenizer (rows_cols);
        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());
        
        char [][] letterboard = new char [rows][cols];
        Boolean [][] checkuse = new Boolean [rows][cols];
        
        for (int r = 0; r<rows; r++) {
            for (int c = 0; c<cols; c++) {
                letterboard[r][c] = gridLetters.charAt(r*cols + c);
            }
        }
        
        // for (int r = 0; r<rows; r++) {
        //     for (int c = 0; c<cols; c++) {
        //         System.out.print (letterboard[r][c]);
        //     }
        //     System.out.println ();
        // }
        
        st = new StringTokenizer (words);
        
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            String solution = findword (s, letterboard);
            
            StringTokenizer st2 = new StringTokenizer (solution);
            for (int i = 0; i<s.length(); i++) {
                int r = Integer.parseInt(st2.nextToken());
                int c = Integer.parseInt(st2.nextToken());
                checkuse [r][c] = true;
            }
        }
        String finalanswer = "";
        for (int r = 0; r<rows; r++) {
            for (int c = 0; c<cols; c++) {
                if ((checkuse[r][c] == null)) {
                    finalanswer += letterboard[r][c];
                }
            }
        }
        
        return finalanswer;
    }
    
    public static String findword (String word, char [][] letterboard) {
        int rows = letterboard.length;
        int cols = letterboard[0].length;
        
        for (int r = 0; r<rows; r++) {
            for (int c = 0; c<cols; c++) {
                if (letterboard[r][c] == word.charAt(0)) {
                    String solution = foundword(word, letterboard, r, c);
                    //System.out.println ("solution: " + word + " " + solution);
                    if (solution.length() > 0) {
                        return solution;
                    }
                }
            }
        }
        return "";
    }
    
    public static String foundword (String word, char[][]letterboard, int r, int c) {
        int rows = letterboard.length;
        int cols = letterboard[0].length;
                
        //check up left
        int place = 1;
        int i = r-1;
        int j = c-1;
        String solution = "" + r + " " + c + " ";
        while (place < word.length() && i >= 0 && j >= 0 && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i--;
            j--;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        //check up
        place = 1;
        i = r-1;
        j = c;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && i >= 0 && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i--;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        //check up right
        place = 1;
        i = r-1;
        j = c+1;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && j < cols && i >= 0 && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i--;
            j++;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        //check right
        place = 1;
        i = r;
        j = c+1;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && j < cols && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            j++;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        //check down right
        place = 1;
        i = r+1;
        j = c+1;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && j < cols && i <rows && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i++;
            j++;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        //check down
        place = 1;
        i = r+1;
        j = c;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && i < rows && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i++;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        
        //check down left
        place = 1;
        i = r+1;
        j = c-1;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && j>=0 && i < rows && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            i++;
            j--;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        
        //check left
        place = 1;
        i = r;
        j = c-1;
        solution = "" + r + " " + c + " ";
        while (place < word.length() && j >=0 && letterboard[i][j]==word.charAt(place)) {
            solution += i + " " + j + " ";
            j--;
            place++;
        }
        if (place == word.length()) {
            return solution;
        }
        
        
        //else: return ""
        return "";
    }

}

public class _2324allstar1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String rows_cols = bufferedReader.readLine();

        String gridLetters = bufferedReader.readLine();

        String words = bufferedReader.readLine();

        String result = Result.wordSearch(rows_cols, gridLetters, words);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
