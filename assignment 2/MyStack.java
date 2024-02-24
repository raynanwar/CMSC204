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
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
    private ArrayList<T> stackList;
    private int size;
    private static final int DEFAULTSIZE = 10;
    private int numberOfElements;
    private int topIndex;

    public MyStack() {
        this(DEFAULTSIZE);
    }
    public MyStack(int size ) {
        ArrayList<T> tempArrayList = new ArrayList<>(size);
        stackList = tempArrayList;
        this.size = size;
        numberOfElements = 0; 
        topIndex=-1;
    }
    public boolean isEmpty() {
        return numberOfElements==0;
    }
    public boolean isFull() {
        return numberOfElements==size;
    }
    public T pop() throws StackUnderflowException {
        if(isEmpty()) {
           throw new StackUnderflowException();
        }
        T temp = stackList.get(topIndex);
        stackList.set(topIndex, null);
        topIndex--;
        numberOfElements--;
        return temp;
    }
    public T top() throws StackUnderflowException  {
        if(isEmpty()) {
            throw new StackUnderflowException();
        }
        return stackList.get(topIndex);
    }
    public int size() {
        return numberOfElements;
    }
    public boolean push(T e ) throws StackOverflowException {
        if(isFull()) {
           throw new StackOverflowException();
        }
        stackList.add(topIndex+1, e);
        topIndex++;
        numberOfElements++;
        return true;   
    }
    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i =0; i<stackList.size(); i++) {
            string.append(stackList.get(i));
            if(i<stackList.size()-1) {
                string.append(", ");
            }
        }
        return string.toString();
    }
    public String toString(String delimiter) {
        StringBuilder string = new StringBuilder();
        for(int i =0; i<stackList.size(); i++) {
            string.append(stackList.get(i));
            if(i<stackList.size()-1) {
                string.append(delimiter);
            }
        }
        return string.toString();
    }
    @SuppressWarnings("unchecked")
   public void fill(ArrayList <T> list) throws QueueOverflowException  {
    ArrayList<T> deepCopy = new ArrayList<>();
    int i =0;
        for(T element : list) {
            try {
                deepCopy.add((T)element.getClass().getConstructor(element.getClass()).newInstance(element));
            } catch(Exception e) {
                System.out.println("Youre fucked");
            }
            push(deepCopy.get(i));
            i++;
        }
        
   }



 
}
