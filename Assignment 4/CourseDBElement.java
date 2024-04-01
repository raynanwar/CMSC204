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
public class CourseDBElement{
    private String id;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructor;
    
    // Constructor
    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor){
        this.id = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }
    
    // Copy constructor
    public CourseDBElement(CourseDBElement element) {
        this.id = element.id;
        this.crn = element.crn;
        this.credits = element.credits;
        this.roomNum = element.roomNum;
        this.instructor = element.instructor;
    }

    public CourseDBElement() {
        //TODO Auto-generated constructor stub
    }

    public String getID() {
        return id;
    }

    public int getCRN() {
        return crn;
    }

    public int getCredits() {
        return credits;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getInstructor() {
        return instructor;
    }

    
    public void setID(String id) {
        this.id = id;
    }

    public void setCRN(int crn) {
        this.crn = crn;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public int hashCode() {
       String key = Integer.toString(crn);
       return key.hashCode();
    }
    public boolean equals(Object anotheObject){
        CourseDBElement anotherObject = (CourseDBElement) anotheObject;
        if(this.getCRN() == anotherObject.getCRN()){
            return true;
        }
        return false;
    }
    public String toString() {
		String course = "Course:" + id + " CRN:" + crn + " Credits:" + (credits) + " Instructor:" + instructor + " Room:" + roomNum;
		return course;
	}


}
