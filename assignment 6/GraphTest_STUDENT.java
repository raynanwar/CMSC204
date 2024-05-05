import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class GraphTest_STUDENT {
    Graph graph; 

    Town Frederick;
    Town Damascus;
    Town Clarksburg;
    Town Germantown;
    Town Gaithersburg;
    Town Rockville;
    Town Potomac;
    Town SilverSpring;
    Town Wheaton;
    Town CollegePark;

    Road frederickRD;
    Road westOldBaltimore;
    Road clarksburgRD;
    Road three55;
    Road wisteriaDR;
    Road two70;
    Road ssRD;
    Road rockvillePike;
    Road chevyRd;
    Road darnestownRd;
    
    @BeforeEach
    void setUp() throws Exception {
         Frederick = new Town("Frederick");
         Damascus = new Town("Damascus");
         Clarksburg = new Town("Clarksburg");
         Germantown = new Town("Germantown");
         Gaithersburg = new Town("Gaithersburg");
         Rockville = new Town("Rockville");
         Potomac = new Town("Potomac");
         SilverSpring = new Town("Silver Spring");
         Wheaton = new Town("Wheaton");
         CollegePark = new Town("College Park");

        graph = new Graph();
        graph.addTown(Frederick);
        graph.addTown(Damascus);
        graph.addTown(Clarksburg);
        graph.addTown(Germantown);
        graph.addTown(Gaithersburg);
        graph.addTown(Rockville);
        graph.addTown(Potomac);
        graph.addTown(SilverSpring);
        graph.addTown(Wheaton);
        graph.addTown(CollegePark);
        
        frederickRD = graph.addRoad(Frederick, Damascus, 6, "Frederick rd");
        westOldBaltimore = graph.addRoad(Damascus, Clarksburg, 8, "West Old Baltimore");
        clarksburgRD = graph.addRoad(Clarksburg, Germantown, 4, "Clarksburg rd");
        three55 = graph.addRoad(Germantown, Gaithersburg, 7, "355");
        wisteriaDR = graph.addRoad(Gaithersburg, Rockville, 6, "Wisteria Dr");
        two70 = graph.addRoad(Rockville, Potomac, 10, "270");
        ssRD = graph.addRoad(Rockville, SilverSpring, 6, "Silver Spring rd");
        rockvillePike = graph.addRoad(Potomac, SilverSpring, 5, "Rockville Pike");
        chevyRd = graph.addRoad(SilverSpring, Wheaton, 4, "Chevy rd");
        darnestownRd = graph.addRoad(SilverSpring, CollegePark, 2, "Darnestown Rd");
    }

    @AfterEach
    void tearDown() throws Exception {
        graph = null;
        Frederick = null;
        Damascus = null;
        Clarksburg = null;
        Germantown = null;
        Gaithersburg = null;
        Rockville = null;
        Potomac = null;
        SilverSpring = null;
        Wheaton = null;
        CollegePark = null;
        frederickRD = null;
        westOldBaltimore = null;
        clarksburgRD = null;
        three55 = null;
        wisteriaDR = null;
        two70 = null;
        ssRD = null;
        rockvillePike = null;
        chevyRd = null;
        darnestownRd = null;
    }
    @Test
    void testAddRoadTownTownIntString() {
        assertEquals(10, graph.vertices.size());
         frederickRD = graph.addRoad(Frederick, Damascus, 6, "Frederick rd");
         westOldBaltimore = graph.addRoad(Damascus, Clarksburg, 8, "West Old Baltimore");
         clarksburgRD = graph.addRoad(Clarksburg, Germantown, 4, "Clarksburg rd");
         three55 = graph.addRoad(Germantown, Gaithersburg, 7, "355");
         wisteriaDR = graph.addRoad(Gaithersburg, Rockville, 6, "Wisteria Dr");
         two70 = graph.addRoad(Rockville, Potomac, 1, "270");
         ssRD = graph.addRoad(Rockville, SilverSpring, 6, "Silver Spring rd");
         rockvillePike = graph.addRoad(Potomac, SilverSpring, 1, "Rockville Pike");
         chevyRd = graph.addRoad(SilverSpring, Wheaton, 4, "Chevy rd");
         darnestownRd = graph.addRoad(SilverSpring, CollegePark, 2, "Darnestown Rd");
        
         assertEquals(20, graph.edges.size());
        
    }

    @Test
    void testAddRoadRoad() {
        assertEquals(10, graph.edges.size());
        Road tempRoad1 = new Road(Frederick, CollegePark, 20, "355");
        graph.addRoad(tempRoad1);
        assertEquals(11, graph.edges.size());
        Road tempRoad2 = new Road(Frederick, CollegePark, 20, "495");
        graph.addRoad(tempRoad2);
        assertEquals(12, graph.edges.size());
    }
    
    @Test
    void testAddRoadWithNullSource() {
        Town tempTown1 = null;
        Town tempTown2 = new Town("tempTown");
        assertEquals(10, graph.vertices.size());
        try{
            graph.addRoad(tempTown1, tempTown2, 10, "200");
        } catch(NullPointerException e) {
            assertEquals(e.getMessage(), "Either source or destination town is null.");
        }
       
    }
    
    @Test
    void testAddRoadWithNullDestination() {
        Town tempTown1 = null;
        Town tempTown2 = new Town("tempTown");
        assertEquals(10, graph.vertices.size());
        try{
            graph.addRoad(tempTown2, tempTown1, 10, "200");
        } catch(NullPointerException e) {
            assertEquals(e.getMessage(), "Either source or destination town is null.");
        }       
    }
    
    @Test
    void testAddRoadSourceNotExists() {
        Town tempTown1 = new Town("tempTown1");
        Town tempTown2=  new Town("tempTown2");
        graph.addTown(tempTown2);
        try {
            graph.addRoad(tempTown1, tempTown2, 30, "OOORGR");
        } catch(IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Either source or destination town is not contained in the graph.");
        }

    }

    @Test
    void testGetRoad() {
        Road tempRoad = graph.getRoad(Frederick, Damascus);
        assertEquals(tempRoad, frederickRD);

    }

    @Test
    void testAddTown() {
        assertEquals(10, graph.vertices.size());
        Town tempTown = new Town("TemmpTown");
        graph.addTown(tempTown);
        assertEquals(11, graph.vertices.size());
    }

    @Test
    void testContainsRoad() {
        assertTrue(graph.containsRoad(Clarksburg, Damascus));
        assertFalse(graph.containsRoad(CollegePark, Frederick));
        
    }

    @Test
    void testContainsTown() {
        assertTrue(graph.containsTown(Clarksburg));
        Town tempTown = new Town("TemmpTown");
        assertFalse(graph.containsTown(tempTown));
    }

    @Test
    void testGetTown() {
        Town tempTown = graph.getTown("Clarksburg");
        assertEquals(tempTown, Clarksburg);
        Town tempTown2 = graph.getTown("Fakesville");
        assertEquals(tempTown2, null);
    }

    @Test
    void testGetRoads() {
        assertEquals(10, graph.getRoads().size());
        TreeSet<Road> expectedRoads = new TreeSet<>();

  
        expectedRoads.add(frederickRD);
        expectedRoads.add(westOldBaltimore);
        expectedRoads.add(clarksburgRD);
        expectedRoads.add(three55);
        expectedRoads.add(wisteriaDR);
        expectedRoads.add(two70);
        expectedRoads.add(ssRD);
        expectedRoads.add(rockvillePike);
        expectedRoads.add(chevyRd);
        expectedRoads.add(darnestownRd);

    
        TreeSet<Road> actualRoads = new TreeSet<>(graph.getRoads());

        
        assertEquals(expectedRoads, actualRoads);
    }

    @Test
    void testGetRoadsOf() {
        Set<Road> roadsOfSilverSpring = new TreeSet<>();
        roadsOfSilverSpring.add(chevyRd);
        roadsOfSilverSpring.add(darnestownRd);
        roadsOfSilverSpring.add(ssRD);
        roadsOfSilverSpring.add(rockvillePike);
        Set<Road> tempSet = graph.getRoadsOf(SilverSpring);
        assertEquals(roadsOfSilverSpring, tempSet);
    }

    @Test
    void testGetRoadsOfNullTown() {
        Town tempTown = null;
        try{
            graph.getRoadsOf(tempTown);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Town is null.");
        }
    }

    @Test
    void testGetRoadsOfTownNotExist() {
        Town tempTown = new Town("Fakesville");
        try{
            graph.getRoadsOf(tempTown);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Town does not exist in graph.");
        }
    }

    @Test
    void testRemoveRoad() {
        assertEquals(10, graph.edges.size());
        graph.removeRoad(westOldBaltimore);
        assertEquals(9, graph.edges.size());

    }

    @Test
    void testRemoveTown() {
        assertEquals(10, graph.vertices.size());
        graph.removeTown(Clarksburg);
        assertEquals(9, graph.vertices.size());
    }

        
    /**************** You must have a test case for a source town to every other town of your test graph 
     * for example; testShortestPathFromTownAToTownB
     */
    @Test
    void testShortestPathFromFrederickToDamascus() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Damascus);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Damascus");
    }

    @Test
    void testShortestPathFromFrederickToClarksburg() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Clarksburg);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Clarksburg");
    }

    @Test
    void testShortestPathFromFrederickToGermantown() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Germantown);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Germantown");
    }
        @Test
    void testShortestPathFromFrederickToGaithersburg() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Gaithersburg);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Gaithersburg");
    }

    @Test
    void testShortestPathFromFrederickToRockville() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Rockville);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        expectedShortestPath.add("Gaithersburg via Wisteria Dr to Rockville 6");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Rockville");
    }

    @Test
    void testShortestPathFromFrederickToPotomac() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Potomac);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        expectedShortestPath.add("Gaithersburg via Wisteria Dr to Rockville 6");
        expectedShortestPath.add("Rockville via 270 to Potomac 10");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Potomac");
    }

    @Test
    void testShortestPathFromFrederickToSilverSpring() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, SilverSpring);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        expectedShortestPath.add("Gaithersburg via Wisteria Dr to Rockville 6");
        expectedShortestPath.add("Rockville via Silver Spring rd to Silver Spring 6");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Silver Spring");
    }

    @Test
    void testShortestPathFromFrederickToWheaton() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, Wheaton);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        expectedShortestPath.add("Gaithersburg via Wisteria Dr to Rockville 6");
        expectedShortestPath.add("Rockville via Silver Spring rd to Silver Spring 6");
        expectedShortestPath.add("Silver Spring via Chevy rd to Wheaton 4");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to Wheaton");
    }

    @Test
    void testShortestPathFromFrederickToCollegePark() {
        ArrayList<String> shortestPath = graph.getShortestPath(Frederick, CollegePark);
        ArrayList<String> expectedShortestPath = new ArrayList<>();
        expectedShortestPath.add("Frederick via Frederick rd to Damascus 6");
        expectedShortestPath.add("Damascus via West Old Baltimore to Clarksburg 8");
        expectedShortestPath.add("Clarksburg via Clarksburg rd to Germantown 4");
        expectedShortestPath.add("Germantown via 355 to Gaithersburg 7");
        expectedShortestPath.add("Gaithersburg via Wisteria Dr to Rockville 6");
        expectedShortestPath.add("Rockville via Silver Spring rd to Silver Spring 6");
        expectedShortestPath.add("Silver Spring via Darnestown Rd to College Park 2");
        assertEquals(expectedShortestPath, shortestPath, "Shortest path from Frederick to College Park");
    }
    @Test
    void testPopulateTownGraph() {
        File file = new File("student.txt");
        try {
            graph.populateTownGraph(file);
        } catch (FileNotFoundException e) {
            System.out.println("This should not throw an exception");
        }

        // Test the towns
        assertTrue(graph.containsTown(new Town("Springfield")));
        assertTrue(graph.containsTown(new Town("Arizona")));
        assertTrue(graph.containsTown(new Town("Clarksburg")));
        assertTrue(graph.containsTown(new Town("Abu Dhabi")));
        assertTrue(graph.containsTown(new Town("Egypt")));
        assertTrue(graph.containsTown(new Town("Greece")));
        assertTrue(graph.containsTown(new Town("Germany")));
        assertTrue(graph.containsTown(new Town("France")));
        assertTrue(graph.containsTown(new Town("England")));
        assertTrue(graph.containsTown(new Town("Brazil")));
        assertTrue(graph.containsTown(new Town("Spain")));
        assertTrue(graph.containsTown(new Town("India")));
        assertTrue(graph.containsTown(new Town("Pakistan")));
        assertTrue(graph.containsTown(new Town("Nigeria")));

        // Test the roads
        assertTrue(graph.containsRoad(new Town("Springfield"), new Town("Arizona")));
        assertTrue(graph.containsRoad(new Town("Clarksburg"), new Town("Abu Dhabi")));
        assertTrue(graph.containsRoad(new Town("Egypt"), new Town("Greece")));
        assertTrue(graph.containsRoad(new Town("Germany"), new Town("France")));
        assertTrue(graph.containsRoad(new Town("England"), new Town("France")));
        assertTrue(graph.containsRoad(new Town("England"), new Town("Abu Dhabi")));
        assertTrue(graph.containsRoad(new Town("England"), new Town("Egypt")));
        assertTrue(graph.containsRoad(new Town("Brazil"), new Town("Spain")));
        assertTrue(graph.containsRoad(new Town("Spain"), new Town("France")));
        assertTrue(graph.containsRoad(new Town("India"), new Town("Pakistan")));
        assertTrue(graph.containsRoad(new Town("Abu Dhabi"), new Town("India")));
        assertTrue(graph.containsRoad(new Town("Spain"), new Town("Germany")));
        assertTrue(graph.containsRoad(new Town("Germany"), new Town("India")));
    }

        
    
}
