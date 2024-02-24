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
/**
 * 
 * Interface for a generic Stack data structure
 * @param <T> data type
 * 
 * @author Farnaz Eivazi
 * @version 1/29/2024
 */

 import java.util.ArrayList;

 /** 
  * 
  * 
  */
 public interface StackInterface<T> {
 
     /**
      * Provide two constructors
      * <p>1. takes in an int as the size of the stack
      * <p>2. default constructor - uses default as the size of the stack
      */
     
     /**
      * Determines if Stack is empty
      * @return true if Stack is empty, false if not
      */
     public boolean isEmpty();
 
     /**
      * Determines if Stack is full
      * @return true if Stack is full, false if not
      */
     public boolean isFull();
     
 
     /**
      * Deletes and returns the element at the top of the Stack
      * @return the element at the top of the Stack
      * @throws StackUnderflowException if stack is empty
      */
     public T pop();
     //throws StackUnderflowException;
     
     /**
      * Returns the element at the top of the Stack, does not pop it off the Stack
      * @return the element at the top of the Stack
      * @throws StackUnderflowException if stack is empty
      */
     public T top();
     //throws StackUnderflowException;
 
     /**
      * Gets the number of elements in the Stack
      * @return the number of elements in the Stack
      */
     public int size();
     
     /**
      * Adds an element to the top of the Stack
      * @param e the element to add to the top of the Stack
      * @return true if the add was successful, false if not
      * @throws StackOverflowException if stack is full
      */
     public boolean push(T e);
     //throws StackOverflowException;
     
     
     /**
      * Returns the elements of the Stack in a String from bottom to top, the beginning 
      * of the String is the bottom of the stack
      * @return a String which represent the objects in the Stack from bottom to top
      */
     public String toString();
     
     /**
      * Returns the String representation of the elements in the Stack, the beginning of the 
      * string is the bottom of the stack
      * <p>Place the delimiter between all elements of the Stack
      * @return String representation of the Stack from bottom to top with elements 
      * separated with the delimiter
      */
     public String toString(String delimiter);
     
      /**
       * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
       * is the first bottom element of the Stack
       * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
       * list reference within your Stack, you will be allowing direct access to the data of
       * your Stack causing a possible security breech.
       * @param list elements to be added to the Stack from bottom to top
       * @throws StackOverflowException if stack gets full
       */
     public void fill(ArrayList<T> list) throws StackOverflowException;
  
 }
 