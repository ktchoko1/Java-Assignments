/*
 * CSCI 111 Spring 2015.
 * A program to print Celcuis to Fahrenheit conversion table
 * last edited February 7, 2015 by Kouassi Tchokoto.
 */
package celciusfahrenheit;

public class CelciusFahrenheit {

    public static void main(String[] args) {
        double c;  // the value degree Celcuis
        double f;  // the value of degree Fahrenheit
        
        // print column headers --t\ is the tab character
        System.out.printf("%2s%13s%n" , "Celcius", "Fahrenheit");
        
        for (c = 0; c <= 40; c++){
        
        // convert celsius into fahrenheit
        f = (9.0/5.0*c)+32.0;
        System.out.printf("%2.0f%13.1f%n", c , f);
           
        } // end Celcuis
        System.out.println();
    } // end main()
    
}// end class CelciusFahrenheit
