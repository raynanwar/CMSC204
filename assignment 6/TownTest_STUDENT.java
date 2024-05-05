import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownTest_STUDENT {
    Town town;
    @BeforeEach
    void setUp() throws Exception {
        town = new Town("Clarksburg");
    }

    @AfterEach
    void tearDown() throws Exception {
        town =  null;
    }

    @Test
    void testGetName() {
        String name = "Clarksburg";
        assertTrue(name.equals(town.getName()));
    }

    @Test
    void testAddAdjTown() {
        Town town2= new Town("Germantwon");
        assertEquals(0, town.getAdjTowns().size());
        town.addAdjTown(town2);
        assertEquals(1, town.getAdjTowns().size());
    }

    @Test
    void testGetAdjTowns() {
        Town town2= new Town("Germantwon");
        town.addAdjTown(town2);
        HashSet<Town> adjTown = town.getAdjTowns();
        assertTrue(adjTown.contains(town2));
    }

    @Test
    void testEqualsTowns() {
        Town town2 = new Town("Clarksburg");
        assertTrue(town.equals(town2));
    }

}
