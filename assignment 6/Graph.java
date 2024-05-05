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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Graph implements GraphInterface<Town, Road> {
    HashSet<Town> vertices; 
    HashSet<Road> edges; 
    public Graph() {
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }
    public Road addRoad(Town sourceTown ,Town destinationTown, int distance, String name) throws NullPointerException, IllegalArgumentException {
        if(sourceTown==null || destinationTown ==null) {
            throw new NullPointerException("Either source or destination town is null.");
        }
        if(!containsTown(sourceTown) || !containsTown(destinationTown)) {
            throw new IllegalArgumentException("Either source or destination town is not contained in the graph.");
        }
        sourceTown.addAdjTown(destinationTown);
        destinationTown.addAdjTown(sourceTown);
        Road road = new Road(sourceTown, destinationTown, distance, name);
        edges.add(road);
        return road;
    }
    public Road addRoad(Road road) {
        Road tempRoad = addRoad(road.getSource(), road.getDestination(), road.getDistance(), road.getName());
        return tempRoad;
    }
    @Override
    public Road getRoad(Town sourceTown, Town destinationTown) {
        if(sourceTown == null || destinationTown ==null) {
            return null;
        }
        for(Road roads: edges) {
            if(roads.getSource().equals(sourceTown) && roads.getDestination().equals(destinationTown)|| 
            roads.getSource().equals(destinationTown) && roads.getDestination().equals(sourceTown)) {
                return roads; 
            }
        }
        return null;
    }
    public boolean addTown(Town town) throws NullPointerException{
         if(town ==null) {
            throw new NullPointerException("Town is null");
        }
        
        if(containsTown(town)) {
            return false; 
        }
        vertices.add(town);
        return true;
    }
    @Override
    public boolean containsRoad(Town sourceTown, Town destinationTown) {
        if(sourceTown == null || destinationTown == null) {
            return false; 
        }
        //checks source and destination of each road and see if they match the towns passed
        for(Road road: edges) {
            if(road.getSource().equals(sourceTown) && road.getDestination().equals(destinationTown) || 
            road.getSource().equals(destinationTown) && road.getDestination().equals(sourceTown)) {
                return true;
            }
        }
        return false; 
    }   
    @Override
    public boolean containsTown(Town town) {
        if(town ==null) {
            return false;
        }
        for(Town verticesTown: vertices) {
            if(verticesTown.equals(town)) {
                return true;
            }
        }
        return false; 
    }
    @Override
    public Set<Road> getRoads() {
       return edges; 
    }
    @Override
    public Set<Road> getRoadsOf(Town town) throws IllegalArgumentException, NullPointerException {
        if(town ==null) {
            throw new NullPointerException("Town is null.");
        }
        if(!containsTown(town)) {
            throw new IllegalArgumentException("Town does not exist in graph.");
        }
       
        Set<Road> roadsOfTown =  new TreeSet<>();
        for(Road roads: edges) {
            if(roads.getSource().equals(town) || roads.getDestination().equals(town)) {
                roadsOfTown.add(roads);
            }
        }
        return roadsOfTown;
    }
    @Override
    public Road removeRoad(Road road) {
        if(!containsRoad(road.getSource(), road.getDestination())) {
            return null;
        }
        Road tempRoad = road;
        edges.remove(road);
        return tempRoad;
    }
    @Override
    public Road removeRoad(Town sourceVertex, Town destinationVertex, int weight, String description) {
        if(!containsTown(sourceVertex) || !containsTown(destinationVertex)) {
            return null;
        }
        sourceVertex.getAdjTowns().remove(destinationVertex);
        destinationVertex.getAdjTowns().remove(sourceVertex);
        for(Road road : edges) {
            if(road.getSource().equals(sourceVertex) && road.getDestination().equals(destinationVertex)) {
                if(weight>-1 && description != null) {
                    if(road.getDistance()==weight && road.getName() == description) {
                        Road tempRoad = road;
                        edges.remove(road);
                        return tempRoad;
                    }
                }
            }
        }
        return null; 
    }
    @Override
public boolean removeTown(Town town) {
    if(!containsTown(town)) {
        return false; 
    }
    vertices.remove(town);
    
    Iterator<Road> iterator = edges.iterator();
    while(iterator.hasNext()) {
        Road road = iterator.next();
        if(road.getSource().equals(town) || road.getDestination().equals(town)) {
            iterator.remove();
        }
    }
    
    return true;
}

    @Override
    public Set<Town> getSetOfTowns() {
        return vertices;
    }
    @Override
    public Town getTown(String name) {
       for(Town townVertices:vertices) {
            if(townVertices.getName().equals(name)) {
                return townVertices; 
            }
       }
       return null;
    }
    @Override
    public ArrayList<String> getShortestPath(Town sourceTown, Town destinationTown) {
        dijkstraShortestPath(sourceTown);
        ArrayList<String> path = new ArrayList<>();
        
        // Traverse the path from destinationTown back to sourceTown
        while (!destinationTown.equals(sourceTown)) {
            if (destinationTown.getPredecessorNode() != null) {
                StringBuilder pathElement = new StringBuilder();
                Road road = getRoad(destinationTown, destinationTown.getPredecessorNode());
                pathElement.append(destinationTown.getPredecessorNode().getName())
                    .append(" via ")
                    .append(road.getName())
                    .append(" to ")
                    .append(destinationTown.getName())
                    .append(" ")
                    .append(road.getDistance());
                path.add(0, pathElement.toString());
            }
             else {
                // If there is no predecessor for the current town, break the loop
                break;
            }
             
            destinationTown = destinationTown.getPredecessorNode();
        }
        
        // Add the source town to the path
        
        return path; 
    }
    
    @Override
    public void dijkstraShortestPath(Town sourceTown) {
      ArrayList<HashMap<Town,Integer>> shortestPaths = new ArrayList<>();
      //this hashmaps holds the town and the tentative distance from the source to the specified town
      HashMap<Town,Integer> distances = new HashMap<>();
      
      //this priority queue uses a custom comparator based on the tentative distance of a 
      //town from the source 
      PriorityQueue<Town> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
      
      //initializing hashMaps
      //this initializes the town having an infinite distance from the source
      for(Town towns: vertices) {
        distances.put(towns, Integer.MAX_VALUE);
        
      }
      //the source is 0 away from itself
      distances.put(sourceTown, 0);
      sourceTown.setShortestDistance(0);
      queue.add(sourceTown);

      while(!queue.isEmpty()) {
        //takes the town with the shortest distance
        Town currentTown = queue.poll();
        int currentDistance = distances.get(currentTown);
        //iterate through each of the neighbors for each town 
            for(Town neighbor: currentTown.getAdjTowns()) {
                //traverse through each adjacent town and calculate the distance from the currentTown 
                //to each of the neighbors 
                int distanceToNeighbor = currentDistance +getDistance(currentTown, neighbor);
                if(distanceToNeighbor < distances.get(neighbor)) {
                    neighbor.setShortestDistance(distanceToNeighbor);
                    neighbor.setPredecessorNode(currentTown);
                    distances.put(neighbor, distanceToNeighbor);
                    queue.add(neighbor);
                }
            }
      }
        for(Town town: vertices) {
            HashMap<Town,Integer> path = new HashMap<>();
            path.put(town, distances.get(town));
            shortestPaths.add(path);
        }
    }
    private int getDistance(Town currentTown, Town neighbor) {
        for(Road roads: edges) {
            if(roads.getSource().equals(currentTown) && roads.getDestination().equals(neighbor) || 
            roads.getSource().equals(neighbor) && roads.getDestination().equals(currentTown)) {
                return roads.getDistance();
            }
        }
        return -1; 
    }
    @Override
    public ArrayList<String> getSortedListOfTowns() {
        TreeSet<Town> set = new TreeSet<>(vertices);
        ArrayList<String> list = new ArrayList<>();
        for (Town town : set) {
            list.add(town.getName());
        }
        return list; 
    }
    
    @Override
    public ArrayList<String> getSortedListOfRoads() {
        TreeSet<Road> set = new TreeSet<>(edges);
        ArrayList<String> list = new ArrayList<>();
        for (Road road : set) {
            list.add(road.getName());
        }
        return list; 
    }
    
        @Override
    public void populateTownGraph(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line != null && !line.isEmpty()) {
                    String[] tokens = line.split(";");
                    if (tokens.length == 3) {
                        String roadNameandWeight = tokens[0];
                        String sourceTownSTRING = tokens[1];
                        String destinationTownSTRING = tokens[2];
                        String[] tokens2 = roadNameandWeight.split(",");
                        if (tokens2.length == 2) {
                            String roadName = tokens2[0];
                            int weight = Integer.parseInt(tokens2[1]);
                            Town sourceTown = createTownOrReturnTown(sourceTownSTRING);
                            Town destinationTown = createTownOrReturnTown(destinationTownSTRING);
                            addTown(destinationTown);
                            addTown(sourceTown);
                            addRoad(sourceTown, destinationTown, weight, roadName);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
    }

    private Town createTownOrReturnTown(String townName) {
        for(Town town:vertices) {
            if(town.getName().equals(townName)) {
                return town;
            }
        }
        Town town = new Town(townName);
        return town;
    }

}
