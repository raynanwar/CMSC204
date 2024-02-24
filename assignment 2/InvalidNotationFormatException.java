/*
 
Class: CMSC204
Instructor: Eivzi
Description: Infix to postifx 
Due: 2/25
Platform/compiler: Eclipse
I pledge that I have completed the programming
assignment independently. I have not copied the code
from a student or any source. I have not given my code
to any student.
Print your Name here:= Rayn Anwar
*/
public class InvalidNotationFormatException extends RuntimeException {
    public InvalidNotationFormatException() {
        super("Notation format is incorrect");
    }
    public InvalidNotationFormatException(String message) {
        super(message);
    }
}