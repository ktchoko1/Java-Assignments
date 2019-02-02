/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * last edited Dce. 19, 2015 by Kouassi Tchokoto
 */
package cityproject;

/**
 *
 * @author Kouassi
 */
public class Stack {
      private int size;
    
    private  StackElement top;

    public Stack() {
        
        top = null;
        size = 0;
       
    }// end Stack()

    //constructor with one element
    
    public Stack(StackElement l){
    
    this.top = top;
    size = 1;
    
    }// end StackNode
    
   
    
    public int getSize(){
        return size;
    
    }//
    
    public StackElement getTop(){
        
        return top;
    
    }// end StackElement getTop()
  
    
    
   // check if the Stack is empty
    
    public boolean isEmpty() {

        if (size == 0){
        
         return true;
        }
        else{
        
        
        }
        return false;
        

    }// end boolean isEmpty

    //This method push the Stack element
    
    public void push(StackElement newElement) {

        newElement.setNext(top);
        top = newElement;

        size++;
        
    }// end push(StackElement data)

    // this method pop the Stack elements
    
    public StackElement pop() {
       
        StackElement temp;
        
        if (top == null){
        
            return null;
        }// end if
        
        else{
            
        temp = top;
         
        top = top.getNext();
        
         size--;
         
        return temp;
        
        }// end else
         
      
    }// end pop()
    
    // this method print the results
    
     public String toString()
    {
        StackElement current = top.getNext();
        String output = "";
        
        while(current != null)
        {
            output += "[" + current.getData() +"]" + " ";
            current = current.getNext();
        }
        
        return output;
    }//end toString   
    
}
