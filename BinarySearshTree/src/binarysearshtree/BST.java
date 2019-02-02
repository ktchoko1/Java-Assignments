     /*
 * Class BST.java has tree properties: BSTNode root the root node, int size the size of rthe tree, int height the height ofthe tree.
 * it implement all the methods
 * last edited December 7, 2015 by Kouassi Tchokoto.
 */
package binarysearshtree;

/**
 *
 * @author Kouassi
 */
public class BST {

    private BSTNode root;
    private int size; // hold the number of node in the tree
    private int height; // hold the position of the node

    public BST() {
        this.root = null;
        this.size = 0;
        this.height = 0;

    }// end BST()

    public BST(BSTNode root, int size, int height) {

        this.root = root;
        this.size = 1;
        this.height = 1;

    }// end BST(BSTNode rt, int s, int h)

    //******************************************************************************************************************
    // 
    public BSTNode getRoot() {

        return this.root;

    }// end get root

    //********************************************************************************************************************
    //returns number of nodes in the tree
    public int getSize() {

        return size;
    }// end getSize()

    //*******************************************************************************************************************
    // insert method
//insert a node to the tree
    public void insert(int data) {
        System.out.println("inserting " + data);
        BSTNode newNode = new BSTNode(data);
        if (root == null) {
            root = newNode;
        } else {
            BSTNode parentNode = null;
            BSTNode currentNode = root;

            while (currentNode != null) {
                parentNode = currentNode;

                if (data < currentNode.getData()) {
                    currentNode = currentNode.getLeft();
                } else {
                    currentNode = currentNode.getRight();
                }// end else

            } // end while

            if (data < parentNode.getData()) {
                parentNode.setLeft(newNode);
            } else {
                parentNode.setRight(newNode);
            }

        } //end else from  if (root == null) 

        size++;//increment size

    }//end insert()

    //************************************************************************************************************************
    public void PreOrder(BSTNode root) {

        if (root != null) {

            System.out.print(root.getData() + " ");
            PreOrder(root.getLeft());
            PreOrder(root.getRight());

        }// end if

    }// end PreOrder

    //*************************************************************************************************************
    public void InOrder(BSTNode root) {

        if (root != null) {

            InOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            InOrder(root.getRight());

        }// end if

    }// end InOrder

    //******************************************************************************************************************
    public void PostOrder(BSTNode root) {

        if (root != null) {

            PostOrder(root.getLeft());
            PostOrder(root.getRight());
            System.out.print(root.getData() + " ");

        }// end if

    }// end PostOrder

    //**********************************************************************************************************
    // method for saerching
    public BSTNode Find(BSTNode root, int data) throws Exception {

//         System.out.println(" value found is: " + root.getData() + " ");
        if (root == null) {

            System.err.println("There is no data in the tree");

        }// en
        else if (root.getData() == data) {

            root = root;
        } else if (data < root.getData()) {
            root = Find(root.getLeft(), data);
        } else {

            root = Find(root.getRight(), data);

        }// end else
        return root;

    }// end Find(BSTNode root, int data)

    //*****************************************************************************************************************
    // find the minimum value in the tree
    public BSTNode Min(BSTNode root) {

        if (root == null) {

            System.err.println("The tree is empty");

        }// end if

        while (root.getLeft() != null) {

            root = root.getLeft();
        }// end while

        return root;
    }// end Min(BSTNode root)

    //*************************************************************************************************************
    // find the maximum value in the tree
    public BSTNode Max(BSTNode root) {

        if (root == null) {

            System.err.println("The tree is empty");

        }// end if

        while (root.getRight() != null) {

            root = root.getRight();
        }// end if

        return root;

    }// end Max(BSTNode root)

    //***************************************************************************************************************
    public int height(BSTNode root) {

        if (root == null) {
            return -1;
        }// end if
        int heightLeft = height(root.getLeft());
        int heightRight = height(root.getRight());

        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }//end else
    }// end height(BSTNode)

    //******************************************************************************************************************
    // delete an element from the tree
    public BSTNode Delete(BSTNode root, int data) {

          //System.out.println(" Deleting : " + root.getData() + " ");
        BSTNode temp;

        if (root == null) {

            System.err.println(" Element not there in the tree");

        }// end if
        else if (data < root.getData()) {

            BSTNode leftroot = Delete(root.getLeft(), data);
        } else if (data > root.getData()) {

            BSTNode rightroot = Delete(root.getRight(), data);
        } else {

          // found elemenet
            if ((root.getLeft() != null) && (root.getRight() != null)) {

              // replace the largest in left subtree
                temp = Max(root.getLeft());
                temp.data = root.getData();
                root = Delete(root.getLeft(), data);
            } else {

                // one child
                temp = root;
                if (root.getLeft() == null) {

                    root = root.getRight();

                }// end else if
                if (root.getRight() == null) {

                    root = root.getLeft();

                }// end if
                temp = null;
            }// end if

        }// end else
        
        return root;

    }// end BSTDelete(BSTNode root, int data)

}//  public class BST
