/*
 * The program copy directory with it contents.
 * CSCI 112 Summer 2015
 * Last edited July 29, 2015 by Kouassi Tchokoto.
 */
package copyingdirectories;

import java.io.*;
import java.util.*;

public class CopyingDirectories {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        // declare an instance of scanner to read data from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // get the source directory from thr keyboardee 
        System.out.println("Please enter the name of the directory: ");
        String sourceFile = keyboard.nextLine();

        // get the destination directory from thr keyboard
        System.out.println("Please enter the name of the destination directory: ");
        String destinationFile = keyboard.nextLine();

        // if isDirectory or file
        isDirFile(sourceFile, destinationFile);

    }// end main

    public static void isDirFile(String source, String destination) throws Exception {

        // create a file object for new directory
        //File dirFile = new File(destination, new File(source).getName());
        File sourceFile = new File(source);

        // make the new directory
        //dirFile.mkdir();
        // create an array of file class objects for each item in the source
        File[] entries;

        // if souce directory exist
        if (sourceFile.exists()) {

            // if the souce is directory
            if (sourceFile.isDirectory()) {
                //get the data and load the aray
                //entries = new File (source).listFiles();

                entries = sourceFile.listFiles();
                File destFile = new File(destination);
                destFile.mkdir();
                for (int i = 0; i < entries.length; i++) {
                    if (entries[i].isDirectory()) {
                        // recursivley call the copy direcvtory method
                        isDirFile(entries[i].getAbsolutePath(), destination + "/" + entries[i].getName());
                    } else {
                        // copy the file
                        copyFile(entries[i].getAbsolutePath(), destination + "/" + entries[i].getName());
                    }
                }  // end for

            }// end if exists
            else {

                System.out.println("The file does not exist.");
            }// end else
        }
    }// end isDirFile

    public static void copyFile(String source, String destination) throws Exception {

        // declare File 
        File sourceFile = null;
        File destinationFile = null;

        // declare stream variables
        FileInputStream sourceStream = null;
        FileOutputStream destStream = null;

        // declare buffering variables
        BufferedInputStream bufferedSource = null;
        BufferedOutputStream bufferedDestination = null;

        try {

            // Create file objects for the source and destination files
            sourceFile = new File(source);
            destinationFile = new File(destination);

            // create file streams for the source and destination files
            sourceStream = new FileInputStream(sourceFile);
            destStream = new FileOutputStream(destinationFile);

            // buffer the file streams -- set the buffer sizes to 8K
            bufferedSource = new BufferedInputStream(sourceStream, 8182);
            bufferedDestination = new BufferedOutputStream(destStream, 6192);

            // use an integer to transfer data between files
            int transfer;

            // tell the user what is happening
            System.out.println("begining file copy:");
            System.out.println("\tcopying " + source);
            System.out.println("\tto      " + destination);

            // read a byte, checking for end of file (-1 is returned by read at EOF)
            while ((transfer = bufferedSource.read()) != -1) {

                // write a byte 
                bufferedDestination.write(transfer);

            } // end while

        } catch (IOException e) {

            e.printStackTrace();
            System.out.println(" An unexpected I/O error occurred.");

        } finally {

            // close file streams 
            if (bufferedSource != null) {
                bufferedSource.close();
            }

            if (bufferedDestination != null) {
                bufferedDestination.close();
            }

            System.out.println("Files closed. Copy complete.");

        } // end finally
    }
}
