/*
 * The program is a simple linked list implmentation.
 * CSCI 211 Fall 2015
 * last edited, Oct 5, 2015.
 */
package LinkedList;

import java.io.*;
import java.util.*;
import javax.swing.*;

public class LinkedList {

    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        
        // create an instance of object that hold the boardSquare element
        
        BoardSquare square = new BoardSquare(); // hold  40 monopoly squares

        // create an instance of object for the linked list
        
        list newList = new list();

        // call the method to load the array
        
        loadList(square, newList);

        
            // tests isEmpty() method: prints true or false
            System.out.println("False for empty list true otherwise: the answer is: " + newList.isEmpty());
            System.out.println();
            
            // tests size() method: prints number of items in list
            System.out.println("The  number of elements in list is " + newList.getSize() + " squares");
            System.out.println();
            
            // test get() method: prints third item in list
            System.out.println("The fourteenth  item in the list:" + newList.getNumber(14));
            System.out.println();
            
            //test traverse() method
            System.out.println("Traversing through list and printing results...");
            newList.traverse();
            newList.iteratePrint();
            System.out.println();
        
            
            //test getHead() method
            System.out.println("the head of  List is :" + newList.getHead().getData());
            System.out.println();
        
            // test getLast() method: prints last item in list
            System.out.println("Printing last item in the list: " + newList.getLast());
            System.out.println();
            
           
            // test for Removehead method
            System.out.println("When removing the head the new list become: ");
            newList.removeHead();
            newList.iteratePrint();
            System.out.println();
            
            // test for removeLast method
            System.out.println("When removing the last emenet the new list become: ");
            newList.removeLast();
            newList.iteratePrint();
            System.out.println();
       
        
            //testing prepend() method
             //instance of a new BoardSquare
            BoardSquare Boarsquare2 = new BoardSquare();
            //Sets properties of new BoardSquare
            Boarsquare2.setName("Claude");
            Boarsquare2.setType("Dynamic");
            Boarsquare2.setPrice(150);
            Boarsquare2.setRent(50);
            Boarsquare2.setColor("Black");
            
            //display original list
            System.out.println("Original list: ");
            newList.iteratePrint();
            System.out.println();

            //display object being added to list
            System.out.println("Adding [" + Boarsquare2.toString() + "] to list");
            System.out.println();
            
            //add the head of the ;ist
            newList.prepend(Boarsquare2);
            
           
           //print the new list
            System.out.println("The new list is: ");
            newList.iteratePrint();
            System.out.println();
       
            
            //test clone() method
            System.out.println("Copying the current list...");
            newList.clone();
            newList.iteratePrint();
            System.out.println();
 
         

    }// end main 

    // method to load the BoardSquare array from a data file
    
    public static void loadList(BoardSquare square, list newList) throws Exception {
        int i; // a loop counter

        // declare temporary variables to hold BoardSquare properties read from a file
        
        String inName;
        String inType;
        int inPrice;
        int inRent;
        String inColor;

        // Create a File class object linked to the name of the file to be read
        
        java.io.File squareFile = new java.io.File("squares.txt");

        /* This loop reads data into linked list of BoardSquare.
         * Each item of data is a separate line in the file.   
         * There are 40 sets of data for the 40 squares.
         */
        System.out.println("creating a linked list from the data file...");
        try (Scanner infile = new Scanner(squareFile)) {

            for (i = 0; i < 40; i++) {
                
                // read data from the file into temporary variables
                // read Strings directly; parse integers
                
                inName = infile.nextLine();
                square.setName(inName);
                inType = infile.nextLine();
                square.setType(inType);
                inPrice = Integer.parseInt(infile.nextLine());
                square.setPrice(inPrice);
                inRent = Integer.parseInt(infile.nextLine());
                square.setRent(inRent);
                inColor = infile.nextLine();
                square.setColor(inColor);

                // create a temporary BoardSquare objectto hold the data added from the list
                ListNode tempNode = new ListNode(square);

                // reset the tempSquare object to null properties
                square = new BoardSquare();

                System.out.println("Adding node to the list");
                System.out.println(tempNode.getData().toString());
                

                if (newList.getHead() == null) {

                    newList.insertHead(tempNode);
                }// end if
                else {

                    newList.append(tempNode);
                }// end else

            } // end for

            newList.iteratePrint();

        } // end try
        catch (FileNotFoundException e) {

            // error message box with custom title and error icon
            JOptionPane.showMessageDialog(null, "File not found: " + squareFile, " Monopoly Warning", JOptionPane.ERROR_MESSAGE);

        }// end catch (FileNotFoundException e)

    }// end loadArray(BoardSquare square)

}// end class BoardSquareProject
