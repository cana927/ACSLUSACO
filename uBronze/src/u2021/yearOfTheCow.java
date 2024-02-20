//package u2021;

import java.util.*;
import java.io.*;

public class yearOfTheCow {

  static String[] animals = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
  static Map<String, Integer> whenBorn = new HashMap<String,Integer>();
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    //create an in variable N and store the first line of input in it
    int n = Integer.parseInt(in.readLine());
    //insert the first entry into the HashMap; we should be inserting "Bessie" with the year 2021
    whenBorn.put("Bessie", 2021);
    //create a for loop that runs n times
    for (int i = 0; i < n; i++) {
      //read in the next input line and split it by a space and store into a String[] called 'input'
      String[] input = in.readLine().split(" ");
      //create a String variable called 'cowA' and store the first element of input in it
      String cowA = input[0];
      //create a String variable called 'relation' and store the 4th element of input in it
      String relation = input[3];
      //create a String variable called 'animal' and store the 5th element of input in it
      String animal = input[4];
      //create a String variable called 'cowB' and store the last element of input in it
      String cowB = input[input.length-1];

      //store a key-value pair where the key is cowA and the value is the value from the entry of cowB in the HashMap whenBorn
      whenBorn.put(cowA, whenBorn.get(cowB));
      //create a do-while loop that runs while cowA's animal year is not equal to the animal variable
      do {
        //create an if statement checking if 'relation' is equal to the String "preious"
        if (relation.equals("previous")) {
          //replace the cowA value from the HashMap with its current value minus 1
          whenBorn.replace(cowA, whenBorn.get(cowA)-1);
        }
        else {
          //replace the cowA value from the HashMap with its current value plus 1
          whenBorn.replace(cowA, whenBorn.get(cowA) + 1);
        }
      } while(!(getAnimal(whenBorn.get(cowA)).equals(animal)));
      
    }

    //print the absolute value of the difference between the value of "Bessie" in the HasMap and the value of "Elsie" in the HashMap
    System.out.println(Math.abs(whenBorn.get("Bessie") - whenBorn.get("Elsie")));
    
  }

  //create a method called getAnimal that takes in an int called 'year' and returns a String
  public static String getAnimal (int year) {
    //create an int variable called 'a' and set it to 0
    int a = 0;
    //create an in variable called 'y' and set it to 2021
    int y = 2021;
    //create a while loop that runs while y is less than year
    while (y < year) {
      y++;
      a++;
      if(a == 12) a = 0;
    }
    //create a while loop that runs while y is greater than year
    while(y > year) {
      y--;
      a--;
      if(a == -1) a = 11;
    }

    //return the animal at index a from the animals array
    return animals[a];
    
  }

}