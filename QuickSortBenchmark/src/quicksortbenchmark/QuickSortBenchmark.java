/*
 * the program conduct benchmark on the bubble sort algorithm.
 * CSCI 112 Summer 2015
 * last edited August 8, 2015 by Kouassi Tchokoto.
 */
package quicksortbenchmark;

public class QuickSortBenchmark {

    public static void main(String[] args) {
        // TODO code application logic here

        for (int k = 1; k <= 100; k++) {
            int size = 2000000;     // change this number to change the size of the random array
            int[] a = new int[size];

            // fill the array with random integers
            for (int i = 0; i < a.length; i++) {
                a[i] = (int) (Math.random() * 2000000 + 1);
            }

            // get the start time in nanoseconds
            long startTime = System.nanoTime();

            // start the sort on the entire array -- a[0] to a[length-1]
            quickSort(a, 0, a.length - 1);

            // get the end time in nanoseconds
            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double) duration / 100000000);
        }// end for
    }// end main

    // the recursive quicksort method, which calls the partition method
    public static void quickSort(int[] a, int startIndex, int endIndex) {
        int pivotIndex;      // the index of pivot returned by the quicksort partition

        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            quickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSort(a, pivotIndex + 1, endIndex);
        } // end if
    } // end quickSort()
    //************************************************************************

    // This method performs quicksort partitioning on a set of elements in an array.
    public static int partition(int[] a, int startIndex, int endIndex) {

        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = (startIndex + endIndex) / 2;
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if a[i] is less than the pivot
            if (a[i] < pivot) {

                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for 

        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;

    } // end partition
    //************************************************************************

    // This method swaps two elements in an integer array
    public static void swap(int[] a, int first, int second) {

        int c;  // a catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    } // end Swap()
    //************************************************************************
    
    
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

} // end class QuickSortBenchmark


