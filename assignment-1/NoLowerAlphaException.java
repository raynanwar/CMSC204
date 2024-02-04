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
public class NoLowerAlphaException extends Exception{
    public NoLowerAlphaException() {
        super("The password must contain at least one lowercase alphabetic character");
    }
    public NoLowerAlphaException(String message) {
        super(message);
    }
}

