/*
 * CSCI 111 Spring 2015.
 * this code calculate the distance between any point and the origine of a cartesian plan
 * it uses Boolean variable and nested if...else statment.
 * last edited January 28, 2015 by Kouassi Tchokoto
 */
package distancequadrant;

import java.util.*;

public class DistanceQuadrant {

    public static void main(String[] args) {
        double a;  // the point on the x-axis
        double b;  // the point on the y-axis
        double dist;  // the distance of the hypotenuse
        double dist1;  // the square distancce
        // declare an instance of Scanner to read the datastrem from the keyboard
        Scanner keyboard = new Scanner(System.in);
        
        // get the value of x
        System.out.println("Enter the value of X: ");
        a = keyboard.nextDouble();
        
        // get the value of y
        System.out.println("Enter the value of Y: ");
        b = keyboard.nextDouble();
        
        // calculate the distance
        dist1 = ((a*a)+(b*b));
        dist = Math.sqrt(dist1);
        
        if ((a>0) && (b>0)) {  // print this
            
            System.out.println("The distance is " + dist );
             System.out.println( a + " and " + b + " belong to quadrant I ");
               } // end of quadrant I
        
        else  if ((a<0) && (b>0)) {  // print this
            
                System.out.println("the distance is " + dist );
                System.out.println( a + " and " + b + " belong to quadrant II ");
                } // end quadrant II
        
        else if ((a<0) && (b<0)) { // print this
            
                System.out.println("The distance is " + dist );
                System.out.println( a + " and " + b + " belong to quadrant III ");
                } // end quadrant III
        
            else  // print this
        {   
                System.out.println(" The distance is " + dist );
                System.out.println( a + " and " + b + " belong to quadrant IV ");
        }
        
            
        
    } // end main()
    
} // end DistanceQuadrant
