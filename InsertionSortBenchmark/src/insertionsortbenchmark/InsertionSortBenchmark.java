/*
 * the program conduct benchmark on the bubble sort algorithm.
 * CSCI 112 Summer 2015
 * last edited August 8, 2015 by Kouassi Tchokoto.

 */
package insertionsortbenchmark;

 
public class InsertionSortBenchmark {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
         for (int k = 1; k <= 100; k++) {
            int size = 100000;     // change this number to change the size of the random array
            int[] a = new int[size];
            
            // fill the array with random integers
        for (int i = 0; i< a.length; i++) 
            a[i] = (int)(Math.random()*100000 +1);
        
        // get the start time in nanoseconds
        long startTime = System.nanoTime();
        
        //to sort the array using insertion sort
        insertionSort(a);

         
          // get the end time in nanoseconds
        long endTime = System.nanoTime();

        // calculate elapsed time in nanoseconds
        long duration = endTime - startTime;

        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double)duration/100000000) ;
        }// end for
    }// end main
    
    
     public static int insertionSort(int[] insert){

        int i;// is a pointer to an ite in the unsorted list
        int j; // is a pointer to an item in the sorted list; originally the sorted;
        int value; //

        // the outer loop if the list has n item , make  pass
        // iterate the entire list
        for (i = 1; i < insert.length-1; i++) {

            //the next item form the original list, which will be added to the new list
            value = insert[i];

            // set the pointer to be beginning of the unsorted list.
            j = i - 1;

            // go from the current item backwards in the array to find wher it goes
            while ((j >= 0) && (insert[j] > value)) {

                insert[j + 1] = insert[j];
                j = j - 1;
            }// end while

            // insert the value in the correct spot
            insert[j + 1] = value;

        }// end inner for
        return insert[i];

    } // end insertionSort
     
     public static void displayLines(int[] a, String fileName) throws Exception {
        // create a File class object with the given file name
        java.io.File out = new java.io.File(fileName);
        // Create a PrintWriter output stream and link it to the File object
        java.io.PrintWriter outfile = new java.io.PrintWriter(out);

        // write the elements of an int array, separated by spaces
        for (int i = 0; i < a.length; i++) 
            outfile.print(a[i] + " ");
        
        // print a newline at the end of the list of integers
        outfile.println();

        outfile.close();

    } // end displayLines()
    
    
}//end InsertionSortBenchmark
