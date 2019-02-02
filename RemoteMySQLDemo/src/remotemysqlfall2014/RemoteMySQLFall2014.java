/* RemoteMySQLFall2014.Java     last edited 8/18/2015 by Kouassi Tchokoto
 * This code connects to a remote MYSQL database on the website CWHerbert.com
 * It connects via a fixed IP address (IPv4) to the database CWHDemo and
 * the table "fall2014" 
 * host IP address: 68.178.216.151
 * database:        CWHDemo
 * username:        student
 * password:        Student%123 
 
 Table metadata can be retrieved with the query "DESCRIBE pet;"
 crn    varchar(20) 
 sbject varchar(5) 
 course   varchar(5) 
 section  varchar(5) 
 credits integer
 time varchar(20)
 days varchar(8)
 term varchar(5)
 campus varchar(5)
 room varchar9(8)
 enrollment integer
 */
package remotemysqlfall2014;

import java.sql.*;
import java.io.*;

public class RemoteMySQLFall2014 {

    public static void main(String[] args)
            throws SQLException, ClassNotFoundException, FileNotFoundException {

        // Connect to a database by  establishing a Connection object
        Connection conn = DriverManager.getConnection("jdbc:mysql://68.178.216.151/CWHDemo", "student", "Student%123");

        System.out.println("Database connection established.\n");

        // Create a statement Object for this  database connection
        Statement st = conn.createStatement();

        // call a method that performs a query using Statement st
        selectAll(st);

        // call a method that performs a query using Statement st getting course, days and campus for class taht have 4 credits
        selectSomeCvs(st);

        // Close the connection
        conn.close();
    } // end main()
    //*********************************************************************************

    /* The following method performs an SQL query 
     * The parameter must be a Statement object with an established connection
     * to an SQL database. 
     */
    public static void selectAll(Statement s) throws SQLException, FileNotFoundException {
        // creat a file class object and give the file name SQLfall
        java.io.File sqlfallcsv = new java.io.File("SQLfall.csv");

        // create a print writer text output stream and link it to the file sqlfallcsv
        java.io.PrintWriter outfile = new java.io.PrintWriter(sqlfallcsv);

        String queryString;     // a String to hold an SQL query 
        ResultSet rs;           // the result set from an SQL query as a table

        // Create an SQL query as String for this statement
        // this query returns all rows and all columns from the database  
        queryString = "SELECT * FROM fall2014;";

        // Send a statement executing the query and saving the result set 
        rs = s.executeQuery(queryString);

        // print headings for the output
        outfile.write(queryString);
        outfile.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", "crn", "subject", "course", "section", "credits", "time", "days", "term", "campus", "room", "enrollment");
        System.out.println("***************************************************************************************************************************************************************************");

        // Iterate through the result set and print.
        while (rs.next()) {
            outfile.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
        }// end while
        outfile.close();

        System.out.println("**********************************************************************************************************************************************************************************************************************************************************");

    } // end selectAll()

    public static void selectSomeCvs(Statement s) throws SQLException, ClassNotFoundException {

        String queryString;     // a String to hold an SQL query 
        ResultSet rs;           // the result set from an SQL query as a table

        // Create an SQL query as String for this statement
        queryString = "SELECT course, days, campus FROM fall2014 WHERE credits = '4';";

        // Send a statement executing the query and saving the result set 
        rs = s.executeQuery(queryString);

        // print headings for the output
        System.out.println(queryString);
        System.out.printf("%-12s%-12s%-12s%n", "course", "days", "campus");
        System.out.println("*******************************************************");

        // Iterate through the result set and print course, days and campus
        while (rs.next()) {
            System.out.printf("%-12s%-12s%-12s%n", rs.getString("course"), rs.getString("days"), rs.getString("campus"));
        }

        System.out.println("*******************************************************");
    }// end selectsomeCsv

} // end class RemoteMySQLFall2014

