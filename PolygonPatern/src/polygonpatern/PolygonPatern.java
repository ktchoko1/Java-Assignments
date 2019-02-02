/*
 *the program present a patern of an open exagone on it top face .
 * CSCI 111 Spring 2015
 * last edited April 26, 2015 by Kouassi Tchokoto.
 */
package polygonpatern;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class PolygonPatern {

    public static void main(String[] args) {
        // Create a MyCanavas object
        MyCanvas canvas2 = new MyCanvas();
        
        // set up a JFrame to hold the canavas
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Polygone Paterns");
        myFrame.setSize(500, 500);
        myFrame.setLocation(100, 100);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add the canvas to the frame as a content panel
        myFrame.getContentPane().add(canvas2);
        myFrame.setVisible(true);
        
    } // end man()
    
}// end PolygonPatern

class MyCanvas extends Canvas{
    
    public MyCanvas(){
        
    }// end MyCanvas constructor
    
    public void paint(Graphics graphics){
        
        int times; // number of time the program is repaeted
        int i; // loop counter
        
        
        for (times = 1; times <= 10; times++){
        // paint the canvas yellow
            graphics.setColor(Color.yellow);
            graphics.fillRect(0, 0, 500, 500);
            
            for (i = 1; i <= 200; i++){
                
                // draw the polygone patern
                
                int n = 6; // hold the number of vertex
                int[] x = {30+i,40*i,60*i,70*i,60*i,40-i};
                int[] y = {40-i,20*i,20*i,40*i,60*i,60+i};
                
                graphics.setColor(Color.BLUE);
                graphics.drawPolygon(x, y, n);
                
                try{
                TimeUnit.MILLISECONDS.sleep(20);
                }// end try
                
                catch (Exception e){
                System.out.println("Exception caught");
                }// end catch
            }// end for
        }// end for
    
    
    }// end public MyCanavs


}// end class MyCanavs extends Canavas
