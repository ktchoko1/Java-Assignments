/*
 * the node classe with property and constructor.

 
 */
package LinkedList;

/**
 *
 * @author Kouassi
 */
public class ListNode {

    private ListNode next;
    private BoardSquare data;

        // null Constructor
    
    public ListNode() {

    }// end ListNode()

        // contructor printing a BoardSquare in the node
    
    public ListNode(BoardSquare b) {

        data = b;
        
    }// end Node(BoardSquare data)

        //constructor putting a BoardSquare and a link in the node
    
    public ListNode(BoardSquare b, ListNode n) {
        next = n;
        data = b;
        
    }// end ListNode(BoardSquare b, ListNode n)

        // constructor putting a  link in the node
    
    public ListNode(ListNode n) {

        next = n;

    }// end ListNode(ListNode n)

        // mutator method
    
    public void setData(BoardSquare b) {

        data = b;

    }// end setData(BoardSquare data)

        // Accessor method
    public BoardSquare getData() {

        return this.data;

    }// BoardSquare getData()

    public void setNext(ListNode n) {

        next = n;

    }// end setNext(Node next)

    public ListNode getNext() {
        return this.next;

    }// public Node getNext()

}// class ListNode
