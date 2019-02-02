/*
 * This class has methods that implement the linked list.
 *
 *
 */
package LinkedList;
/**
 *
 * @author Kouassi
 */
public class list {

    private   ListNode head;
    private  int size = 0;

    // a null constructor
    public list() {

        this.head = null;
        this.size = 0;

    }// end  public LinkedList()

    // constructor that set ths head of the list
    public list(ListNode h) {

        this.head = h;
        this.size = 1;
    }// end list(ListNode h)

    /*Checks for an empty list
     * Returns true if empty and false if otherwise
     */
    public boolean isEmpty() {
        return head == null;

    }//end isEmpty()

    //*************************************************************************************************
    //  this method return data from specific position
    public BoardSquare getNumber(int index) {
        // index must be one  or higher
        if (index <= 0) {
            return null;
        }

        ListNode current = head.getNext();

        for (int i = 1; i < index - 1; i++) {
            if (current.getNext() == null) {
                return null;
            }

            current = current.getNext();
        }
        return current.getData();

    }//end get(int index)

     //****************************************************************************************************
    // accessor method
    public ListNode getHead() {

        return head;

    }// end ListNode getHead()

    //***********************************************************************************
    public BoardSquare getLast() {

        if (head == null) {

            System.err.println("Attempt the to get frm an empty list");
        }//end if

    // traverse and get the next element
        ListNode temp = head;

        while (temp.getNext() != null) {

            temp = temp.getNext();

        }// end hile

        return temp.getData();

    }// end BoardSquare getLast

    //**********************************************************************************************
    //this method traverse and print key  elements in list
    public void traverse() {

        ListNode temp = head;

        while (temp != null) {

            temp = temp.getNext();

        }// end while

    }//end traverse

    //**********************************************************************************************
    // this method return the head of the list
    public int getSize() {

        return this.size;

    }//end size()

    //************************************************************************************
    // return data from the head node
    public void insertHead(ListNode newNode) {

        System.out.println("new head");
        newNode.setNext(this.head);   // Node to be inserteed links to head
        this.head = newNode;        // newNode becomes the new head

        this.size++;
    }// end BoardSquare First()

    //************************************************************************************************************
    // the method add a node after the last element in te list
    public void append(ListNode newNode) {

        ListNode current = head;

        if (current == null) {
            head = current;
            this.size++;
        } else {

            while (current.getNext() != null) {
                current = current.getNext();
            }// end while

            current.setNext(newNode);
            newNode.setNext(null);
            this.size++;
        }// else
    }//appendNode(ListNode newNode)

    //********************************************************************************************
    public void prepend(BoardSquare data) {
        ListNode temp = new ListNode(data);
        temp.setNext(this.head);   // Node to be inserteed links to head
        this.head = temp;        // newNode becomes the new head
        this.size++;

    }//end prepend()

   

    //**************************************************************************************************
    // insert a node in the list before a specific element
    public void insertAfter(ListNode temp, ListNode loc) {

        // Chech for an empty lis
        if (head == loc) {

            //  is new head
            temp = head.getNext();
            head = temp;

        }// end if
        else {
            // if is not the head
            ListNode next = head;
            ListNode current = head.getNext().getNext();

            while (current != loc) {

                next = current;
                current = current.getNext().getNext();

                head.setNext(next);
                next.setNext(current);

            }// while
            head.setNext(temp);
            temp.setNext(current);
            this.size++;
        }// end else

    }// end insertAfter(ListNode temp)

    //***************************************************************************************************
    // inser a node in the list before a specific elmenet
    public void insertBefore(ListNode loc, ListNode temp) {

        // if head is that location
        if (head == loc) {

            head = temp.getNext();
            head = temp;

        }// end if
        // il loc is not head is not the head
        else {
            ListNode previous = head;
            ListNode current = head.getNext();

            while (current != loc) {

                previous = current;
                current = current.getNext();

            }// end while

            head.setNext(previous);
            previous.setNext(current);
            this.size++;
        }// end else

    }// insertbefore

    //******************************************************************************************************
    //  delete the head of the list
    public ListNode removeHead() {

        // check for an empty list
        if (head == null) {

            System.err.println("Attempt the to remove frm an empty list");

        }// end if
        // remove the head
        else {

            head = head.getNext();
        }// end else
        return head;

    }// end ListNode removeFirst()

    //********************************************************************************************************
    // Delete the last element in the list
    public ListNode removeLast() {

        if (head == null) {

            System.err.println();
        }
        ListNode temp1 = head;
        ListNode temp2 = null;
       ListNode next = head.getNext();

        if (next == null) {

            head = null;
            return temp2;

        }// end if

        while ((next = temp1.getNext()) != null) {

            temp2 = temp1;
            temp1 = next;
        }
        temp2.setNext(null);
        return temp1;

    }// end ListNode removeLast

    //******************************************************************************************
    public void removeBefore(ListNode temp, ListNode loc) {

        // Check for an empty list
        if (head == null) {

            System.err.println("Attempt the to remove frm an empty list");
        }// end if
        // if head is the only lement
        else if (head == temp) {

            head = temp.getNext();
            temp.setNext(head);
            head.setNext(null);

        }// end if else
        else {

            // if there is more than one elemnet
            head = loc;
            ListNode current = head.getNext();

            while (current != loc) {

                current = current.getNext();
                head = current;
                head.setNext(current);

            }// end else
            size--;
        }// end

    }// removeBefore

    //*********************************************************************************************
    public void removeAfter(ListNode temp, ListNode loc) {

        // Check for an empty list
        if (head == null) {

            System.err.println("Attempt the to remove frm an empty list");

        }// end if
        // if head is the only element remove
        else if (head == temp) {

            head = temp.getNext();
            head.setNext(temp);

        }// end else if
        // if there is more than one element
        else {

            ListNode current = head.getNext();
            head = loc;
            current = head;

            while (current != loc) {

                current = current.getNext();
                head.setNext(current);

            }// end while
               size--;
        }//end else
         
    }// removeAfter(ListNode temp, ListNode loc)
    
    //*********************************************************************************************************

    // this method clone the list and the under line data
    public list copy() {

        list list2 = new list();

        ListNode temp = head;

        while (temp != null) {

            list2.insertHead(temp.getNext());

            temp = temp.getNext();

        }// end While
        return list2;

    }// end LinkedList copy()
    
    //******************************************************************************************

    // this method copy clone the list without the under line daat
    public list clone() {

        list list1 = null;

        return list1;

    }// end LinkedList clone

    // this method compare list1 to the list2
    public int compareTo(list list1) {
        
        // initialise list1
       list list2 = null;
        
     
        return list1.compareTo(list2);

    }// end compareTo
    
    //***************************************************************************************
    
     //  print the list
    public void iteratePrint() {
        ListNode current = head; // start with the head node
        int count = 0;          // used to count the intems in the list

        // print a heading for the list
        System.out.println("\nHere is the linked list of boardSquare\n");

        while (current != null) {
            count++;
            // print the list node number
            System.out.print("boardSquare " + count + ": ");

            // print the node's data
            System.out.println(current.getData().toString());
            

            // update current -- move to next node in the list
            current = current.getNext();

        } // end while
        System.out.println();
    }//iteratePrint()

}// end class LinkedList
