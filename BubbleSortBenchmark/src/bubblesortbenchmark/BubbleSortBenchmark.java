/*
 * the program conduct benchmark on the bubble sort algorithm.
 * CSCI 112 Summer 2015
 * last edited August 8, 2015 by Kouassi Tchokoto.
 */
package bubblesortbenchmark;

public class BubbleSortBenchmark {

    public static void main(String[] args) {
        // TODO code application logic here
        for (int k = 1; k <= 100; k++) {
            int size = 20000;     // change this number to change the size of the random array
            int[] a = new int[size];
            
            // fill the array with random integers
        for (int i = 0; i< a.length; i++) 
            a[i] = (int)(Math.random()*20000 +1);
        
        // get the start time in nanoseconds
        long startTime = System.nanoTime();
        
        //to sort the array using bubble sort
        sortArray(a);

         
          // get the end time in nanoseconds
        long endTime = System.nanoTime();

        // calculate elapsed time in nanoseconds
        long duration = endTime - startTime;

        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double)duration/100000000) ;
        }// end for
        

    }//end main
    
    public static int sortArray(int[] integer){
        
         boolean swapped;    //  keeps track of when array values are swapped 
        int i;              // a loop counter
        int temp;         // catalyst variable for String swapping

        // Each iteration of the outer do loop is is one pass through the loop. 
        // If anything was swapped, it makes another pass
        do {
            // set swapped to false before each pass
            swapped = false;

            // the for loop is a pass through the array to the second to last element
            for (i = 0; (i < integer.length - 1); i++) {
                // if the two items are out of order  see page 16 for String compareTo() 
                if (integer[i + 1] < integer[i])  {
                    // swap the two items ans set swapped to true    
                    temp = integer[i];
                    integer[i] = integer[i + 1];
                    integer[i + 1] = temp;

                    swapped = true;

                }  // end if
            } // end for

            // the outer loop will repeat if a swap was made  – another passs
        } while (swapped);
        return integer[i];

        
    }// end sortArray
    
  /* This method writes an int array to a text data file.  
     * The first parameter is the array. The second parameter
     * is the file name.
     */
    public static void displayLines(int[] integer, String fileName) throws Exception {
        // create a File class object with the given file name
        java.io.File out = new java.io.File(fileName);
        // Create a PrintWriter output stream and link it to the File object
        java.io.PrintWriter outfile = new java.io.PrintWriter(out);

        // write the elements of an int array, separated by spaces
        for (int i = 0; i < integer.length; i++) 
            outfile.print(integer[i] + " ");
        
        // print a newline at the end of the list of integers
        outfile.println();

        outfile.close();

    } // end writeTextArray()
    
}// end bubble sort