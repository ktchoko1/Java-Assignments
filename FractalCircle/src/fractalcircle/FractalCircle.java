/*
 * The program draw fractal partern circle.
 * CSCI 112 summer 2015
 * last edited July 18,2015 by Kouassi Tchokoto.
 */
package fractalcircle;

import java.awt.*;
import javax.swing.*;
public class FractalCircle {

   
    public static void main(String[] args) {
        // create the object for my canvas
        MyCanvas canvas1 = new MyCanvas();
        
        // set up Jframe to hold the canvas
        JFrame myFrame = new JFrame();
         
         
        myFrame.setSize(500, 500);
        myFrame.setLocation(100, 100);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // add the canavas to the frame as content panel
        myFrame.getContentPane().add(canvas1);
        myFrame.setVisible(true);
        
    }// end main 
    
}// end classFractal

class MyCanvas extends Canvas{
    
    // constructor

    public MyCanvas(){
    
    }// end MyCanvas
    
    // this methode will draw the initial circle and invisible line
    
    public void paint(Graphics graphics){
    
        int n = 125; // the radius of the first cercle
        int x1, x2, y1, y2; // coordinates
        int xMid = 250; // center point of the circle
        int yMid = 250;
        
        // put a title on the canvas
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("Arial", Font.BOLD, 18));
        String title = "Fractal Circle";
        graphics.drawString(title, 150, 30);
        
        // draw invisible line
       /* graphics.drawLine(0, 250, 500, 250);*/
        // set the drawing color
        graphics.setColor(Color.BLUE);
        
        // draw the first cercle
        graphics.drawOval(xMid-n, yMid-n, n*2, n*2);
        
        // run fractal algorithm to draw two cercle
        drawCircles(graphics, xMid, yMid, n);
        
         
        
    }//end
    
    public void drawCircles(Graphics graphics, int xMid, int yMid, int n){
    
        // left position (x1, y2)
        int x1 = xMid-n-(n/2);
        int y1 = yMid-(n/2);
        
        // right position (x2, y2)
        int x2 = xMid+n-(n/2);
        int y2 = yMid-(n/2);
        
        if (n>5){
        
        
            
        // draw circle 
            drawCircles(graphics, xMid, yMid, n/2);
         
             // draw circle to the left
             graphics.drawOval(x1, y1, (n/2)*2, (n/2)*2);
             drawCircles(graphics, xMid-n, yMid, (n/2));
             
             
              // draw circle to the right
             graphics.drawOval(x2, y2, (n/2)*2, (n/2)*2);
             drawCircles(graphics, xMid+n, yMid, (n/2));
             
             
             
             
            
             
        }// end if  
             
        
    }// end drawCircle
 


    
    }//end fractalCircle  
