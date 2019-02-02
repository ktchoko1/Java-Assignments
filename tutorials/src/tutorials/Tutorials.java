/*  CSCI 111 - Fall 2013
 * reading, sorting and writing data in text files
 * this program reads data from a text file, sorst the data,
 * then writes the data bacxk to another text file.
 * last edited Oct 1, 2013 by C. Herbert
 *
 * the program has two new sorting method method : selection and insertion sort
 * CSCI 112 Summer 2015
 * modified on August 2, 2015 by Kouassi Tchokoto
 
 */
package tutorials;

import java.util.Scanner;

public class Tutorials {

    // the main method call methods to perform each part of the program
    public static void main(String[] args) throws Exception {
        String[] tutorials = new String[100];     // an array to hold a list of tutorials
        int count;		// the number of elements in the that are used

        int spot = 0;  // location in the array where the minimum is insert from the remainder of the list
        int minimum = 0;// location of the miminum value in the remainder of the list

        // read data into tutorials[] line by line and return count
        count = readLines(tutorials);

        // print the array on the screen
        System.out.println("The original array:\n");
        displayLines(tutorials, count);

        //to sort the array using bubble sort
        sortStringArray(tutorials, count);

        // print the array on the screen  line by line
        System.out.println("\nThe bubble sorted array:\n");
        displayLines(tutorials, count);

        //sort the array using selection sort
        selectionSort(tutorials, count, spot, minimum);

        // print the array on the screen  line by line
        System.out.println("\nThe selection sorted array:\n");
        displayLines2(tutorials, count, spot);

        // sort the array using insertion sorting
        insertionSort(tutorials, count);

        // print the array on the screen  line by line
        System.out.println("\nThe inserion sorted array:\n");
        displayLines3(tutorials, count);

        // write the array to a data file line by line
        writeLines(tutorials, count);

    } // end main()        

    /**
     * **********************************************
     */

    /* This method reads data from the file into the array. 
     * We want our array to work with up to 100 elements  
     * Each line from the file will be one element in the array.
     * 
     * The parameter refers to the array in the main method.  
     * 
     * The method returns the number of elements it uses.
     */
    public static int readLines(String[] lines) throws Exception {
        int count = 0; // number of array elements with data

        // Create a File class object linked to the name of the file to read
        java.io.File unsorted = new java.io.File("unsorted.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(unsorted);

        /* This while loop reads lines of text into an array. it uses a Scanner class 
         * boolean function hasNextLine() to see if there another line in the file.
         */
        while (infile.hasNextLine()) {
            // read a line and put it in an array element
            lines[count] = infile.nextLine();
            count++;  // increment the number of array elements with data

        } // end while

        infile.close();
        return count;    // returns the number of items used in the array.

    } // end readList()

    /**
     * **********************************************
     */

    /* This method sorts an array of Strings line by line 
     * using a simple bubble sort. 
     * 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */
    public static void sortStringArray(String[] a, int count) {
        boolean swapped;    //  keeps track of when array values are swapped 
        int i;              // a loop counter
        String temp;         // catalyst variable for String swapping

        // Each iteration of the outer do loop is is one pass through the loop. 
        // If anything was swapped, it makes another pass
        do {
            // set swapped to false before each pass
            swapped = false;

            // the for loop is a pass through the array to the second to last element
            for (i = 0; (i < count - 1); i++) {
                // if the two items are out of order  see page 16 for String compareTo() 
                if (a[i + 1].compareTo(a[i]) < 0) {
                    // swap the two items ans set swapped to true    
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                    swapped = true;

                }  // end if
            } // end for

            // the outer loop will repeat if a swap was made  – another passs
        } while (swapped);

    } // end sortStringArray

    /**
     * ***************************************************************
     */

    /*This method prints an array of Strings on the screen.  
     * The first parameter refers to the array in the main method.  The second 
     * parameter is the number of elements in the array that actually contain data
     */
    public static void displayLines(String[] lines, int count) {
        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            System.out.println(lines[i]);
        }

    } // end displayLines()

    /**
     * **********************************************
     */
    public static void selectionSort(String[] a, int count, int spot, int minimum) {

        // the outer loop if the list has n item , make  pass
        for (spot = 0; spot < a.length; spot++) {

            // find the minimum value in the remainder of the list
            // initialize the minimum to be the first value in the remainder of the list
            minimum = spot;
            int i;

            //iterats from spot to the end of the list one passs
            for (i = spot + 1; i < count - 1; i++) {

                if (a[i].compareTo(a[minimum]) < 0) {

                    minimum = i;

                    String temp = a[spot];
                    a[spot] = a[minimum];
                    a[minimum] = temp;
                }// end fi
            }// end inner for
        }// end outer for
    } // end selctionSort

    /*
     *
     ***********************************************************************
     */
    public static void displayLines2(String[] lines, int count, int spot) {

        // iterate the elements actually used
        for (spot = 0; spot < count; spot++) {
            System.out.println(lines[spot]);
        }// end for
    }// end displayLines2

    /**
     *
     * *************************************************************
     *
     */
    public static void insertionSort(String[] a, int count) {

        int i;// is a pointer to an ite in the unsorted list
        int j; // is a pointer to an item in the sorted list; originally the sorted;
        String value; //

        // the outer loop if the list has n item , make  pass
        // iterate the entire list
        for (i = 1; i < count; i++) {

            //the next item form the original list, which will be added to the new list
            value = a[i];

            // set the pointer to be beginning of the unsorted list.
            j = i - 1;

            // go from the current item backwards in the array to find wher it goes
            while ((j >= 0) && (a[j].compareTo(value) > 0)) {

                a[j + 1] = a[j];
                j = j - 1;
            }// end while

            // insert the value in the correct spot
            a[j + 1] = value;

        }// end inner for

    } // end insertionSort

    /**
     *
     * ****************************************************************
     *
     */
    public static void displayLines3(String[] lines, int count) {
        int i; // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {

            System.out.println(lines[i]);
        }// end for
    }// end displayLines3

    /**
     * **********************************************
     */

    /* This method writes an array of Strings to a text data file.  
     * The first parameter refers to the array in the main method. The second parameter
     * is the number of elements in the array that actually contain data
     */
    public static void writeLines(String[] lines, int count) throws Exception {
        // create a File class object and give the file the name tutorials.txt
        java.io.File tut = new java.io.File("tutorials.txt");
        // Create a PrintWriter text output stream and link it to the file x
        java.io.PrintWriter outfile = new java.io.PrintWriter(tut);

        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            outfile.println(lines[i]);
        }

        outfile.close();

    } // end writeTextArray()

}// end class
