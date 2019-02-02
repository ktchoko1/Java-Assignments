/*
 * The main class test and implement the skact elment.
 * CSCI 211 Fall 2015
 * last edited Nov 09, 2015.
 */
package stackproject;

public class StackProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // creat an array of five String name

        String name[] = {"Claude", "Chris", "Adidaja", "John", "Rose"};

        // create an instance of stack object
        Stack myStack = new Stack();

        // create an instance of stack element object
        // print the original list name
        System.out.println(" The original list is: ");
        System.out.println();

        for (int i = 0; i < name.length; i++) {

            System.out.println(name[i]);

        }// end for
        System.out.println();

        // Put the elemenet into the node and the node int the stack
        for (int i = 0; i < name.length; i++) {
            StackElement temp = new StackElement();
            temp.setData(name[i]);
            myStack.push(temp);

        }// end for
        System.out.println("True is the stack is empty false otherwise. The answer is: " + myStack.isEmpty());
        System.out.println();
        System.out.println("The size of the Stack is: " + myStack.getSize());
        System.out.println();

        // new array for the pop element
        String[] krl = new String[5];

        for (int i = 0; i < krl.length; i++) {

            krl[i] = myStack.pop().getData();

        }//end for

        // print the popping element from the stack
        System.out.println("The list of elemnet popping from the Stack is: ");
        System.out.println();

        for (int i = 0; i < krl.length; i++) {

            System.out.println(krl[i]);

        }// end for

    }// end mein

}// end class stack
