/*
 * the program conduct benchmark on the bubble sort algorithm.
 * CSCI 112 Summer 2015
 * last edited August 8, 2015 by Kouassi Tchokoto.
 */
package selectionsortbenchmark;


public class SelectionSortBenchmark {

   
    public static void main(String[] args) {
        // TODO code application logic here
        
         for (int k = 1; k <= 100; k++) {
            int size = 100000;     // change this number to change the size of the random array
            int[] a = new int[size];
            
            // fill the array with random integers
        for (int i = 0; i< a.length; i++) 
            a[i] = (int)(Math.random()*100000 +1);
        
         int spot = 0;  // location in the array where the minimum is insert from the remainder of the list
        int minimum = 0;// location of the miminum value in the remainder of the list
        
        // get the start time in nanoseconds
        long startTime = System.nanoTime();
        
        //to sort the array using selection sort
        selectionSort(a, spot, minimum);

         
          // get the end time in nanoseconds
        long endTime = System.nanoTime();

        // calculate elapsed time in nanoseconds
        long duration = endTime - startTime;

        // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
        System.out.printf("%12.8f %n", (double)duration/100000000) ;
        }// end for
        
    }//end main
    
    public static int selectionSort(int[] a, int spot, int minimum) {

        // the outer loop if the list has n item , make  pass
        for (spot = 0; spot < a.length; spot++) {

            // find the minimum value in the remainder of the list
            // initialize the minimum to be the first value in the remainder of the list
            minimum = spot;
            int i;

            //iterats from spot to the end of the list one passs
            for (i = spot + 1; i < a.length - 1; i++) {

                if (a[i] < a[minimum]){

                    minimum = i;

                    int temp = a[spot];
                    a[spot] = a[minimum];
                    a[minimum] = temp;
                }// end fi
            }// end inner for
        }// end outer for
        return spot;
    } // end selctionSort
    
     /* This method writes an int array to a text data file.  
     * The first parameter is the array. The second parameter
     * is the file name.
     */
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

    } // end writeTextArray()
    

    
}//end
