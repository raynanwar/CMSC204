/*
import java.util.*;
public class Driver {
    public static void main(String[] args) {
        // Create a new graph
        Graph graph = new Graph();

        // Create towns 
        Town clarksburg = new Town("Clarksburg");
        Town germantown = new Town("Germantown");
        Town rockville = new Town("Rockville");
        Town gaithersburg = new Town("Gaithersburg");
        Town bethesda = new Town("Bethesda");
        Town frederick = new Town("Frederick");
        Town damascus = new Town("Damascus");
        Town potomac = new Town("Potomac");
        Town silverSpring = new Town("Silver Spring");
        Town wheaton = new Town("Wheaton");
        Town collegePark = new Town("College Park");
        
        // Create roads
        Road frederickRD = new Road(frederick, damascus, 6, "Frederick rd");
        Road westOldBaltimore = new Road(damascus, clarksburg, 8, "West Old Baltimore");
        Road clarksburgRD = new Road(clarksburg, germantown, 4, "Clarksburg rd");
        Road three55 = new Road(germantown, gaithersburg, 7, "355");
        Road wisteriaDR = new Road(gaithersburg, rockville, 6, "Wisteria Dr");
        Road two70 = new Road(rockville, potomac, 1, "270");
        Road ssRD = new Road(rockville, silverSpring, 6, "Silver Spring rd");
        Road rockvillePike = new Road(potomac, silverSpring, 1, "Rockville Pike");
        Road chevyRd = new Road(silverSpring, wheaton, 4, "Chevy rd");
        Road darnestownRd = new Road(silverSpring, collegePark, 2, "Darnestown Rd");

        // Add towns and roads to the graph
        graph.addTown(clarksburg);
        graph.addTown(germantown);
        graph.addTown(rockville);
        graph.addTown(gaithersburg);
        graph.addTown(bethesda);
        graph.addTown(frederick);
        graph.addTown(damascus);
        graph.addTown(potomac);
        graph.addTown(silverSpring);
        graph.addTown(wheaton);
        graph.addTown(collegePark);

        graph.addRoad(frederickRD);
        graph.addRoad(westOldBaltimore);
        graph.addRoad(clarksburgRD);
        graph.addRoad(three55);
        graph.addRoad(wisteriaDR);
        graph.addRoad(two70);
        graph.addRoad(ssRD);
        graph.addRoad(rockvillePike);
        graph.addRoad(chevyRd);
        graph.addRoad(darnestownRd);

        

       ArrayList<String> path = graph.getShortestPath(silverSpring, clarksburg);
       System.out.println(path);
       path = graph.getShortestPath(wheaton, collegePark);
        System.out.println(path);

    } 

}

  */