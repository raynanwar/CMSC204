import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface for Course DB Structure
 * 
 * @author Farnaz Eivazi
 * @version 1/31/2024
 */

/**
 * This is the interface to the Course Database Structure Class.
 */
public interface CourseDBStructureInterface {
	/**
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of
	 * the CourseDatabaseElemen object's crn value. If the CourseDatabaseElement
	 * already exists, exit quietly
	 * 
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */
	void add(CourseDBElement element);

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */

	CourseDBElement get(int crn) throws IOException;

	/**
	 * @return an array list of string representation of each course in the data
	 *         structure separated by a new line. Refer to the following example:
	 *         Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular
	 *         Room:SC100 Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody
	 *         Room:SC200
	 */

	ArrayList<String> showAll();

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	int getTableSize();

}
