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
public class Road implements Comparable<Road> {
    private Town source; 
    private Town destination; 
    private int distance; 
    private String name; 
    public Road(Town source, Town destination, int distance, String name) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.name = name;
    }
    public Road(Town source, Town destination, String name) {
        this.source = source;
        this.destination  = destination; 
        this.name = name;
        this.distance = 1;
    }
    public boolean contains(Town town) {
        if(source.getName().equals(town.getName()) || destination.getName().equals(town.getName())) {
            return true;
        }
        return false;
    }
    public String getName() {
        return this.name;
    }
    public Town getDestination() {
        return this.destination;
    }
    public Town getSource() {
        return this.source;
    }
    public int getDistance() {
        return this.distance;
    }
    public int compareTo(Road o) {
        return this.name.compareTo(o.name);
    }
    public boolean equals(Object r) {
        if (!(r instanceof Road)) {
            return false;
        }
        Road tempRoad = (Road)r;
        return (this.source.equals(tempRoad.source) && this.destination.equals(tempRoad.destination)) ||
               (this.source.equals(tempRoad.destination) && this.destination.equals(tempRoad.source));
    }
    
}
