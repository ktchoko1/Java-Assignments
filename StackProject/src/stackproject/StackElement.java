/*
 * The class implemt StackElement.
 * it has two properties string object and the element.
 * 
 */
package stackproject;

/**
 *
 * @author Kouassi
 */
public class StackElement {

    private String data;
    private   StackElement next;

    public StackElement() {

        next = null;
        data= null;

    }// end StackElement

    public void StackElement( String d) {

        data = d;

    }// end StackElement( String d)
    
    public void StackElement(StackElement s){
    
    next = s;
    
    }// end StackElement(StackElement s)
    
    public void setData(String d){
    
    data = d;
    
    }//end setData(String d)
    
    public void setNext(StackElement s){
    
    next = s;
    }// end setNext(StackElement s) 
    
    public String getData(){
        return data;
    
    }// end String getData()
    
    public StackElement getNext(){
        return next;
    
    
    }// end StackElement getNext()
 

}// end StackElement()
