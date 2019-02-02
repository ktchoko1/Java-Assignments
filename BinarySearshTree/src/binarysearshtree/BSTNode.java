    /*
 * class BSTNode.java is the node class. it has tree properties: BSTNode left, BSTNode right and int data.
 * It mutates and accesses left, right and data
 * last edited December 7, 2015 by Kouassi Tchokoto.
 */
package binarysearshtree;

/**
 *
 * @author Kouassi
 */
public class BSTNode {

    int data; // hold the data in the tree
    private BSTNode left;
    private BSTNode right;

    public BSTNode() {

    }// end BSTNode

    public  BSTNode(int data) {

        this.data = data;

    }// end BSTNode(int data)

    public BSTNode(BSTNode left, BSTNode right) {

        this.left = left;
        this.right = right;

    }// end BSTNode(BSTNode left, BSTNode right)

    public BSTNode(int data, BSTNode left, BSTNode right) {

        this.data = data;
        this.left = left;
        this.right = right;
        
    }// end BSTNode(int data, BSTNode left, BSTNode right)

    public void setData(int data) {

        this.data = data;

    }// end setData(int data)

    public int getData() {

        return data;

    }// end getData()

    public void setLeft(BSTNode left) {

        this.left = left;
        
    }// end setLeft(BSTNode left)

    public BSTNode getLeft() {

        return left;

    }// end getNext()

    public void setRight(BSTNode right) {

        this.right = right;
    }// end setRight(BSTNode right)

    public BSTNode getRight() {

        return right;

    }// end getRight()
    
    
    // find an element
    
  

}// end class BSTNod
