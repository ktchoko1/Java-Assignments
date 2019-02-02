/*
 * CSCI Spring 2015.
 * the program fills an array with 1000 random number between 1 and 10.
 * last edited February 26, 2015.
 */
package radomsummary;

import java.io.File;
import java.io.PrintWriter;

public class RadomSummary {

    // the main method call methods which perform each part of the problem
    public static void main(String[] args) throws Exception {
        int[] arrayt = new int[1000];  // an array holding 1000 number place
        int[] count = new int[10];  // an array holding 10 number place for counting each random number
        double average ; // holds  the value of the average number
         
        // method to fill the array with the random numbers
        randomNumber(arrayt);

        // method to count the each random number loaded in the arrayt
        countNumber(count,arrayt);

        // method to calculate the average number fo the random number
        average =averageNumber(count, arrayt);

        // wrute the summary to a file
        writeLines(count,  average, arrayt);
        
    } // end main

    public static void randomNumber(int[] numArray) {
        // this method calculates the randoms numbers and fills the arrayt with the calculated numbers
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (1 + Math.random() * 9);  
             
        } // end for
    } // end randomNumber

    public static void countNumber(int[] count, int[] arrayt) {
        // the method count each commom elemnts in the arrayt
        for (int i = 1; i < arrayt.length; i++) {
            count[arrayt[i]]++;  
        }// end for
        
         
    } // end countNumber
    
    public static double averageNumber(int[] count, int[] arrayt) {
        
        int sum = 0; // add each number to the next one from second to the last
        double average = 0.0;
        for (int i = 0; i < arrayt.length; i++) {
            sum = sum + arrayt[i];  // holding the sum of all randoms numbers
            average = (double)(sum / arrayt.length); // calculate the average of the randoms numbers
            
        } // end for
        
        return average;
        
    } // end averageNumber

    public static void writeLines(int[] count, double average, int[] arrayt) throws Exception {

        // create a file class object and give it the name of "summary.txt"
        File s = new File("summary.txt");

        // create a PrintWriter output text stream and link to the file S
        PrintWriter y = new PrintWriter(s);

        // iterat each random number count
        for (int i = 0; i < count.length; i++) {
             
             y.println(" the number of " + i + "s is: " + count[i]);
        } // end for

        // output of the average number
          
             y.println(" The average number is: " + average);
         
        // iterat the random number
        for (int i = 0; i < arrayt.length; i++) {

             y.print(arrayt[i] + " ");
        } // for
        y.close();
    } // end writelines

} // end Class
