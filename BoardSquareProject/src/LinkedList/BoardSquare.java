/*
 * the class os Boardsquare that hold the object properties
 
 */
package LinkedList;

/**
 *
 * @author Kouassi
 */
public class BoardSquare {
    
    private String name;    // the name of the square
    private String type;    // property, railroad, utility, plain, tax, or  toJail 
    private int price;      // cost to buy the square; zero means not for sale
    private int rent;       // rent paid by a player who lands on the square 
    private String color;   // many are null; this is not the Java Color class

    
    

    // constructors
    public BoardSquare() {
        name = "";
        type = "";
        price = 0;
        rent = 0;
        color = "";
    } // end Square()

    public BoardSquare(String name, String type, int price, int rent, String color) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.color = color;
    } // end Square((String name, String type, int price, int rent, String color)

    // accesors for each property
    public String getName() {
        return name;
    } //end  getName()

    public String getType() {
        return type;
    } //end  getType()

    public int getPrice() {
        return price;
    } //end  getPrice()

    public int getRent() {
        return rent;
    } //end  getRent()

    public String getColor() {
        return color;
    } //end  getColor()

    // mutator for each property
    public void setName(String name) {

        this.name = name;
    }// end setName

    public void setType(String type) {

        this.type = type;
    }// end setType

    public void setPrice(int price) {

        this.price = price;
    }// end setPrice

    public void setRent(int rent) {

        this.rent = rent;

    }//end setRent

    public void setColor(String color) {

        this.color = color;
    }

   // a method to return the BoardSquare's data as a String
    public String toString() {
        String info;
        info = (name + ", " + type + ", " + price + ", " + rent + ", " + color);
        return info;
    } //end  toString()
    
    
    //**********************************************************************************************
    
    
    
}
