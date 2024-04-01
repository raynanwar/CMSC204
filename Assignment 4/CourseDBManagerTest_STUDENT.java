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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;
/**
 * Test template provided to students
 * Students must implement the methods
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 *
 */
class CourseDBManagerTest_STUDENT {
	CourseDBManager dataMgr;
	@BeforeEach
	void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@AfterEach
	void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	void testAdd() {
		assertEquals(dataMgr.showAll().size(), 0);
		dataMgr.add("CMSC203" ,12345, 4, "100", "Eivazi");
		assertEquals(dataMgr.showAll().size(), 1);
		dataMgr.add("CMSC204", 12345, 4, "100", "Kuijt");
		assertEquals(dataMgr.showAll().size(), 1);
		dataMgr.add("CMSC205", 123456, 4, "110", "Shah");
		assertEquals(dataMgr.showAll().size(),2);
		
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
		dataMgr.add("CMSC201", 123456, 4, "100", "Kuijt");
		dataMgr.add("CMSC202", 123457, 4, "100", "Eivazi");
		dataMgr.add("CMSC203", 123458, 4, "100", "Webb");
		
		assertEquals(dataMgr.showAll(), array);
		
	}

	@Test
	void testReadFile() {
		File inputFile= new File("studentCourses.txt");
		assertEquals(dataMgr.showAll().size(),0);
		try {
			dataMgr.readFile(inputFile);
			assertEquals(dataMgr.showAll().size(), 9);
		} catch (Exception e) {
			assertTrue(false, "this shouldn't throw an exception");
		}
		File inputFile2 = new File("johhny.txt");
		try {
			dataMgr.readFile(inputFile2);
		} catch (Exception e) {
			assertTrue(true, "this throws an exception");
		}
	}

	@Test
	void testGet() {
		try {
			dataMgr.get(10);
		}catch (Exception e) {
			assertTrue(true, "this throws an exception");
		}
		try {
			
			CourseDBElement temp = dataMgr.get(123456);
			assertEquals(temp.toString(), dataMgr.showAll());
		}
		catch(Exception e) {
			assertTrue(true, "this doesn't throw an exception");
		}
		
	}

}
