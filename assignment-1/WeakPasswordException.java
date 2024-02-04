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
public class WeakPasswordException extends Exception{
    public WeakPasswordException() {
        super("The password is OK but weak - it contains fewer than 10 characters.");
    }
    public WeakPasswordException(String message) {
        super(message);
    }
}
