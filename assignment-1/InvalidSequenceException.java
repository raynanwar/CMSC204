
/*
 
Class: CMSC204
Instructor: Eivazi
Description: (Give a brief description for each Class)
Due: 02/04/2024
I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Rayn Anwar
*/
public class InvalidSequenceException extends Exception {
    public InvalidSequenceException() {
        super("The password cannot contain more than two of the same character in sequence.");
    }
    public InvalidSequenceException(String message) {
        super(message);
    }
}
