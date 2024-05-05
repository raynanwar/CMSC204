import java.util.HashSet;
/*
 
Class: CMSC204
Instructor: Eivzi
Description: Graph
Due: 5/6
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
public class Town implements Comparable<Town> {
    private String name; 
    private HashSet<Town> adjacencySet = new HashSet<>();
    private int shortestDistance;
    private Town predecessorNode;
    public Town(String name) {
        this.name = name;
    }
    public Town(Town templateTown) {
        this.name = templateTown.name;
    }
    public void addAdjTown(Town adjTown) {
        adjacencySet.add(adjTown);
    }
    public HashSet<Town> getAdjTowns() {
        return this.adjacencySet;
    }
    public String getName() {
        return this.name;
    }
    public int getShortestDistance() {
        return this.shortestDistance;
    }
    public void setShortestDistance(int shortestDistance) {
        this.shortestDistance = shortestDistance;
    }
    public Town getPredecessorNode() {
        return this.predecessorNode;
    }
    public void setPredecessorNode(Town predecessorNode) {
        this.predecessorNode = predecessorNode;
    }
    public int compareTo(Town o) {
        return this.name.compareTo(o.name);
    }
    public String toString() {
        return this.name;
    }
    public int hashCode() {
        return name.hashCode();
    }
    public boolean equals(Object obj) {
        Town tempTown = (Town)obj;
        if(this.name.equals(tempTown.name)) {
            return true;
        }
        return false;
    }
}