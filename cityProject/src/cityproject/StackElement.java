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
public class StackElement {
    private City data;
    private   StackElement next;

    public StackElement() {

        next = null;
        data= null;

    }// end StackElement

    public void StackElement( City d) {

        data = d;

    }// end StackElement( City d)
    
    public void StackElement(StackElement s){
    
    next = s;
    
    }// end StackElement(StackElement s)
    
    public void setData(City d){
    
    data = d;
    
    }//end setData(String d)
    
    public void setNext(StackElement s){
    
    next = s;
    }// end setNext(StackElement s) 
    
    public City getData(){
        return data;
    
    }// end String getData()
    
    public StackElement getNext(){
        return next;
    
    
    }// end StackElement getNext()
 

    
}
