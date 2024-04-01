/*
 
Class: CMSC204
Instructor: Eivzi
Description: COURSEelement
Due: 4/1
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBStructureTest_STUDENT {
CourseDBStructure dbStructure;
	@BeforeEach
	void setUp() throws Exception {
		dbStructure = new CourseDBStructure(50);
	}

	@AfterEach
	void tearDown() throws Exception {
		dbStructure = null;
		
	}

	
	@Test
	void testCourseDBStructureStringInt() {
		CourseDBElement course1 = new CourseDBElement("CMSC201", 123456, 4, "100", "Kuijt");
		dbStructure=  new CourseDBStructure("10", 50);
		assertEquals(dbStructure.sizeOfHashTable, 50);
		assertEquals(dbStructure.showAll().size(), 0);
		dbStructure.add(course1);
		assertEquals(dbStructure.showAll().size(), 1);
		
	}

	@Test
	void testCourseDBStructureInt() {
		CourseDBElement course1 = new CourseDBElement("CMSC201", 123456, 4, "100", "Kuijt");
		dbStructure = new CourseDBStructure(50);
		assertEquals(dbStructure.sizeOfHashTable, 43);
		assertEquals(dbStructure.showAll().size(), 0);
		dbStructure.add(course1);
		assertEquals(dbStructure.showAll().size(), 1);
	}

	@Test
	void testAdd() {
		CourseDBElement course1 = new CourseDBElement("CMSC201", 123456, 4, "100", "Kuijt");
		CourseDBElement course2 = new CourseDBElement("CMSC203", 123456, 4, "100", "Kuijt");
		dbStructure = new CourseDBStructure(50);
		assertEquals(dbStructure.showAll().size(), 0);
		dbStructure.add(course1);
		dbStructure.add(course2);
		//the should stay as 1 
		assertEquals(dbStructure.showAll().size(), 1);
	}

	@Test
	void testShowAll() {
		CourseDBElement course1 = new CourseDBElement("CMSC201", 123456, 4, "100", "Kuijt");
		CourseDBElement course2 = new CourseDBElement("CMSC202", 123457, 4, "100", "Eivazi");
		CourseDBElement course3 = new CourseDBElement("CMSC203", 123458, 4, "100", "Webb");
		ArrayList<String>array = new ArrayList<>();
		array.add(course1.toString() +"\n");
		array.add(course2.toString()+"\n");
		array.add(course3.toString()+"\n");
		dbStructure.add(course1);
		dbStructure.add(course2);
		dbStructure.add(course3);
		
		assertEquals(dbStructure.showAll(), array);
	}

	@Test
	void testGet() {
		try {
			dbStructure.get(10);
		}catch (Exception e) {
			assertTrue(true, "this throws an exception");
		}
		try {
			
			CourseDBElement temp = dbStructure.get(123456);
			assertEquals(temp.toString(), dbStructure.showAll());
		}
		catch(Exception e) {
			assertTrue(true, "this doesn't throw an exception");
		}
		
	}

	@Test
	void testGetTableSize() {
		assertEquals(dbStructure.getTableSize(), 43);
		dbStructure=  new CourseDBStructure("10", 50);
		assertEquals(dbStructure.sizeOfHashTable, 50);
		
	}

	@SuppressWarnings("static-access")
	@Test
	void testGet4KPrime() {
		int temp = (int)(50/1.5);
		assertEquals(dbStructure.getTableSize(), dbStructure.get4KPrime(temp));
	}

}
