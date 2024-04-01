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
import java.util.*;
import java.io.*;
public class CourseDBManager implements CourseDBManagerInterface {
    CourseDBStructure hashTable;
    public CourseDBManager() {
       hashTable =  new CourseDBStructure(50);
    }
    public void add (String id, int crn, int credits, String roomNum, String instructor) {
        hashTable.add(new CourseDBElement(id, crn, credits, roomNum,instructor));
    }
   
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        
        while(scanner.hasNextLine()) {
        	StringBuilder string = new StringBuilder();
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String id = tokens[0];
            int crn = Integer.parseInt(tokens[1]);
            int credits = Integer.parseInt(tokens[2]);
            String roomNum = tokens[3];
            for(int i =4; i<tokens.length; i++) {
            	 
                string.append(tokens[i]);
                if(i<=tokens.length-1) {
                    string.append(" ");
                }
            }
            add(id, crn, credits, roomNum, string.toString());

            
        }
        scanner.close();
        
    }
    @Override
    public CourseDBElement get(int crn) {
        try {
            CourseDBElement element = hashTable.get(crn);
            return element;

        } catch (Exception e) {
            e.getStackTrace();
        }
      return null;
    }

    @Override
    public ArrayList<String> showAll() {
       ArrayList<String> courses = hashTable.showAll();
       return courses; 
    }
}
