/* Monopoly.java
 * 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * 
 * This package contains code that can be used as the basis of a monopoly game
 * It has a class of BoardSquares for the board squares in a Monopoly game,
 * and a main program that puts the squares into an array.
 * 
 * The main method has code to test the program by printing the data from the array
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images used in Monopoly are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
package monopoly;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author cherbert
 */
public class Monopoly {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BoardSquare[] square = new BoardSquare[40]; // array of 40 monopoly squares

        int i = 0; // a loop counter

        // call the method to load the array
        loadArray(square);

        // player instantiates with locatio 0 and balance1500
        Player pl = new Player(" Claude", "Battleship", 0, 1500);

        // variable holding the number rolled by the pair dice
        int dice1 = 1 + (int) (Math.random() * 6); // hold the number rolled by dice one  
        int dice2 = 1 + (int) (Math.random() * 6);  // hold the number rolled by second dice
        int rollDice = dice1 + dice2; // hold the total number rolled by the idce
        
        // initialization of the location and the balance
        int location = 0;  // the initial position of the player
        int balance = 1500;  // the initiale balance of the player

        // pirnts out the initial starting information of player pl
        System.out.println("Player: " + pl.getName());
        System.out.println("Token: " + pl.getToken());
        System.out.println("Location: " + square[pl.getLocation()].getName());
        System.out.println(" Balance: " + pl.getBalance());

        // loop while balance > 0 keep rolling
        while (pl.getBalance() > 0) {
            
            
           // Turn method that uptaded player's characteristic
            turn(square, location, balance, rollDice, pl);
             

          
        }// end while

    } // main()
    //***********************************************************************
    /*
CSCI 111 spring 2015
program that create new class in Monopoly game
last edited March 30, 2015 by Kouassi Tchokototo
*/

    public static void turn(BoardSquare[] square, int location, int balance, int rollDice, Player pl)throws Exception{

        int loc = pl.getLocation(); // hold player' location

        int bal = pl.getBalance(); // hold player's balance
        
        int roll = rollDice; // hold the number rolled by the dices

        // update location of player by adding pair of dice
        loc = loc + roll;
        if (loc > 39) {
            loc = loc - 40;
        }// end if

        // update balance
        bal = bal - square[loc].getRent();

        //update object's properties
        pl.setLocation(loc);
        pl.setBalance(bal);
      // summarizing the output by buildint an output String in String variable, then display the output int the JOptionPane dialog box to contnue  
    String message = "";   
    message = message + pl.getName() + " rolled a " + roll + "\n";
    message = message + pl.getName() + "'s " + pl.getToken() + " is now on " + square[loc].getName() + "\n";
    message = message + " the rent is " + " $" + square[loc].getRent() + "\n";
    message = message + " the new balance is " + " $" +  pl.getBalance() + "\n";
    
    JOptionPane.showMessageDialog(null, message);

    }
    

    // method to load the BoardSquare array from a data file
    public static void loadArray(BoardSquare[] square) throws Exception {
        int i; // a loop counter

        // declare temporary variables to hold BoardSquare properties read from a file
        String inName;
        String inType;
        int inPrice;
        int inRent;
        String inColor;

        // Create a File class object linked to the name of the file to be read
        java.io.File squareFile = new java.io.File("squares.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(squareFile);

        /* This loop reads data into the square array.
         * Each item of data is a separate line in the file.
         * There are 40 sets of data for the 40 squares.
         */
        for (i = 0; i < 40; i++) {
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inName = infile.nextLine();
            inType = infile.nextLine();
            inPrice = Integer.parseInt(infile.nextLine());
            inRent = Integer.parseInt(infile.nextLine());;
            inColor = infile.nextLine();

            // intialze each square with the BoardSquare constructor
            square[i] = new BoardSquare(inName, inType, inPrice, inRent, inColor);
        } // end for
        infile.close();

    } // endLoadArray
    //***********************************************************************

} // end class Monopoly
//***************************************************************************


/* code for a class of Monopoly squares
 * 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * Each object in this class is a square for the board game Monopoly.
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images in the game are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
class BoardSquare {

    private String name;    // the name of the square
    private String type;    // property, railroad, utility, plain, tax, or  toJail 
    private int price;      // cost to buy the square; zero means not for sale
    private int rent;       // rent paid by a player who lands on the square 
    private String color;   // many are null; this is not the Java Color class

    // constructors
    public BoardSquare() {
        name = "";
        type = "";
        price = 0;
        rent = 0;
        color = "";
    } // end Square()

    public BoardSquare(String name, String type, int price, int rent, String color) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.color = color;
    } // end Square((String name, String type, int price, int rent, String color)

    // accesors for each property
    public String getName() {
        return name;
    } //end  getName()

    public String getType() {
        return type;
    } //end  getType()

    public int getPrice() {
        return price;
    } //end  getPrice()

    public int getRent() {
        return rent;
    } //end  getRent()

    public String getColor() {
        return color;
    } //end  getColor()

    // a method to return the BoardSquare's data as a String
    public String toString() {
        String info;
        info = (name + ", " + type + ", " + price + ", " + rent + ", " + color);
        return info;
    } //end  toString()

} // end class BoardSquare
//***************************************************************************
/*
CSCI 111 spring 2015
program that create new class in Monopoly game
last edited March 30, 2015 by Kouassi Tchokototo
*/
class Player {

    private String name; // teh of the player
    private String token; // racecar, wheelbarrow, battleship, top hat etc..
    private int location; // the number of the square the player is on initialise to zero
    private int balance; // the player's bank balance initialized to 1500

    public Player() {

    }// end player()

    public Player(String name, String token, int location, int balance) {

        this.name = name;
        this.token = token;
        this.location = location;
        this.balance = balance;

    }// end player(String name, String token, int location, int blance)

    // accessor for all the properties
    public String getName() {

        return name;
    }// end get name

    public String getToken() {

        return token;
    }// end getToken

    public int getLocation() {
        return location;
    }// end getLocation

    public int getBalance() {
        return balance;
    }// end getBalance

    // mutator methoad
    public void setName(String name) {
        this.name = name;
    }// end setName

    public void setToken(String token) {
        this.token = token;
    }// end setToken

    public void setLocation(int location) {
        this.location = location;
    }// end setLocation

    public void setBalance(int balance) {
        this.balance = balance;
    }// end set Balance
  
      
}// end classe player

