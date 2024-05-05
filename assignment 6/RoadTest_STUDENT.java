import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoadTest_STUDENT {
    Road road; 
    Town sourceTown;
    Town destinationTown;
	@BeforeEach
	void setUp() throws Exception {
        sourceTown = new Town("Clarksburg");
        destinationTown = new Town("Germantown");
        road = new Road(sourceTown, destinationTown, 8, "355");
	}

	@AfterEach
	void tearDown() throws Exception {
        sourceTown = null;
        destinationTown =  null;
        road = null;
	}

	@Test
	void testGetName() {
		String name =  "355";
        assertTrue(name.equals(road.getName()));
	}

	@Test
	void testGetDestination() {
		Town copyTown = sourceTown;
        assertEquals(copyTown, road.getSource());
	}

	@Test
	void testGetSource() {
		Town copyTown = destinationTown;
        assertEquals(copyTown, road.getDestination());
	}

	@Test
	void testGetDistance() {
		assertEquals(8, road.getDistance());
	}

	@Test
	void testContains() {
		assertTrue(road.contains(destinationTown));
        assertTrue(road.contains(sourceTown));
        Town fakeTown = new Town("fake Town");
        assertFalse(road.contains(fakeTown));
	}

	@Test
	void testEqualsRoads() {
		Road copyRoad = new Road(destinationTown, sourceTown, "355 copy");
        assertTrue(road.equals(copyRoad));
	}

}
