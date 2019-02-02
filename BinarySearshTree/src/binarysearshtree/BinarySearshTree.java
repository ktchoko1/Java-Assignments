/*
 * The man class class test other classes and all methods.
 * It has tree set of generated random numbers. First set of increasing random numbers from 1 to 100
 * second set of decreasing number from 100 to 1 and , third set of simple random number from 1 to 100
 * one last set of 1000 random number generated for analysing the height and efficiency of the tree
 * BST.java is the class of binary search tree. ist contains all the methods
 * BSTNode.java is the node class.
 * For checking the result of the tree based on increasing geneted numbers generated "uncomment lines 43 and 48"
 * For checking the result of the tree based on decreasing generated numbers generated "uncomment lines 62 and 67"
 * For checking the result of the tree based on no ordering 100 random numbers generated "uncomment lines 82 and 89 "
 * For checking the result of the tree based on no ordering 1000 random numbers generated "uncomment lines 103 and 108"
 * last edited December 7, 2015 by Kouassi Tchokoto.
 */
package binarysearshtree;

/**
 *
 * @author Kouassi
 */
public class BinarySearshTree {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // Create an instance of binay searsh tree object
        BST myBST = new BST();

        // create an istace of Queue
//*****************************************************************************************************************
        //Grenerate numbers from 1 to 100 
        int[] num = new int[100];
        int i;
        for (i = 0; i < num.length; i++) {

            num[i] = i + 1;

            // printing the number in increasing order
            //  System.out.print(num[i] + " ");
            // create an instance of node object
            BSTNode temp = new BSTNode();

            //put the data into the tree, insert() will put it in a node
            //  myBST.insert(num[i]);
        }// end for

        System.out.println();
//***************************************************************************************************************************        

        //Grenerate numbers from 1 to 100 
        int[] reverse = new int[100];

        for (i = 0; i < reverse.length; i++) {

            reverse[i] = 100 - i;

            // printing the number in decreasing order
            //  System.out.print(reverse[i] + " ");
            // create an instance of node object
            BSTNode temp = new BSTNode();

         //put the data into the tree, insert() will put it in a node
            //     myBST.insert(reverse[i]);
        }// end for

        System.out.println();
//********************************************************************************************************************* 

        // This method generates random numbers from 1 to 100 without any order
        // create an array that will hold  100 elements
        int[] randNumber = new int[100];

        //  generat number from 1 to 100
        for (i = 0; i < randNumber.length; i++) {
            randNumber[i] = (int) (1 + Math.random() * 99); // random number;

            // the number generated are:
             System.out.print(randNumber[i] + " ");
            // create an instance of node object
            BSTNode temp = new BSTNode();

            // put the data into the tree, insert() will put it in a node
             myBST.insert(randNumber[i]);
        } // end for

//***********************************************************************************************************
        // create random number with 1000 integer
        // create an array that will hold  100 elements
        int[] randNunb = new int[1000];

        //  generat number from 1 to 100
        for (i = 0; i < randNunb.length; i++) {

            randNunb[i] = (int) (1 + Math.random() * 999); // random number;

            // the number generated are:
            //  System.out.print(randNunb[i] + " ");
            // create an instance of node object
            BSTNode temp = new BSTNode();

            // put the data into the tree, insert() will put it in a node
            //  myBST.insert(randNunb[i]);
        } // end for

        //*************************************************************************************************************
        System.out.println();

        // the size of the tree is
        System.out.println(" the size of the tree is: " + myBST.getSize());
        System.out.println();

        //  System.out.println(myBST.getRoot());
        System.out.print(" the tree inorder is: ");
        myBST.InOrder(myBST.getRoot());
        System.out.println();

        System.out.print(" the tree PostOrder is: ");

        myBST.PostOrder(myBST.getRoot());
        System.out.println();

        System.out.print(" the tree PreOrder is: ");
        myBST.PreOrder(myBST.getRoot());
        System.out.println();
        System.out.println();

        // the root node is 
        System.out.println(" The root node in the tree is: " + myBST.getRoot().getData());
        System.out.println();
        System.out.println();

        // The minimum value in the tree is
        System.out.println(" The minimum value in the tree is: " + myBST.Min(myBST.getRoot()).getData());
        System.out.println();

        // the maximum value in the tree is
        System.out.println(" The maximum value in the tree is: " + myBST.Max(myBST.getRoot()).getData());
        System.out.println();

        // The height of the tree is
        System.out.println(" The height of the tree is: " + myBST.height(myBST.getRoot()));
        System.out.println();

        // find an element in the tre
        System.out.println(" The number search for is: " + myBST.Find(myBST.getRoot(), 13).getData());
        System.out.println();

        // Deleete an element from the tree
        System.out.println(" The number to be delete is:" + myBST.Delete(myBST.getRoot(), 10).getData());

    }// end main

}//class BinarySearshTree
