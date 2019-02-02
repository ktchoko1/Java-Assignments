/* Edge.Java  -- class file
 *  
 * This software package creates a graph of cities in the Unitied States with
 * links between the cities. Each city is a vertex in the graph.
 * Each link between cities is an edge in the graph.   The data for the cities and
 * links are read into arrays from data files, which should be in the project folder.
 * The files are CSV files, which can be read and edited in Excel.
 *
 * The main class for the project is the CityProject class.   Other class include:
 * 
 *   Vertex - clas for each Vertex in a graph.
 *   City extends Vertex - Each City is a Vertex with added properties.  Each City
 *      has a unique name, and X and Y cooordinates for location on a 1500 by 900 Canvas.
 *   Edge - an edge in the graph, with a source, destination, and length.
 *   AjacencyNode - a node for a linked list of cities directly connected to each City.
 *      Each City has a linked list of adjacnt cities, created from the info in the 
 *      data files, with destination City and distance data in the node, and a 
 *      link to the next node. 
 *   CityMap - extends Canvas, a map of the graph on a 1500 by 900 GUI Canvas.
 *      A CityMap object in instantiated in the drawMap method in the CityProject class.
 * 
 * The main method in the CityProject class calls methods to reads City and Edge 
 * data from data files into arrays, set up the adjacency list in each instance 
 * of City, print a list of Vertex cities and their Edges, then draw a map of the graph.
 *
 * created for use by students in CSCI 211 at Community Colle of Philadelphia
 * copyright 2014 by C. herbert. last edited Dce. 19, 2015 by Kouassi Tchokoto
 */

package cityproject;

//Array of edges sorted by source 
public class Edge {

    City  source;		// the name of the source vertex;
    City  destination;	// the name of the destination vertex;
    int length;			// the length of the edge;

    Edge() {
    }

    Edge(City s, City d, int l) {
        this.source = s;
        this.destination = d;
        this.length = l;
    } // end Edge(...)

    public void setSource(City s) {
        this.source = s;
    }  // end setSource

    public void setDestination(City d) {
        this.destination = d;
    } // end setDestination

    public void setLength(int l) {
        this.length = l;
    } // end setLength

    public City getSource() {
        return this.source;
    }  // end getSource

    public City getDestination() {
        return this.destination;
    } // end getDestination

    public int getLength() {
        return this.length;
    } // end getLength

    public String toString() {
        return this.source + " to " + this.destination + ": " + this.length;
    }

}  //end class edge
